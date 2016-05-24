package com.kalashnikov.monitoring.algorithms.factory;

import com.kalashnikov.monitoring.algorithms.AbstractAlgorithm;
import com.kalashnikov.monitoring.algorithms.TimeSeriesManager;
import com.kalashnikov.monitoring.parser.wireshark.Parser;
import com.kalashnikov.monitoring.parser.wireshark.PackageFromWireShark;
import org.apache.log4j.Logger;

import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AlgorithmFactory extends Options {

    public static final String LIMIT_IS_EXCEEDED_GET_READY_TO_IT = "Limit is exceeded! Get ready to it!";
    public static final String TIME_SERIES = "timeSeries = ";
    public static final String PREDICTED_VALUE = "predictedValue = ";
    public static final String FILE_WAS_NOT_FOUND = "File was not found";
    public static final String EXECUTION_WAS_STOPPED = "Execution was stopped";
    public static final String PROCESS_WAS_INTERRUPTED = "Process was interrupted";
    public static final String EXECUTION_TIME = "Execution time : ";
    public static final String SEC = "sec";
    public static final String ERROR_DURING_LOADING_ALGORITHM_CLASS = "Error during loading Algorithm class";
    public static final String ERROR_DURING_INSTANTIATION = "Error during instantiation";
    public static final String ACCESS_ERROR_DURING_LOADING_ALGORITHM_CLASS = "Access error during loading Algorithm class";
    public static final String COM_KALASHNIKOV_MONITORING_ALGORITHMS = "com.kalashnikov.monitoring.algorithms.";
    public static final String ERROR_WHILE_LAUNCHING_ALGORITHM = "Error while launching algorithm";
//    public static final String PATH = "src\\main\\resources\\traffic.cap";
    public static final String PATH = "E:\\prog\\Java_Progs\\NET_CRACKER_PROJ\\MonitoringSystem\\src\\main\\resources\\traffic.cap";
//    public static final String PATH = "D:\\GitHub\\traffic.txt";
    public static final int NUMBER_OF_INTERVALS = 12;

    private final int SECOND = 1000;

    public static final Logger log = Logger.getLogger(AlgorithmFactory.class);

    public AbstractAlgorithm getAlgorithmClass() throws IOException, InstantiationException, IllegalAccessException {

        Class<AbstractAlgorithm> algorithm = null;

        try {
            algorithm = (Class<AbstractAlgorithm>) Class
                    .forName(COM_KALASHNIKOV_MONITORING_ALGORITHMS + algorithmType);
        } catch (ClassNotFoundException e) {
//            log.error(ERROR_WHILE_LAUNCHING_ALGORITHM, e);
        }

        return algorithm.newInstance();

    }

    public void execute2(){
        ArrayList<ArrayList<PackageFromWireShark>> timeSeries = new ArrayList<>();
        int counter = 0;
        counter++;
        if (counter==1){
            long startTime = System.currentTimeMillis();
            try(BufferedReader br = new BufferedReader(new FileReader(AlgorithmFactory.PATH))){
                Parser parser = new Parser(br, timeSeries, timeSeriesInterval, AlgorithmFactory.NUMBER_OF_INTERVALS);
                Thread thread = new Thread(parser);
                thread.start();
//                Thread.sleep(1000);
//                while (true)
//                System.out.println(timeSeries.get(0));
            } catch (FileNotFoundException e) {
                AlgorithmFactory.log.error(AlgorithmFactory.FILE_WAS_NOT_FOUND, e);
            } catch (IOException e) {
                AlgorithmFactory.log.error(AlgorithmFactory.EXECUTION_WAS_STOPPED, e);
            }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            catch (InterruptedException e) {
//                AlgorithmFactory.log.error(PROCESS_WAS_INTERRUPTED, e);
//            }
        }
    }

    public void execute() {

        long startTime = System.currentTimeMillis();
        ArrayList<ArrayList<PackageFromWireShark>> timeSeries = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            Parser parser = new Parser(br, timeSeries, timeSeriesInterval, numberOfIntervals);
            Thread thread = new Thread(parser);
            thread.start();

            for (int i = 0; i < numberOfIntervals; i+= (predictionTimeInterval/timeSeriesInterval)) {
                Thread.sleep((long) (predictionTimeInterval * SECOND));
                double predictedValue = function(timeSeries, timeSeriesInterval);
                if (predictedValue > packetLimit) {
//                    log.warn(LIMIT_IS_EXCEEDED_GET_READY_TO_IT);
                }
                System.out.print(TIME_SERIES+":");
                for(ArrayList<PackageFromWireShark> list:timeSeries){
                    System.out.print(" " + list.size());
                }
                System.out.println("\n"+ PREDICTED_VALUE + predictedValue);
            }

            thread.join();

        } catch (FileNotFoundException e) {
//            log.error(FILE_WAS_NOT_FOUND, e);
        } catch (IOException e) {
//            log.error(EXECUTION_WAS_STOPPED, e);
        } catch (InterruptedException e) {
//            log.error(PROCESS_WAS_INTERRUPTED, e);
        }

        long endTime = System.currentTimeMillis() - startTime;

//        log.info(EXECUTION_TIME + (double) endTime / SECOND + SEC);

    }

    private double function(ArrayList<ArrayList<PackageFromWireShark>> timeSeries, double timeInterval) {

        TimeSeriesManager manager = new TimeSeriesManager();
        ArrayList<Integer> partOfTimeSeries;

        if (timeSeries.size() == 0) {
            partOfTimeSeries = new ArrayList<>();
        } else if (timeSeries.size() < numberOfValuesForTrend) {
            partOfTimeSeries = new ArrayList<>();
            for (ArrayList<PackageFromWireShark> list : timeSeries.subList(0, timeSeries.size() - 1)) {
                partOfTimeSeries.add(list.size());
            }
        } else {
            partOfTimeSeries = new ArrayList<>();
            for (ArrayList<PackageFromWireShark> list : timeSeries.
                    subList(timeSeries.size() - numberOfValuesForTrend, timeSeries.size() - 1)) {
                partOfTimeSeries.add(list.size());
            }
        }

        manager.setTimeSeries(partOfTimeSeries);
        manager.setPeriod(timeInterval);
        AbstractAlgorithm algorithmClass = null;

        try {
            algorithmClass = getAlgorithmClass();
        } catch (IOException e) {
//            log.error(ERROR_DURING_LOADING_ALGORITHM_CLASS, e);
        } catch (InstantiationException e) {
//            log.error(ERROR_DURING_INSTANTIATION, e);
        } catch (IllegalAccessException e) {
//            log.error(ACCESS_ERROR_DURING_LOADING_ALGORITHM_CLASS, e);
        }

        algorithmClass.setTimeSeriesManager(manager);

        return algorithmClass.predictNextValue();

    }

}