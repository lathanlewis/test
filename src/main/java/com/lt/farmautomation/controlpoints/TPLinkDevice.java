package com.lt.farmautomation.controlpoints;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TPLinkDevice extends Device {
	private static final String ACCOUNT = "3528876";
	private static final String TOKEN = "5fece690-A5blxkikqRhrozwUxnyYwhQ";
	private static final String URL = "https://wap.tplinkcloud.com/";
	
	public TPLinkDevice(String name, String deviceID) {
		super(name, deviceID);
	}

	public boolean turnOn() {
		System.out.println("Turning [" + name + "] On");
		
		Client client = Client.create();

		WebResource webResource = client
		   .resource(URL).queryParam("token", TOKEN);

		String input = "{\"method\":\"passthrough\", \"params\":{\"deviceId\":\"";
		input += deviceID;
		input += "\",\"requestData\": \"{\\\"system\\\":{\\\"set_relay_state\\\":{\\\"state\\\":1}}} \" }}";

//		System.out.println("json:" + input);		
//		System.out.println("webrsrc:" + webResource.toString());
		
		ClientResponse response = webResource.type("application/json")
		   .post(ClientResponse.class, input);

		if (response.getStatus() != 201) {
			System.out.println("Failed : HTTP error code : "
			     + response.getStatus());
		}

		System.out.println("Output from Server .... \n");
		String output = response.getEntity(String.class);
		System.out.println(output);

		
		return true;
	}
	
	public boolean turnOff() {
		System.out.println("Turning [" + name + "] Off");
		
		Client client = Client.create();

		WebResource webResource = client
		   .resource(URL).queryParam("token", TOKEN);

		String input = "{\"method\":\"passthrough\", \"params\":{\"deviceId\":\"";
		input += deviceID;
		input += "\",\"requestData\": \"{\\\"system\\\":{\\\"set_relay_state\\\":{\\\"state\\\":0}}} \" }}";

//		System.out.println("json:" + input);		
//		System.out.println("webrsrc:" + webResource.toString());
		
		ClientResponse response = webResource.type("application/json")
		   .post(ClientResponse.class, input);

		if (response.getStatus() != 201) {
			System.out.println("Failed : HTTP error code : "
			     + response.getStatus());
		}

		System.out.println("Output from Server .... \n");
		String output = response.getEntity(String.class);
		System.out.println(output);

		
		return true;
	}
}
