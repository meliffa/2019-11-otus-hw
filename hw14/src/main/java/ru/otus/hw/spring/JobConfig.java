package ru.otus.hw.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Inna Spodarik on 21.04.2020.
 */
@Configuration
@RequiredArgsConstructor
public class JobConfig {
    public static final String MIGRATE_MONGO_TO_POSTGRE_SQL = "migrateMongoToPostgreSql";
    private final JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job migrateMongoToPostgreSql(@Qualifier("authorStep") Step authorStep,
                                        @Qualifier("genreStep") Step genreStep,
                                        @Qualifier("bookStep") Step bookStep,
                                        @Qualifier("commentStep") Step commentStep) {
        return jobBuilderFactory.get(MIGRATE_MONGO_TO_POSTGRE_SQL)
                .start(authorStep)
                .next(genreStep)
                .next(bookStep)
                .next(commentStep)
                .build();
    }
}
