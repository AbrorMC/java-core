package lesson03.PartTwo;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class Fighter {

    private static Map<Integer, Fighter> fighters = new HashMap<>();

    private int code;
    private String name;
    private int health;
    private int attack;

    public Fighter(int code, String name, int health, int attack) {
        this.code = code;
        this.name = name;
        this.health = health;
        this.attack = attack;
        fighters.put(code, this);
    }

    public void fight(Fighter enemy) {
        if (enemy != null) {
            enemy.setHealth(enemy.getHealth() - attack);
            if (enemy.getHealth() < 0) {
                enemy.setHealth(0);
            }
        }
    }

    public static Map<Integer, Fighter> getFighters() {
        return fighters;
    }

    public String getFighterInfo() {
        return "Code - " + code + ", name - " + name + ", health - " + health + ", attack - " + attack;
    }

}
