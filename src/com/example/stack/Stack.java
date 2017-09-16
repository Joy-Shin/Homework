package com.example.stack;

class Main {
	public static void main(String[] args) {
		//Stack stack = new Stack(10);
//		Stack stack = new Stack();
//		stack.push(1); stack.push(2); stack.push(3); stack.push(4); stack.push(5);
//		stack.push(6); stack.push(7); stack.push(8);stack.push(9);stack.push(10);
//		stack.push(11);
//
//		stack.pop(); stack.pop();stack.pop();stack.pop();stack.pop();stack.pop();stack.pop();stack.pop();stack.pop();stack.pop();stack.pop();
        TeacherStack stack = new TeacherStack();
        stack.push(1); stack.push(2); stack.push(3); stack.push(4);stack.push(5);
        stack.push(6); stack.push(7);stack.push(8);stack.push(9);stack.push(10);
        stack.push(11);

        stack.pop(); stack.pop(); stack.pop(); stack.pop(); stack.pop(); stack.pop(); stack.pop(); stack.pop(); stack.pop(); stack.pop(); stack.pop();
        stack.pop();
	}
}

class Stack {

	private int size;
	private int[] stacks;
	private int top;

	public Stack() {
		this.size = 10;
		this.stacks = new int[size];
		this.top = -1;
	}

	public void push(int element) { // speed : 7? O(1)??
		if (top -1 == size) { // top == --size
			//System.out.println("Stack is full");

			//Switch
			int[] tmp = new int[size * 2];
			for(int i = 0; i <= top; i++){
				tmp[i] = stacks[i];
			}
			stacks = null;
			stacks = new int[size * 2];
			for(int i = 0; i <= top; i++){
				stacks[i] = tmp[i];
			}
			stacks[++top] = element;
			System.out.println(element + " is pushed");
		} else {
			stacks[++top] = element;
			System.out.println(element + " is pushed");
		}
		size++;
	}

	public void pop() { // speed : 5 ? O(5)???
		if (top == -1) {
			System.out.println("Stack is empty");
		} else {
			System.out.println(stacks[top] + " is popped");
			top--;
		}
		size--;
	}
}

class TeacherStack{
	private int size;
	private int top;
	private int[] stack;

	public TeacherStack(){
		this.size = 10;
		this.top = -1;
		this.stack = new int[size];
	}

	public void push(int element){
		if(size < stack.length){
            stack[++top] = element;
        }
		else {
            int[] tmp = new int[size * 2];
            for(int i = 0; i <= top; i++){
                tmp[i] = stack[i];
            }
            stack = null;
            stack = new int[size * 2];
            for(int i = 0; i <= top; i++) {
                stack[i] = tmp[i];
            }
			stack[++top] = element;
		}
        System.out.println(element + " is pushed");
        size++;
	}

	public void pop() {
        if (top == -1) {
            System.out.println("Error: Stack is empty");
        }
        System.out.println(stack[top--] + " is popped");
        size--;
    }
}