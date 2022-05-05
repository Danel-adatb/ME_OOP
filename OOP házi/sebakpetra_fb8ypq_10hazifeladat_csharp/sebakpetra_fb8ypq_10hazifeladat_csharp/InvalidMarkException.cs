using System;
using System.Collections.Generic;
using System.Text;

namespace egyetem
{
    class InvalidMarkException : Exception
    {
        int ervenytelenerdemjegy;

        public int Ervenytelenerdemjegy { get => ervenytelenerdemjegy; set => ervenytelenerdemjegy = value; }

        public InvalidMarkException(int ervenytelenerdemjegy)
        {
            this.ervenytelenerdemjegy = ervenytelenerdemjegy;
        }
    }
}
