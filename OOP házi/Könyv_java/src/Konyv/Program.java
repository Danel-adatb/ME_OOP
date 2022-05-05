package Konyv;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		//Ez volt az eredeti
		/*Scanner input=new Scanner(System.in);
		System.out.println("Adja meg az els� k�nyv adatait:");
		Book konyv=new Book(input.nextLine(),input.nextLine(),input.nextInt(),input.nextInt());
		System.out.println(konyv.ToString());
		System.out.println("Adja meg a masodik k�nyv adatait:");
		Book konyv2=new Book(input.nextLine(),input.nextLine(),input.nextInt());
		System.out.println(konyv2.ToString());*/
		
		//Ez a kieg�sz�t�s
		Scanner input=new Scanner(System.in);
		
		System.out.println("H�ny darab k�nyv van?");
		int n=input.nextInt();
		Book[] konyvek=new Book[n];
		System.out.println("Adja meg a k�nyvek adatait:(c�m,szerz�,�r,oldalsz�m)");
		for (int i = 0; i < n; i++) 
		{
			System.out.println((i+1)+". k�nyv adatai:");
		//A cimet es a szerzo ha tobb szobol all '_' jellel kell elvalasztani
			String a=input.next();
			String b=input.next();
			int c=input.nextInt();
			int d=input.nextInt();
			konyvek[i]=new Book(a,b,c,d);
		}
		input.close();
		
		
		
		System.out.println("A leghosszabb k�nyv: ");
		System.out.println(konyvek[leghosszabb(n,konyvek)].ToString());
		
		System.out.println("A leghosszabb p�ros oldalsz�m� k�nyv: ");
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
		if(maxhely==5000) System.out.println("Nincs p�ros");
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
			System.out.println(konyvek[i].szerzo+" "+darab[i]+"db k�nyvet �rt");
		}
		
		}
	}

}
