package com.pizzathread.simulator;

public class Client extends Thread{

    private Table table;
    public static long t = 1000;
    private boolean stopEating = false;

    public Client(String name, Table table){
        super(name);
        this.table = table;
    }

    public void eatPizza(){
        System.out.println(getName() + ": I'll get a pizza from the table...");
        synchronized(table){
            try{
                while(table.isEmpty()){
                    System.out.println(getName() + ": The table is empty! I'll wait for a pizza...");
                    table.wait();
                }
                Pizza p = table.takePizza();
                System.out.println(getName() + ": nom nom nom");
                System.out.println(getName() + ": *digesting*");
                Thread.sleep(t);
            }catch(InterruptedException ex){
            }
        }
    }

    public void stopEatingPizza(){
        stopEating = true;
    }

    public void run(){
        while(!stopEating){
            eatPizza();
        }
    }
}
