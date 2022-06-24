using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharpStudy03
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //참고로 이 녹색 글자는 그냥 보시면 됩니다.
            //자바의 주석이랑 똑같음

            Console.WriteLine("안녕"); //System.out.println이랑 동일

            Console.WriteLine(); //그냥 한 줄 띈 거
            Console.WriteLine();
            Console.WriteLine();
            //cw <- 코드조각이라고 부름

            Console.WriteLine(1+2+""+3+4); //앞에 더하기는 숫자 더하기
            //""이 나오고 나서는 문자열로써 더하기가 됨
            //즉 앞의 더하기는 1+2=3 이 나오고
            //뒤의 더하기는 글자 3과 4를 이어붙인 것
            //334
            Console.WriteLine("안녕"+"하세요");//2개의 문자열을 이어 붙임

            //ctrl+d -> 한 줄 복사 붙여넣기가 됨
            Console.WriteLine("반갑습니다."[0]);//반 을 출력
            Console.WriteLine("반갑습니다."[5]);//. 을 출력

            //자바에서 문자열의 특정 글자를 추출하려면 charAt을 썼다.
            //하지만 씨샵에서는 배열처럼 대괄호([])를 쓰면 된다.
            //가장 첫번째 글자는 0
            //끝에 글자는 글자길이-1입니다.
            //반갑습니다.  이건 점까지 해서 6글자짜리다. 그래서 [5]하면
            //가장 끝의 글자인 점이 찍힌다.


            Console.WriteLine(true & true); //t
            Console.WriteLine(true | false); //t
            Console.WriteLine(true ^ true); //f
            Console.WriteLine(false ^ false);//f

            int a = 2147483640;
            int b = 52273;
            Console.WriteLine(a+b);//-2147431383

            Console.WriteLine(int.MaxValue);
            //System.out.println(Integer.MAX_VALUE);
            Console.WriteLine(int.MinValue);
            Console.WriteLine(uint.MaxValue);//음수를 쓰지 않음
            Console.WriteLine(uint.MinValue);//0

            Console.WriteLine((char)65);//A
            Console.WriteLine((int)'a');//97

            string name = "이";
            name += "동준"; //"이"+"동준", name=name+"동준";
            Console.WriteLine(name);

            b = 0;
            Console.WriteLine(++b);//1
            Console.WriteLine(b++);//1
            Console.WriteLine(b);//2
            b++;//++b나 b++이나 출력되는 모양은 똑같다.
            Console.WriteLine(b);

            Console.WriteLine("당신의 MBTI를 입력하세요.");
            string mymbti = Console.ReadLine();
            Console.WriteLine("당신의 MBTI는 " + mymbti+"입니다.");
            Console.WriteLine("당신의 태어난 연도를 입력하세요.");
            int year = int.Parse(Console.ReadLine());
            //int.Parse의 기능 -> 문자열을 정수로 바꿔줌
            //실수로 바꾸고 싶다면 double.Parse를 쓰면 됨
            Console.WriteLine("태어난 연도 : " + year);

            //숫자를 문자열로 바꾸는 방식 2가지
            Console.WriteLine(year.ToString());
            Console.WriteLine(year+"");
            Console.WriteLine(123.ToString());
            Console.WriteLine(123+"");


        }
    }
}
