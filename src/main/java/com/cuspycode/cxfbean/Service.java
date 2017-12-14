package com.cuspycode.cxfbean;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.LinkedHashMap;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Application;

public class Service extends Application {

    @Override
    public Set<Class<?>> getClasses() {
	return new HashSet<Class<?>>(Arrays.asList(Service.class));
    }

    @GET
    @Path("/customer")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomer() {
	Customer c = new Customer();
	c.setId(1234);
	c.setName("Charlie User");
	c.setEmail("charlie@example.com");
	return c;
    }

    @POST
    @Path("/customer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String,String> postCustomer(Customer input) {
	String name = input.getName();
	Map<String,String> response = new LinkedHashMap<String,String>();
	response.put("status", "success");
	response.put("name", name);
	return response;
    }
}
