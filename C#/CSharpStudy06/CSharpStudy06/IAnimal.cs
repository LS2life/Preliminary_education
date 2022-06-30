using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharpStudy06
{
    //특정 메소드를 구현해야 하는 규칙
    //이 인터페이스를 상속한다면
    //(자바기준으로 얘기하면 implements)
    //반드시 지정된 메소드를 구현해야 함
    public interface IAnimal
    {
        void Fight();
        void Sleep();
    }
}
