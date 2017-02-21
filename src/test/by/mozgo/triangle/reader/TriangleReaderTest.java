package test.by.mozgo.triangle.reader;

import by.mozgo.triangle.reader.TrianglesInputReader;
import by.mozgo.triangle.reader.exception.TriangleReaderException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Andrei Mozgo
 */
public class TriangleReaderTest {

    @Test
    public void testFileReader() throws TriangleReaderException {
        String filename = "data/input.txt";
        Assert.assertTrue(TrianglesInputReader.readData(filename).size() > 0);

    }

    @Test(expected = TriangleReaderException.class)
    public void testFileReaderException() throws TriangleReaderException {
        String filename = "";
        TrianglesInputReader.readData(filename);
    }
}
