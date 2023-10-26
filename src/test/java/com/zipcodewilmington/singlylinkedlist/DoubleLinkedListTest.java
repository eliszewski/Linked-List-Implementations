package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

public class DoubleLinkedListTest {

    DoubleLinkedList<Integer> subject;


    @Test
    public void add_firstElement(){
        subject = new DoubleLinkedList<>();

        subject.add(3);

        Assert.assertEquals(1,subject.size());
        Assert.assertEquals(Integer.valueOf(3), subject.get(0));
    }

    @Test
    public void add_multipleElements(){
        subject = new DoubleLinkedList<>();

        subject.add(3);
        subject.add(7);
        subject.add(8);

        Assert.assertEquals(3,subject.size());
        Assert.assertEquals(Integer.valueOf(3), subject.get(0));
        Assert.assertEquals(Integer.valueOf(7), subject.get(1));
        Assert.assertEquals(Integer.valueOf(8), subject.get(2));
    }

    @Test
    public void get_firstElement(){
        subject = new DoubleLinkedList<>();
        subject.add(3);

        subject.get(0);

        Assert.assertEquals(Integer.valueOf(3), subject.get(0));
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

        Assert.assertFalse(subject.contains(3));
    }
}
