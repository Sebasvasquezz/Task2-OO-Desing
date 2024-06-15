package edu.escuelaing.arsw.ASE.app;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * MyLinkedList represents a simple linked list data structure that stores elements of type T.
 * It implements the Iterable interface to enable iteration over its elements.
 *
 * @param <T> the type of elements stored in the linked list.
 */
public class MyLinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private int size;
    /**
     * Constructs a new node with the specified data.
     *
     * @param data the data to be stored in the node.
     */
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Constructs an empty linked list.
     */
    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Adds a new element to the end of the linked list.
     *
     * @param data the data to be added to the linked list.
     */
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * Removes and returns the first element of the linked list.
     *
     * @return the removed element.
     * @throws NoSuchElementException if the linked list is empty.
     */
    public T remove() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    /**
     * Retrieves the element at the specified index in the linked list.
     *
     * @param index the index of the element to retrieve.
     * @return the element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Returns the number of elements in the linked list.
     *
     * @return the size of the linked list.
     */
    public int size() {
        return size;
    }

    /**
     * Returns an iterator over the elements in the linked list.
     *
     * @return an iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    /**
     * Calculates the mean (average) of the elements in the linked list.
     *
     * @return the mean of the elements.
     * @throws IllegalStateException if the linked list is empty.
     */
    public double calculateMean() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        double sum = 0;
        for (T num : this) {
            sum += (Double) num;
        }
        return Math.round((sum / size) * 100.0) / 100.0;
    }

     /**
     * Calculates the standard deviation of the elements in the linked list.
     *
     * @return the standard deviation of the elements.
     * @throws IllegalStateException if the linked list is empty.
     */
    public double calculateStandardDeviation() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        double mean = calculateMean();
        double sumSquaredDiffs = 0;
        for (T num : this) {
            sumSquaredDiffs += Math.pow((Double) num - mean, 2);
        }
        
        return Math.round(Math.sqrt(sumSquaredDiffs / (size - 1)) * 100.0) / 100.0;
    }
}


