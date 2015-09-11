package masker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Chris Matthews
 * chrismatthews@outlook.com
 * 09 September 2015
 */
public class MaskerTest {
    private Masker testee;

    @Before
    public void setUp() throws Exception {
        testee = new Masker('*');
    }

    @After
    public void tearDown() throws Exception {
        testee = null;
    }

    @Test
    public void testMaskStringWithValidLength() throws Exception {
        assertThat(testee.maskString("hello", 0, 1), is(equalTo("****o")));
        assertThat(testee.maskString("hello", 1, 0), is(equalTo("h****")));
        assertThat(testee.maskString("hello", 1, 1), is(equalTo("h***o")));
        assertThat(testee.maskString("hello", 2, 2), is(equalTo("he*lo")));
    }

    @Test(expected = RuntimeException.class)
    public void testMaskStringWithEqualLengthOfUnmaskedCharacters() throws Exception {
        testee.maskString("hello", 2, 3);
    }

    @Test(expected = RuntimeException.class)
    public void testMaskStringWithShorterLengthThanUnmaskedCharacters() throws Exception {
        testee.maskString("hello", 5, 5);
    }
}