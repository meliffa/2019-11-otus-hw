package ru.otus.hw.db.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.hw.db.mongo.entity.Author;

import java.util.Optional;

/**
 * Created by Inna Spodarik on 24.02.2020.
 */
public interface AuthorRepository extends MongoRepository<Author, String> {
}
