package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

class JobAscByPriorityTest {

    @Test
    public void whenJobAscByPriority() {
        Comparator<Job> cmp = new JobAscByPriority();
        Job job1 = new Job("Task", 1);
        Job job2 = new Job("Task", 2);
        int result = cmp.compare(job1, job2);
        assertThat(result).isLessThan(0);

        Job job3 = new Job("Task", 1);
        result = cmp.compare(job1, job3);
        assertThat(result).isEqualTo(0);
    }
}