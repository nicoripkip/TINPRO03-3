package trucks;


import container.BaseContainer;
import container.CooledContainer;
import container.HeatedContainer;
import docks.Dock;
import main.Colors;
import static java.lang.System.out;


/**
 * @author Nico van Ommen - 1030808
 * @since 03/28/2020
 */
public class ContainerTruck extends BaseTruck 
{
    private BaseContainer _container;
   
   
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
        while (!this._thread_finish) {
            try {
                this.consume();
            } catch (InterruptedException e) {
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
        int t = super.getTiming();
        Thread.sleep(super.getTiming());

        if (super.getDock().getContainerLength() == 0) {
            out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tVrachtwagen: " + Colors.TEXT_YELLOW  + super.getTruckName() + Colors.TEXT_RESET +  " is aan het wachten tot er weer containers beschikbaar zijn!");
            
            if (super.getDock().getShipDeparted()) {
                super._thread_finish = true;
                return;
            } else {
                return;
            }
        }
        
        this.load(super.getDock().unload());
        
        // Checkt of de container type overeen komt met het type vrachtwagen wat deze weg mag rijden
        if (this.getContainer() instanceof HeatedContainer || this.getContainer() instanceof CooledContainer) {
            this.getContainer().connectElements();
        }

        out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tContainer: " + Colors.TEXT_PURPLE + this.getContainer().getUUID() + Colors.TEXT_RESET + " is geladen op vrachtwagen: " + Colors.TEXT_YELLOW + this.getTruckName() + Colors.TEXT_RESET + "!");
        
        // Als de vrachtwagen de container heeft weggereden, verwijder de container uit het model
        if (this.getContainer() != null) {
            out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "][" + Colors.TEXT_GREEN + t + Colors.TEXT_RESET + "]\tVrachtwagen: " + Colors.TEXT_YELLOW + this.getTruckName() + Colors.TEXT_RESET + " heeft container: " + Colors.TEXT_PURPLE + this.getContainer().getUUID() + Colors.TEXT_RESET + " weggereden!");
            this.unload();
        }
    }


    /**
     * Methode voor het laden van een container
     * 
     * @param container
     */
    public void load(BaseContainer container) 
    {
        this._container = container;
    }


    /**
     * Methode voor het verwijderen van de vracht
     * 
     * @return Container
     */
    public BaseContainer unload() 
    {
        BaseContainer temp = this._container;
        this._container = null;

        return temp;
    }


    /**
     * Methode voor het ophalen van de container
     * 
     * @return Container
     */
    private BaseContainer getContainer()
    {
        return this._container;
    }
}
