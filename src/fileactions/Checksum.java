package fileactions;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

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

    public static boolean compareCheckSum(String strC, String strS) {
        int lC = strC.length();
        int lS = strS.length();
        int lMin = Math.min(lC, lS);

        for (int i = 0; i < lMin; i++) {
            int strC_ch = strC.charAt(i);
            int strS_ch = strS.charAt(i);

            if (strC_ch != strS_ch) {
                return false;
            }
        }
        return lC == lS;
    }

}



