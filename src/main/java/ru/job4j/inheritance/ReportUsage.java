package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        TextReport report = new TextReport();
        String text = report.generate("Report's title", "Report's body");
        System.out.println(text);

        HtmlReport htmlReport = new HtmlReport();
        String generateHtml = htmlReport.generate("Report's title", "Report's body");
        System.out.println(generateHtml);

        JsonReport jsonReport = new JsonReport();
        String generateJson = jsonReport.generate("Report's title", "Report's body");
        System.out.println(generateJson);
    }
}
