package com.example.doublyLinkedList;

//import java.util.Iterator;

import com.example.fibonacci.Fibonacci;

import java.util.ArrayList;
import java.util.LinkedList;

class MyArrayList extends LinkedList{

}

class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        list.addHead(1); list.addHead(2); list.addHead(3);
        System.out.println(list.removeFirst()); System.out.println(list.removeLast());
        System.out.println(list.removeAt(0));

        Fibonacci fibonacci = new Fibonacci(5);
        fibonacci.Calculate();
    }
}

public class DoublyLinkedList <T>  {

    private int size;
    private Node<T> head;
    private Node<T> tail;
    public DoublyLinkedList() {
        this(0, null, null);
    }

    public DoublyLinkedList(int size, Node<T> head, Node<T> tail) {
        this.size = size;
        this.head = head;
        this.tail = tail;
    }

    private class Node<T> {
        T data;
        Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        //getter and setter
        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    //Empty this linked list, O(n)
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    //Return the size of this linked list
    public int size(){
        return this.size;
    }

    //Is this linked list empty?
    public boolean isEmpty(){
        return this.size == 0;
    }

    //Add an element to the tail of the linked list, O(1)
    public void add(T elem){
        addTail(elem);
    }

    //Add a node to the tail of the linked list, O(1)
    public void addTail(T elem){
        if(size == 0) { // head = null, tail = null, size = 0
            Node<T> newNode = new Node(elem, head, tail);
            head = newNode;
            tail = newNode;
        } else {
//            Node<T> node = new Node(elem, tail.prev.next, tail.prev);
            Node<T> newNode = new Node(elem, tail.prev, tail);
//            tail.prev.next = newNode;
//            tail.prev = newNode;
            newNode.prev = tail;
            tail.next = newNode;
            newNode = tail;
        }
        size++;
    }

    //Add an element to the beginning of this linked list, O(1)
    public void addHead(T elem) {
        if(size == 0)
        {
            Node<T> newNode = new Node(elem, head, tail);
//            head.next = newNode;
//            tail.prev = newNode;
            head = newNode;
            tail = newNode;
        }
        else {
//            Node<T> newNode = new Node(elem, head, head.getNext());
//            head.getNext().setPrev(newNode);
//            head.next = newNode;
//            Node<T> nextNode = head.next;

            Node<T> newNode = new Node(elem, head, head.next);
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        System.out.println(elem + " is added");
        size++;
    }

    //Check the value of the first node if it exists, O(1)
    public T peekFirst() {
        if(size == 0)
        {
            return null;
        }
        else
        {
            return head.next.data;
        }
    }

    //Check the value of the last node if it exists, O(1)
    public T peekLast() {
        if(size == 0)
        {
            return null;
        }
        else
        {
            return tail.data;
        }
    }

    //Remove the first value at the head of the linked list, O(1)
    public T removeFirst() {
        if(size == 0)
            return null;
        else {
//            Node<T> firstNode = head.next;
//            Node<T> secondNode = firstNode.next;
//            head.next = secondNode;
//            secondNode.prev = head;
//            size--;
//            return firstNode.data;
            T data = head.data;
            head = head.next;
            head.prev = null;
            size--;
            return data;
        }
    }

    //Remove the last value at the tail of the linked list, O(1)
    public T removeLast() {
        if(size == 0)
        {
            return null;
        }
        else{
//            Node<T> lastNode = tail.prev;
//            Node<T> secondLast = lastNode.prev;
//            tail.prev = secondLast;
//            secondLast.next = tail;
//            size--;
//            return lastNode.data;
            T data = tail.data;
            tail = tail.prev;
            tail.next = null;
            size--;
            return data;
        }
    }

    //Remove an arbitrary node from the linked list, O(1)
    public T remove(Node<T> node) {
        if(size == 0)
        {
            return null;
        }
        else { //what if the node is not existed?
            Node<T> previousNode = node.prev;
            Node<T> nextNode = node.next;
            previousNode.next = nextNode;
            nextNode.prev = previousNode;
            size--;
            return node.data;
        }
    }

    //Remove a node at a particular index, O(n)
    public T removeAt(int index)
    {
        if(size < index)
        {
            System.out.println("Error: Index cannot be over than list size");
        }
            if(size == 0)
            {
                System.out.println("Error: It's empty! Cannot remove anything");
                return null;
            }
            if(size == 1)
            {
                T data = head.data;
                head = null;
                tail = null;
                size = 0;
                return data;
            }
            Node<T> target = head;
            Node<T> previousNode, nextNode = null;
            int count = 0;
            while(count != index)
            {
                target = target.next;
                count++;
            }

            previousNode = target.prev;
            nextNode = target.next;
            previousNode.next = nextNode;
            nextNode.prev = previousNode;
            size--;
            return target.data;
    }

    //Remove a particular value in the linked list, O(n)
    public boolean remove(Object obj)
    {
        boolean check = false;
        Node<T> target = head;
        Node<T> previousNode, nextNode = null;
        while(target != null)
        {
            if(obj.equals(target.data)) {
                previousNode = target.prev;
                nextNode = target.next;
                previousNode.next = nextNode;
                nextNode.prev = previousNode;
                size--;
                check = true;
            }
                target = target.next;
        }
        return check;
    }

    //Find the index of a particular value in the linked list, O(n)
    public int indexOf(Object obj) {
        int count = 0;
        Node<T> target = head;
        while(target != null)
        {
            if(target.data.equals(obj))
            {
                return count;
            }
            target = target.next;
            count++;
        }
        return -1;
    }

    //Check is a value is contained within the linked list
    public boolean contains(T obj){
        Node<T> target = head;
        while(target != null){
            if(target.data.equals(obj)){
                return true;
            }
            target = target.next;
        }
        return false;
    }

    class Stack{
        private int size;
        private int listSize;
        private DoublyLinkedList list;
        private Node<T> head;
        private Node<T> tail;

        public Stack()
        {
            this.size = 5;
            this.listSize = 0;
            this.head = null;
            this.tail = null;
        }

        public Stack(int size, DoublyLinkedList list)
        {
            this.size = size;
            this.list = list;
            this.listSize = list.size();
            this.head = list.head;
            this.tail = list.tail;
        }
    }
}
