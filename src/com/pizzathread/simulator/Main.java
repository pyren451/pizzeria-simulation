package com.pizzathread.simulator;

public class Main{
    public static void main(String[] args){
        Table table1 = new Table(3);

        Client client1 = new Client("Mario", table1);
        Client client2 = new Client("Luigi", table1);

        Chef chef1 = new Chef("Chef Luca", table1);
        Chef chef2 = new Chef("Chef Andrea", table1);
        Chef chef3 = new Chef("Chef Marco", table1);

        client1.start();
        client2.start();

        chef1.start();
        chef2.start();
        chef3.start();
    }
}
