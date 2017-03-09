package test.by.mozgo.triangle.reader;

import by.mozgo.triangle.reader.TriangleReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author Andrei Mozgo
 */
public class TriangleReaderTest {

    @Test
    public void testFileReader() {
        String filename = "data/input.txt";
        List<String> lines = TriangleReader.readData(filename);
        boolean fileNotEmpty = lines.size() > 0;
        Assert.assertTrue(fileNotEmpty);
    }

    @Test(expected = RuntimeException.class)
    public void testFileReaderException() throws RuntimeException {
        String filename = "";
        TriangleReader.readData(filename);
    }
}
