package doc_ghi_list;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class WriteStudents {
    public static void main(String[] args) {
        List <Student> students = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            students.add(new Student("s01","nguyen nam",
                    true,sdf.parse("12/5/2000"),"ha noi","JV040824"));
            students.add(new Student("s01","nguyen vien",
                    true,sdf.parse("12/5/2000"),"ha noi","JV040824"));
            students.add(new Student("s01","nguyen man",
                    true,sdf.parse("12/5/2000"),"ha noi","JV040824"));
            students.add(new Student("s01","hai ha",
                    true,sdf.parse("12/5/2000"),"ha noi","JV040824"));
            students.add(new Student("s01","huyen my ",
                    true,sdf.parse("12/5/2000"),"ha noi","JV040824"));
            students.add(new Student("s01","vu binh",
                    true,sdf.parse("12/5/2000"),"ha noi","JV040824"));

        } catch (ParseException e) {
            System.err.println(e.getMessage());;
        }
//        ghi file
        ObjectOutputStream write = null;
        try {
            write = new ObjectOutputStream(new FileOutputStream("src/data/list_student.txt"));
            write.writeObject(students);
            System.out.println("Da ghi danh sach xuong file");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                write.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }


    }
}
