using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharpStudy06
{
    public class Pokemon : Animal, IAnimal, ICharacter
    {

        public string Name { get; set; }
        public int Lv { get; set; }

        public override void eat()
        {
            System.Windows.Forms.MessageBox.Show("Test");
        }

        public void Fight()
        {
            throw new NotImplementedException();
        }

        public void SayHi()
        {
            throw new NotImplementedException();
        }

        public void Sleep()
        {
            throw new NotImplementedException();
        }
    }
}
