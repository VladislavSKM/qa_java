package com.example;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    private Feline feline;
    @Spy
    private Cat cat = new Cat(feline);

    @Test
    public void GetSoundTest() throws Exception {
        Cat cat = new Cat(new Feline());
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void GetFoodTest() throws Exception {
        cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }
}