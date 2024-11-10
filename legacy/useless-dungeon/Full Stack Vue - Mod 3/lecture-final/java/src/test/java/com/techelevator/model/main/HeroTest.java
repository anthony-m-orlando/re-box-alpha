package com.techelevator.model.main;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    private Hero hero;
    private Profession profession;

    @BeforeEach
    void setUp() {
        profession = new Profession(1, "Warrior", 100, 50, 75);
        hero = new Hero(profession);
    }

    @Test
    void heroShouldBeCreatedWithCorrectProfession() {
        assertEquals(profession, hero.getProfession());
    }

    @Test
    void heroAttackShouldBeSetAndRetrievedCorrectly() {
        hero.setAttack(75);
        assertEquals(75, hero.getAttack());
    }

    @Test
    void heroProfessionShouldBeSetAndRetrievedCorrectly() {
        Profession newProfession = new Profession(2, "Mage", 80, 60, 70);
        hero.setProfession(newProfession);
        assertEquals(newProfession, hero.getProfession());
    }

    @Test
    void heroShouldBeCreatedWithCorrectValues() {
        assertEquals(profession, hero.getProfession());
        assertEquals(75, hero.getAttack());
    }

    @Test
    void heroShouldUpdateAttackWhenProfessionChanges() {
        Profession newProfession = new Profession(2, "Mage", 80, 60, 70);
        hero.setProfession(newProfession);
        assertEquals(80, hero.getAttack());
    }

    @Test
    void heroShouldBeCreatedWithDefaultValuesUsingDefaultConstructor() {
        Hero defaultHero = new Hero();
        assertNull(defaultHero.getProfession());
        assertEquals(0, defaultHero.getAttack());
        // Add similar assertions for other fields
    }

    @Test
    void heroHealthShouldBeSetAndRetrievedCorrectly() {
        hero.setHealth(80);
        assertEquals(80, hero.getHealth());
    }

    @Test
    void heroDefenseShouldBeSetAndRetrievedCorrectly() {
        hero.setDefense(60);
        assertEquals(60, hero.getDefense());
    }

    @Test
    void heroShouldUpdateFieldsWhenProfessionChanges() {
        Profession newProfession = new Profession(3, "Rogue", 90, 70, 80);
        hero.setProfession(newProfession);
        assertEquals(newProfession, hero.getProfession());
        assertEquals(90, hero.getAttack());
        // Add similar assertions for other fields
    }
}