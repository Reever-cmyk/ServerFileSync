package objects;

import fileactions.Checksum;
import fileactions.FileStream;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

public class Client {
    String dirPathClient;
    byte[] checkSum;
    FileStream fileStream = new FileStream();
    HashMap<Integer, File> fileMap;

    public Client(String dirPathClient, byte[] checkSum) {
        this.dirPathClient = dirPathClient;
        this.checkSum = Checksum.getSHA256Hash(this.dirPathClient);
        this.fileMap = fileStream.fileSetup(dirPathClient);
    }

    /**
     * @return dirPathClient
     */
    public String getDir() {
        return dirPathClient;
    }

    /**
     * wandelt localhost namen in ip um.
     * @return  client ip address
     * @throws UnknownHostException falls local host nicht umgewandelt werden kann.
     */
    public InetAddress getClientIp() throws UnknownHostException {
        return InetAddress.getLocalHost();
    }
}
