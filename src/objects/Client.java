package objects;

import fileactions.Checksum;
import fileactions.FileStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
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

    /**
     * sendet checksum byte für byte and Server
     * @param port Server Port
     * @throws IOException Sockets werfen exception
     */
    public void Checksum_Sender(int port) throws IOException
    {
        ServerSocket servSock = new ServerSocket(port);
        Socket socket = servSock.accept();

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        while (true)
        {
            dos.write(checkSum);
            for (byte b : checkSum) {
                dos.writeByte(b);
            }
            if (dis.readUTF().equals("success"))
            {
                System.out.println("Erfolgreiche Übertragung.");
                break;
            }
            else if (dis.readUTF().equals("failure"))
            {
                System.out.println("Übertragung fehlgeschlagen.");
                break;
            }
        }
        dis.close();
        dos.close();
        socket.close();
    }
}
