package ru.otus.hw.changelogs;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.otus.hw.db.entity.Author;
import ru.otus.hw.db.entity.Book;
import ru.otus.hw.db.entity.Comment;
import ru.otus.hw.db.entity.Genre;

import java.util.Arrays;
import java.util.List;


/**
 * Created by Inna Spodarik on 24.02.2020.
 */
@ChangeLog(order = "1")
public class MongoDBInit {
    private Author author1;
    private Author author2;
    private Author author3;
    private Author author4;

    private Genre genre1;
    private Genre genre2;
    private Genre genre3;
    private Genre genre4;

    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private Book book5;

    private Comment comment1;
    private Comment comment2;
    private Comment comment3;
    private Comment comment4;
    private Comment comment5;

    @ChangeSet(order = "1", id = "dropDB", author = "ispodarik", runAlways = true)
    public void dropDB(MongoDatabase database){
        database.drop();
    }

    @ChangeSet(order = "2", id = "insertAuthors", author = "ispodarik", runAlways = true)
    public void insertAuthors(MongoTemplate template){
        author1 = template.save(new Author("0057666e-25c2-44f9-a76a-c1ca42e1ba2f", "Ray Douglas Bradbury"));
        author2 = template.save(new Author("Erich Maria Remarque"));
        author3 = template.save(new Author("Aldous Huxley"));
        author4 = template.save(new Author("Julio Cortazar"));
    }

    @ChangeSet(order = "3", id = "insertGenres", author = "ispodarik", runAlways = true)
    public void insertGenres(MongoTemplate template){
        genre1 = template.save(new Genre("046655eb-d84d-424c-8e6d-05b47041d30b", "Science fiction"));
        genre2 = template.save(new Genre("Novel"));
        genre3 = template.save(new Genre("Antinovel"));
        genre4 = template.save(new Genre("Classic prose"));
    }

    @ChangeSet(order = "4", id = "insertComments", author = "ispodarik", runAlways = true)
    public void insertComments(MongoTemplate template){
        comment1 = template.save(new Comment("879e650f-e92b-40f8-a936-fa633687c8c9", "Test comment 1"));
        comment2 = template.save(new Comment("Test comment 2"));
        comment3 = template.save(new Comment("Test comment 3"));
        comment4 = template.save(new Comment("Test comment 4"));
        comment5 = template.save(new Comment("Test comment 5"));
    }

    @ChangeSet(order = "5", id = "insertBooks", author = "ispodarik", runAlways = true)
    public void insertBooks(MongoTemplate template){
        book1 = template.save(new Book("95006896-12c4-4531-b11c-8ff153e44d70", "Fahrenheit 451", author1, genre1, Arrays.asList(comment1)));
        book2 = template.save(new Book("Arc de Triomphe", author2, genre2, Arrays.asList(comment2)));
        book3 = template.save(new Book("Brave New World", author3, genre3, Arrays.asList(comment3)));
        book4 = template.save(new Book("Hopscotch", author4, genre4, Arrays.asList(comment4)));
        book5 = template.save(new Book("Life on loan", author2, genre4, Arrays.asList(comment5)));
    }
}
