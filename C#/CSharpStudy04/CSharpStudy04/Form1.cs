using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CSharpStudy04
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            button1.Text = "안녕";
            myButton.Text = "Hello";
            label_random.Text = new Random().Next().ToString();

            Random r = new Random();
            label_random.Text = r.Next().ToString();

            //디자인창에는 - 라고 적혀있으나
            //프로그램 시작시 아무 것도 안 보이게 된다.
            label_myrandom.Text = "";
        }

        private void button1_Click(object sender, EventArgs e)
        {
            //mbox tab tab
            MessageBox.Show("Test");
        }

        private void button2_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Test");
        }

        private void button9_Click(object sender, EventArgs e)
        {

        }

        private void button8_Click(object sender, EventArgs e)
        {

        }

        private void button_random_Click(object sender, EventArgs e)
        {
            Random r = new Random();
            //1이상 46 미만.
            //즉 1~45까지의 숫자 집어 넣을 수 있다.
            int num = r.Next(1, 46);
            label_myrandom.Text = num.ToString();//num+"";

        }
    }
}
