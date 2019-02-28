package com.lt.farmautomation.controlpoints;


public abstract class Device {
	protected String deviceID;
	protected String name;

	public Device(String name, String deviceID) {
		this.name = name;
		this.deviceID = deviceID;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}
	
}
