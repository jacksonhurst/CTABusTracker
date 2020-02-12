
public class BusPrediction {
	public String destination;
	public String vehicleId;
	public int predictedTime;
	
	public BusPrediction(String destination, String vehicleId, int predictedTime) {
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
