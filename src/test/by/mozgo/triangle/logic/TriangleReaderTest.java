package test.by.mozgo.triangle.logic;

import by.mozgo.triangle.reader.TrianglesInputReader;
import by.mozgo.triangle.reader.exceptions.FileNotFoundReaderException;
import by.mozgo.triangle.reader.exceptions.TrianglesInputReaderException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Andrei Mozgo
 */
public class TriangleReaderTest {

    @Test
    public void testFileReader() throws TrianglesInputReaderException {
        try {
            String filename = "data/input.txt";
            Assert.assertTrue(TrianglesInputReader.readData(filename).size() > 0);
        } catch (FileNotFoundReaderException e) {
            Assert.fail();
        }
    }

    @Test(expected = TrianglesInputReaderException.class)
    public void testFileReaderException() throws TrianglesInputReaderException {
        String filename = "";
        TrianglesInputReader.readData(filename);
    }
}
