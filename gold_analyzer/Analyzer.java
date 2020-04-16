package gold_analyzer;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

public class Analyzer {
	

	public static void main(String[] args){
		ParaseJSON url = new ParaseJSON("http://api.nbp.pl/api/cenyzlota");
		JSONArray x =url.getJSONArray();
		System.out.println(x);
		
		Scanner in=new Scanner(System.in);
		System.out.println("Podaj notowania cen z³ota");
		int liczba=in.nextInt();
		ParaseJSON url2=new ParaseJSON("https://api.nbp.pl/api/cenyzlota/last/" + liczba);
		JSONArray g=url2.getJSONArray();
		System.out.println(g);
	
		 double a=whatIsThePriceOfgold(x);
		//System.out.println("Aktualna cena zlota to: " + a);
		 
		 String h=whatIsTheDate(x);
		// System.out.println("Z dnia: "+ h);
		 
		System.out.println("Aktualna cena zlota to: " + a + " z dnia: "+ h );
		
		double r=howAseriesOfRecentGoldQuotations(g,liczba);
		System.out.println("Seria ostatnich notowan to " + r );		
		System.out.println("Œrednia z ostatnich " + liczba + "notowan jest równa " + r/liczba);
	}
	
	public static double whatIsThePriceOfgold(JSONArray y) {
		JSONObject obj = y.getJSONObject(0);
		double cena = obj.getDouble("cena");
		return cena;	
	}
	
	public static String whatIsTheDate(JSONArray q) {
		JSONObject obj=q.getJSONObject(0);
		String data=obj.getString("data");
		return data;	
	}
	
	public static double howAseriesOfRecentGoldQuotations(JSONArray f,int liczba){
		
		double p=0;
		for(int y=0; y<liczba; y++){
			double cena = f.getJSONObject(y).getDouble("cena");
			p=p+cena;
		}
		
		return p;	
	}
	
}
