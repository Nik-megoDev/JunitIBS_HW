package ru.ibs.gnm.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.NumberFormatException;

public class TestJunitHW {

    private JunitHW junitHW;

    @BeforeEach
    void init() {
        junitHW = new JunitHW();
    }

    @Test
    void fizzBuzzTest() {
        String expected = "1 FizzBuzz 13 8 Fizz FizzBuzz ";
        StringBuilder actual = new StringBuilder("");
        Integer intArray[] = {1, 15, 13, 8, 9, 0};
        for (int i = 0; i < intArray.length; i++) {
            actual.append(JunitHW.fizzBuzz(intArray[i]) + " ");
        }
        Assertions.assertEquals(expected, actual.toString());
    }

    @Test
    void actionWithContentStringTest () throws IOException {
        final BufferedReader br = Mockito.mock(BufferedReader.class);
        Mockito.when(br.readLine()).thenReturn("str");
        Assertions.assertThrows(NumberFormatException.class, () -> {
            JunitHW.actionWithContent(br);
        });
        br.close();
    }

    @Test
    void actionWithContentSeveralNumbersTest () throws IOException {
        final BufferedReader br = Mockito.mock(BufferedReader.class);
        Mockito.when(br.readLine()).thenReturn("15 10");
        Assertions.assertThrows(NumberFormatException.class, () -> {
            JunitHW.actionWithContent(br);
        });
        br.close();
    }

    @Test
    void mainMethodTest ()  {
        ByteArrayInputStream in = new ByteArrayInputStream("Неправильный путь к файлу".getBytes());
        System.setIn(in);
        Assertions.assertThrows(IOException.class, JunitHW::mainMethod);
        System.setIn(System.in);
    }
}
