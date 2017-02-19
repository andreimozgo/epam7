package test.by.mozgo.triangle.logic;

import by.mozgo.triangle.reader.TrianglesInputReader;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Andrei Mozgo
 */
public class TriangleReaderTest {
    @Test
    public void testFileReader() {
        Assert.assertNotNull(TrianglesInputReader.readData());
    }
}
