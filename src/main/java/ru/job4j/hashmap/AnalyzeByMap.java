package ru.job4j.hashmap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        double totalScore = 0;
        int numberOfSubjects = 0;
        for (Pupil pupil : pupils) {
            numberOfSubjects += pupil.subjects().size();
            totalScore += getTotalScore(pupil);
        }
        return totalScore / numberOfSubjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double totalScore = getTotalScore(pupil);
            int numberOfSubjects = pupil.subjects().size();
            double averageScore = totalScore / numberOfSubjects;
            list.add(new Label(pupil.name(), averageScore));
        }
        return list;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        Map<String, Integer> map = collectScoresBySubject(pupils);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String subjectName = entry.getKey();
            int averageScore = entry.getValue() / pupils.size();
            list.add(new Label(subjectName, averageScore));
        }
        return list;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double totalScore = getTotalScore(pupil);
            list.add(new Label(pupil.name(), totalScore));
        }
        return getLabelNaturalOrder(list);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        Map<String, Integer> map = collectScoresBySubject(pupils);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(new Label(entry.getKey(), entry.getValue()));
        }
        return getLabelNaturalOrder(list);
    }

    private static Label getLabelNaturalOrder(List<Label> list) {
        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }

    private static double getTotalScore(Pupil pupil) {
        return pupil.subjects().stream()
                .mapToInt(Subject::score)
                .sum();
    }

    private static Map<String, Integer> collectScoresBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                String subjectName = subject.name();
                map.put(subjectName,
                        map.getOrDefault(subjectName, 0) + subject.score());
            }
        }
        return map;
    }
}
