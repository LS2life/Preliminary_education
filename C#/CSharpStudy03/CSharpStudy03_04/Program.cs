using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharpStudy03_04
{
    internal class Program
    {
        static void Main(string[] args)
        {
            if(false)
            {
            #region 1번 문제
            /*
             * 1. 5개의 숫자를 입력받고
                그 중에서 최댓값과 최솟값을 출력하시오.
             */
            int[] numbers = new int[5];
            for(int i = 0; i<numbers.Length;i++)
            {
                Console.WriteLine("숫자 입력("+i+")");
                numbers[i] = int.Parse(Console.ReadLine());
            }
            int max = numbers[0];
            int min = max; //둘 다 가장 첫번째껄 최댓값,
            //최솟값으로 가정함

            foreach(var item in numbers)
            {
                if(item>max)
                    max = item;
                if (item < min)
                    min = item;
            }
            Console.WriteLine("최댓값:"+max);
            Console.WriteLine("최솟값:"+min);
            #endregion

            }

            #region 2번 문제
            /*
             * 2. 대문자A~Z, 소문자 a~z까지 반복문을
            이용해서 출력하세요.
             */
            for (char c = 'A'; c<='z'; c++)
            {
                if (c > 'Z' && c < 'a')// [, \, ] ^ _ 등...
                    continue;
                //continue 쓰고 싶지 않다면
                //continue부분 지우고
                //아래 조건문 하나 추가하면 됨
                //if ( ! (c > 'Z' && c < 'a') ) //논리 부정
                    Console.Write(c);
            }
            #endregion


            if(false)
            {
            #region 3,4,5번
            Console.WriteLine();
            Console.WriteLine("출력할 별의 높이 입력하기");
            int floor = int.Parse(Console.ReadLine());

            /*
                 3. 다음 삼각형을 출력하시오.
                입력 : 3
                *
                **
                ***
                4. 다음 역삼각형을 출력하시오.
                입력 : 3
                  *
                 **
                ***
                5. 삼각형 모양의 피라미드 출력하세요.
                ex) 입력 : 3
                  *
                 ***
                *****
            */

            Console.WriteLine("3번 정답");
            for(int i = 0; i < floor; i++)
            {
                for(int j = 0;j<=i;j++)
                    Console.Write("*");
                Console.WriteLine();
            }
            Console.WriteLine("4번 정답");
            for(int i = 0; i<floor; i++)
            {
                for(int j = floor-i-1; j>0; j--)
                    Console.Write(" ");
                for (int j = 0; j <= i; j++)
                    Console.Write("*");
                Console.WriteLine();
            }
            Console.WriteLine("5번 정답(피라미드)");
            for(int i = 0; i<floor; i++)
            {
                for(int j = floor-i-1; j>0;j--)
                {
                    Console.Write(" ");
                }
                for(int j = 0; j< 2*i+1; j++)
                    Console.Write("*");

                Console.WriteLine();
            }


            #endregion

            }

            if(false)
            {
                #region 6번 문제
                /*
                 6. 임의의 숫자 7개를 배열에 집어넣어 보세요.
단, 중복되면 안 됩니다.
그리고 다 입력되고 나서는 이 배열의 숫자들을 오름차순 정렬해서
출력해보세요.
                 */
                Console.WriteLine();
            Console.WriteLine("6번 문제");
            int[] mynumbers = new int[7];

            //Contain 이용 하는 법
            for(int i = 0; i<mynumbers.Length; i++)
            {
                Console.WriteLine("숫자 입력하기");
                int num = int.Parse(Console.ReadLine());
                if(mynumbers.Contains(num))
                {
                    Console.WriteLine("중복!!!");
                    i--;
                    continue;
                }
                mynumbers[i] = num;
            }
            foreach (var item in mynumbers)
            {
                Console.WriteLine(item);
            }

            //직접 체크하는 법
            mynumbers = new int[7]; //초기화

            for(int i = 0; i<mynumbers.Length; i++)
            {
                Console.WriteLine("값 입력");
                int n = int.Parse(Console.ReadLine());
                bool isduplicate = false;
                for (int j = 0; j < i; j++)
                {
                    if (mynumbers[j] == n)
                    {
                        Console.WriteLine("중복~~~");
                        isduplicate = true;
                        i--;
                        break;
                    }
                }

                if (isduplicate == false)
                    mynumbers[i] = n;
            }

            foreach (var item in mynumbers)
                Console.WriteLine(item);
            {

            }

            #endregion

            }
            Console.WriteLine();
            Console.WriteLine("7번 문제!!!");

            string start = "1"; //처음 시작하는 값이자 출력되는 값
            for(int i = 0; i<20; i++)
            {
                Console.WriteLine($"{i+1}번째 : {start}");
                string end = ""; //누적값 저장, 읽어들이는 숫자가
                //달라지거나 수열이 끝났을 때 그동안
                //누적된 값을 적거나 누적하는 것

                char num = start[0]; //읽어들이는 숫자
                int count = 0;//읽어들인 숫자의 개수

                for(int j = 0; j<start.Length; j++)
                {
                    if (start[j]!=num)
                    {
                        end = end + num + count;
                        num = start[j];
                        count = 1;
                    }
                    else
                    {
                        count++;
                    }
                }
                end = end + num + count;
                start = end;
            }

            /* 디버깅 하기*/
            //ctrl+f5 말고 f5 눌러야 함
            //숫자 옆에 점 찍거나 해당 라인에 대고 f9 누르기
            //빨간점 = break point
            //해당 시점의 값을 마우스 올려놓고 조사하거나
            //밑에 있는 조사식 이용해서 값을 보면 됨
            //f5 눌려진 상태에서
            //디버그->창->조사식->조사식 1~4중 하나 선택하기

        }
    }
}
