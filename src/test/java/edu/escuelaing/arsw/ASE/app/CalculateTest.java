package edu.escuelaing.arsw.ASE.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculateTest {

    @Test
    public void testReadNumbersFromFile() {
        Calculate calculator = new Calculate();
        calculator.readNumbersFromFile("E:\\ARSW\\Tarea2\\OO-Desing\\testFiles\\test.txt"); 

        assertEquals(5, calculator.getNumbers().size());
        assertEquals(600.0, calculator.getNumbers().get(0));
        assertEquals(470.0, calculator.getNumbers().get(1));
        assertEquals(170.0, calculator.getNumbers().get(2));
        assertEquals(430.0, calculator.getNumbers().get(3));
        assertEquals(300.0, calculator.getNumbers().get(4));
    }

    @Test
    public void testCalculateMeanColumn1() {
        Calculate calculator = new Calculate();
        calculator.readNumbersFromFile("E:\\ARSW\\Tarea2\\OO-Desing\\testFiles\\Column1.txt");
        assertEquals(550.6, calculator.calculate(list -> list.calculateMean()));
    }

    @Test
    public void testCalculateMeanColumn2() {
        Calculate calculator = new Calculate();
        calculator.readNumbersFromFile("E:\\ARSW\\Tarea2\\OO-Desing\\testFiles\\Column2.txt");
        assertEquals(60.32, calculator.calculate(list -> list.calculateMean()),0.01);
    }

    @Test
    public void testCalculateStdDevColumn1() {
        Calculate calculator = new Calculate();
        calculator.readNumbersFromFile("E:\\ARSW\\Tarea2\\OO-Desing\\testFiles\\Column1.txt");
        assertEquals(572.03, calculator.calculate(list -> list.calculateStandardDeviation()),0.01);
    }

    @Test
    public void testCalculateStdDevColumn2() {
        Calculate calculator = new Calculate();
        calculator.readNumbersFromFile("E:\\ARSW\\Tarea2\\OO-Desing\\testFiles\\Column2.txt");
        assertEquals(62.25, calculator.calculate(list -> list.calculateStandardDeviation()),0.01);
    }

    @Test
    public void testCalculateMeanOneValue() {
        Calculate calculator = new Calculate();
        calculator.readNumbersFromFile("E:\\ARSW\\Tarea2\\OO-Desing\\testFiles\\UnValor.txt");
        assertEquals(160.0, calculator.calculate(list -> list.calculateMean()),0.01);
    }

    @Test
    public void testCalculateMeanWithEmptyList() {
        Calculate calculator = new Calculate();
        assertThrows(IllegalStateException.class, () -> calculator.calculate(list -> list.calculateMean()));
    }

    @Test
    public void testCalculateStandardDeviationWithEmptyList() {
        Calculate calculator = new Calculate();
        calculator.readNumbersFromFile("E:\\ARSW\\Tarea2\\OO-Desing\\testFiles\\Vacio.txt");
        assertThrows(IllegalStateException.class, () -> calculator.calculate(list -> list.calculateStandardDeviation()));
    }
}

