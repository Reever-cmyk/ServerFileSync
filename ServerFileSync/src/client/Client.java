package client;

import fileactions.Checksum;
import server.Server;

//TODO client hat clientDir. prueft ob mainDir checkSum anderst ist als seit letzten update falls ja update mainDir mit clientDir. update beinhaltet nur veraenderte dateien.
public class Client {
    String dirPathClient;
    String clientIp;
    String serverIp;
    String dirPathServer;

    public Client(String dirPathClient, String serverIp){
        this.dirPathClient = dirPathClient;
        this.serverIp = serverIp;
    }

    private String getDir(){
        return dirPathClient;
    }

    /**
        reine upload methode keine checks sonstiges.
        @param name dies ist der testname
     **/
    private boolean uploadWork(){
        boolean updateStatus = true;

        return updateStatus;
    }
}
