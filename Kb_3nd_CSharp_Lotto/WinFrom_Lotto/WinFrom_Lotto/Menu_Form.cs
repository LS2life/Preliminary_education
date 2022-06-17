using System;
using System.Text;
using System.Drawing;
using System.Linq;
using System.Windows.Forms;

namespace WinFrom_Lotto
{
    public partial class Menu_Form : Form
    {
        const int MAX_SLIDING_WIDTH = 778;
        const int MIN_SLIDING_WIDTH = 5;
        const int STEP_SLIDING = 10;
        int _panel1 = MIN_SLIDING_WIDTH;
        int _panel2 = MIN_SLIDING_WIDTH;
        Random r = new Random();

        public Menu_Form()
        {
            InitializeComponent();

            //checkBox1.Checked = true;
            //checkBox1.Checked = false;
            //checkBox2.Checked = true;
            //checkBox2.Checked = false;


            num1.Text = "";
            num2.Text = "";
            num3.Text = "";
            num4.Text = "";
            num5.Text = "";
            num6.Text = "";



            Try_one.Text = "Get Ready!";
            Try_one.MouseMove += (s, e) =>
            {
                Try_one.Text = "Set !";
                Try_one.ForeColor = Color.Yellow;
            };

            Try_one.MouseLeave += (s, e) =>
            {
                Try_one.Text = "Get Ready!";
                Try_one.ForeColor = Color.Black;
            };

            Try_one.MouseDown += (s, e) =>
            {
                Try_one.Text = "GO !!";
                Try_one.ForeColor = Color.Red;
            };

            //  ! 2 page
            Try_5.Text = "Get Ready!";
            Try_5.MouseMove += (s, e) =>
            {
                Try_5.Text = "Set !";
                Try_5.ForeColor = Color.Yellow;
            };

            Try_5.MouseLeave += (s, e) =>
            {
                Try_5.Text = "Get Ready!";
                Try_5.ForeColor = Color.Black;
            };

            Try_5.MouseDown += (s, e) =>
            {
                Try_5.Text = "GO !!";
                Try_5.ForeColor = Color.Red;
            };


            Try_one.Click += (s, e) =>
            {
                /*
			num1.Text = r.Next(1, 46).ToString();
			num2.Text = r.Next(1, 46).ToString();
			num3.Text = r.Next(1, 46).ToString();
			num4.Text = r.Next(1, 46).ToString();
			num5.Text = r.Next(1, 46).ToString();
			num6.Text = r.Next(1, 46).ToString();
			num7.Text = r.Next(1, 46).ToString();
                 */
                int[] lotto_num = new int[6];

                for (int i = 0; i < 6; i++)
                {
                    int num = r.Next(1, 46);
                    if (!lotto_num.Contains(num))
                        lotto_num[i] = num;
                    else
                        i--;
                }

                Array.Sort(lotto_num);

                num1.Text = lotto_num[0].ToString();
                num2.Text = lotto_num[1].ToString();
                num3.Text = lotto_num[2].ToString();
                num4.Text = lotto_num[3].ToString();
                num5.Text = lotto_num[4].ToString();
                num6.Text = lotto_num[5].ToString();

            };

            Try_5.Click += (s, e) =>
            {
		    label1.Text = "";
		    label2.Text = "";
		    label3.Text = "";
		    label4.Text = "";
		    label5.Text = "";

                Array[] label = new Array[5];

                for (int j = 0; j < 5; j++)
                {
                    int[] lotto_num = new int[6];

                    for (int i = 0; i < 6; i++)
                    {
                        int num = r.Next(1, 46);
                        if (!lotto_num.Contains(num))
                            lotto_num[i] = num;
                        else
                            i--;
                    }
                    label[j] = lotto_num;
                    Array.Sort(lotto_num);
                }

                foreach (var item in label[4])
                {
                    label1.Text += item + " ";
                }
                foreach (var item in label[3])
                {
                    label2.Text += item + " ";
                }
                foreach (var item in label[2])
                {
                    label3.Text += item + " ";
                }
                foreach (var item in label[1])
                {
                    label4.Text += item + " ";
                }
                foreach (var item in label[0])
                {
                    label5.Text += item + " ";
                }
            };
        }

        private void checkBox1_CheckedChanged(object sender, EventArgs e)
        {
            if (checkBox1.Checked)
            {
                checkBox2.Checked = false;
                timer1.Start();
                //Console.WriteLine("!!!");
                //timer2.Stop();
            }
            else
            {
                //Console.WriteLine("???");
                checkBox2.Checked = true;
            }
        }

        private void checkBox2_CheckedChanged(object sender, EventArgs e)
        {
            if (checkBox2.Checked)
            {
                // Console.WriteLine("@@@");
                checkBox1.Checked = false;
                timer2.Start();
                //timer1.Stop();
            }
            else
            {
                // Console.WriteLine("_)___");
                checkBox1.Checked = true;
            }

        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            if (checkBox1.Checked == true)
            {
                //panel1.BringToFront();
                _panel1 += STEP_SLIDING;
                //Console.WriteLine(_panel1+"???1");
                if (_panel1 >= MAX_SLIDING_WIDTH)
                {
                    //timer1.Stop();
                    _panel1 = MAX_SLIDING_WIDTH;
                    Console.WriteLine("///");
                }
                else
                {
                    panel1.Width = _panel1;
                }

            }
            else
            {
                //Console.WriteLine("zzzz");
                //Console.WriteLine(_panel1 + "!!!1");
                _panel1 -= STEP_SLIDING;
                if (_panel1 <= MIN_SLIDING_WIDTH)// { }
                {
                    //timer1.Stop();
                    // timer2.Start();
                    _panel1 = MIN_SLIDING_WIDTH;
                    Console.WriteLine("\\");
                }
                else
                {
                    panel1.Width = _panel1;
                }

            }

        }
        private void timer2_Tick(object sender, EventArgs e)
        {
            if (checkBox2.Checked == true)
            {
                //panel1.BringToFront();
                _panel2 += STEP_SLIDING;
                //Console.WriteLine(_panel1+"???1");
                if (_panel2 >= MAX_SLIDING_WIDTH)
                {
                    //timer1.Stop();
                    _panel2 = MAX_SLIDING_WIDTH;
                    Console.WriteLine("!!");
                }
                else
                {
                    panel2.Width = _panel2;
                }

            }
            else
            {
                //Console.WriteLine("zzzz");
                //Console.WriteLine(_panel1 + "!!!1");
                _panel2 -= STEP_SLIDING;
                if (_panel2 <= MIN_SLIDING_WIDTH)// { }
                {
                    //timer1.Stop();
                    // timer2.Start();
                    _panel2 = MIN_SLIDING_WIDTH;
                    Console.WriteLine("@@");
                }
                else
                {
                    panel2.Width = _panel2;
                }

            }


        }

        private void linkLabel1_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            System.Diagnostics.Process.Start("https://flyasiana.com/C/KR/KO/index?site_preference=NORMAL");
        }

        private void toolTip1_Popup(object sender, PopupEventArgs e)
        {
            toolTip1.SetToolTip(this.linkLabel1, "땅콩 좋아하니?");
        }

        private void linkLabel2_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            System.Diagnostics.Process.Start("http://www.dhlottery.co.kr/gameResult.do?method=statIndex");
        }

        private void linkLabel4_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            System.Diagnostics.Process.Start("https://www.mercedes-benz.co.kr/passengercars/models.html?group=amg&subgroup=see-all&view=BODYTYPE&_ga=2.72591827.1741469155.1627298254-236307989.1626161520&tgroup=realTarget");
        }

        private void linkLabel3_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            System.Diagnostics.Process.Start("https://www.hermes.com/kr/ko/category/women/bags-and-small-leather-goods/bags-and-clutches/#");
        }


    }
}
