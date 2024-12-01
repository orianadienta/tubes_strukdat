package com.strukdat.gimmick;

import java.util.Random;

public class RandomGimmick implements GimmickInterface {
    @Override
    public String runGimmick() {
        Random random = new Random();
        String[] facts = {
                "Honey never spoils.",
                "Bananas are berries, but strawberries aren't.",
                "Octopuses have three hearts.",
                "A group of flamingos is called a 'flamboyance'.",
                "The Eiffel Tower can be 15 cm taller during the summer.",
                "Wombat poop is cube-shaped.",
                "Humans share 60% of their DNA with bananas.",
                "A day on Venus is longer than a year on Venus.",
                "The shortest war in history lasted 38 minutes.",
                "There are more stars in the universe than grains of sand on Earth."
        };

        return facts[random.nextInt(facts.length)];
    }
}
