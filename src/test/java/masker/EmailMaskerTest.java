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
public class EmailMaskerTest {

    @Test
    public void testClassCanBeInstantiated() throws Exception {
        // This is really for coverage report (cobertura) purposes
        EmailMasker em = new EmailMasker();
        assertThat(em, instanceOf(EmailMasker.class));
    }

    @Test
    public void testMaskEmailAddressWithValidEmail() throws Exception {
        assertThat(EmailMasker.maskEmailAddress("c@test.com"), is(equalTo("c@test.com")));
        assertThat(EmailMasker.maskEmailAddress("ck@test.com"), is(equalTo("c*@test.com")));
        assertThat(EmailMasker.maskEmailAddress("c.k@test.com"), is(equalTo("c*k@test.com")));
        assertThat(EmailMasker.maskEmailAddress("kent@test.com"), is(equalTo("k**t@test.com")));
        assertThat(EmailMasker.maskEmailAddress("clark@test.com"), is(equalTo("cl*rk@test.com")));
        assertThat(EmailMasker.maskEmailAddress("clark.kent@test.com"), is(equalTo("cl******nt@test.com")));
    }

    @Test
    public void testMaskEmailAddressWithInvalidEmail() throws Exception {
        assertThat(EmailMasker.maskEmailAddress("test@localhost"), is(equalTo("test@localhost")));
        assertThat(EmailMasker.maskEmailAddress("clarkkent"), is(equalTo("clarkkent")));
    }
}