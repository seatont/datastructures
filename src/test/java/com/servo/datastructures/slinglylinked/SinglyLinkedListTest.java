package com.servo.datastructures.slinglylinked;

import org.junit.Test;
import com.servo.datastructures.singlylinked.SinglyLinkedList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class SinglyLinkedListTest {

    @Test
    public void itShouldReturnAnEmptyCountOnConstruction() {
        SinglyLinkedList list = new SinglyLinkedList();
        assertTrue(list.getCount() == 0);
    }

    @Test
    public void itShouldHaveOneItem() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(10);
        assertTrue(list.getCount() == 1);
    }

    @Test
    public void itShouldReturnTheFirstValue() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(10);
        list.addFirst(11);
        list.addFirst(12);
        list.addFirst(13);
        assertTrue(list.getFirst() == 13);
    }

    @Test(expected = RuntimeException.class)
    public void itShouldThrowAnExceptionWhenEmptyAndCallForFirst() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.getFirst();
    }

    @Test
    public void itShouldReturnTheFinalValue() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(10);
        list.addFirst(11);
        list.addFirst(12);
        list.addFirst(13);
        assertEquals(10,list.getLast());
    }

    @Test(expected = RuntimeException.class)
    public void itShouldThrowAnExceptionWhenEmptyAndCallForLast() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.getLast();
    }

    @Test
    public void itShouldRemoveTheCorrectElementAndMaintainTheLinks() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(10);
        list.addFirst(11);
        list.addFirst(12);
        list.addFirst(13);
        assertTrue(list.remove(12));
        assertEquals(3, list.getCount());
    }

    @Test
    public void itShouldRemoveTheFinalLink() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(10);
        list.addFirst(11);
        list.addFirst(12);
        list.addFirst(13);
        assertTrue(list.remove(13));
        assertEquals(3, list.getCount());
    }

    @Test
    public void itShouldReturnFalseNoItemFound() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(10);
        list.addFirst(11);
        list.addFirst(12);
        list.addFirst(13);
        assertFalse(list.remove(25));
        assertEquals(4, list.getCount());
    }
}
