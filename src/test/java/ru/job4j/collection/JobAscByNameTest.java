package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

class JobAscByNameTest {

    @Test
    public void whenJobAscByName() {
        Comparator<Job> cmp = new JobAscByName();
        Job job1 = new Job("Alpha", 1);
        Job job2 = new Job("Beta", 2);
        int result = cmp.compare(job1, job2);
        assertThat(result).isLessThan(0);

        Job job3 = new Job("Alpha", 3);
        result = cmp.compare(job1, job3);
        assertThat(result).isEqualTo(0);
    }
}