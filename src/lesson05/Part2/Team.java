package lesson05.Part2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Team implements Comparable<Team>{
    private String name;
    private List<Member> members = new ArrayList<>();
    private int totalPoints;

    public Team(String name) {
        this.name = name;
        totalPoints = 0;
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void addScore(int score) {
        totalPoints += score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return totalPoints;
    }

    public String answer() {
        System.out.println("Team - " + getName());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public String toString() {
        return "Team - " + name + '\'' +
                ", totalPoints - " + totalPoints;
    }

    @Override
    public int compareTo(Team o) {
        return totalPoints - o.totalPoints;
    }
}
