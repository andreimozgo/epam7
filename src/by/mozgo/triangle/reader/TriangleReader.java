package by.mozgo.triangle.reader;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrei Mozgo
 */
public class TriangleReader {
    private static final Logger LOGGER = LogManager.getLogger();

    public static List<String> readData(String filename) {
        if (filename == null) {
            LOGGER.log(Level.FATAL, "Input filename = null!");
            throw new RuntimeException("Input filename = null!");
        }
        List<String> lines = new ArrayList<>();
        File inputFile = new File(filename);
        try (BufferedReader in = new BufferedReader(new FileReader(inputFile))) {
            String s;
            while ((s = in.readLine()) != null) {
                lines.add(s);
            }
            in.close();
        } catch (IOException e) {
            LOGGER.log(Level.FATAL, "Input file isn't found! " + filename);
            throw new RuntimeException(e + " Input file isn't found! " + filename);
        }
        if (lines.isEmpty()) {
            LOGGER.log(Level.FATAL, "Input file is empty! " + filename);
            throw new RuntimeException("Input file is empty! " + filename);
        }
        return lines;
    }
}
