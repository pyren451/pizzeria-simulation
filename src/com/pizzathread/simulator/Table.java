package com.pizzathread.simulator;

public class Table {

    private Pizza[] buffer;
    private int n;

    public Table(int max){
        buffer = new Pizza[max];
    }

    public void addPizza(Pizza p){
        System.out.println("New pizza on the table. TOTAL: "+(n+1));
        if(isEmpty()){
            notifyAll();
            System.out.println("There are pizzas on the table. Notification sent.");
        }
        buffer[n++] = p;
    }

    public boolean isFull(){
        return n==buffer.length;
    }

    public boolean isEmpty(){
        return n==0;
    }

    public Pizza takePizza(){
        System.out.println("Pizza taken from table. TOTAL: "+(n-1));
        if(isFull()){
            notifyAll();
            System.out.println("The table is full. Notification sent.");
        }
        return buffer[--n];
    }

    public void setMax(int max){
        n=0;
        buffer = new Pizza[max];
    }

}
