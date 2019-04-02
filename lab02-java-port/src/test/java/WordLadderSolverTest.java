import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * WordLadderSolver Tester.
 *
 * @author <Authors name>
 * @since <pre>03/10/2019</pre>
 * @version 1.0
 */
public class WordLadderSolverTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     *
     * Method: loadDictionary(int length)
     *
     */
    @Test
    public void testLoadDictionary() throws Exception {
        WordLadderSolver solver = new WordLadderSolver();
        solver.loadDictionary(4);
        assertEquals(3862, solver.vis.size());
    }

    /**
     *
     * Method: findLadder(String s, String e)
     *
     */
    @Test
    public void testFindLadder() throws Exception {
        WordLadderSolver solver = new WordLadderSolver();
        solver.loadDictionary(4);
        ArrayList<String> ans = solver.findLadder("this", "that");
        assertEquals(ans, Arrays.asList("this", "thin", "than", "that"));
    }

    /**
     *
     * Method: main(String[] args)
     *
     */
    @Test
    public void testMain() throws Exception {
//TODO: Test goes here... 
    }


    /**
     *
     * Method: isNeighbor(String a, String b)
     *
     */
    @Test
    public void testIsNeighbor() throws Exception {
    }
} 
