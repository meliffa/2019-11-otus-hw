package ru.otus.hw.db.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.hw.db.entity.Comment;

/**
 * Created by Inna Spodarik on 24.02.2020.
 */
public interface CommentRepository extends MongoRepository<Comment, String> {
}
