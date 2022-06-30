using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharpStudy06
{

    //추상클래스
    //메소드를 구체화하지 않는다.
    //이걸 상속하는 클래스가 구체화 해야 한다.

    public abstract class Animal
    {
        public int Age { get; set; }
        public abstract void eat();
    }
}
