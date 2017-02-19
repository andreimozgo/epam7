package by.mozgo.triangle.reader;

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
public class TrianglesInputReader {
    private static final Logger LOGGER = LogManager.getLogger();

    public static List<String> readData() {
        List<String> lines = new ArrayList<>();
        File inputFile = new File("data/input.txt");

        try {
            BufferedReader in = new BufferedReader(new FileReader(inputFile.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    lines.add(s);
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            LOGGER.error("Input file not found!");
            return null;
        }
        return lines;
    }
}
