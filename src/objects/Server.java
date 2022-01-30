package objects;

import fileactions.Checksum;
import fileactions.FileStream;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

public class Server {

    HashMap<Integer, File> fileMap;
    String dirPathServer;
    String clientIp;
    byte[] checkSumServ;
    int PORT;
    FileStream fileStream = new FileStream();

    public Server(String dirPathServer, String clientIp, HashMap<Integer, File> fileMap, byte[] checkSum){
        this.dirPathServer = dirPathServer;
        this.clientIp = clientIp;
        this.fileMap = fileMap;
        this.checkSumServ = Checksum.getSHA256Hash(this.dirPathServer);
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

    /**
     * Empfängt gesendete Checksum von Client und vergleicht diese direkt.
     * @throws IOException socket wirft exception
     */
    public void checksumReceiver()throws IOException{

        Socket sock = new Socket(clientIp, PORT);
        DataInputStream dis = new DataInputStream(sock.getInputStream());
        DataOutputStream dos = new DataOutputStream(sock.getOutputStream());

        int l;
        l = dis.readInt();

        byte[] bytes = new byte[l];

        for(byte b:bytes){
            bytes[b] = dis.readByte();
        }
        if(Checksum.compareCheckSum(checkSumServ, bytes)){
            dos.writeUTF("success");
        }else {
            dos.writeUTF("failure");
        }

        dis.close();
        dos.close();
        sock.close();
    }

}


