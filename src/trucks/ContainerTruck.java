package trucks;


import java.util.ArrayList;
import java.util.List;
import container.Container;
import docks.Dock;
import main.Colors;


/**
 * @author Nico van Ommen - 1030808
 * @since 03/28/2020
 */
public class ContainerTruck extends BaseTruck 
{
    private static final int MAX_CONTAINER = 1;
    private Container _container;
   
   
    /**
     * Constructor
     * 
     * @param name
     * @param speed
     * @param type
     */
    public ContainerTruck(String name, int speed, String type, Dock dock)
    {
        super(name, speed, type, dock);
    }


    /**
     * Methode voor het starten van de thread
     */
    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                this.consume();
            }
            catch (InterruptedException e)
            {
                System.out.println("["+Colors.TEXT_RED + "error" + Colors.TEXT_RESET + "]\t\tError: " + e);
            }
        }
    }
    
    
    /**
     * Methode voor het uitvoeren van de thread code
     */
    public void consume() throws InterruptedException
    {
        synchronized (this)
        {
            while (super.getDock().getContainerLength() == 0) 
            {
                System.out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tVrachtwagen: " + super.getTruckName() + " is aan het wachten tot er weer containers beschikbaar zijn!");
                wait();
            }

            System.out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tContainer: " + this.getContainer().getUUID() + " is geladen op vrachtwagen: " + this.getTruckName() + "!");
            this.load(super.getDock().unload());

            notify();
            Thread.sleep(1000);
        }
    }


    /**
     * Methode voor het laden van een container
     * 
     * @param container
     */
    public void load(Container container)
    {
        this._container = container;
    }


    /**
     * Methode voor het verwijderen van de vracht
     * 
     * @return Container
     */
    public Container unload()
    {
        Container temp = this._container;
        this._container = null;
        return this._container;
    }


    /**
     * Methode voor het ophalen van de container
     * 
     * @return Container
     */
    private Container getContainer()
    {
        return this._container;
    }
}
