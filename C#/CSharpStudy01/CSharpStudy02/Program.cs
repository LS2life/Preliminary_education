using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharpStudy02
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("안녕");
            //문자열 입력
            string input = Console.ReadLine();
            Console.WriteLine(input); //입력한 것 출력

            int num = int.Parse(Console.ReadLine());
            Console.WriteLine(num+10);



            Console.WriteLine("안녕하세요"[0]);//첫번째 글자인 안 출력
            Console.WriteLine("123"[0]); //글자 1이 출력됨

            Console.WriteLine("123"[0]-'0'); //진짜 숫자 1이 출력됨
            Console.WriteLine((int)"123"[0]); //글자 '1'은 아스키코드 49이다.
        }
    }
}
