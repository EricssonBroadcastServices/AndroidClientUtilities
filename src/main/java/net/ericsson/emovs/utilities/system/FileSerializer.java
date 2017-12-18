package net.ericsson.emovs.utilities.system;

import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;

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

    public static <T> boolean writeJson(T object, String path) {
        try {
            File f = new File(path);
            if(f.getParentFile().exists() == false) {
                f.getParentFile().mkdirs();
            }

            JSONObject serialized = new JSONObject();

            for (Field field : object.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object value = field.get(object);
                serialized.put(field.getName(), value);
            }

            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeUTF(serialized.toString());
            out.close();
            fileOut.close();
            return true;
        }
        catch (Exception e) {
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

    public static <T> T readJson(T object, String path) {
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            String objectString = in.readUTF();
            in.close();
            fileIn.close();

            JSONObject serialized = new JSONObject(objectString);

            for (Field field : object.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object value = serialized.opt(field.getName());
                try {
                    field.set(object, value);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return object;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
