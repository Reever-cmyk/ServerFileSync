package fileactions;

import java.io.File;
import java.util.HashMap;
import java.util.Objects;

public class Fileread {

    HashMap<Integer, File> fileMap;

    private HashMap<Integer, File> fileSetup(String path){
        File fileRead = new File(path);
        for(int i = 0; i < Objects.requireNonNull(fileRead.listFiles()).length; i++){
            if(fileRead.exists()){
                fileMap.put(i, fileRead);
            }
        }
        return fileMap;
    }

}
