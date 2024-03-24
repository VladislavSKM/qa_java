package com.example;

import org.mockito.Spy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

   @Spy
   private Feline feline;

    @Test
    public void getKittensTest() throws Exception{
        Lion lion = new Lion("Самка", feline);
        when(feline.getKittens()).thenReturn(1);
        assertEquals(feline.getKittens(), lion.getKittens());
    }

    @Test
    public void getFoodPredatorTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"),lion.getFood());
    }

}
