package lesson05.Part2;

import java.util.List;

public class MultipleChooseQuestion extends Question {
    private List<String> options;
    private Options answer;

    public MultipleChooseQuestion(String text, int points, List<String> options, Options answer) {
        super(text, points);
        this.options = options;
        this.answer = answer;
    }

    @Override
    public void ask() {
        System.out.println(super.getText());
        printOptions();
    }

    private void printOptions() {
        for (String option : options) {
            System.out.println(option);
        }
    }

    @Override
    public boolean checkAnswer(String curAnswer) {
        return Options.valueOf(curAnswer.toUpperCase()).equals(answer);
    }
}
