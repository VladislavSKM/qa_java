package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import static com.example.Constants.EXCEPTION_TEXT;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class ParameterizedTest {

    private String sex;

    public ParameterizedTest(String sex, boolean hasMane){
      this.sex = sex;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {

        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

   @Mock
   Feline felineMock;

    @Test
    public void doesHaveManeTest() throws Exception {
        try {
            Lion lion = new Lion(sex, felineMock);
            lion.doesHaveMane();
            assertEquals(lion.hasMane, lion.doesHaveMane());
        } catch (Exception e) {
            assertEquals(EXCEPTION_TEXT, e.getMessage());
        }
    }

}

