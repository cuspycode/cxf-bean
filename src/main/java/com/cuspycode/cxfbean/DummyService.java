package com.cuspycode.cxfbean;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Application;

public class DummyService extends Application {
    @Override
    public Set<Class<?>> getClasses() {
	return new HashSet<Class<?>>(Arrays.asList(DummyService.class));
    }

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String getRoot() {
	return "This is the API root URL. Please use a versioned sub-path for your requests.\n";
    }
}
