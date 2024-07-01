package BT9.business.feature;

import BT9.business.entity.Book;

public interface IBookFeature {
    void saveOrUpdate(Book book);

    void deleteById(int idDelete);

    int findIndexById(int idFind);
}
