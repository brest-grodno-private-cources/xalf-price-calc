package com.epam.georgia.reader;

import java.io.IOException;
import java.util.Map;

public interface FileReader {

    Map<Integer, Double> readData(String filePath) throws IOException;

}
