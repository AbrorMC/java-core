package lesson05.Part2;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private String title;
    private List<Question> questions = new ArrayList<>();
    private List<Team> teams = new ArrayList<>();

    public Quiz(String title) {
        this.title = title;
    }

    public void addQuestion (Question question) {
        questions.add(question);
    }

    public void addTeam (Team team) {
        teams.add(team);
    }

    public void start() {
        for (Question question : questions) {
            question.ask();
            for (Team team : teams) {
                String answer = team.answer();
                if (question.checkAnswer(answer)){
                    team.addScore(question.getPoints());
                }
            }
        }
    }

    public void showResults() {
        teams.stream()
                .sorted()
                .toList()
                .forEach(System.out::println);
    }
}
