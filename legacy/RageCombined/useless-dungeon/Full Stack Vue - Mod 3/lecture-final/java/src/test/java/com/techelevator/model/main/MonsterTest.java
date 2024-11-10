package com.techelevator.model.main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MonsterTest {

    private Monster monster;

    @BeforeEach
    void setUp() {
        monster = new Monster("Roar", 10);
    }

    @Test
    void shouldSetAttackDescriptionCorrectly() {
        assertEquals("Roar", monster.getAttackDescription());
    }

    @Test
    void shouldSetAttackCorrectly() {
        assertEquals(10, monster.getAttack());
    }

    @Test
    void shouldUpdateAttackDescription() {
        monster.setAttackDescription("Growl");
        assertEquals("Growl", monster.getAttackDescription());
    }

    @Test
    void shouldUpdateAttack() {
        monster.setAttack(15);
        assertEquals(15, monster.getAttack());
    }
}