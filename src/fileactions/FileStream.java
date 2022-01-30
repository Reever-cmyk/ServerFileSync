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

}
