package com.jacksonhurst.ctaTracker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class BusService {
	
	public static BusTrackResp[] getBusses(String stpid) throws Exception {
		
		String baseURL = "http://www.ctabustracker.com/bustime/api/v2/getpredictions";
		String key = "64qXx9NUedsUXyaNKxvLWVA5K";
		
		StringBuilder url = new StringBuilder();
		url.append(baseURL);
		url.append("?key=");
		url.append(key);
		url.append("&stpid=");
		url.append(stpid);
		url.append("&format=json");
		
		try {
			URL urlForGetRequest = new URL(url.toString());
		    String readLine = null;
		    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
		    conection.setRequestMethod("GET");

		    int responseCode = conection.getResponseCode();
		    if (responseCode == HttpURLConnection.HTTP_OK) {
		        BufferedReader in = new BufferedReader(
		            new InputStreamReader(conection.getInputStream()));
		        StringBuffer response = new StringBuffer();
		        while ((readLine = in.readLine()) != null) {
		            response.append(readLine);
		        } in.close();
		        // print result
		        JSONObject json = new JSONObject(response.toString());
		        
		        JSONObject bustimeResponse = json.getJSONObject("bustime-response");
		        
		        JSONArray incomingVehicles = bustimeResponse.getJSONArray("prd");
		        
		        BusTrackResp[] incomingBusses = new BusTrackResp[incomingVehicles.length()];
		        
		        for(int i = 0; i < incomingVehicles.length(); i++) {
		        	JSONObject nextBus = incomingVehicles.getJSONObject(i);
		        	String dest = nextBus.getString("des");
		        	String vid = nextBus.getString("vid");
		        	String estTime = nextBus.getString("prdctdn");
		        	incomingBusses[i] = new BusTrackResp(dest, vid, estTime);
		        }
		        
		        return incomingBusses;

		    } else {
		        throw new Exception("Error while making request to CTA API");
		    }
		} catch (Exception e) {
	        throw new Exception("Error while making request to CTA API");
		}
	}
	
}

