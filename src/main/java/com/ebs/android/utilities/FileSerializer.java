package com.ebs.android.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Joao Coelho on 2017-10-21.
 */

public class FileSerializer {

    public static <T> boolean write(T object, String path) {
        try {
            File f = new File(path);
            if(f.getParentFile().exists() == false) {
                f.getParentFile().mkdirs();
            }
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(object);
            out.close();
            fileOut.close();
            return true;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static <T> T read(String path) {
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            T object = (T) in.readObject();
            in.close();
            fileIn.close();
            return object;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
