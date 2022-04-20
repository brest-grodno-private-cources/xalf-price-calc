package com.epam.georgia.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class CSVFileReader implements FileReader {

    @Override
    public Map<Integer, Double> readData(String filePath) throws IOException {

        Map<Integer, Double> resultMap = new TreeMap<>();
        InputStream inputStream = getClass().getResourceAsStream("/" + filePath);
        try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String line;
            String[] values;
            while ((line = bufferedReader.readLine()) != null) {
                values = line.split(",");
                resultMap.put(Integer.valueOf(values[0]), Double.valueOf(values[1]));
            }
        }
        return resultMap;
    }

}
