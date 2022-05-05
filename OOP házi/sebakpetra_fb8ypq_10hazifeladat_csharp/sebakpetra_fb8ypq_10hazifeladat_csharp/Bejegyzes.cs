using System;
using System.Collections.Generic;
using System.Text;

namespace egyetem

{
    class Bejegyzes
    {
        string tantargy;
        DateTime datum;
        int erdemjegy;

        public string Tantargy { get => tantargy; set => tantargy = value; }
        public DateTime Datum { get => datum; set => datum = value; }
        public int Erdemjegy { get => erdemjegy; set => erdemjegy = value; }

        public Bejegyzes(string tantargy,DateTime datum,int erdemjegy)
        {
            this.tantargy = tantargy;
            this.datum = datum;
            
            if(erdemjegy>=1 && erdemjegy<=5)
            {
                this.erdemjegy = erdemjegy;
                
            }
            else
            {
                throw new InvalidMarkException(erdemjegy);
               
            }
        }
        public override string ToString()
        {
            return "Tantargy: " + Tantargy + " Datum: " + Datum + " Erdemjegy: " + Erdemjegy;
        }

    }
}
