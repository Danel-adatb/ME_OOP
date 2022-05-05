package Konyv;
import java.util.*;
public class Book {
	String cim;
	String szerzo;
	int ev;
	int ar;
	int oldalszam;
	String kiado="Móra";
	
	public Book(String a,String b,int c,int e)
	{
		cim=a;
		szerzo=b;
		java.time.LocalDate ido=java.time.LocalDate.now();
		ev=ido.getYear();
		ar=c;
		
		oldalszam=e;
	}
	public Book(String a,String b,int e)
	{
		cim=a;
		szerzo=b;
		java.time.LocalDate ido=java.time.LocalDate.now();
		ev=ido.getYear();
		ar=2500;
		
		oldalszam=e;
	}
	
public String getCim() {
		return cim;
	}
	public void setCim(String cim) {
		this.cim = cim;
	}
	public String getSzerzo() {
		return szerzo;
	}
	public void setSzerzo(String szerzo) {
		this.szerzo = szerzo;
	}
	public int getEv() {
		return ev;
	}
	public void setEv(int ev) {
		this.ev = ev;
	}
	public int getAr() {
		return ar;
	}
	public void setAr(int ar) {
		this.ar = ar;
	}
public static int novel(int a)
{
	Scanner input=new Scanner(System.in);
	int szazalek=input.nextInt();
	a=a*((100/szazalek)+1);
	input.close();
	return a;
}
public String ToString()
{
	return "Cím: "+cim+" Szerzõ: "+ szerzo+" Ev "+ev+" Ár: "+ar+" Oldalszam: "+oldalszam+" Kiado: "+kiado;
}
public Book hosszabb(Book a,Book b)
{
	if(a.oldalszam>b.oldalszam)return a;
	else return b;
}
public Boolean paros(Book a)
{
	if(a.oldalszam%2==2)return true;
	else return false;
}
}
