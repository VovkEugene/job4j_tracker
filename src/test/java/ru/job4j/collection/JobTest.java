package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int result = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1));
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenAscByNameThenByPriorityNamesEqualThenCompareByPriority() {
        Comparator<Job> cmp = new JobAscByName().thenComparing(new JobAscByPriority());
        Job job1 = new Job("Alpha", 1);
        Job job2 = new Job("Alpha", 2);
        int result = cmp.compare(job1, job2);
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenAscByNameThenByPriorityNamesDifferentThenCompareByName() {
        Comparator<Job> cmp = new JobAscByName().thenComparing(new JobAscByPriority());
        Job job1 = new Job("Alpha", 2);
        Job job2 = new Job("Beta", 1);
        int result = cmp.compare(job1, job2);
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenDescByNameThenByPriorityNamesEqualThenCompareByPriority() {
        Comparator<Job> cmp = new JobDescByName().thenComparing(new JobDescByPriority());
        Job job1 = new Job("Alpha", 2);
        Job job2 = new Job("Alpha", 1);
        int result = cmp.compare(job1, job2);
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenDescByNameThenByPriorityNamesDifferentThenCompareByName() {
        Comparator<Job> cmp = new JobDescByName().thenComparing(new JobDescByPriority());
        Job job1 = new Job("Beta", 2);
        Job job2 = new Job("Alpha", 1);
        int result = cmp.compare(job1, job2);
        assertThat(result).isLessThan(0);
    }
}