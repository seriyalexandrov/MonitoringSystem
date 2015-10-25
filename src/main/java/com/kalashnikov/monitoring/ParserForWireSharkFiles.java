package com.kalashnikov.monitoring;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserForWireSharkFiles {
     // pathToFile = "resources\\traffic.cap"
    public List<PackageFromWireShark> getPackageListFromStringList(String pathToFile) {
        List<String> untreatedList = getListFromFile(pathToFile);
        List<String> stingsWithRightInformation = getStingsWithRightInformation(untreatedList);
        PackageFromWireShark pack;
        String[] dividedString;
        List<PackageFromWireShark> packageList = new ArrayList<PackageFromWireShark>(stingsWithRightInformation.size());
        for (int i = 0; i < stingsWithRightInformation.size(); i++) {
            dividedString = stingsWithRightInformation.get(i).split(" +");
            pack = new PackageFromWireShark(Integer.parseInt(dividedString[1]));
            pack.setTime(Double.parseDouble(dividedString[2]));
            pack.setSource(dividedString[3]);
            pack.setDestination(dividedString[4]);
            pack.setProtocol(dividedString[5]);
            packageList.add(pack);
        }
        return packageList;
    }

    private List<String> getListFromFile(String pathToFile) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(pathToFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;
        List<String> lines = new ArrayList<String>();

        try {
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lines;
    }

    private List<String> getStingsWithRightInformation(List<String> untreatedList) {
        List<String> processedList = new ArrayList<String>();
        String regex = "^No\\. +Time +Source +Destination +Protocol +$";
        for (int i = 0; i < untreatedList.size() - 1; i++) {
            if (untreatedList.get(i).matches(regex)) {
                processedList.add(untreatedList.get(i + 1));
            }
        }
        return processedList;
    }


}
