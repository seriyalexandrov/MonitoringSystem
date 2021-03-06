package com.kalashnikov.monitoring;

import com.kalashnikov.monitoring.algorithms.factory.AlgorithmFactory;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class SystemExecutor {

    private static final Logger log = Logger.getLogger(SystemExecutor.class);

    public void execute() {

        AlgorithmFactory algorithmFactory = new AlgorithmFactory();
        algorithmFactory.execute2();
        System.out.println(new ArrayList<Double>());

    }

    public static void main(String[] args) {

        SystemExecutor systemExecutor = new SystemExecutor();
        systemExecutor.execute();

    }

}