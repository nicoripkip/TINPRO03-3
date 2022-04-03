package main;


import trucks.ContainerTruck;
import container.Container;
import crane.ContainerCrane;
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
        Queue<ContainerTruck> containerTrucks = new LinkedList<ContainerTruck>();

        for (int i = 0; i < 100; i++) {
            containerTrucks.add(new ContainerTruck("Truck"+i, new Random().nextInt(50), "Normal"));
        }


        System.out.println(Colors.TEXT_BLUE + "[info]" + Colors.TEXT_RESET + "\t\tAantal trucks in queue: " + containerTrucks.size());
    }
}
