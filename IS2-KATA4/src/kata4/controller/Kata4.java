package kata4.controller;

import java.io.IOException;
import java.util.List;
import kata4.model.Histogram;
import kata4.model.Mail;
import kata4.view.HistogramDisplay;
import kata4.view.MailHistogramBuilder;
import kata4.view.MailListReader;

public class Kata4 {
    private static String fileName;
    private static List<Mail> mailList;
    private static Histogram<String> mailHistogram;

    public static void main(String[] args) throws IOException {
        execute();
    }

    private static void execute() throws IOException {
        input();
        process();
        output();
    }

    private static void input() {
        fileName =  "email.txt";
    }

    private static void process() throws IOException {
        mailList = MailListReader.read(fileName);
    }

    private static void output() {
        HistogramDisplay histogramDisplay = new HistogramDisplay(MailHistogramBuilder.build(mailList));

    }




}
