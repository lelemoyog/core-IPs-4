package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {



    @Test
   public void NewHeroObject_true() throws Exception {
        Hero hero = new Hero("nelson madela");
        assertEquals (true, hero instanceof Hero);
    };
    @Test
   public void HeroInstantiatesWithName_true() throws Exception{
        Hero hero = new Hero ("Nelson Mandela");
        assertEquals("Nelson Mandela",hero.getName());
    }
}