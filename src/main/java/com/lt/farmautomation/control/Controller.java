package com.lt.farmautomation.control;

import com.lt.farmautomation.controlpoints.TPLinkDevice;
import com.lt.farmautomation.sensors.SensorData;

public class Controller {
	private static TPLinkDevice seeds;
	private static TPLinkDevice ambient;
	
	private static final int SOIL_TEMP_THRESHOLD = 70;  //From https://harvesttotable.com/vegetable-seed-germination-temperatures/
	private static final int AMBIENT_TEMP_THRESHOLD = 35; //Need to keep above freezing
	
	static {
		seeds = new TPLinkDevice("Seed Heater", "8006A84F7D5AB0CAAA2B436A036A3BEF17AE73EA");
		ambient = new TPLinkDevice("Ambient Heater", "8006E403471460FF5A22A6070E20262117AEC84F");	
	}
	
	public static void processData(SensorData data) {
		int soilTemp = data.getSoilTemp();
		if (soilTemp >= SOIL_TEMP_THRESHOLD) {
			seeds.turnOff();
		} else if (soilTemp != -1) {
			seeds.turnOn();
		}
		
		int ambientTemp = data.getAmbientTemp();
		if (ambientTemp >= AMBIENT_TEMP_THRESHOLD) {
			ambient.turnOff();
		} else if (ambientTemp != -1) {
			ambient.turnOn();
		}
		
	}
}
