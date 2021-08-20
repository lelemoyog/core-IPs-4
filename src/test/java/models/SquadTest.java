package models;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {
    @Before
    public void setUp() throws Exception {
        Squad.clearAllSquads();
    }

    @After
    public void tearDown() throws Exception {
        Squad.clearAllSquads();
    }

    @Test
    public void NewSquadObject_true() throws Exception {
        Squad squad = new Squad(1,"Phoenix");
        assertEquals (true, squad instanceof Squad);
    };
    @Test
    public void SquadInstantiatesWithSquadName_true() throws Exception{
        Squad squad = new Squad(1,"Phoenix");
        assertEquals("Phoenix",squad.getSquadName());
    }
    @Test
    public void AllSquadsAreCorrectlyReturned_true(){
        Squad squad = new Squad(1,"Phoenix");
        Squad newSquad = new Squad(2,"Dragon");
        assertEquals(2,Squad.getInstances().size());
    }
    @Test
    public void AllSquadsContainsAllSquads_true() {
        Squad squad = new Squad(1,"Phoenix");
        Squad newSquad = new Squad(2,"Dragon");;
        assertTrue(Squad.getInstances().contains(squad));
        assertTrue(Squad.getInstances().contains(newSquad));
    }
    @Test
    public void getSquadId_SquadInstantiateWithAnID_1() throws Exception{
        Squad.clearAllSquads();
        Squad squad = new Squad(1,"Phoenix");
        assertEquals(1, squad.getSquadId());
    }
    @Test
    public void findReturnsCorrectSquad() throws Exception {
        Squad squad = new Squad(1,"Phoenix");
        assertEquals(1, squad.findById(squad.getSquadId()).getSquadId());
    }
    @Test
    public void findReturnsCorrectSquadWhenMoreThanOneSquadsExists() throws Exception {
        Squad squad = new Squad(1,"Phoenix");
        Squad newSquad = new Squad(2,"Dragon");
        assertEquals(2, Squad.findById(newSquad.getSquadId()).getSquadId());
    }
    @Test
    public void updateChangeSquadContent() throws Exception {
        Squad newSquad = new Squad(2,"Dragon");
        String formerSquadName = newSquad.getSquadName();
        int formerId =newSquad.getSquadId();

        newSquad.update(2,"Phoenix");

        assertEquals(formerId, newSquad.getSquadId());
        assertNotEquals(formerSquadName, newSquad.getSquadName());
    }
    @Test
    public void deleteDeletesASpecificSquad() throws Exception {
        Squad squad = new Squad(1,"Phoenix");
        Squad newSquad = new Squad(2,"Dragon");
        squad.deleteSquad();
        assertEquals(1, Squad.getInstances().size()); //one is left
        assertEquals(Squad.getInstances().get(0).getSquadId(), 2);

    }

}