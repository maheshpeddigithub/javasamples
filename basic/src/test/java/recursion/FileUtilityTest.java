package recursion;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertThat;

public class FileUtilityTest {

    @Before
    public void setUp() {
    }

    @Test
    public void testGetFileCount() {
        int fileCount = FileUtility.getFileCount(new File(this.getClass().getResource("/dir1").getFile()));
        assertThat(fileCount, CoreMatchers.is(6));
    }


    @After
    public void tearDown() {
    }

}
