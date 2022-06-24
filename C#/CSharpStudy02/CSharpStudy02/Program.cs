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
            Console.WriteLine((int)'A');
            Console.WriteLine((char)97);

            Console.WriteLine(10+20);
            Console.WriteLine(""+10+20);
            Console.WriteLine(10+20+""+30+40);
            Console.WriteLine("안녕"+"하세요");

            Console.WriteLine("ABC"[0]);//가장 첫번째 글자
            Console.WriteLine((int)"ABC"[0]);//대문자 A => 65
            Console.WriteLine((int)"123"[0]);//49
            Console.WriteLine((int)"123"[0] -'0');
            Console.WriteLine((int)"123"[0] -48);

            Console.WriteLine(100==100);
            Console.WriteLine(100!=100);
            int a = 2147483647;
            a++;
            Console.WriteLine(a);

            Console.WriteLine(int.MaxValue);
            Console.WriteLine(long.MaxValue);
            Console.WriteLine(ulong.MaxValue);//음수 없는 long


            int aa = 100;//'A' = 65
            aa += 'A';
            Console.WriteLine(aa);

            int bb = 200;
            bb += aa;//165+200
            Console.WriteLine(bb);

            string hi = "Hello";
            hi += " World";
            Console.WriteLine(hi);

            int a1 = 10;
            int b1 = 20;

            //++ = +1하는 거랑 똑같은 거
            //-- = -1 하는 거랑 똑같은거
            //**
            Console.WriteLine(a1++);//10
            Console.WriteLine(a1);//11
            Console.WriteLine(++a1);//12


            a1 = 10;
            Console.WriteLine(++a1 + b1++); //31
            Console.WriteLine(++b1+a1); //33
            //실무에서는 이런식으로 적는다.
            a1++;
            b1++;
            Console.WriteLine(a1+b1);//++이 앞에 있으나 뒤에 있으나
            //결과가 똑같다.

            int test = int.Parse("1234");
            test++;
            Console.WriteLine(test); //1235

            Console.WriteLine("당신의 MBTI는 뭔가요?");
            Console.WriteLine(Console.ReadLine());
            string mbti = Console.ReadLine();
            Console.WriteLine("당신의 mbti는 " + mbti+"입니다.");

            //String.format
            //1. string.format
            //문자열에 들어갈 변수가 여러개면
            //{0}, {1}, {2}... 이렇게 숫자를 늘려주고
            //그에 따라서 변수들을 콤마(,) 뒤에 적으면 됨
            Console.WriteLine(string.Format("당신의 mbti:{0}{1}", mbti,aa) );

            //2. $ (자바스크립트에서도 유사한 방식이 있음)
            Console.WriteLine($"당신의 mbti는 {mbti}이에요.");

            string result = $"aa의 값은 {aa}이고, mbti는 {mbti}다";
            Console.WriteLine(result);

            Console.WriteLine("aaaa");

        }
    }
}
