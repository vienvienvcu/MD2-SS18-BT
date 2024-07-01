package BT9.presentation;

import BT9.business.entity.Book;
import BT9.business.feature.IBookFeature;
import BT9.business.feature.impl.BookFeatureImpl;

import java.util.Scanner;
import java.util.stream.Stream;

public class BookManagement {
    public static final IBookFeature bookFeature = new BookFeatureImpl();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("***************MENU**************");
            System.out.println("1. Add Book");
            System.out.println("2. Delete Book");
            System.out.println("3. Edit Book");
            System.out.println("4. Print Book");
            System.out.println("5. Exit");
            System.out.printf("your choice 1-5 : ");
            int choice = inputNumber(scanner);
            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    deleteBook(scanner);
                    break;
                case 3:
                    updateBook(scanner);
                    break;
                case 4:
                    printBook();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Invalid choice");
            }
        }while (true);
    }

    private static void updateBook(Scanner scanner) {
        System.out.print("Enter Book ID you want to update: ");
        int bookId = inputNumber(scanner);
        int indexUpdate = bookFeature.findIndexById(bookId);
        boolean isExit = true;
        if (indexUpdate <0){
            System.err.println("Book Id not Exist");
            return;
        }
        Book bookUpdate = BookFeatureImpl.books.get(indexUpdate);
        do {
            System.out.println("1. Update Book title");
            System.out.println("2. Update Book author");
            System.out.println("3. Update Book publisher ");
            System.out.println("4. Update Book price");
            System.out.println("5. back");
            System.out.println("your choice 1-5: ");
            int choice = inputNumber(scanner);
            switch (choice){
                case 1:
                    bookUpdate.setTitle(bookUpdate.inputBookTitle(scanner));
                    break;
                case 2:
                    bookUpdate.setAuthor(bookUpdate.inputBookAuthor(scanner));
                    break;
                case 3:
                    bookUpdate.setPublisher(bookUpdate.inputPublisher(scanner));
                    break;
                case 4:
                    bookUpdate.setPrice(bookUpdate.inputPrice(scanner));
                    break;
                case 5:
                    isExit = false;
                    break;
                default:
                    System.err.println("enter your choice you 1-5");
            }
        }while (isExit);
    }

    private static void deleteBook(Scanner scanner) {
        System.out.print("Enter Book ID you want to delete: ");
        int bookIdDelete = inputNumber(scanner);
        bookFeature.deleteById(bookIdDelete);

    }

    private static void addBook(Scanner scanner) {
        System.out.println("Enter number of books to add");
        int numberOfBooks = inputNumber(scanner);
        for (int i = 0; i < numberOfBooks; i++) {
            Book book = new Book();
            book.inputData(scanner);
            bookFeature.saveOrUpdate(book);
        }
    }

    private static void printBook() {
        for (Book book: BookFeatureImpl.books){
            book.outputData();
        }
    }


    private static int inputNumber(Scanner scanner) {
       do {
           try {
               return Integer.parseInt(scanner.nextLine());
           }catch (NumberFormatException e) {
               System.out.println("Please enter a valid number");
           }
       }while (true);
    }
}
