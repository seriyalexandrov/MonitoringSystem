package com.kalashnikov.monitoring.parser.wireshark;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserForWireSharkFiles {
    // pathToFile = "resources\\traffic.cap"
    public List<PackageFromWireShark> getPackageListFromFile(String pathToFile) {
        List<String> stingsWithRightInformation = getListFromFile(pathToFile);
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
        String regex = "^No\\. +Time +Source +Destination +Protocol +$";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(pathToFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;
        List<String> lines = new ArrayList<String>();
        int flag = 0;
        try {
            while ((line = reader.readLine()) != null) {
                if (flag != 0) {
                    lines.add(line);
                    flag = 0;
                }
                if (line.matches(regex)) {
                    flag++;
                }
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


}
