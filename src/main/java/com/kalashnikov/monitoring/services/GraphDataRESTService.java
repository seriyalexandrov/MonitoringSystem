package com.kalashnikov.monitoring.services;

import com.kalashnikov.monitoring.algorithms.factory.AlgorithmFactory;
import com.sun.org.apache.regexp.internal.RE;

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
//    public boolean mode = false;
//    private AlgorithmFactory factory;

    @Context
    private UriInfo context;


    @GET
    @Path("/getInfo")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getInfo(){
//        if (mode == false){
//            factory = new AlgorithmFactory();
//            mode = true;
//            return Response.ok("{\"info\":\"info_body\"}").build();
//        }
        return Response.ok("{\"Hello\":\"World\"}").build();
    }
//    @GET
//    @Path("/getInfo2")
//    @Produces({MediaType.APPLICATION_JSON})
//    public Response getInfo2(){
////        if (mode == false){
////            factory = new AlgorithmFactory();
////            mode = true;
////            return Response.ok("{\"info\":\"info_body\"}").build();
////        }
//        return Response.ok("{\"Hello\":\"World\"}").build();
//    }
}

