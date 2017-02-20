package by.mozgo.triangle.reader;

import by.mozgo.triangle.reader.exceptions.FileNotFoundReaderException;
import by.mozgo.triangle.reader.exceptions.InputFileIsEmptyException;
import by.mozgo.triangle.reader.exceptions.TrianglesInputReaderException;
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

    public static List<String> readData(String filename) throws TrianglesInputReaderException {
        if (filename == null) {
            LOGGER.error("Input file not found!");
            throw new FileNotFoundReaderException("Input file = null!");
        }
        List<String> lines = new ArrayList<>();
        File inputFile = new File(filename);
        try {
            BufferedReader in = new BufferedReader(new FileReader(inputFile.getAbsoluteFile()));
            String s;
            while ((s = in.readLine()) != null) {
                lines.add(s);
            }
            in.close();
        } catch (IOException e) {
            LOGGER.error("Input file not found!");
            throw new FileNotFoundReaderException("Input file not found!");
        }
        if (lines.size() == 0) {
            throw new InputFileIsEmptyException("Input file empty");
        }
        return lines;
    }
}
