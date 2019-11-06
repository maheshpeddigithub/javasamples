package immutable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;

public class ImmutableWithPrivateConstructorTest {

    private String id;
    private Date date;
    private ImmutableWithPrivateConstructor immutableWithPrivateConstructor;

    @Before
    public void setUp() {
        id = "id1";
        date = new Date(10);
        immutableWithPrivateConstructor = ImmutableWithPrivateConstructor.createNewInstance(id, date);
    }

    @Test
    public void testImmutableWithPrivateConstructor() {
        Date dateInner = immutableWithPrivateConstructor.getDate();
        assertThat(dateInner.getTime(), is(equalTo(date.getTime())));
        dateInner.setTime(20);
        Date dateInnerOriginal = immutableWithPrivateConstructor.getDate();
        assertThat(dateInnerOriginal.getTime(), is(equalTo(date.getTime())));
        date.setTime(30);
        Date dateInnerInitial = immutableWithPrivateConstructor.getDate();
        assertThat(dateInnerInitial.getTime(), is(not(date.getTime())));
    }

    @After
    public void tearDown() {

    }

}