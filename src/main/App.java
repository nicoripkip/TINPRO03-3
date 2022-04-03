package main;


import trucks.ContainerTruck;
import container.Container;
import crane.ContainerCrane;
import docks.Dock;
import ship.ContainerShip;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Timer;


/**
 * @author Niko van Ommen
 * @since 03/29/2020
 */
public class App {
    /**
     * Methode voor het opstarten van het programma
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        ContainerTruck containerTruck1 = new ContainerTruck("Truck1", 20, "normal");
        ContainerTruck containerTruck2 = new ContainerTruck("Truck2", 20, "normal");
        ContainerTruck containerTruck3 = new ContainerTruck("Truck3", 20, "normal");

        ContainerCrane crane1 = new ContainerCrane("Kraan 1", 30);
        ContainerCrane crane2 = new ContainerCrane("Kraan 2", 40);

        Dock containerDock = new Dock();
        ContainerShip containerShip = new ContainerShip("Mearsk");

        // De threads van de trucks worden hier gestart!
        Thread truckThread1 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try 
                {
                    containerTruck1.consume();
                } 
                catch (InterruptedException e) 
                {

                }
            }
        });
        Thread truckThread2 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try 
                {
                    containerTruck2.consume();
                } 
                catch (InterruptedException e)
                {

                }
            }
        });
        Thread truckThread3 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try
                {
                    containerTruck3.consume();
                }
                catch (InterruptedException e)
                {

                }
            }
        });


        // De threads van de kranen
        Thread craneThread1 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try 
                {
                    crane1.produce(containerDock, containerShip);
                } 
                catch (InterruptedException e) 
                {
                    System.out.println("["+Colors.TEXT_RED + "error" + Colors.TEXT_RESET + "]\t\tError: " + e);
                }
            }
        });
        Thread craneThread2 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try 
                {
                    crane2.produce(containerDock, containerShip);
                } 
                catch (InterruptedException e) 
                {
                    System.out.println("["+Colors.TEXT_RED + "error" + Colors.TEXT_RESET + "]\t\tError: " + e);
                }
            }
        });


        // Start de threads
        // truckThread1.start();
        // truckThread2.start();
        // truckThread3.start();
        craneThread1.start();
        craneThread2.start();
    }
}
