package BT4;

import java.io.*;
import java.util.Scanner;

public class ReverseFileContent {
    public static void main(String[] args) {

            // Bước 2: Đọc văn bản từ file
            String content = readDataFromFile("original.txt");

            // Bước 3: Chuyển đổi chuỗi thành mảng từ
            String[] words = content.split("\\s+");

            // Bước 4: Đảo ngược mảng từ
            String reversedContent = reverseWords(words);

            // Bước 5: Ghi chuỗi mới ra file
            writeFile("reversed.txt", reversedContent);

    }

    private static void writeFile(String fileName, String content) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String readDataFromFile(String path) {
        File file = null;
        StringBuilder contentBuilder = new StringBuilder();
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            file = new File(path);
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line).append(" ");
            }
        }catch (IOException ex){
            ex.printStackTrace();
        } catch (Exception ex1) {
            ex1.printStackTrace();
        }
        return contentBuilder.toString();
    }

    private static String reverseWords(String[] words) {
        StringBuilder reversedBuilder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversedBuilder.append(words[i]).append(" ");
        }
        return reversedBuilder.toString().trim();
    }

}

