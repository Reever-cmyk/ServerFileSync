package objects;

import fileactions.Checksum;
import fileactions.FileStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;

public class Server {

    HashMap<Integer, File> fileMap;
    String dirPathServer;
    String clientIp;
    byte[] checkSum;
    FileStream fileStream = new FileStream();

    public Server(String dirPathServer, String clientIp, HashMap<Integer, File> fileMap, byte[] checkSum){
        this.dirPathServer = dirPathServer;
        this.clientIp = clientIp;
        this.fileMap = fileMap;
        this.checkSum = Checksum.getSHA256Hash(this.dirPathServer);
        this.fileMap = fileStream.fileSetup(dirPathServer);
    }

    /**
     *
     * @return dirPathServer
     */
    public String getDir(){
        return dirPathServer;
    }

    /**
     * wandelt localhost Namen in ip um
     * @return Server Ip address
     * @throws UnknownHostException falls local host name nicht in ip umgewandelt werden kann.
     */
    public InetAddress getServerIp() throws UnknownHostException {
        return InetAddress.getLocalHost();
    }

}


