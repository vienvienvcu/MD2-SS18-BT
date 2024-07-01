package BT9.business.feature.impl;

import BT9.business.entity.Book;
import BT9.business.feature.IBookFeature;
import BT9.business.utils.IOFile;

import java.util.ArrayList;
import java.util.List;

public class BookFeatureImpl implements IBookFeature {
    public static List<Book> books = new ArrayList<>();
    public BookFeatureImpl() {
        books = IOFile.readFromFile(IOFile.PATH_BOOK);
    }
    @Override
    public void saveOrUpdate(Book book) {
        int indexCheck = findIndexById(book.getId());
        if (indexCheck < 0) {
            books.add(book);
        }else {
            books.set(indexCheck, book);
        }
        System.out.println("you make add new book susses");
        IOFile.writeToFile(IOFile.PATH_BOOK, books);
    }

    @Override
    public void deleteById(int idDelete) {
        int indexDeleted = findIndexById(idDelete);
        if (indexDeleted >=0) {
           books.remove(indexDeleted);
           IOFile.writeToFile(IOFile.PATH_BOOK, books);
        }else {
            System.err.println("book not found,can't delete");
        }

    }

    @Override
    public int findIndexById(int idFind) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == idFind) {
                return i;
            }
        }
        return -1;
    }
}
