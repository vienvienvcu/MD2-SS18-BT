package BT9.business.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFile {
    public static final String PATH_BOOK =
    "./src/BT9/business/data/book.txt";
    public static <T> void writeToFile(String path, List<T> list) {
        File file = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.flush();
        }catch (IOException ex) {
//            ex.printStackTrace();
        }finally {
            try {
                if(fos != null) {
                    fos.close();
                }
                if(oos != null) {
                        oos.close();
                }
                } catch (IOException ex1) {
//                    ex1.printStackTrace();
            }
        }
    }
    public static <T> List<T> readFromFile(String path) {
        List<T> list = new ArrayList<T>();
        File file = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            file = new File(path);
//            if (!file.exists()) {
//                file.createNewFile();
//            }
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            list = (List<T>) ois.readObject();

        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            try {
                if(fis != null) {
                    fis.close();
                }
                if(ois != null) {
                    ois.close();
                }

            }catch (IOException ex1){
                ex1.printStackTrace();
            }
        }
        return list;
    }
}
