package ru.otus.hw.jpa.repository.book;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hw.jpa.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Inna Spodarik on 06.01.2020.
 */
@Repository
@Transactional
public class BookRepoImpl implements BookRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Book getById(Integer bookId) {
        return em.find(Book.class, bookId);
    }

    @Override
    public List<Book> getByName(String bookName) {
        try {
            TypedQuery<Book> query = em.createQuery(
                    "select b from Book b where b.bookName = :bookName",
                    Book.class
            );
            query.setParameter("bookName", bookName);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void insert(Book book) {
        em.persist(book);
    }

    @Override
    public void update(Book book) {
        em.merge(book);
    }

    @Override
    public void deleteById(Integer bookId) {
        em.remove(getById(bookId));
    }

    @Override
    public List<Book> getAll() {
        TypedQuery<Book> query = em.createQuery("select b from Book b order by b.bookId", Book.class);
        return query.getResultList();
    }
}
