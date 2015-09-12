package masker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Chris Matthews
 * chrismatthews@outlook.com
 * 09 September 2015
 */
public class PhoneMaskerTest {

    @Test
    public void testClassCanBeInstantiated() throws Exception {
        // This is really for coverage report (cobertura) purposes
        PhoneMasker pm = new PhoneMasker();
        assertThat(pm, instanceOf(PhoneMasker.class));
    }

    @Test
    public void testMaskPhoneNumberWithValidUkMobile() throws Exception {
        assertThat(PhoneMasker.maskPhoneNumber("07812345678"), is(equalTo("078*****678")));
        assertThat(PhoneMasker.maskPhoneNumber("447812345678"), is(equalTo("4478*****678")));
        assertThat(PhoneMasker.maskPhoneNumber("+447812345678"), is(equalTo("+4478*****678")));
        assertThat(PhoneMasker.maskPhoneNumber("00447812345678"), is(equalTo("004478*****678")));
    }

    @Test
    public void testMaskPhoneNumberWithValidUkLandline() throws Exception {
        assertThat(PhoneMasker.maskPhoneNumber("02012345678"), is(equalTo("02012345678")));
    }

    @Test
    public void testMaskPhoneNumberWithValidInternationalNumber() throws Exception {
        assertThat(PhoneMasker.maskPhoneNumber("+35312345678"), is(equalTo("+35312345678")));
    }

    @Test
    public void testMaskPhoneNumberWithInvalidNumber() throws Exception {
        assertThat(PhoneMasker.maskPhoneNumber("12345"), is(equalTo("12345")));
        assertThat(PhoneMasker.maskPhoneNumber("123hello90"), is(equalTo("123hello90")));
    }
}