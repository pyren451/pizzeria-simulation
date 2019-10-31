package com.pizzathread.simulator;

public class Chef extends Thread{

    private Table table;
    public static long t = 1000;
    private boolean stopProduction = false;

    public Chef(String name, Table table){
        super(name);
        this.table = table;
    }

    public void makePizza(){
        System.out.println(getName() + ": Making pizza...");
        synchronized(table){
            try{
                while(table.isFull()){
                    System.out.println(getName() + ": The table is full, pizza waiting to be collected");
                    table.wait();
                    System.out.println(getName() + ": The table is empty, making next pizza...");
                }
                System.out.println(getName() + ": *working*");
                Thread.sleep(t);
                table.addPizza(new Pizza());
            }catch(InterruptedException ex){
            }
        }
    }

    public void stopPizza(){
        stopProduction = true;
    }

    public void run(){
        while(!stopProduction){
            makePizza();
        }
    }
}
