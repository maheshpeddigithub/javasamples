package immutable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class ImmutableWithMutableTest {

    private int id;
    private String name;
    private Map<String, String> mutable;
    ImmutableWithMutable immutableWithMutable;

    @Before
    public void setUp() {
        id = 1;
        name = "name1";
        mutable = new HashMap<String, String>();
        mutable.put("key1", "value1");
        immutableWithMutable = new ImmutableWithMutable(id, name, mutable);
    }

    @Test
    public void testImmutableWithMutableInitialization() {
        Map<String, String> mutableInner = immutableWithMutable.getMutable();
        assertThat(mutableInner.size(), is(equalTo(1)));
    }

    @Test
    public void testImmutableWithMutableAlteringMutable() {
        mutable.put("key2", "value2");
        Map<String, String> mutableInner = immutableWithMutable.getMutable();
        assertThat(mutableInner.size(), is(equalTo(1)));
    }

    @Test
    public void testImmutableWithMutableAlteringMutableInner() {
        Map<String, String> mutableInner = immutableWithMutable.getMutable();
        assertThat(1, is(equalTo(mutableInner.size())));
        mutableInner.put("key2", "value2");
        mutableInner = immutableWithMutable.getMutable();
        assertThat(mutableInner.size(), is(equalTo(1)));
    }

    @After
    public void tearDown() {
        mutable = null;
        immutableWithMutable = null;
    }

}