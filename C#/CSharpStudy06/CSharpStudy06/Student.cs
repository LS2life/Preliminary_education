using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharpStudy06
{
    public class Student
    {
        //변수 : 인스턴스 변수, 클래스 변수
        //메소드 : 인스턴스 메소드, 클래스 메소드

        //static : 클래스 변수나 클래스 메소드
        public string Name { get; set; } //인스턴스 변수
        public static int count { get; set; } //클래스 변수

        //string hakbeon;
        //public string getHakbeon()
        //{
        //    return hakbeon;
        //}
        //public void setHakbeon(string hakbeon)
        //{
        //    this.hakbeon = hakbeon;
        //}

       //string hakbeon;
       // public string _Hakbeon { get { return hakbeon; } set { hakbeon = value; }}
        //public string _Hakbeon { get => hakbeon;  set => hakbeon = value; }
        public string hakbeon { get;  set; }


        //public 클래스명() {} <- 생성자
        public Student()
        {
            count++;
        }

        //오버로딩(자바에도 있음, 오버라이드랑 헷갈리면 안 된다!!!)
        //똑같은 이름의 메소드를 만드는 것
        //조건 : 매개변수의 타입이나 개수가 다르면 된다.
        public void Study() //인스턴스 메소드
        {
            System.Windows.Forms.MessageBox.Show(Name+"학생은 공부한다.");
        }
        public void Study(int a)
        {
            for(int i = 0; i<a;i++)
                System.Windows.Forms.MessageBox.Show(Name+"의 공부!!");
        }
        public static void ShowCount()
        {
            //System.Windows.Forms.MessageBox.Show(Name);
            System.Windows.Forms.MessageBox.Show("이 학교의 인원은 " + count+"이다.");
        }


        //이 클래스를 상속받은 클래스에서만 쓸 수 있는 메소드
        protected void sleep()
        {
            System.Windows.Forms.MessageBox.Show(Name+"은 잔다.");
            System.Windows.Forms.MessageBox.Show(hakbeon+" 학번 이 빠져가지고...");
        }


    }
}
