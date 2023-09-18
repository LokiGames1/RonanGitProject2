import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GitTest {

    @BeforeAll
    static void setUpBeforeClass() throws Exception {

        Utils.writeStringToFile("junit_example_file_data.txt", "test file contents");
        Utils.deleteFile("Index.txt");
        Utils.deleteDirectory("Objects");
        Utils.deleteFile("Tree");

    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        Utils.deleteFile("junit_example_file_data.txt");
        Utils.deleteFile("Index.txt");
        Utils.deleteDirectory("Objects");
        Utils.deleteFile("Tree");
    }

    @Test
    @DisplayName("Test if creating a Blob works")
    void testBlob() throws Exception {

    }

    @Test
    @DisplayName("Test if Initializing works - index and objects folders need to be created")
    void testInit() throws Exception {

    }

    @Test
    @DisplayName("Test if adding a Blob works - index gets updated and object folder adds the blob")
    void testAdd() throws Exception {

    }

    @Test
    @DisplayName("Test if removing a Blob works - index gets updated and object folder removes the blob")
    void testRemove() throws Exception {

    }
}