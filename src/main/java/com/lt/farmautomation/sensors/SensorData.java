package com.lt.farmautomation.sensors;

import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class SensorData {
    private String sensorID;
    private int ambientTemp;
    private int soilTemp;
    private int moisture;
    
    public String getSensorID() {
        return sensorID;
    }
    
    public void setSensorID(String sensorID) {
        this.sensorID = sensorID;
    }
    
    public int getAmbientTemp() {
        return ambientTemp;
    }

    public void setAmbientTemp(int ambientTemp) {
        this.ambientTemp = ambientTemp;
    }

	public int getSoilTemp() {
		return soilTemp;
	}

	public void setSoilTemp(int soilTemp) {
		this.soilTemp = soilTemp;
	}

	public int getMoisture() {
		return moisture;
	}

	public void setMoisture(int moisture) {
		this.moisture = moisture;
	}
}