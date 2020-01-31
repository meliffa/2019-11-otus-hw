package ru.otus.hw.jpa.repository.comment;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hw.jpa.entity.Comment;

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
public class CommentRepoImpl implements CommentRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Comment getById(Integer commentId) {
        return em.find(Comment.class, commentId);
    }

    @Override
    public List<Comment> getByBookId(Integer bookId) {
        try {
            TypedQuery<Comment> query = em.createQuery(
                    "select c from Comment c where c.bookId = :bookId order by c.commentId",
                    Comment.class
            );
            query.setParameter("bookId", bookId);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void insert(Comment comment) {
        em.persist(comment);
    }

    @Override
    public void update(Comment comment) {
        em.merge(comment);
    }

    @Override
    public void deleteById(Integer commentId) {
        em.remove(getById(commentId));
    }

    @Override
    public List<Comment> getAll() {
        TypedQuery<Comment> query = em.createQuery("select c from Comment c order by c.commentId", Comment.class);
        return query.getResultList();
    }
}
