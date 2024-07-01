package BT1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReaderUtil {
    public static void main(String[] args) {
        System.out.println("Nhập đường dẫn file: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        FileReaderUtil fileReaderUtil = new FileReaderUtil();
        fileReaderUtil.readFileAsString(path);

    }
    public static void readFileAsString(String filePath) {
        try {
            File file = new File(filePath);
            // Kiểm tra nếu file không tồn tại thì ném ra ngoại lệ.
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            // Đọc từng dòng của file
            BufferedReader br = new BufferedReader(new FileReader(file));
//            tạo đối tượng StringBuilder để xây dựng chuỗi từ các dòng đã đọc.
            StringBuilder contentBuilder = new StringBuilder();

//            TAO VONG LAP DE DOC TUONG DONG VA THEM VAO StringBuilder
            String currentLine;
            while ((currentLine = br.readLine())!= null){
                contentBuilder.append(currentLine).append(" ");
            }
//            dong BufferedReader sau khi sử dụng.
            br.close();
//             Chuyển đổi chuỗi thành mảng các từ
            String fileContent = contentBuilder.toString().trim();
            String[] words = fileContent.split("\\s+");

            // Bước 3: Tạo một List để lưu các từ có độ dài lớn nhất

            List<String> longestWords = new ArrayList<>();
            int maxLength = 0;
            for (String word : words) {
                int length = word.length();
                if (length > maxLength) {
                    maxLength = length;
                    longestWords.clear(); // Xóa các từ cũ trong danh sách
                    longestWords.add(word);
                }else if (length == maxLength) {
                    longestWords.add(word);
                }

            }
            // Bước 5: In ra các từ có độ dài lớn nhất và độ dài của chúng
            System.out.println("Các từ có độ dài lớn nhất (" + maxLength + " ký tự):");
            for (String word : longestWords) {
                System.out.println(word);
            }

        }catch (Exception e) {
//             TH file không tồn tại hoặc nội dung file có lỗi thì sẽ hiển thị thông báo lỗi.
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
        
    }
}
