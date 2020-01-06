package ru.otus.hw.jpa.repository.author;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hw.jpa.entity.Author;

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
public class AuthorRepoImpl implements AuthorRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Author getById(Integer authorId) {
        return em.find(Author.class, authorId);
    }

    @Override
    public Author getByName(String authorName) {
        try {
            TypedQuery<Author> query = em.createQuery(
                    "select a from Author a where a.authorName = :authorName",
                    Author.class
            );
            query.setParameter("authorName", authorName);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void insert(Author author) {
        em.persist(author);
    }

    @Override
    public void update(Author author) {
        em.merge(author);
    }

    @Override
    public void deleteById(Integer authorId) {
        em.remove(getById(authorId));
    }

    @Override
    public List<Author> getAll() {
        TypedQuery<Author> query = em.createQuery(
                "select a from Author a order by a.authorId",
                Author.class
        );
        return query.getResultList();
    }
}
