package com.jacksonhurst.ctaTracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusController {
	@GetMapping("/track-bus")
	public BusTrackResp[] greeting(@RequestParam(value = "stpid") String stpid) throws Exception {
		
		System.out.println("Request made");
		
		BusTrackResp[] incomingBusses;
		try {
			incomingBusses = BusService.getBusses(stpid);
		} catch (Exception e) {
			throw new Exception("Error while making request to CTA API");
		}
		
		return incomingBusses;
	}
}
