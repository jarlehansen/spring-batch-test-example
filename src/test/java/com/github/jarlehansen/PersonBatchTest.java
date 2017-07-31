package com.github.jarlehansen;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonBatchTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    public void returnStatusCompletedWhenPersonJobIsCompleted() throws Exception {
        BatchStatus status = jobLauncherTestUtils.launchJob().getStatus();
        assertEquals(BatchStatus.COMPLETED, status);
    }

    @Test
    public void returnStatusCompletedForStep() {
        JobExecution execution = jobLauncherTestUtils.launchStep("personTransformationStep");
        assertEquals(BatchStatus.COMPLETED, execution.getStatus());
    }

}