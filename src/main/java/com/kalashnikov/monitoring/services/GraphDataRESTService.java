package com.kalashnikov.monitoring.services;

import com.kalashnikov.monitoring.algorithms.factory.AlgorithmFactory;
import com.kalashnikov.monitoring.parser.wireshark.PackageFromWireShark;
import com.kalashnikov.monitoring.parser.wireshark.Parser;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.log4j.Logger;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@Path("/service")
@Stateless
public class GraphDataRESTService {
    private static int counter = 0;
    private AlgorithmFactory factory;
    private ArrayList<ArrayList<PackageFromWireShark>> timeSeries;
    private Logger log = Logger.getLogger(GraphDataRESTService.class);
    private static Parser parser;
    private static BufferedReader br;


    @Context
    private UriInfo context;


    @Asynchronous
    private void initThread(BufferedReader br){
        parser = new Parser(br, timeSeries, 1, 12);
        Thread thread = new Thread(parser);
        thread.start();
    }

    @POST
    @Path("/getInfoP")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getInfoP(final int temp){
        return Response.ok("{"+temp+":"+timeSeries.get(temp)+"}").build();
    }

    @GET
    @Path("/getInfo")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getInfo(){
        try{
            if (counter==0){
                br = new BufferedReader(new FileReader(AlgorithmFactory.PATH));
                factory = new AlgorithmFactory();
                timeSeries = new ArrayList<ArrayList<PackageFromWireShark>>(12);
                initThread(br);
            }
            Thread.sleep(2000);
            int temp = counter;
            counter++;
            return Response.ok("{"+temp+":"+parser.getValues().get(temp)+"}").build();
        } catch (FileNotFoundException e) {
                log.error(AlgorithmFactory.FILE_WAS_NOT_FOUND, e);
            return Response.ok("{\"FILE NOT FOUND\":111}").build();
        } catch (IOException e) {
                log.error(AlgorithmFactory.EXECUTION_WAS_STOPPED, e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Response.ok("{\"FUCK\":111}").build();
    }
}

