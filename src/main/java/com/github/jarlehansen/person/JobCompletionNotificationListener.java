package com.github.jarlehansen.person;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! Time to verify the results");

            List<Person> results = jdbcTemplate.query("SELECT first_name, last_name FROM person",
                    (rs, row) -> new Person(rs.getString(1), rs.getString(2)));
            results.forEach(person -> log.info("Found <" + person + "> in the database."));
        }
    }
}