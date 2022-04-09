package trucks;


import java.util.ArrayList;
import java.util.List;
import container.Container;
import docks.Dock;
import main.Colors;
import static java.lang.System.out;


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
     * 
     */
    @Override
    public void run()
    {
        while (!this._thread_finish)
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
     * 
     */
    public void consume() throws InterruptedException
    {
        synchronized (super.getDock())
        {
            while (super.getDock().getContainerLength() == 0) 
            {
                out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tVrachtwagen: " + Colors.TEXT_YELLOW  + super.getTruckName() + Colors.TEXT_RESET +  " is aan het wachten tot er weer containers beschikbaar zijn!");
                
                if (super.getDock().getShipDeparted()) 
                {
                    super._thread_finish = true;
                    return;
                } 
                else 
                {
                    super.getDock().wait();
                }
            }
            
            this.load(super.getDock().unload());

            if (super.getTruckType() == ContainerTypes.Normal && this.getContainer().getContainerType() == "normal") 
            {
                out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tContainer: " + Colors.TEXT_PURPLE + this.getContainer().getUUID() + Colors.TEXT_RESET + " is geladen op vrachtwagen: " + Colors.TEXT_YELLOW + this.getTruckName() + Colors.TEXT_RESET + "!");
            } 
            else if (super.getTruckType() == ContainerTypes.Heating && this.getContainer().getContainerType() == "heating") 
            {
                out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tContainer: " + Colors.TEXT_PURPLE + this.getContainer().getUUID() + Colors.TEXT_RESET + " is geladen op vrachtwagen: " + Colors.TEXT_YELLOW + this.getTruckName() + Colors.TEXT_RESET + "!");
                this.getContainer().connectHeatingElements();
            }
            else if (super.getTruckType() == ContainerTypes.Cooling && this.getContainer().getContainerType() == "cooling") 
            {
                out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tContainer: " + Colors.TEXT_PURPLE + this.getContainer().getUUID() + Colors.TEXT_RESET + " is geladen op vrachtwagen: " + Colors.TEXT_YELLOW + this.getTruckName() + Colors.TEXT_RESET + "!");
                this.getContainer().connectCoolingElements();
            } 
            else 
            {
                // out.println("[" + Colors.TEXT_RED + "error" + Colors.TEXT_RESET + "]\t\tContainer: " + Colors.TEXT_PURPLE + this.getContainer().getUUID() + Colors.TEXT_RESET + " kan niet op vrachtwagen: " + Colors.TEXT_YELLOW + this.getTruckName() + Colors.TEXT_RESET + " worden geladen!");
                super.getDock().load(this.unload());
                // super.getDock().wait();
                Thread.sleep(1000);
            }
            
            super.getDock().notify();
            Thread.sleep(10);
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
        return temp;
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
