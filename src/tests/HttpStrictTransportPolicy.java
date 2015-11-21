package tests;

import java.util.List;
import java.util.Map;
import main.ResultHelper;

//import org.jsoup.Connection.Response;

import objects.Result;

public class HttpStrictTransportPolicy {
	
	private static boolean strictEnabled = false;
	private static String details = "Not found";
	
	public static void StartTest(Map<String, List<String>> urlRespMap, Result resultObj) {
		System.out.print("Strict-Transport-Security header: ");
		if(urlRespMap.containsKey("Strict-Transport-Security")) {
			System.out.print("Found\n");
			strictEnabled = true;
		}else{
			strictEnabled = false;
		}
		
		resultObj.setStrictEnabled(strictEnabled); 
		details = ResultHelper.addDetails(urlRespMap, resultObj, "Strict-Transport-Security");
		
		if (details.length()==0)
			details="Strict Transport Security header not found!";
		
		resultObj.setStrictDetails(details);
	}
}
