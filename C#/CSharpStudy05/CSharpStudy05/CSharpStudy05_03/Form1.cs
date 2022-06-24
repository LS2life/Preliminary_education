using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml.Linq;

namespace CSharpStudy05_03
{
    public partial class Form1 : Form
    {
        List<Weather> w = new List<Weather>();


        public Form1()
        {
            InitializeComponent();

        }

        private void button1_Click(object sender, EventArgs e)
        {
            string url = "https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1150061500";
            XElement xe = XElement.Load(url);
            foreach (var item in xe.Descendants("data"))
            {
                Weather t = new Weather();
                t.Name = item.Element("wfKor").Value;
                t.Temp = double.Parse(item.Element("temp").Value);
                w.Add(t);
            }

            dataGridView1.DataSource = null;
            dataGridView1.DataSource = w;
        }

        List<Air> airs = new List<Air>();
        private void button2_Click(object sender, EventArgs e)
        {
            string url =
                "https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustFrcstDspth?serviceKey=I35xhBVrKuRe7RbiQpN9NOkt%2B6JQT5Fd0fgCNDuB0dURcjnYRTmTeyrFaNHFDHVY%2FQ4etMclK24pY%2FdEMx2fGQ%3D%3D&returnType=xml&numOfRows=100&pageNo=1&searchDate=2022-06-20&InformCode=PM10";
            XElement xe = XElement.Load(url);

            foreach (var item in xe.Descendants("item"))
            {
                Air a = new Air();
                a.informData = item.Element("informData").Value;
                a.informGrade = item.Element("informGrade").Value;
                airs.Add(a);
            }

            dataGridView2.DataSource = null;
            dataGridView2.DataSource = airs;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            //https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=861

            int count = 1000; //1000회차부터 현재까지 출력하기

            List<Lotto> lottos = new List<Lotto>();

            while (true)
            {
                var json =
                    new WebClient().DownloadString("https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=" + count);
                count++;
                var jArray = JObject.Parse(json);
                if (jArray["returnValue"].ToString() == "fail")
                    break;

                Lotto l = new Lotto()
                {
                    drwNoDate = jArray["drwNoDate"].ToString(),
                    totSellamnt = jArray["totSellamnt"].ToString()
                };

                lottos.Add(l);
            }
            dataGridView3.DataSource = null;
            dataGridView3.DataSource = lottos;
        }

    }
}

