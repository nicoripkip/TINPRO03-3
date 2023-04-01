package main;


import trucks.ContainerTruck;
import trucks.OilTruck;
import docks.Dock;
import equipment.ContainerCrane;
import equipment.Pump;
import ship.ContainerShip;
import ship.TankerShip;


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
        TankerShip tankerShip = new TankerShip("Zs Mr Oliebol");

        Pump pump = new Pump("Oliepomp", tankerShip);

        ContainerTruck containerTruck1 = new ContainerTruck("Truck1", 20, containerDock);
        ContainerTruck containerTruck2 = new ContainerTruck("Truck2", 20, containerDock);
        ContainerTruck containerTruck3 = new ContainerTruck("Truck3", 20, containerDock);

        OilTruck oilTruck1 = new OilTruck("Olie truck 1", 20, containerDock, pump);
        OilTruck oilTruck2 = new OilTruck("Olie truck 2", 20, containerDock, pump);

        ContainerCrane crane1 = new ContainerCrane("Kraan 1", 30, containerDock, containerShip);
        ContainerCrane crane2 = new ContainerCrane("Kraan 2", 40, containerDock, containerShip);

        // De threads van de kranen worden hier gestart
        crane1.start();
        crane2.start();

        // De threads van de pomp worden hier gestart
        pump.start();

        // De threads van de trucks worden hier gestart!
        containerTruck1.start();
        containerTruck2.start();
        containerTruck3.start();

        // De threads van de olietrucks worden hier gestart
        oilTruck1.start();
        oilTruck2.start();
    }
}
