package lesson05.Part2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz("Brain Battle");

        Team team1 = new Team("Alpha");
        team1.addMember(new Member("Ivanov Ivan"));
        team1.addMember(new Member("Sidorov Mixail"));
        team1.addMember(new Member("Antonov Yuriy"));

        Team team2 = new Team("Beta");
        team2.addMember(new Member("Petrova Anna"));
        team2.addMember(new Member("Sidorova Marina"));
        team2.addMember(new Member("Ivanova Anastasiya"));

        quiz.addTeam(team1);
        quiz.addTeam(team2);

        Question q1 = new MultipleChooseQuestion(
                "What is the capital of France?",
                10,
                List.of("A) Berlin", "B) Paris", "C) Rome", "D) Madrid"),
                Options.B
        );

        Question q2 = new TrueFalseQuestion(
                "The Earth is flat.",
                5,
                false
        );

        Question q3 = new OpenQuestion(
                "Who wrote the play Romeo and Juliet?",
                15,
                List.of("William Shakespeare", "Shakespeare", "W.Shakespeare")
        );

        quiz.addQuestion(q1);
        quiz.addQuestion(q2);
        quiz.addQuestion(q3);

        quiz.start();

        quiz.showResults();

    }
}

