using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharpStudy06
{
    //Student 클래스를 상속 받음
    public class EliteStudent : Student
    {
        public void 대학생활()
        {
            sleep(); //sleep은 EliteStudent는 쓸 수 있다.
            //하지만 다른 클래스에선 못 쓴다.
        }
    }
}
