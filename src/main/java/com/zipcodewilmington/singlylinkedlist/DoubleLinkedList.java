package com.zipcodewilmington.singlylinkedlist;

public class DoubleLinkedList<T extends Comparable<T>> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (size == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        size++;
        tail = newNode;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        int counter = 0;
        Node<T> current = head;
        while (counter != index) {
            current = current.next;
            counter++;
        }
        return current.value;
    }

    public boolean contains(T value) {
        Node<T> current = head;
        while(current != null){
            if(value.equals(current.value)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void remove(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Negative index not allowed");
        }
        if(index >= size){
            throw new IllegalStateException("Out of bounds index");
        }

        if(index == 0){
            head = head.next;
            head.next.setPrev(null);
            if(size == 1){
                tail = null;
            }
        } else {
            Node<T> currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }
            Node<T> skippedToNode = currentNode.getNext().getNext();
            currentNode.setNext(skippedToNode);
            skippedToNode.setPrev(currentNode);
            if (index == size - 1) {
                tail = currentNode;
            }
        }
        size--;
    }


    private static class Node<T extends Comparable<T>> {
            T value;
            Node<T> next;
            Node<T> prev;

            public Node(T value) {
                this.value = value;
                this.next = null;
                this.prev = null;
            }

            public T getValue() {
                return value;
            }

            public void setValue(T value) {
                this.value = value;
            }

            public Node<T> getNext() {
                return next;
            }

            public void setNext(Node<T> nextNode) {
                this.next = nextNode;
            }

            public Node<T> getPrev() {
                return prev;
            }

            public void setPrev(Node<T> prev) {
                this.prev = prev;
            }
        }
    }
