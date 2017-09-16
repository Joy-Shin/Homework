package com.example.stack;

class main {
    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        stack.push(1); stack.push(2); stack.push(3);stack.push(4);stack.push(5); stack.push(6);
        stack.pop(); stack.pop();stack.pop();stack.pop();stack.pop();
        stack.pop();

//        LinkedStack<String> stacks = new LinkedStack<String>();
//        stacks.push("["); stacks.push("(");stacks.push("]");stacks.push("]");
//        OpenClose openClose = new OpenClose(stacks);
//
//        System.out.println(openClose.validating());
    }
}

class LinkedStack <T>{
    private int size;
    private int listSize;
    private Node<T> head;

    public LinkedStack()
    {
        this.listSize = 0;
        this.size = 5;
        this.head = null;
    }
    public LinkedStack(Node<T> head, Node<T> tail)
    {
        this.listSize = 0;
        this.size = 5;
        this.head = head;
    }

    private class Node<T> {
        T data;
        Node<T> next;

        public Node(T data, Node<T> next){
            this.data = data;
            this.next = next;
        }
    }

    public void push(T element) {
        if (size < listSize) {
            size *= 2;
            push(element);
        } else {
            if (listSize == 0) {
                Node<T> newNode = new Node<T>(element, null);
                head = newNode;
                listSize++;
                System.out.println(element + " is pushed");
                size++;
            } else {
                System.out.println(element + " is pushed");
//                Node<T> newNode = new Node<T>(element, null);
//                Node<T> target = head;
//                while(target.next != null)
//                {
//                    target = target.next;
//                }
//
//                target.next = newNode;
//                listSize++;
//                size++;

                Node<T> newNode = new Node<T>(element, null);
                newNode.next = head;
                head = newNode;
                listSize++;
                size++;
            }
        }
    }

    public void pop() {
        if (listSize == 1) {
            System.out.println(head.data + " is popped");
            head = null;
            listSize = 0;
            size = 0;
        }
        if(size > listSize){
//            Node<T> target = head;
//            while(target.next != null)
//            {
//                target = target.next;
//            }
//
//            System.out.println(target.data + " is popped");

            T data = head.data;
            head = head.next;
            System.out.println(data + " is popped");
            listSize--;
            size--;
        }
        else
        {
            System.out.println("Error: Stack is empty");
        }
    }

    public T getHead()
    {
        return head.data;
    }

    public T getTail()
    {
        Node<T> target = head;
        while(target.next != null)
        {
            target = target.next;
        }

        return target.data;
    }

    public int getIndex(T data)
    {
        int count = 0;
        Node<T> target = head;
        while(target.next != null) {
            if (target.data.equals(data)) {
                break;
            }
            count++;
        }

        return count;
    }
}

class OpenClose<String> {
    private LinkedStack<String> stack = new LinkedStack<String>();
    private String start;
    private String end;
    private int size;
    private boolean validation;

    public OpenClose(LinkedStack<String> stack)
    {
        this.stack = stack;
        this.size = 4;
        this.start = stack.getHead();
        this.end = stack.getTail();
    }

    public boolean validating()
    {

        boolean check = false;
        if(start == end)
        {
            stack.pop();
            check = true;
            validating();
        }
        else
        {
            stack.pop();
            check = false;
            validating();
        }

        return check;
    }
}
