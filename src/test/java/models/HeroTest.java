package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {
    @Before
    public void setUp() throws Exception {
        Hero.clearAllHeroes();
    }

    @After
    public void tearDown() throws Exception {
        Hero.clearAllHeroes();
    }


    @Test
   public void NewHeroObject_true() throws Exception {
        Hero hero = new Hero("nelson madela",5,"great leader","love", 1);
        assertEquals (true, hero instanceof Hero);
    };
    @Test
   public void HeroInstantiatesWithHeroName_true() throws Exception{
        Hero hero = new Hero ("Nelson Mandela",5,"great leader","love",  1);
        assertEquals("Nelson Mandela",hero.getName());
    }
    @Test
    public void AllHeroesAreCorrectlyReturned_true(){
        Hero hero = new Hero ("Nelson Mandela",5,"great leader","love",  1);
        Hero otherHero = new Hero ("Nelson Mandela",5,"great leader","love",  1);
        assertEquals(2,Hero.getAll().size());
    }
    @Test
    public void AllHeroesContainsAllHeroes_true() {
        Hero hero = new Hero ("Nelson Mandela",5,"great leader","love",  1);
        Hero otherHero = new Hero ("Nelson Mandela",5,"great leader","love",  1);
        assertTrue(Hero.getAll().contains(hero));
        assertTrue(Hero.getAll().contains(otherHero));
    }
    @Test
    public void getId_HeroesInstantiateWithAnID_1() throws Exception{
        Hero.clearAllHeroes();
        Hero myHero = new Hero ("Nelson Mandela",5,"great leader","love", 1);
        assertEquals(1, myHero.getId());
    }

    private Hero setupNewHero() {
        return new Hero ("Nelson Mandela",5,"great leader","love",  1);
    }
    @Test
    public void findReturnsCorrectHero() throws Exception {
        Hero hero = setupNewHero();
        assertEquals(1, hero.findById(hero.getId()).getId());
    }
    @Test
    public void findReturnsCorrectHeroWhenMoreThanOneHeroesExists() throws Exception {
        Hero hero = setupNewHero();
        Hero myHero = new Hero ("Nelson Mandela",5,"great leader","love",  1);
        assertEquals(2, Hero.findById(myHero.getId()).getId());
    }
    @Test
    public void updateChangesPostContent() throws Exception {
        Hero hero = setupNewHero();
        String formerSpecialPower = hero.getSpecialPower();
        int formerId = hero.getId();

        hero.update("kenyatta",5,"kenyan leader","progress");
        assertEquals(formerId, hero.getId());
        assertNotEquals(formerSpecialPower, hero.getSpecialPower());
    }
    @Test
    public void deleteDeletesASpecificHero() throws Exception {
        Hero hero = setupNewHero();
        Hero myHero = new Hero ("Nelson Mandela",5,"great leader","love", 1);
        hero.deleteHero();
        assertEquals(1, Hero.getAll().size()); //one is left
        assertEquals(Hero.getAll().get(0).getId(), 2);

    }

}