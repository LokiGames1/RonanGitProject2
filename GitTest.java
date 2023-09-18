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
}