package BT3;

import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadFileFindMax {
    public static void main(String[] args) {
        System.out.println("Nhập đường dẫn file: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        ReadFileFindMax readFileFindMax = new ReadFileFindMax();
        readFileFindMax.findMax(path);
    }

    public static void findMax(String filePath) {
        try {
            File file = new File(filePath);
            // Kiểm tra nếu file không tồn tại thì ném ra ngoại lệ.
            if (!file.exists()) {
                try {
                    throw new FileNotFoundException();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            // Đọc từng dòng của file
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
//            tạo đối tượng StringBuilder để xây dựng chuỗi từ các dòng đã đọc.
            StringBuilder contentBuilder = new StringBuilder();

//            TAO VONG LAP DE DOC TUONG DONG VA THEM VAO StringBuilder
            String currentLine;
            while (true) {
                try {
                    if (!((currentLine = br.readLine()) != null)) break;
                    contentBuilder.append(currentLine).append(" ");
                } catch (IOException ex1) {
                    ex1.printStackTrace();
                }

            }
//            dong BufferedReader sau khi sử dụng.
            try {
                br.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
//             Chuyển đổi chuỗi thành mảng các từ
            String fileContent = contentBuilder.toString().trim();
            String[] words = fileContent.split("\\s+");
            for (String word : words) {
                System.out.println(word);
            }
            // Đếm số lượng từ
            int wordCount = words.length;
            System.out.println("Số lượng từ trong file: " + wordCount);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}


