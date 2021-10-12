package ex43;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WebGenTest {

    @Test
    void testWebsiteGeneration() {

        // Create test websites
        new WebGen("test1", "test1author", false, false);
        new WebGen("test2", "test2author", true, true);
        new WebGen("test3", "test3author", false, true);

        String path = System.getProperty("user.dir") + "/website/";

        // ./website/test1/ should exist and should only include index.html
        assertEquals(Files.exists(Paths.get(path+"test1/")), true);
        assertEquals(Files.exists(Paths.get(path+"test1/index.html")), true);
        assertEquals(Files.exists(Paths.get(path+"test1/js/")), false);
        assertEquals(Files.exists(Paths.get(path+"test1/css/")), false);

        // ./website/test2/ should exist with index.html, /js/, and /css/ contents
        assertEquals(Files.exists(Paths.get(path+"test2/")), true);
        assertEquals(Files.exists(Paths.get(path+"test2/index.html")), true);
        assertEquals(Files.exists(Paths.get(path+"test2/js/")), true);
        assertEquals(Files.exists(Paths.get(path+"test2/css/")), true);

        // ./website/test3/ should exist with index.html and /css/ contents.
        assertEquals(Files.exists(Paths.get(path+"test3/")), true);
        assertEquals(Files.exists(Paths.get(path+"test3/index.html")), true);
        assertEquals(Files.exists(Paths.get(path+"test3/js/")), false);
        assertEquals(Files.exists(Paths.get(path+"test3/css/")), true);
    }
}