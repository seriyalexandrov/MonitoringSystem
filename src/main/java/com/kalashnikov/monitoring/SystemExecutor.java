package com.kalashnikov.monitoring;

import com.kalashnikov.monitoring.algorithms.AlgorithmFactory;
import org.apache.log4j.Logger;

public class SystemExecutor {

    private static final Logger log = Logger.getLogger(SystemExecutor.class);

    public void execute() {

        AlgorithmFactory algorithmFactory = new AlgorithmFactory();
        algorithmFactory.execute();

    }

    public static void main(String[] args) {

        SystemExecutor systemExecutor = new SystemExecutor();
        systemExecutor.execute();
    }

}