package ru.otus.hw.jpa.repository.genre;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hw.jpa.entity.Genre;

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
public class GenreRepoImpl implements GenreRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Genre getById(Integer genreId) {
        return em.find(Genre.class, genreId);
    }

    @Override
    public Genre getByName(String genreName) {
        try {
            TypedQuery<Genre> query = em.createQuery(
                    "select g from Genre g where g.genreName = :genreName",
                    Genre.class
            );
            query.setParameter("genreName", genreName);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void insert(Genre genre) {
        em.persist(genre);
    }

    @Override
    public void update(Genre genre) {
        em.merge(genre);
    }

    @Override
    public void deleteById(Integer genreId) {
        em.remove(getById(genreId));
    }

    @Override
    public List<Genre> getAll() {
        TypedQuery<Genre> query = em.createQuery(
                "select g from Genre g order by g.genreId",
                Genre.class
        );
        return query.getResultList();
    }
}
