using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UseAPIStudy
{
    public class Locale
    {
        public string Name { get; set; }
        public double Lat { get; set; }
        public double Lng { get; set; }

        public Locale(string name, double lat, double lng)
        {
            Name = name;
            Lat = lat;
            Lng = lng;
        }

        //Object 클래스(=모든 객체의 조상)의 ToString을 덮어쓰기함(=오버라이드)

        public override string ToString()
        {
            //return base.ToString();
            return Name;
        }


    }
}
