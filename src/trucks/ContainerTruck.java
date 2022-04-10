package trucks;


import container.Container;
import container.ContainerTypes;
import docks.Dock;
import main.Colors;
import static java.lang.System.out;


/**
 * @author Nico van Ommen - 1030808
 * @since 03/28/2020
 */
public class ContainerTruck extends BaseTruck 
{
    private Container _container;
   
   
    /**
     * Constructor
     * 
     * @param name
     * @param speed
     * @param type
     * @param dock
     */
    public ContainerTruck(String name, int speed, Dock dock)
    {
        super(name, speed, dock);
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
     * @return Als de thread wordt gestopt, wordt er een void return call gemaakt
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

            // Checkt of er speciale containers staan en deze voorrrang kunnen krijgen
            // if ((super.getDock().containsContainerType(ContainerTypes.Heating) || super.getDock().containsContainerType(ContainerTypes.Cooling)))
            // {
            //     super.getDock().wait(50);
            // }
            
            this.load(super.getDock().unload());
            
            // Checkt of de container type overeen komt met het type vrachtwagen wat deze weg mag rijden
            if (this.getContainer().getContainerType() != ContainerTypes.Normal) 
            {
                this.getContainer().connectElements();
            }

            out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tContainer: " + Colors.TEXT_PURPLE + this.getContainer().getUUID() + " van type: " + this.getContainer().getContainerType() + Colors.TEXT_RESET + " is geladen op vrachtwagen: " + Colors.TEXT_YELLOW + this.getTruckName() + Colors.TEXT_RESET + "!");
            
            int t = super.getTiming();

            super.getDock().notify();
            Thread.sleep(super.getTiming());

            // Als de vrachtwagen de container heeft weggereden, verwijder de container uit het model
            if (this.getContainer() != null) 
            {
                out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "][" + Colors.TEXT_GREEN + t + Colors.TEXT_RESET + "]\tVrachtwagen: " + Colors.TEXT_YELLOW + this.getTruckName() + Colors.TEXT_RESET + " heeft container: " + Colors.TEXT_PURPLE + this.getContainer().getUUID() + Colors.TEXT_RESET + " weggereden!");
                this.unload();
            }
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
