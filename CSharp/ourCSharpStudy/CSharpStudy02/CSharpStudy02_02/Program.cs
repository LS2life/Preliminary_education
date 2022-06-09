using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharpStudy02_02
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //숫자를 입력해서, 그 숫자가 
            //홀수인 경우에만 출력한다.

            Console.WriteLine("숫자 입력");
            int num = int.Parse(Console.ReadLine());

            //num을 2로 나눴을 때 나머지가 0이 아닌 경우(=홀수)
            //이때만 홀수라는 메시지를 출력한다.
            //if : 만약에~
            if(num%2!=0)
            {
                Console.WriteLine("홀수!!!");
                Console.WriteLine(num);
            }

            //삼항연산자
            //엑셀의 IF문이랑 비슷
            //1줄로 조건문을 표시하는 아주 간단한 코드
            //보통 2가지 경우의 수가 있을 때 쓰고, 
            //경우의 수가 2개 넘어도 쓸 순 있는 데 너무 복잡해짐

            // 물음표(?) 뒤에 있는 건 
            // 물음표 앞에 있는 조건이 참일 때 성립됨
            // 조건이 거짓이면 콜론(:) 뒤에 있는 것이 성립됨
            string result = num % 2 == 0 ? "짝" : "홀";
            Console.WriteLine("결과:"+result);

            switch (num%2)
            {
                case -1:
                case 0:
                case -2:
                    Console.WriteLine("num은 짝");
                    break;
                case 1:
                    Console.WriteLine("num은 홀");
                    break;
                default:
                    break;
            }

            switch (num)
            {
                case 0:
                case 1:
                    Console.WriteLine("num은 0 혹은 1이다.");
                    break;

                default: //이도 저도 아닌 경우
                    break;
            }


            //셋다 True
            Console.WriteLine("안녕하세요".Contains("안녕"));//안녕 포함됨
            Console.WriteLine("안녕하세요".Equals("안녕하세요"));
            Console.WriteLine("안녕하세요"=="안녕하세요");
        }
    }
}
