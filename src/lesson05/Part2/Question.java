package lesson05.Part2;

public abstract class Question {
    private String text;
    private int points;

    public Question(String text, int points) {
        this.text = text;
        this.points = points;
    }

    public String getText() {
        return text;
    }

    public int getPoints() {
        return points;
    }

    public abstract void ask();

    public abstract boolean checkAnswer(String answer);
}
