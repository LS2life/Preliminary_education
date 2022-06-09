using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharpStudy03_03
{
    internal class Program
    {
        static void Main(string[] args)
        {

            if(false)//if(false||true) 이렇게 적으면 실행됨
            {
                Console.WriteLine("시간을 입력하세요.");
                int hour = int.Parse(Console.ReadLine());
                if (hour < 12)
                    Console.WriteLine("1 오전입니다.");

                //&& = and
                //&&로 묶인 것들이 단 하나라도 거짓이면
                //전체를 거짓(false)으로 본다.
                if (hour > 0 && hour < 12)
                    Console.WriteLine("2 오전입니다.");

                if (hour > 0 && hour % 2 != 0)
                {
                    Console.WriteLine(hour + "값은 양수");
                    Console.WriteLine(hour + "값은 홀수");
                }

                if (hour > 0)
                {
                    if (hour < 12)
                        Console.WriteLine("양수, 오전!");
                }
            }
            else //if문의 경우의 수가 만족되지 않는 경우
            {

            }

            int number = 1;

            if(number>1)
            {
                Console.WriteLine("number는 1을 넘는다.");
            }
            else
            {
                Console.WriteLine("number는 1을 넘지 못한다.");

                if(number==0)
                    Console.WriteLine("number는 0이다.");
                else if(number==1)
                    Console.WriteLine("number는 1이다.");
                else if(number==2)
                    Console.WriteLine("number는 2이다.");
                else
                    Console.WriteLine("number는 이도저도 아니다.");

                if (number == 0)
                    Console.WriteLine("- number는 0이다.");
                if (number == 1)
                    Console.WriteLine("- number는 1이다.");
                if (number == 2)
                    Console.WriteLine("- number는 2이다.");
                else
                    Console.WriteLine("- number는 이도저도 아니다.");

            }

            //true
            Console.WriteLine("안녕하세요".Contains("안녕"));




        }
    }
}
