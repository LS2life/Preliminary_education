using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharpStudy03_02
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("1번");
            Console.WriteLine("이름이 뭐니");
            string name = Console.ReadLine();
            Console.WriteLine("혈액형이 뭐니");
            string bType = Console.ReadLine();
            Console.WriteLine("MBTI가 뭐니");
            string mbti = Console.ReadLine();

            //1. 더하기 노가다
            Console.WriteLine("이름:"+name);
            Console.WriteLine("혈액형:"+bType);
            Console.WriteLine("MBTI:"+mbti);
            //2. string.format
            Console.WriteLine(
                string.Format("이름:{0},혈액형:{1},MBTI:{2}",
                name,bType,mbti));

            //3. $ <- js에서 쓰는 거랑 유사한 거임
            Console.WriteLine($"이름:{name}, 혈액형:{bType}, MBTI:{mbti}");

            Console.WriteLine("2번");
            Console.WriteLine("너비?");
            int w = int.Parse(Console.ReadLine());
            Console.WriteLine("높이?");
            int h = int.Parse(Console.ReadLine());
            Console.WriteLine("사각형의 넓이 : " + (w*h) );

            Console.WriteLine("3번");
            //피타고라스의 정리
            //a^2 + b^2 = c^2
            //c^2의 결과를 출력
            Console.WriteLine("a는?");
            int a = int.Parse(Console.ReadLine());
            Console.WriteLine("b는?");
            int b = int.Parse(Console.ReadLine());
            Console.WriteLine((a*a) + (b*b));

            Console.WriteLine(Math.Pow(a,2)+Math.Pow(b,2));
            Console.WriteLine(Math.Sqrt(Math.Pow(a,2)+Math.Pow(b,2)));
        }
    }
}
