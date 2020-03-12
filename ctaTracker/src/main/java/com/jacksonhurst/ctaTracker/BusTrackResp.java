package com.jacksonhurst.ctaTracker;

public class BusTrackResp {
	public String destination;
	public String vehicleId;
	public String predictedTime;
	
	public BusTrackResp(String destination, String vehicleId, String predictedTime) {
		this.destination = destination;
		this.vehicleId = vehicleId;
		this.predictedTime = predictedTime;
	}
	
	public String toString() {
		return "Dest: " + this.destination + 
				"\nVehicle ID: " + this.vehicleId +
				"\nPredicted Time to Stop: " + this.predictedTime;
	}
}
