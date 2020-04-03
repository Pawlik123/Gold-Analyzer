package gold_analyzer;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Analyzer {
	
	public static void main(String[] args){
		ParaseJSON url = new ParaseJSON("http://api.nbp.pl/api/cenyzlota");
		JSONArray x =url.getJSONArray();
		System.out.println(x);
		
		 double a=whatIsThePriceOfgold(x);
		//System.out.println("Aktualna cena zlota to: " + a);
		 
		 String h=whatIsTheDate(x);
		 //System.out.println("Z dnia: "+ h);
		 
		System.out.println("Aktualna cena zlota to: " + a + " z dnia: "+ h );
	
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
}






