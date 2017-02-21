package test.by.mozgo.triangle.reader;

import by.mozgo.triangle.reader.TriangleReader;
import by.mozgo.triangle.exception.TriangleReaderException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author Andrei Mozgo
 */
public class TriangleReaderTest {

    @Test
    public void testFileReader() throws TriangleReaderException {
        String filename = "data/input.txt";
        List<String> lines = TriangleReader.readData(filename);
        boolean fileNotEmpty = lines.size() > 0;
        Assert.assertTrue(fileNotEmpty);
    }

    @Test(expected = TriangleReaderException.class)
    public void testFileReaderException() throws TriangleReaderException {
        String filename = "";
        TriangleReader.readData(filename);
    }
}
