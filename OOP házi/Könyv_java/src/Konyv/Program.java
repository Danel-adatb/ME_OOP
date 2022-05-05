package Konyv;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		//Ez volt az eredeti
		/*Scanner input=new Scanner(System.in);
		System.out.println("Adja meg az elsõ könyv adatait:");
		Book konyv=new Book(input.nextLine(),input.nextLine(),input.nextInt(),input.nextInt());
		System.out.println(konyv.ToString());
		System.out.println("Adja meg a masodik könyv adatait:");
		Book konyv2=new Book(input.nextLine(),input.nextLine(),input.nextInt());
		System.out.println(konyv2.ToString());*/
		
		//Ez a kiegészítés
		Scanner input=new Scanner(System.in);
		
		System.out.println("Hány darab könyv van?");
		int n=input.nextInt();
		Book[] konyvek=new Book[n];
		System.out.println("Adja meg a könyvek adatait:(cím,szerzõ,ár,oldalszám)");
		for (int i = 0; i < n; i++) 
		{
			System.out.println((i+1)+". könyv adatai:");
		//A cimet es a szerzo ha tobb szobol all '_' jellel kell elvalasztani
			String a=input.next();
			String b=input.next();
			int c=input.nextInt();
			int d=input.nextInt();
			konyvek[i]=new Book(a,b,c,d);
		}
		input.close();
		
		
		
		System.out.println("A leghosszabb könyv: ");
		System.out.println(konyvek[leghosszabb(n,konyvek)].ToString());
		
		System.out.println("A leghosszabb páros oldalszámú könyv: ");
		leghosszabbparos(n,konyvek);

		szerzok(n,konyvek);
	}
	
	public static int leghosszabb(int n,Book[] konyvek)
	{
		int max=0;
		for (int i = 0; i < n; i++) 
		{
			if(konyvek[max].oldalszam<konyvek[i].oldalszam)
			{
				max=i;
			}
		}
		return max;
	}
	public static void leghosszabbparos(int n,Book[] konyvek)
	{
		int maxhely=5000;
		for (int i = 0; i < n; i++) 
		{
			if((konyvek[i].oldalszam)%2==0)
			{
				maxhely=i;
				break;
			}
		}
		if(maxhely==5000) System.out.println("Nincs páros");
		else {
		for (int i = 0; i < n ; i++) 
		{
			if((konyvek[i].oldalszam)%2==0 && konyvek[i].oldalszam<konyvek[maxhely].oldalszam )
			{
				maxhely=i;
			}
		}
		System.out.println(konyvek[maxhely].ToString());
		}
		
	}
	public static void szerzok(int n,Book[] konyvek)
	{
		
		int[] darab=new int[n];
		for (int i = 0; i < n; i++) {
			darab[i]=(int)(Math.random()*90)+1;
		}
		
		for (int i = 0; i < n; i++) 
		{
			int db=1;
			for (int j = i+1; j < n; j++) 
			{
				if(konyvek[i].szerzo.equals(konyvek[j].szerzo))
				{
					db++;
					darab[j]=0;
				}
				
			}
			if(darab[i]!=0)
			{
				darab[i]=db;
			}
		}
		for (int i = 0; i < n; i++) {

		if(darab[i]!=0) {
			System.out.println(konyvek[i].szerzo+" "+darab[i]+"db könyvet írt");
		}
		
		}
	}

}
