package BT7;

import demo.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectRead_Write {
    public static void main(String[] args) {
        List <Student> studentList = new ArrayList<>();
        Student student1 = new Student("SV001","NGUYEN VAN A",20);
        Student student2 = new Student("SV002","NGUYEN VAN B",22);
        Student student3 = new Student("SV003","NGUYEN VAN C",21);
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        writeObjectToFile(studentList,"listStudents.txt");
        readObjectFromFile("listStudents.txt");
    }
    public static void writeObjectToFile(List<demo.Student> studentList, String path) {
        File file = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
//      b1 khoi tao doi tuong
            file = new File(path);
//      b2 khoi tao doi tuong file output
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
//      b3 ghi du lieu ra file
            oos.writeObject(studentList);
            oos.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
//      b4 dong cac ket noi
            if(fos!=null){
                try {
                    fos.close();
                    oos.close();
                } catch (IOException ex1) {
                    ex1.printStackTrace();
                }
            }

        }

    }
    public static void readObjectFromFile(String path) {
        File file = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
//            b1 khoi tao doi tuong file
            file = new File(path);
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
//            b2 tao doi tuong tu file va lua vao mot bien
            List<demo.Student> studentListRead = (List<demo.Student>) ois.readObject();
            System.out.println("danh sach sinh vien doc tu file");
            for (Student student : studentListRead) {
                System.out.printf("ma sv: %s - Ten SV:  %s - Tuoi SV: %d\n", student.getStudentId(),student.getStudentName(),
                        student.getAge());
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(fis!=null) {
                    fis.close();
                }
                if(ois!=null){
                    ois.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}
