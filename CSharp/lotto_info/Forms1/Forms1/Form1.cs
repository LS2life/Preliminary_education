using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Forms1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            button_random.Text = "안녕";
            label_random.Text = new Random().Next().ToString();

        }

        private void button1_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Test");
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label_random_Click(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {

        }

        private void button_random_Click(object sender, EventArgs e)
        {
            int num = new Random().Next(1, 46);

            label_random.Text = num + "";//num.ToString();
        }
    }
}
