package edu.escuelaing.arsw.ASE.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;

public class MyLinkedListTest {

    @Test
    public void testAdd() {
        MyLinkedList<Double> list = new MyLinkedList<>();
        list.add(1.0);
        list.add(2.0);
        list.add(3.0);

        assertEquals(3, list.size());
        assertEquals(1.0, list.get(0));
        assertEquals(2.0, list.get(1));
        assertEquals(3.0, list.get(2));
    }

    @Test
    public void testRemove() {
        MyLinkedList<Double> list = new MyLinkedList<>();
        list.add(1.0);
        list.add(2.0);
        list.add(3.0);

        double removedElement = list.remove();
        assertEquals(1.0, removedElement);
        assertEquals(2, list.size());
        assertEquals(2.0, list.get(0));
        assertEquals(3.0, list.get(1));
    }

    @Test
    public void testRemoveFromEmptyList() {
        MyLinkedList<Double> list = new MyLinkedList<>();
        assertThrows(NoSuchElementException.class, list::remove);
    }

    @Test
    public void testGet() {
        MyLinkedList<Double> list = new MyLinkedList<>();
        list.add(1.0);
        list.add(2.0);
        list.add(3.0);

        assertEquals(1.0, list.get(0));
        assertEquals(2.0, list.get(1));
        assertEquals(3.0, list.get(2));
    }

    @Test
    public void testGetWithInvalidIndex() {
        MyLinkedList<Double> list = new MyLinkedList<>();
        list.add(1.0);
        list.add(2.0);
        list.add(3.0);

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }

    @Test
    public void testCalculateMean() {
        MyLinkedList<Double> list = new MyLinkedList<>();
        list.add(1.0);
        list.add(2.0);
        list.add(3.0);
        list.add(4.0);
        list.add(5.0);

        assertEquals(3.0, list.calculateMean());
    }

    @Test
    public void testCalculateMeanWithEmptyList() {
        MyLinkedList<Double> list = new MyLinkedList<>();
        assertThrows(IllegalStateException.class, list::calculateMean);
    }

    @Test
    public void testCalculateStandardDeviation() {
        MyLinkedList<Double> list = new MyLinkedList<>();
        list.add(600.0);
        list.add(470.0);
        list.add(170.0);
        list.add(430.0);
        list.add(300.0);
  
        assertEquals(164.711, list.calculateStandardDeviation(), 0.01);
    }

    @Test
    public void testCalculateStandardDeviationWithEmptyList() {
        MyLinkedList<Double> list = new MyLinkedList<>();
        assertThrows(IllegalStateException.class, list::calculateStandardDeviation);
    }
}