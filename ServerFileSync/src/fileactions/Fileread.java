package fileactions;

import java.io.File;
import java.util.HashMap;
import java.util.Objects;

public class Fileread {
    private String path;
    HashMap<Integer, File> fileMap;

    public Fileread(String path){
        this.path = path;

    }

    private void fileread(){
        File fileRead = new File(path);
        for(int i = 0; i < Objects.requireNonNull(fileRead.listFiles()).length; i++){
            if(fileRead.exists()){
                fileMap.put(i, fileRead);
            }
        }

    }

}
