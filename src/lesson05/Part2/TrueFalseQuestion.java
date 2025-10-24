package lesson05.Part2;

public class TrueFalseQuestion extends Question {
    private boolean answer;
    public TrueFalseQuestion(String text, int points, boolean answer) {
        super(text, points);
        this.answer = answer;
    }

    @Override
    public void ask() {
        System.out.println(super.getText());
        System.out.println("true");
        System.out.println("false");
    }

    @Override
    public boolean checkAnswer(String curAnswer) {
        String result = answer ? "true" : "false";
        return curAnswer.toLowerCase().equals(result);
    }
}
