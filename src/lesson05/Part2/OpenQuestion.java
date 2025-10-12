package lesson05.Part2;

import java.util.List;

public class OpenQuestion extends Question {
    private List<String> answer;

    public OpenQuestion(String text, int points, List<String> answer) {
        super(text, points);
        this.answer = answer.stream().map(e -> e.trim().toLowerCase()).toList();
    }

    @Override
    public void ask() {
        System.out.println(super.getText());
    }

    @Override
    public boolean checkAnswer(String curAnswer) {
        boolean result = false;
        for (String ans : answer) {
            result = curAnswer.toLowerCase().equals(ans);
        }
        return result;
    }
}
