package fileactions;
import server.Server;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Checksum {

    private String dir;

    public Checksum(Server server){
        this.dir = server.getDir();
    }

    /*
        erzeugt checksum des übergebenen Objects Server/Client
     */
    public byte[] getSHA256Hash() {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            return digest.digest(dir.getBytes(StandardCharsets.UTF_8));
        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
