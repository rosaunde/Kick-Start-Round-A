import static org.junit.Assert.*;

import java.io.*;

import org.junit.*;

public class Solution3Test {
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
        final String testString = "5\n" +
                "1 3\n" +
                "3 4 3\n" +
                "1 3\n" +
                "3 0 0\n" +
                "3 3\n" +
                "0 0 0\n" +
                "0 2 0\n" +
                "0 0 0\n" +
                "2 1\n" +
                "1\n" +
                "5\n" +
                "5 5\n" +
                "0 0 0 5 2\n" +
                "9 1 0 2 0\n" +
                "0 3 0 8 2\n" +
                "0 3 0 8 2\n" +
                "0 3 0 8 2\n"
                ;
        provideInput(testString);

        final String testOutput = "Case #1: 0\n" +
                "Case #2: 3\n" +
                "Case #3: 4\n" +
                "Case #4: 3\n" +
                "Case #5: 117\n";
        Solution3.main(new String[0]);

        assertEquals(testOutput, getOutput());
    }
}
