package fileactions;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Checksum {

    /**
     * erzeugt SHA256 Hash einer directory
     * @param dir String directory
     * @return byte[]
     */
    public static byte[] getSHA256Hash(String dir) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            return digest.digest(dir.getBytes(StandardCharsets.UTF_8));
        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean CheckHash(){

    }

}
