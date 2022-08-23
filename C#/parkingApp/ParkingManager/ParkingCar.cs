using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ParkingManager
{
    //parkingManager 테이블과 동일한 구조의 클래스
    //테이블에 있는 내용을 읽어서
    //이 클래스에 담을 것이다.
    //(=이 클래스 타입의 List에 담을 것이다.)

    public class ParkingCar
    {
        public int ParkingSpot { get; set; }
        public string carNumber { get; set; }
        public string driverName { get; set; }
        public string phoneNumber { get; set; }
        public DateTime parkingTime { get; set; }
    }
}
