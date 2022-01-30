package fileactions;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;

public class Checksum {
    String dir;

    public Checksum(String dir){
        this.dir = dir;
    }



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

    private static String byteArrayToString(byte[] bytes){
        try{
            return new String(bytes);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static boolean compareCheckSum(byte[] checkSumServer, byte[] checkSumClient) {
        return Arrays.equals(checkSumClient, checkSumServer);
    }

}



