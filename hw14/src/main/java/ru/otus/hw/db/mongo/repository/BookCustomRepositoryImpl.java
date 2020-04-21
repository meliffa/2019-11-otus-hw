package ru.otus.hw.db.mongo.repository;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ru.otus.hw.db.mongo.entity.Book;

/**
 * Created by Inna Spodarik on 21.04.2020.
 */
@Repository
public class BookCustomRepositoryImpl implements BookCustomRepository {
    private final MongoTemplate mongoTemplate;

    public BookCustomRepositoryImpl(MongoTemplate template) {
        this.mongoTemplate = template;
    }
    @Override
    public Book findBookByCommentId(Integer commentId) {
        Query query = Query.query(Criteria.where("comments.$id").is(commentId));
        return mongoTemplate.findOne(query, Book.class);
    }
}
