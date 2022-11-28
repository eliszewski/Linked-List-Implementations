package com.zipcodewilmington.singlylinkedlist;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {
    @Test
    public void testAdd(){
        //given
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        //when
        sll.add(2);
        sll.add(5);
        //then
        Assert.assertTrue(sll.contains(2));
        Assert.assertTrue(sll.contains(5));
    }
    @Test
    public void testRemove(){
        //given
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        sll.add(1);
        sll.add(2);
        sll.add(3);
        //when
        sll.remove(1);
        //then
        Assert.assertFalse(sll.contains(2));
    }
    @Test
    public void testRemove_First(){
        //given
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        sll.add(1);
        sll.add(2);
        sll.add(3);
        //when
        sll.remove(0);
        //then
        Assert.assertFalse(sll.contains(1));
    }
    @Test
    public void testRemove_Last(){
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        sll.add(1);
        sll.add(2);
        sll.add(3);
        //when
        sll.remove(sll.size() -1 );
        //then
        Assert.assertFalse(sll.contains(3));
    }
    @Test
    public void testFind(){
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        sll.add(1);
        sll.add(2);
        sll.add(3);
        //when
        int actual = sll.find(3);
        int expected = 2;
        //then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testFind_doesNotContain(){
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        sll.add(1);
        sll.add(2);
        sll.add(3);
        //when
        int actual = sll.find(10);
        int expected = -1;
        //then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testContains(){
        //given
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        //when
        sll.add(2);
        sll.add(5);
        //then
        Assert.assertTrue(sll.contains(2));
        Assert.assertTrue(sll.contains(5));
    }
    @Test
    public void testContains_False(){
            //given
            SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
            //when
            sll.add(2);
            sll.add(5);
            //then
            Assert.assertFalse(sll.contains(10));
            Assert.assertFalse(sll.contains(89));
    }
    @Test
    public void testGet(){
        //given
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        sll.add(2);
        sll.add(5);
        //when
        Integer actual = sll.get(1);
        Integer expected = 5;
        //then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testSize(){
        //given
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        sll.add(10);
        sll.add(12);
        //when
        int actual = sll.size();
        int expected = 2;
        //then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testCopyAndEquals(){
        //given
        SinglyLinkedList<String> sll = new SinglyLinkedList<String>();
        sll.add("hi");
        sll.add("person");
        //when
        SinglyLinkedList<String> actual = sll.copy();
        //then
        Assert.assertTrue(sll.equals(actual));
    }
    @Test
    public void testEquals_false(){
        //given
        SinglyLinkedList<String> sll = new SinglyLinkedList<String>();
        sll.add("hi");
        sll.add("person");
        //when
        SinglyLinkedList<String> other = sll.copy();
        other.add("you wish you had this");
        //then
        Assert.assertFalse(sll.equals(other));
    }

    @Test
    public void testSort_MaxSteps(){
        //given
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        sll.add(4);
        sll.add(3);
        sll.add(2);
        sll.add(1);

        SinglyLinkedList<Integer> sllSorted = new SinglyLinkedList<Integer>();
        sllSorted.add(1);
        sllSorted.add(2);
        sllSorted.add(3);
        sllSorted.add(4);

        //when
        sll.sort();
        //then
        Assert.assertTrue(sll.equals(sllSorted));
    }
    @Test
    public void testSort_NonMaxIterations(){
        //given
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        sll.add(1);
        sll.add(3);
        sll.add(4);
        sll.add(2);

        SinglyLinkedList<Integer> sllSorted = new SinglyLinkedList<Integer>();
        sllSorted.add(1);
        sllSorted.add(2);
        sllSorted.add(3);
        sllSorted.add(4);

        //when
        sll.sort();
        //then
        Assert.assertTrue(sll.equals(sllSorted));
    }
}
