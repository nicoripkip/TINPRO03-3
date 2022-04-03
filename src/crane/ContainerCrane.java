package crane;


import container.Container;
import docks.Dock;
import ship.ContainerShip;


/**
 * @author Nico van Ommen - 1030808
 * @since 04/03/2022
 */
public class ContainerCrane extends BaseCrane
{
    private boolean _isFree;
    private Container container;
    

    /**
     * Constructor
     * 
     * @param name
     * @param speed
     */
    public ContainerCrane(String name, int speed)
    {
        super(name, speed);
    }


    /**
     * Functie die de threat laat starten
     * 
     * @param dock
     */
    public void produce(Dock dock, ContainerShip ship) throws InterruptedException
    {
        while (true) 
        {
            synchronized (this) 
            {
                while (dock.getContainerLength() >= 5) wait();
                while (ship.) wait();
            }
        }
    }
}
