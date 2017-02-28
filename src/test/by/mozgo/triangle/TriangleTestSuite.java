package test.by.mozgo.triangle;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.by.mozgo.triangle.creator.TriangleCreatorTest;
import test.by.mozgo.triangle.logic.TriangleLogicTest;
import test.by.mozgo.triangle.observer.OperationObserverTest;
import test.by.mozgo.triangle.reader.TriangleReaderTest;

/**
 * @author Andrei Mozgo
 */
@Suite.SuiteClasses({TriangleReaderTest.class, TriangleCreatorTest.class,
        TriangleLogicTest.class, OperationObserverTest.class})
@RunWith(Suite.class)
public class TriangleTestSuite {
}
