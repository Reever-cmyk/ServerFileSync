package server;

import fileactions.Checksum;

//TODO server hat mainDir. prueft ob client checksum uebereinsteimmt mit mainDir, wenn nicht ziehe update. update beinhaltet nur veraenderte dateien.
public class Server {
    String dirPathServer;
    String clientIp;
    String checkSum;

    public Server(String dirPathServer, String clientIp){
        this.dirPathServer = dirPathServer;
        this.clientIp = clientIp;
    }

    /**
        liest Directory ein speichert werte mit checksum in HashMap, welche mit client vergliechen wird. erzeugt checksum solange bis update gefunden wurde. Damit nicht die komplette Dir jedes mal hochgeladen wird sondern nur der jeweils kleinste subDir.
     **/
    private void readDir(){

    }

    public String getDir(){
        return dirPathServer;
    }

}
