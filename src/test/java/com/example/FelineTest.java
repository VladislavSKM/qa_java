package com.example;

import org.junit.Assert;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import static com.example.Constants.EXCEPTION_TEXT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline felineSpy;

    @Test
    public void eatMeatTest() throws Exception {
        Feline feline = new Feline();
        Animal animal = new Animal();
        assertEquals(feline.eatMeat(), animal.getFood("Хищник"));
    }

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensTest() {
        felineSpy.getKittens();
        Mockito.verify(felineSpy, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void testGetKittensWithArgggumentTest() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens(1));
    }

    @Test
    public void getExceptionTest() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Средний пол", new Feline()));
        Assert.assertEquals(EXCEPTION_TEXT, exception.getMessage());
    }
}