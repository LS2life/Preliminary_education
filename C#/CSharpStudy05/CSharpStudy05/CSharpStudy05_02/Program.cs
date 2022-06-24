using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace CSharpStudy05_02
{
    internal class Program
    {
        static void Main(string[] args)
        {
            List<Product> input = new List<Product>()
            {
                new Product() {Name="고구마", Price=1500},
                new Product() {Name="사과", Price=2400}
            };
            input.Add(new Product() { Name = "바나나", Price = 1000 });
            Product p = new Product() { Name = "배", Price = 3000 };
            input.Add(p);
            Product p2 = new Product();
            p2.Name = "감자";
            p2.Price = 1000;
            input.Add(p2);

            input.Add(new Product() { Name = "토마토", Price = 2000 });
            input.Add(new Product() { Name = "옥수수", Price = 1500 });
            input.Add(new Product() { Name = "자두", Price = 500 });


            //가격이 1500원 이상인 제품들을 제품명으로 오름차순한 것
            //ascending 오름 차순(생략가능)
            Console.WriteLine("1번");
            var output1 = from ㅁㅁ in input
                          where ㅁㅁ.Price > 1500 
                          orderby ㅁㅁ.Name ascending
                          select ㅁㅁ;
            foreach(var item in output1)
                Console.WriteLine(item);//item 대신 item.ToString() 해도 똑같음
            Console.WriteLine("2번");
            var output2 = from item in input orderby item.Price select item;
            foreach(var item in output2)
                Console.WriteLine(item);
            Console.WriteLine("3번");
            var output3 = from item in input orderby item.Price descending select item;
            foreach(var item in output3)
                Console.WriteLine(item);

            //string만 저장되고
            //제품명:가격원
            Console.WriteLine("4-1");
            var output4 = from item in input select item.ToString();
            foreach(var item in output4)
                Console.WriteLine(item);
            Console.WriteLine("4-2");
            var output4_2 = from item in input select item.Name + ":" + item.Price;
            foreach(var item in output4_2)
                Console.WriteLine(item);

            Console.WriteLine("-------------------------------------------");

            string url = "https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1150061500";
            XElement xe = XElement.Load(url);
            Console.WriteLine(xe);
            Console.WriteLine("-------------------------------------------");

            var xQ = from item in xe.Descendants("data") select item;
            foreach(var item in xQ)
            {
                Console.WriteLine(item.Element("day").Value);
                Console.WriteLine(item.Element("temp").Value);
                Console.WriteLine(item.Element("wfKor").Value);
            }

            List<Weather> w = new List<Weather>();
            foreach(var item in xe.Descendants("data"))
            {
                Weather temp = new Weather();
                temp.Name = item.Element("wfKor").Value;
                temp.Temp = double.Parse(item.Element("temp").Value);
                w.Add(temp);
            }

            foreach(var item in w)
            {
                Console.WriteLine(item.Name);
                Console.WriteLine(item.Temp);
            }


        }
    }
}
