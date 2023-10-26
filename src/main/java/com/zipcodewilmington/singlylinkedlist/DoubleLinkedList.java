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
