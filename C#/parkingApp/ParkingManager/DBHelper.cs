using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ParkingManager
{
    //데이터베이스에 직접 접근하는 클래스
    //데이터 넣고 빼고 수정하는 클래스
    //DataManager에서 사용하는 클래스
    //되도록이면 MainForm과 같은 화면에선
    //이 클래스를 직접 안 쓰는 게 좋다.
    //(MVC패턴처럼)
    public class DBHelper
    {
        //전부 static이 붙는 이유
        //메소드들이랑 객체들 모두 클래스명.메소드 혹은
        //클래스명.객체 이렇게 사용할거라서 그렇다.
        //new 등으로 인스턴스 만들 필요가 없으므로
        //(=DB 연결 객체가 하나면 되므로)
        //이렇게 한다.
        private static SqlConnection conn = new SqlConnection();
        public static SqlDataAdapter da;
        public static DataSet ds;
        public static DataTable dt;

        //DB 연결하는 부분
        public static void ConnectDB()
        {
            conn.ConnectionString =
                string.Format("Data Source=({0}); "
                + "initial Catalog = {1};" +
                "integrated Security = {2};" +
                "Timeout=3",
                "local", "MYDB", "SSPI");
            conn=new SqlConnection(conn.ConnectionString);
            conn.Open();
        }


        //selectQuery(); <- 이런식으로 괄호 안에 아무 것도 안 적으면
        //자동으로 parkingSpot 매개변수에 -1이 들어간다는 뜻
        public static void selectQuery(int parkingSpot=-1)
        {
            try
            {
                ConnectDB();

                SqlCommand cmd = new SqlCommand();
                cmd.Connection = conn;
                if(parkingSpot==-1) //매개변수 없이 selectQuery 실행
                {
                    cmd.CommandText = "select * from parkingManager";
                } 
                else //그게 아닌 경우는 특정 주차 공간 번호의 정보 조회
                {
                    cmd.CommandText = "select * from parkingManager " +
                        " where parkingSpot = " 
                        + parkingSpot;
                }

                da = new SqlDataAdapter(cmd);
                ds = new DataSet();
                da.Fill(ds, "ParkingManager");
                dt = ds.Tables[0];

            }
            catch (Exception ex)
            {
                System.Windows.Forms.MessageBox.Show(ex.Message);
                return;
            } finally
            {
                conn.Close();
            }
        }

        public static void updateQuery(string parkingSpotText, string carNumber, string driverName, string phoneNumber, bool isRemove)
        {
            try
            {
                ConnectDB();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = conn;
                cmd.CommandType = CommandType.Text;
                string sqlcommand="";

                if(isRemove) //출차
                {
                    sqlcommand = "update parkingmanager set carnumber='', " +
                        "drivername='', phonenumber='', parkingtime=null where parkingspot=@p1";
                    cmd.Parameters.AddWithValue("@p1", parkingSpotText);
                }
                else
                {
                    //파라메터를 @에 실어서 보내는 방식
                    //sql injection이라는 해킹 공격 방지하는 것
                    //sql injection(sql삽입공격)은 해킹 공격의 일종
                    //커멘드에 잘못된 명령어 입력해서 비밀번호 등 탈취하는 기술
                    //ex : select * from `  <- 이렇게 말도 안 되는 문자를 입력해서
                    //비밀번호 등 정보 탈취
                    sqlcommand = "update parkingManager set carnumber=@p1, " +
                        "drivername=@p2, phonenumber=@p3," +
                        "parkingtime=@p4 where parkingspot=@p5";

                    cmd.Parameters.AddWithValue("@p1", carNumber);
                    cmd.Parameters.AddWithValue("@p2", driverName);
                    cmd.Parameters.AddWithValue("@p3", phoneNumber);
                    cmd.Parameters.AddWithValue("@p4", DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss.fff"));
                    cmd.Parameters.AddWithValue("@p5", parkingSpotText);
                }
                cmd.CommandText = sqlcommand;
                cmd.ExecuteNonQuery();
                

            }
            catch (Exception)
            {

            }
            finally
            {
                conn.Close();
            }
        }

		//insert, delete용
		public static void executeQuery(string parkingSpot, string command)
		{
			string sqlcommand = "";
			if (command == "insert")
			{
				sqlcommand = "insert into parkingManager(parkingSpot) values (@p1)";
			}
			else
			{
				sqlcommand = "delete from parkingManager where parkingSpot= @p1";
			}
			try
			{
				ConnectDB();
				SqlCommand cmd = new SqlCommand();
				cmd.Connection = conn;
				cmd.CommandType = CommandType.Text;
				cmd.Parameters.AddWithValue("@p1", parkingSpot);
				cmd.CommandText = sqlcommand;
				cmd.ExecuteNonQuery();
			}
			catch (Exception)
			{

			}
			finally
			{
				conn.Close();
			}
		}

		public static void deleteQuery(string parkingSpot)
		{
			executeQuery(parkingSpot, "delete");
		}

		public static void insertQuery(string parkingSpot)
		{
			executeQuery(parkingSpot, "insert");
		}


	}
}
