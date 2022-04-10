package main;


import trucks.ContainerTruck;

import java.util.Random;

import crane.ContainerCrane;
import docks.Dock;
import ship.ContainerShip;


/**
 * @author Niko van Ommen - 1030808
 * @since 03/29/2020
 */
public class App 
{
    /**
     * Methode voor het opstarten van het programma
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Dock containerDock = new Dock();
        ContainerShip containerShip = new ContainerShip("Mearsk");

        ContainerTruck containerTruck1 = new ContainerTruck("Truck1", 20, containerDock);
        ContainerTruck containerTruck2 = new ContainerTruck("Truck2", 20, containerDock);
        ContainerTruck containerTruck3 = new ContainerTruck("Truck3", 20, containerDock);

        ContainerCrane crane1 = new ContainerCrane("Kraan 1", 30, containerDock, containerShip);
        ContainerCrane crane2 = new ContainerCrane("Kraan 2", 40, containerDock, containerShip);

        // De threads van de kranen
        crane1.start();
        crane2.start();

        // De threads van de trucks worden hier gestart!
        containerTruck1.start();
        containerTruck2.start();
        containerTruck3.start();
    }
}
