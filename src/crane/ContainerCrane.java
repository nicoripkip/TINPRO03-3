package crane;


import container.Container;
import docks.Dock;
import ship.ContainerShip;
import main.Colors;


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
                while (dock.getContainerLength() >= 5) 
                {
                    System.out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tKraan: " + this.getCraneName() + " is aan het wachten tot er weer ruimte is op de dock!");
                    wait();
                }                
                while (ship.getContainerCount()==0) 
                {
                    System.out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tKraan: " + this.getCraneName() + " is aan het wachten tot er weer een nieuw schip aankomt!");
                    wait();
                }

                Container container = ship.unload();
                System.out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tKraan: " + this.getCraneName() + " haalt nu container: " + container.getUUID() + " uit schip: " + ship.getName() + " gehaalt!");
                dock.load(container);
                System.out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tKraan: " + this.getCraneName() + " heeft nu container: " + container.getUUID() + " op de kade gezet!");

                notify();
            }
        }
    }
}
