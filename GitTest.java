import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
    void testBlob(String inputFile) throws IOException, NoSuchAlgorithmException {
        File file = new File(inputFile);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            sb.append(line).append("");
        }
        reader.close();
        String hashed = generateSHA(sb.toString());
        write(hashed, sb);

    }

    @Test
    @DisplayName("Testing if generateSHA works")
    String generateSHA(String input) throws NoSuchAlgorithmException {
        try {
            // getInstance() method is called with algorithm SHA-1
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);

            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            // return the HashText
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Testing if the write works correctly")
    void write(String hashed, StringBuilder inside) throws IOException {
        String newFile = hashed;
        FileWriter write = new FileWriter("./objects/" + newFile);
        write.write(inside.toString());
        write.close();
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