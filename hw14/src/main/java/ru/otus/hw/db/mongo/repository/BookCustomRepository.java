package ru.otus.hw.db.mongo.repository;

import ru.otus.hw.db.mongo.entity.Book;

/**
 * Created by Inna Spodarik on 21.04.2020.
 */
public interface BookCustomRepository {
    Book findBookByCommentId(Integer commentId);
}
