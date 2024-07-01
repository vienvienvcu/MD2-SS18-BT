package doc_ghi_list;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadStudents {
    public static void main(String[] args) {
        List <Student> students = null;

        ObjectInputStream read = null;
        try {
            read = new ObjectInputStream(new FileInputStream("src/data/list_student.txt"));
            students = (List<Student>) read.readObject();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                read.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Danh sach sinh vien: ");
        for (Student student : students){
            System.out.println(student.toString());
        }
    }
}
