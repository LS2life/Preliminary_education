using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CsharpStudy03
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("I am ground self is water ");

            int age = int.Parse(Console.ReadLine());
            string bt = Console.ReadLine();
            string MBTI = Console.ReadLine();
            Console.WriteLine("나이: " + age);
            Console.WriteLine("혈액형: " + bt);
            Console.WriteLine("MBTI: " + MBTI);
            Console.WriteLine("저의 나이는" + age + "이고, 혈액형은 " + bt + "형 일때 " + MBTI + "를 구하시오.");
            
            Console.WriteLine(
                string.Format("이름:{0}, 혈액형:{1}, MBTI:{2}", age, bt, MBTI));

            Console.WriteLine($"나이:{age}, 혈액형:{bt}, MBTI:{MBTI}");
                

            int Vertical = int.Parse(Console.ReadLine());
            int Horizontal = int.Parse(Console.ReadLine());
            Console.WriteLine(Vertical * Horizontal);

            Console.WriteLine("피타고라스가 정리합니다.");
            Console.WriteLine();
            Console.WriteLine("\"답이없다.\"");

            int alpha = int.Parse(Console.ReadLine());
            int beta = int.Parse(Console.ReadLine());
            int gamma = int.Parse(Console.ReadLine());

            int result = alpha ^ 2 + beta ^ 2;
            int result2 = gamma ^ 2;

            Console.WriteLine(result);
            Console.WriteLine(result2);
            Console.WriteLine();
            bool noanswer = (result == result2);
        }

    }
}


/* 자기소개 
 * 나이 혈액형 MBTI
 *
 * 너비와 높이 값 입력받아서 사각형의 넓이 구하는 프로그램 짜보기
 * 
 * 피타고라스의 정리 결과값 출력(연산의 우선순위 및 괄호 활용
 * ex  입력1 : 3
 *     입력2 : 4
 *     결과 : 25
 *