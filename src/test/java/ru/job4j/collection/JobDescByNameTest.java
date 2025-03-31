package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

class JobDescByNameTest {

    @Test
    public void whenJobDescByName() {
        Comparator<Job> cmp = new JobDescByName();
        Job job1 = new Job("Alpha", 1);
        Job job2 = new Job("Beta", 2);
        int result = cmp.compare(job1, job2);
        assertThat(result).isGreaterThan(0);

        Job job3 = new Job("Beta", 3);
        result = cmp.compare(job2, job3);
        assertThat(result).isEqualTo(0);
    }
}