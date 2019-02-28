package com.lt.farmautomation.sensors;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "sensors" path)
 */
@Path("sensors")
public class SensorAPIs {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void getSensorData(SensorData sensorData) {
        System.out.println("ID = " + sensorData.getSensorID());
        System.out.println("temp = " + sensorData.getAmbientTemp());
        
        
    }
}
