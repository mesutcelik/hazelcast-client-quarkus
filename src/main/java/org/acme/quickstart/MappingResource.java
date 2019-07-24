package org.acme.quickstart;


import com.hazelcast.core.HazelcastInstance;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/map")
@RequestScoped
public class MappingResource {

    @Inject
    MappingService mapService;

    @GET
    @Path("/get")
    @Produces(MediaType.TEXT_PLAIN)
    public String getValue(@QueryParam("key") String key) {
        String val = mapService.get(key);
        return "value: " + val + "\n";
    }

    @GET
    @Path("/put")
    @Produces(MediaType.TEXT_PLAIN)
    public void putValue(@QueryParam("key") String key, @QueryParam("value") String value) {
        mapService.put(key,value);
    }

}