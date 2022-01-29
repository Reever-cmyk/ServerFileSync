package fileactions;

import java.io.File;
import java.util.HashMap;
import java.util.Objects;

public class FileStream {

    HashMap<Integer, File> fileMap;

    public HashMap<Integer, File> fileSetup(String path){
        File file = new File(path);
        for(int i = 0; i < Objects.requireNonNull(file.listFiles()).length; i++){
            if(file.exists()){
                fileMap.put(i, file);
            }
        }
        return fileMap;
    }

    public void fileCheckHash(HashMap<Integer, File> fileMap){
        for(File file:fileMap.values()){
            byte [] checksumClient = Checksum.getSHA256Hash(file.getAbsolutePath());
            byte [] checkSumServer = Checksum.getSha256Hash()
            if(ceckSumClient = checkSumServer){
                uploadWork();
            }
        }
    }

}
