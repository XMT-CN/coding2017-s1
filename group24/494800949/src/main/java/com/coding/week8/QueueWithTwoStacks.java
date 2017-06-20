package com.coding.week8;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列
 * @author liuxin
 *
 * @param <E>
 */
public class QueueWithTwoStacks<E> {
	private Stack<E> stack1;
    private Stack<E> stack2;


    public QueueWithTwoStacks() {
        stack1 = new Stack<E>();
        stack2 = new Stack<E>();
    }



    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }



    public int size() {
        return stack1.size() + stack2.size();
    }



    public void enQueue(E item) {
        if(item == null){
            throw new RuntimeException("item cant be null");
        }
        stack1.push(item);
    }

    public E deQueue() {
        if (isEmpty()) {
            throw new RuntimeException("no data in queue");
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }



 }

