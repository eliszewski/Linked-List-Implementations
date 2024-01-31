package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoubleLinkedListTest {

    DoubleLinkedList<Integer> subject;


    @Test
    public void add_firstElement(){
        subject = new DoubleLinkedList<>();

        subject.add(3);

        assertEquals(1,subject.size());
        assertEquals(Integer.valueOf(3), subject.get(0));
    }

    @Test
    public void add_multipleElements(){
        subject = new DoubleLinkedList<>();

        subject.add(3);
        subject.add(7);
        subject.add(8);

        assertEquals(3,subject.size());
        assertEquals(Integer.valueOf(3), subject.get(0));
        assertEquals(Integer.valueOf(7), subject.get(1));
        assertEquals(Integer.valueOf(8), subject.get(2));
    }

    @Test
    public void get_firstElement(){
        subject = new DoubleLinkedList<>();
        subject.add(3);

        subject.get(0);

        assertEquals(Integer.valueOf(3), subject.get(0));
    }

    @Test
    public void contains_whenElementIsPresent_returnTrue(){
        subject = new DoubleLinkedList<>();
        subject.add(3);
        subject.add(5);

        Assert.assertTrue(subject.contains(5));
    }

    @Test
    public void contains_whenElementIsNotPresent_returnFalse(){
        subject = new DoubleLinkedList<>();

        assertFalse(subject.contains(3));
    }

    @Test
    public void remove_removeHead(){
        subject = new DoubleLinkedList<>();
        subject.add(3);

        subject.remove(0);

        assertFalse(subject.contains(0));
        assertEquals(0,subject.size());
    }

    @Test
    public void remove_emptyList_throwException(){
        subject = new DoubleLinkedList<>();

        Exception actual = assertThrows(IllegalStateException.class, () -> subject.remove(0));

        assertEquals("Out of bounds index", actual.getMessage());
    }

    @Test
    public void remove_removeMiddle(){
        subject = new DoubleLinkedList<>();
        subject.add(3);
        subject.add(4);
        subject.add(5);
        subject.add(6);
        subject.add(7);

        subject.remove(2);

        assertFalse(subject.contains(5));
        assertEquals(4,subject.size());
    }
}
