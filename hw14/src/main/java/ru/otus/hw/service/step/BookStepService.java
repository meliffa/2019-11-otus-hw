package ru.otus.hw.service.step;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.MongoItemReader;
import org.springframework.batch.item.data.builder.MongoItemReaderBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.otus.hw.db.mongo.entity.Book;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * Created by Inna Spodarik on 21.04.2020.
 */
@Configuration
@RequiredArgsConstructor
public class BookStepService {
    private final MongoTemplate mongoTemplate;
    private final StepBuilderFactory stepBuilderFactory;
    private final DataSource dataSource;

    @Value("${hw14.chunkSize}")
    Integer chunkSize;

    @Bean(name="bookStep")
    public Step bookStep() {
        return stepBuilderFactory.get("bookStep")
                .<Book, Book>chunk(chunkSize)
                .reader(bookMongoItemReader(mongoTemplate))
                .processor(bookItemProcessor())
                .writer(bookJdbcBatchItemWriter())
                .build();
    }

    @StepScope
    @Bean
    public MongoItemReader<Book> bookMongoItemReader(MongoTemplate mongoTemplate) {
        return new MongoItemReaderBuilder<Book>()
                .name("bookMongoItemReader")
                .template(mongoTemplate)
                .targetType(Book.class)
                .jsonQuery("{}")
                .sorts(new HashMap<>())
                .build();
    }

    @StepScope
    @Bean
    public ItemProcessor<Book, Book> bookItemProcessor() {
        return book -> book;
    }

    @StepScope
    @Bean
    public JdbcBatchItemWriter<Book> bookJdbcBatchItemWriter() {
        JdbcBatchItemWriter<Book> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        writer.setSql("INSERT INTO HW_BOOK (BOOKID, BOOKNAME, AUTHORID, GENREID) " +
                "VALUES (:bookId, :bookName, :author.authorId, :genre.genreId)");
        writer.setDataSource(dataSource);
        return writer;
    }
}
