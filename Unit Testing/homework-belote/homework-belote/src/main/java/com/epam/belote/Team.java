package com.epam.belote;

import com.epam.belote.bonus.Bonus;

import java.util.Set;


public class Team {
    private int score;

    public Team() {

    }

    public void calculatePoints(Set<Bonus> bonuses) {
        for(Bonus bonus: bonuses) {
            this.score += bonus.getBonus();
        }
    }

    public int getScore() {
        return this.score;
    }
}

