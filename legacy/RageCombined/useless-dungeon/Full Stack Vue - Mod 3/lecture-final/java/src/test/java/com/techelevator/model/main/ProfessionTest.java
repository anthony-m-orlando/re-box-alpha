package com.techelevator.model.main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProfessionTest {

    private Profession profession;

    @BeforeEach
    void setUp() {
        profession = new Profession(1, "Warrior", 100, 50, 75);
    }

    @Test
    void professionShouldBeCreatedWithCorrectValues() {
        assertEquals(1, profession.getProfessionId());
        assertEquals("Warrior", profession.getProfessionName());
        assertEquals(100, profession.getStartingHealth());
        assertEquals(50, profession.getStartingDefense());
        assertEquals(75, profession.getStartingAttack());
    }


}