package solution;

import solution.Solution;
import static solution.Solution.sort;
import java.util.ArrayList;
import junit.framework.TestCase;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.*;
import org.junit.Test;
import static solution.Solution.sortAndConvertToArrayList;

public class SolutionTest {
    
    @BeforeClass
        public static void setUpBeforeClass() throws Exception {
            
            
            //Method annotated with `@BeforeClass` will execute once before any of the test methods in this class.

            //This method could be used to set up any test fixtures that are computationally expensive and shared by several test methods. e.g. establishing database connections 

            //Sometimes several tests need to share computationally expensive setup (like logging into a database). While this can compromise the independence of tests, sometimes it is a necessary optimization. From http://junit.sourceforge.net/javadoc/org/junit/BeforeClass.html
           
        }
    @AfterClass
        public static void tearDownAfterClass() throws Exception {
            
            //Method annotated with `@AfterClass` will execute once after all of the test methods are executed in this class.

            //If you allocate expensive external resources in a BeforeClass method you need to release them after all the tests in the class have run. Annotating a public static void method with @AfterClass causes that method to be run after all the tests in the class have been run. All @AfterClass methods are guaranteed to run even if a BeforeClass method throws an exception. From http://junit.sourceforge.net/javadoc/org/junit/AfterClass.html
        }

    @Before
        public void setUp() throws Exception {
             //Method annotated with `@Before` will execute before each test method in this class is executed.

             //If you find that several tests need similar objects created before they can run this method could be used to do set up those objects (aka test-fixtures).
        }
        
    @After
        public void tearDown() throws Exception {
             
             //Method annotated with `@After` will execute after each test method in this class is executed.

             //If you allocate external resources in a Before method you must release them in this method.
        }

    Solution arraydemo = new Solution();
    
    @Test
    public void elementShouldNotBeMillionAndOne() {
        int[] array = {1000001, 890000,34,-10000};
        TestCase.assertFalse(arraydemo.verifyElementsInArray(array));
        assertThat(true, is(not(equalTo(arraydemo.verifyElementsInArray(array))))); 
    }
     @Test
    public void elementShouldNotBeMinusMillionAndOne() {
        int[] array = {-1000001, 890000,34,-10000};
        TestCase.assertFalse(arraydemo.verifyElementsInArray(array));
        assertThat(true, is(not(equalTo(arraydemo.verifyElementsInArray(array))))); 
    }
     @Test
    public void elementMayBeMillion() {
        int[] array = {1000000, 890000,34,-10000};
        TestCase.assertTrue(arraydemo.verifyElementsInArray(array));
        assertThat(true, is(equalTo(arraydemo.verifyElementsInArray(array)))); 
    }
     @Test
    public void arrayShouldHaveHundredThousandOrLessElements() {
        int[] array = new int[100000];
        TestCase.assertTrue(arraydemo.verifyElementsInArray(array));
    }
     @Test
    public void shouldSortElements() {
        int[] array = {1, 3, 6, 4, 1, 2};
        int m = array.length;
        sort(array);
        int[] arrayExpected = {1,1,2,3,4,6};
        TestCase.assertEquals(array[3],arrayExpected[3]);
        assertThat(array[3], is(equalTo(arrayExpected[3])));
    }
    
    @Test
    public void shouldConvertIntArrayToArrayList() {
        int[] array = {1, 3, 6, 4, 1, 2};
        int m = array.length;
        int[] copy = (array).clone(); 
        ArrayList<Integer> array2 = arraydemo.sortAndConvertToArrayList(copy);
        
        for(int i = 0; i < copy.length -1; i ++)
         if(array[i] >= 0)array2.add(array[i]);
        assertThat(copy[3], is(equalTo(3)));
   
    }
    
    @Test
    public void shouldFindMissingInteger() {
        int[] A = {1,3,2};
        ArrayList<Integer> array2 = arraydemo.sortAndConvertToArrayList(A);
        int missing = arraydemo.checkMissingInteger(array2);
        assertThat(4, is(equalTo(missing)));
   }
    
    @Test
    public void shouldFindMissingInteger2() {
        int[] A = {-1,-3};
        ArrayList<Integer> array2 = arraydemo.sortAndConvertToArrayList(A);
        int missing = arraydemo.checkMissingInteger(array2);
        assertThat(1, is(equalTo(missing)));
   }
/*    When it comes to assertions, there is the set of old JUnit assertions like:
org.junit.Assert.assertArrayEquals
org.junit.Assert.assertEquals
org.junit.Assert.assertFalse
org.junit.Assert.assertNotNull
org.junit.Assert.assertNotSame
org.junit.Assert.assertNull
org.junit.Assert.assertSame
org.junit.Assert.assertTrue
And the org.junit.Assert.assertThat method (available in JUnit4) which uses matchers and is better than old style assertions because it provides:
Better readability
assertThat(actual, is(equalTo(expected))); is better than assertEquals(expected, actual);
assertThat(actual, is(not(equalTo(expected)))); is better than assertFalse(expected.equals(actual));
Better failiure messages
java.lang.AssertionError: Expected: is "hello" but: was "hello world" is better than

org.junit.ComparisonFailure: expected:<hello[]> but was:<hello[ world]>

Flexbility
Multiple conditions could be asserted using matchers like anyOf or allOf.

eg: assertThat("hello world", anyOf(is("hello world"), containsString("hello"))); In this case, the test will pass if either the actual string is “hello world” or if it contains the word “hello”.

Following is a list of hamcrest coreMatchers from the hamcrest docs.
allOf
any
anyOf
anything
both
containsString
describedAs
either
endsWith
equalTo
everyItem
hasItems
instanceOf
is
isA
not
notNullValue
nullValue
sameInstance
startsWith
theInstance
*/
}
