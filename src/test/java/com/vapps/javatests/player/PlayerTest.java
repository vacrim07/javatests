package com.vapps.javatests.player;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void should_looses_when_dice_is_lower_than_reference(){

        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(2);

        Player player = new Player(dice,3);

        assertFalse(player.play());
    }

    @Test
    public void should_wins_when_dice_is_higher_than_reference(){

        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(4);

        Player player = new Player(dice,3);

        assertTrue(player.play());
    }

}