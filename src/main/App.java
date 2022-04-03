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

        ContainerCrane crane1 = new ContainerCrane();
        ContainerCrane crane2 = new ContainerCrane();

        Dock containerDock = new Dock();

        Thread truckThread1 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    containerTruck1.consume();
                } catch (InterruptedException e) {

                }
            }
        });
    }
}
