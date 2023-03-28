package ru.otus.spring.dao;

import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.core.io.ClassPathResource;
import ru.otus.spring.domain.Question;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;



@RequiredArgsConstructor
public class QuestionDaoCsv implements QuestionDao {

    private final String csvPath;

    @Override
    public List<Question> getQuestionList() {
        List<Question> questionList = new ArrayList<>();

        ClassPathResource resource = new ClassPathResource(csvPath);
        try (InputStreamReader isr = new InputStreamReader(resource.getInputStream())) {
            CSVParser parser = new CSVParser(isr, CSVFormat.DEFAULT);
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
