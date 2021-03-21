import static org.junit.Assert.*;

import java.io.*;

import org.junit.*;

public class Solution2Test {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void testCase1() {
        final String testString = "2\n" +
                "4 3\n" +
                "1 0 0\n" +
                "1 0 1\n" +
                "1 0 0\n" +
                "1 1 0\n" +
                "6 4\n" +
                "1 0 0 0\n" +
                "1 0 0 1\n" +
                "1 1 1 1\n" +
                "1 0 1 0\n" +
                "1 0 1 0\n" +
                "1 1 1 0\n";
        provideInput(testString);

        final String testOutput = "Case #1: 1\n" +
                "Case #2: 9\n";
        Solution2.main(new String[0]);

        assertEquals(testOutput, getOutput());
    }
}
