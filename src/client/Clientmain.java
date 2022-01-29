package client;

//TODO client hat clientDir. prueft ob mainDir checkSum anderst ist als seit letzten update falls ja update mainDir mit clientDir. update beinhaltet nur veraenderte dateien.
public class Clientmain {
    String dirPathClient;
    String clientIp;
    String serverIp;
    String dirPathServer;

    public Clientmain(String dirPathClient, String serverIp){
        this.dirPathClient = dirPathClient;
        this.serverIp = serverIp;
    }

    private String getDir(){
        return dirPathClient;
    }

    /**
     * Schickt Directory an Server über Sockets.
     * @return boolean
     */
    private boolean uploadWork(){
        boolean updateStatus = true;

        return updateStatus;
    }
}
