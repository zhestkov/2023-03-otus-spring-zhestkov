package ru.otus.spring.hw2.dao;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import ru.otus.spring.hw2.domain.Question;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionDaoCsv implements QuestionDao {

    private final String csvFilename;

    public QuestionDaoCsv(@Value("${quiz.questions.filename}") String csvFilename) {
        this.csvFilename = csvFilename;
    }

    @Override
    public List<Question> getQuestionList() {
        List<Question> questionList = new ArrayList<>();

        var resource = new ClassPathResource(csvFilename);
        try (InputStreamReader isr = new InputStreamReader(resource.getInputStream())) {
            var parser = new CSVParser(isr, CSVFormat.DEFAULT);
            parser.getRecords().stream().skip(1).forEach(rec -> {
                questionList.add(Question.builder()
                        .title(rec.get(0))
                        .correctAnswer(rec.get(1))
                        .build());
            });
        } catch (IOException ex) {
            System.out.println("InputStreamReader exception:" + ex);
        }

        return questionList;
    }
}
