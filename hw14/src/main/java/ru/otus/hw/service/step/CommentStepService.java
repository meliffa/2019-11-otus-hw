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
import ru.otus.hw.db.mongo.entity.Comment;
import ru.otus.hw.db.mongo.entity.CommentExt;
import ru.otus.hw.service.processor.CommentProcessor;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * Created by Inna Spodarik on 21.04.2020.
 */
@Configuration
@RequiredArgsConstructor
public class CommentStepService {
    private final MongoTemplate mongoTemplate;
    private final StepBuilderFactory stepBuilderFactory;
    private final DataSource dataSource;
    private final CommentProcessor commentProcessor;

    @Value("${hw14.chunkSize}")
    Integer chunkSize;

    @Bean(name="commentStep")
    public Step commentStep() {
        return stepBuilderFactory.get("commentStep")
                .<Comment, CommentExt>chunk(chunkSize)
                .reader(commentMongoItemReader(mongoTemplate))
                .processor(commentItemProcessor())
                .writer(commentJdbcBatchItemWriter())
                .build();
    }

    @StepScope
    @Bean
    public MongoItemReader<Comment> commentMongoItemReader(MongoTemplate mongoTemplate) {
        return new MongoItemReaderBuilder<Comment>()
                .name("commentMongoItemReader")
                .template(mongoTemplate)
                .targetType(Comment.class)
                .jsonQuery("{}")
                .sorts(new HashMap<>())
                .build();
    }

    @StepScope
    @Bean
    public ItemProcessor<Comment, CommentExt> commentItemProcessor() {
        return commentProcessor;
    }

    @StepScope
    @Bean
    public JdbcBatchItemWriter<CommentExt> commentJdbcBatchItemWriter() {
        JdbcBatchItemWriter<CommentExt> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        writer.setSql("INSERT INTO HW_COMMENT (COMMENTID, BOOKID, COMMENT) VALUES (:commentId, :bookId, :comment)");
        writer.setDataSource(dataSource);
        return writer;
    }
}
