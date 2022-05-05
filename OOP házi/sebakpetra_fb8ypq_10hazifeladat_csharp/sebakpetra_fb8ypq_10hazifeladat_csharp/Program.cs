using System;
using System.Collections.Generic;
using System.IO;
using System.Runtime.InteropServices.ComTypes;
using System.Text;

namespace egyetem
{
    class Program
    {
        static void Main(string[] args)
        {
            string file = "bejegyzes.txt";
            
            Console.WriteLine("Szeretne beolvasni új bejegyzést? IGEN vagy NEM");
            string q = Console.ReadLine();
            if (q=="igen" || q=="IGEN" || q=="Igen")
            {
                Console.WriteLine("Írja be egy bejegyzés adatait:");
                Bejegyzes bejegyzes = Kivetelkezeles();
                Fajlbairas(bejegyzes, file);
            }
            Console.WriteLine("Bejegyzések: ");
            Fajlbololvasas(file);
            

        }

        private static void Fajlbololvasas(string file)
        {
            StreamReader reader = null;
            try
            {
                reader = new StreamReader(file);
                while(!reader.EndOfStream)
                {
                    string readLine = reader.ReadLine();
                    Console.WriteLine(readLine);
                }
            }
            catch (IOException e)
            {
                Console.WriteLine("Hiba a fájl olvasásakor");
            }
            finally
            {
                if(reader!=null)
                {
                    reader.Close();
                }
            }
        }

        private static void Fajlbairas(Bejegyzes b,string file)
        {
            
            FileStream filestream = null;
            StreamWriter writer = null;
            
            try
            {
                filestream = new FileStream(file, FileMode.Append);
                writer = new StreamWriter(filestream, Encoding.ASCII);
                writer.WriteLine(b);
            }
            catch (IOException e)
            {
                Console.WriteLine("Hiba történt a fájl írásakor....");
            }
            finally
            {
                if (writer != null)
                {
                    writer.Close();
                }
            }
        }

        public static string Beolvasstring()
        {
            string s;
            int n;
            bool success;
            do
            {
                s = Console.ReadLine();
                if(int.TryParse(s,out n))
                {
                    success = false;
                }
                else
                {
                    success = true;
                }
                if (!success)
                {
                    Console.WriteLine("Nem fegfelelő adat! Próbálja meg újra!");
                }
            } while (!success);
            return s;
        }
        public static DateTime Beolvasdatum()
        {
            string s;
            DateTime n;
            bool success;
            do
            {
                s = Console.ReadLine();
                success = DateTime.TryParse(s, out n);
                if (!success)
                {
                    Console.WriteLine("Nem fegfelelő adat! Próbálja meg újra!");
                }
            } while (!success);
            return n;
        }
        public static Bejegyzes Kivetelkezeles()
        {
           
            Console.Write("Tantárgy: ");
            string targy = Beolvasstring();
            Console.Write("Dátum: ");
            DateTime mikor = Beolvasdatum();
            bool ok = true;
            Bejegyzes b=null;
            do
            {
                try
                {

                    Console.Write("Érdemjegy: ");
                    string seged = Console.ReadLine();
                    int jegy = int.Parse(seged);
                    b = new Bejegyzes(targy, mikor, jegy);
                    ok = true;

                    
                }
                catch (InvalidMarkException jegy)
                {
                    Console.WriteLine("Nem megfelelő az érdemjegy!");
                    ok = false;
                }
                catch (FormatException seged)
                {
                    Console.WriteLine("Nem megfelelő az érdemjegy!");
                    ok = false;
                }

            } while (!ok);


            return b;



        }
    }
}