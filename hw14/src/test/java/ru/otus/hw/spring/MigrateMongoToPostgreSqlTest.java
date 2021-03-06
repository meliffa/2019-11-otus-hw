package ru.otus.hw.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.JobRepositoryTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.hw.db.mongo.repository.AuthorRepository;
import ru.otus.hw.db.mongo.repository.BookRepository;
import ru.otus.hw.db.mongo.repository.GenreRepository;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Inna Spodarik on 21.04.2020.
 */

@SpringBatchTest
@SpringBootTest
public class MigrateMongoToPostgreSqlTest {
    public static final String MIGRATE_MONGO_TO_POSTGRE_SQL = "migrateMongoToPostgreSql";
    public static final String COMPLETED = "COMPLETED";

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    private JobRepositoryTestUtils jobRepositoryTestUtils;

    @BeforeEach
    void clearMetaData() {
        jobRepositoryTestUtils.removeJobExecutions();
    }

    @Test
    void testMongoToMySqlJob() throws Exception {
        Job job = jobLauncherTestUtils.getJob();
        assertThat(job).isNotNull()
                .extracting(Job::getName)
                .isEqualTo(MIGRATE_MONGO_TO_POSTGRE_SQL);

        JobExecution jobExecution = jobLauncherTestUtils.launchJob();
        assertThat(jobExecution.getExitStatus().getExitCode()).isEqualTo(COMPLETED);
    }

}
