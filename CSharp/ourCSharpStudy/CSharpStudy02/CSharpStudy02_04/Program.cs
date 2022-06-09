using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharpStudy02_04
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //for문으로 덧셈해보기
            //1부터 10까지 해보기
            int sum = 0;
            for (int i = 1; i <= 10; i++)
                sum += i;
            Console.WriteLine("1부터 10까지의 합 : " + sum);

            for(char c='가'; c<='힣';c++)
                Console.Write(c);
            Console.WriteLine(); //그냥 한 줄 띔

            //while (true)
            //{
            //    for (char c = '가'; c <= '힣'; c++)
            //        Console.Write(c);
            //}

            //숫자 5개를 입력받고, 그 숫자들의 합 구하기
            //foreach

            //배열 선언과 동시에 값을 집어넣음
            int[] numbers = { 10, 20, 1, 2, 3 };
            //배열 선언과 동시에 크기만 잡아줌
            //(숫자 5개 들어간다고 크기만 잡음)
            int[] numbers2 = new int[5];
            numbers2[0] = 24;
            numbers2[1] = 32;
            numbers2[2] = 22;
            numbers2[3] = 12;
            numbers2[4] = 20;

            //for - 반복
            //each - 각각의
            //배열이나 List의 길이만큼만 반복을 해주는 반복문

            //두 개의 반복문 모두 배열의 길이만큼 반복을 한다.
            //foreach문 없이 반복하기
            sum = 0;
            for (int i = 0; i < numbers.Length; i++)
                sum += numbers[i];

            //foreach사용 : 배열의 길이만큼 반복하는 반복문
            //여기서 item은 배열 안에 있는 값들 각각을 의미
            //var 대신 int 써도 됨
            //var 의 의미 : 변수 타입을 정하지 않았으나
            //대입되는 값에 따라서 타입이 변경됨
            //여기선 item이 numbers2라는 배열에 대해서 있으므로
            //int타입
            sum = 0;
            foreach (var item in numbers2)
                sum += item;


            Console.WriteLine("안녕");
            Console.WriteLine("안녕");
            Console.WriteLine("안녕");

            goto mytest;//웬만하면 쓰지마세요.

            Console.WriteLine("하세요"); //이 부분이 skip됨

            mytest:
                Console.WriteLine("못해요");

            Console.WriteLine("hello World".ToUpper());
            Console.WriteLine("hello World".ToLower());

            //하나의 문자열을 배열로 분할
            string[] result = "이동준,피강효,권건모".Split(',');
            foreach(var item in result)
                Console.WriteLine(item);

            //배열을 문자열로 뭉침
            string myresult = string.Join(",", result);
            Console.WriteLine(myresult);

        }
    }
}
