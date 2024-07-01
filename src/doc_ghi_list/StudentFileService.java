package doc_ghi_list;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class StudentFileService {

    public static boolean writeStudentToFile(String filename, List<Student> students) {
//        ghi file
        ObjectOutputStream write = null;
        try {
            write = new ObjectOutputStream(new FileOutputStream("src/data" + filename));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                write.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            return true;
        }


    }
}
