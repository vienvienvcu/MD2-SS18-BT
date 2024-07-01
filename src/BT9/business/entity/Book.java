package BT9.business.entity;

import BT9.business.feature.impl.BookFeatureImpl;

import java.io.Serializable;
import java.util.Scanner;

public class Book implements Serializable {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private double price;

    public Book() {
    }

    public Book(String author, int id, double price, String publisher, String title) {
        this.author = author;
        this.id = id;
        this.price = price;
        this.publisher = publisher;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void inputData(Scanner scanner){
        this.id = inputBookId();
        this.title = inputBookTitle(scanner);
        this.author = inputBookAuthor(scanner);
        this.publisher = inputPublisher(scanner);
        this.price = inputPrice(scanner);

    }

    public double inputPrice(Scanner scanner) {
        System.out.println("Enter price of book");
        do {
            try {
                String price = scanner.nextLine();
                if (price.isEmpty()){
                    System.err.println("Price cannot empty");
                }else if (Double.parseDouble(price)<0){
                    System.err.println("price must >0");
                }else {
                    return Double.parseDouble(price);
                }
            }catch (Exception ex){
                System.err.println("Invalid price entered");
            }
        }while (true);
    }

    public String inputPublisher(Scanner scanner) {
        System.out.println("Enter publisher name: ");
        do {
            String publisher = scanner.nextLine();
            if (publisher.isEmpty()) {
                System.err.println("Publisher name cannot be empty");
            }else {
                return publisher;
            }
        }while (true);
    }

    public int inputBookId (){
        int idMax = 0;
          for (Book b: BookFeatureImpl.books){
              if (b.getId() > idMax){
                  idMax = b.getId();
              }
          }
        return  idMax + 1;
      }



    public String inputBookTitle(Scanner scanner){
        System.out.println("Enter title: ");
        do {
            String title = scanner.nextLine();
            if (title.isEmpty()){
                System.out.println("Title cannot be empty");
            }else {
                boolean isExist = false;
                for (int i = 0; i < BookFeatureImpl.books.size(); i++){
                    if (BookFeatureImpl.books.get(i).getTitle().equals(title)){
                        isExist = true;
                        break;
                    }
                }
                if (!isExist){
                    return title;
                }else {
                    System.err.println("Title already exist,please try again");
                }
            }
        }while (true);

    }

    public String inputBookAuthor(Scanner scanner){
        System.out.println("Enter author: ");
        do {
            String author = scanner.nextLine();
            if (author.isEmpty()){
                System.out.println("Author cannot be empty");
            }else {
                return author;
            }
        }while (true);
    }



    public void outputData(){
        System.out.printf("%-20s %-20s %-20s %-20s %-20s\n",
                "ID", "Title", "Author", "Publisher", "Price");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s\n",
                this.id,this.title,this.author,this.publisher,this.price);
    }
}
