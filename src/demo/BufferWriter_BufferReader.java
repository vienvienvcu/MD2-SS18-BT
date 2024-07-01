package demo;

import java.io.*;
import java.util.Scanner;

public class BufferWriter_BufferReader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        writeDataToFile(scanner,"/Users/viennguyenthi/Desktop/model2/MD2-ss18/demo.txt");
        readDataFromFile("demo.txt");
    }
    public static void writeDataToFile(Scanner scanner, String path){
//        b1. khoi tao doi tuong file
        File file = new File(path);
//       b2. khoi tao doi tuong output
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
//        NHAP DU LIEU TU BAN PHIM VA LUU RA RA FILE
        do {
            System.out.println("nhap mot dong du lieu");
            String line = scanner.nextLine();
//            GHI RA FILE
            try {
                bw.write(line);
                bw.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("ban co ghi du lieu tiep k?");
            System.out.println("1. co");
            System.out.println("2. khong");
            System.out.println("lua chon cua ban");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice != 1){
                break;
            }
        }while (true);

//            DONG KET NOI
        try {
            bw.close();
            fos.close();
            osw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void readDataFromFile( String path){
//      b1.  khoi tao doi tuong file

//      B2. KHOI TAO CAC DOI TUONG INPUT STREAM
        File file = null;
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;


        file = new File(path);
        try {
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
             br = new BufferedReader(isr);
//            DOC DU LIEU TU FILE
            System.out.println("cac du lieu trong file la");
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        }catch (RuntimeException ex1){
            ex1.printStackTrace();
        } catch (FileNotFoundException ex2) {
            ex2.printStackTrace();
        } catch (IOException ex3) {
            ex3.printStackTrace();
        }finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (isr != null) {
                    isr.close();
                }
                if (fis != null) {
                    fis.close();
                }
        }catch (IOException e){
                throw new RuntimeException(e);
            }


    }

    }
}
