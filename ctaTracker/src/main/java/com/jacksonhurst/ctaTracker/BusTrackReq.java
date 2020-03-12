package com.jacksonhurst.ctaTracker;

public class BusTrackReq {
	private final String stpid;

	public BusTrackReq(String stpid) {
		this.stpid = stpid;
	}

	public String getId() {
		return stpid;
	}

}
