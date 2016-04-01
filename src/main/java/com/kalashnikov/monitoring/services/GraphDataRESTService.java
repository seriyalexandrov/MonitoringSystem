package com.kalashnikov.monitoring.services;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Map;

@Path("/service")
@Stateless
public class GraphDataRESTService {

    @Context
    private UriInfo context;


    @GET
    @Path("/getInfo")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getInfo(){

        return Response.ok("{\"info\":\"info_body\"}").build();
    }
}

