package equipment;


import container.BaseContainer;
import container.CooledContainer;
import container.HeatedContainer;
import docks.Dock;
import ship.ContainerShip;
import main.Colors;
import static java.lang.System.out;


/**
 * @author Nico van Ommen - 1030808
 * @since 04/03/2022
 */
public class ContainerCrane extends BaseCrane
{
    private BaseContainer _container;
    private ContainerShip _ship;
    private boolean _thread_finish = false;
    private int _previous_time = 0;
    

    /**
     * Constructor
     * 
     * @param name
     * @param speed
     */
    public ContainerCrane(String name, int speed, Dock dock, ContainerShip ship)
    {
        super(name, speed, dock);
        this.setContainerShip(ship);
    }


    /**
     * Methode voor het runnen
     */
    @Override
    public void run()
    {
        while (!this._thread_finish) {
            try {
                this.consume();
                this.produce();
            } catch (InterruptedException e) {
                out.println("["+Colors.TEXT_RED + "error" + Colors.TEXT_RESET + "]\t\tError: " + e);
            }
        }
    }


    /**
     * Methode voor het toevoegen van data aan de dock
     * 
     * @param dock
     */
    public void produce() throws InterruptedException
    {
        Thread.sleep(this._previous_time);

        if (super.getDock().getContainerLength() >= 5) {
            out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tKraan: " + Colors.TEXT_CYAN + this.getCraneName() + Colors.TEXT_RESET + " is aan het wachten tot er weer ruimte is op de dock!");
            // super.getDock().getContainerList().wait();
            return;
        }

        out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tKraan: " + Colors.TEXT_CYAN + this.getCraneName() + Colors.TEXT_RESET + " gaat nu container: " + Colors.TEXT_PURPLE + this.getContainer().getUUID() + Colors.TEXT_RESET + " op de kade zetten!");
        super.getDock().load(this.getContainer());
        out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "][" + Colors.TEXT_GREEN + (this._previous_time * 2) + Colors.TEXT_RESET + "]\tKraan: " + Colors.TEXT_CYAN + this.getCraneName() + Colors.TEXT_RESET + " heeft nu container: " + Colors.TEXT_PURPLE + this.getContainer().getUUID() + Colors.TEXT_RESET + " op de kade gezet!");

        // super.getDock().getContainerList().notify();
    }


    /**
     * Methode voor het ophalen van data uit de containership buffer
     * 
     * @param ship
     */
    public void consume() throws InterruptedException
    {
        this._previous_time = super.getTiming() / 2;
        Thread.sleep(this._previous_time);

        while (this.getContainerShip().getContainerCount() == 0) {
            out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tKraan: " + Colors.TEXT_CYAN + this.getCraneName() + Colors.TEXT_RESET + " is aan het wachten tot er weer een nieuw schip aankomt!");
            this._thread_finish = true;
            super.getDock().setShipDeparted(this._thread_finish);
            return;
        }

        out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tKraan: " + Colors.TEXT_CYAN + this.getCraneName() + Colors.TEXT_RESET + " gaat nu een container uit het schip: " + this.getContainerShip().getShipName() + " halen!");
        
        this.setContainer(this.getContainerShip().unload());

        if (this.getContainer() instanceof HeatedContainer || this.getContainer() instanceof CooledContainer) {
            this.getContainer().disconnectElements();
        }

        out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tKraan: " + Colors.TEXT_CYAN + this.getCraneName() + Colors.TEXT_RESET + " haalt nu container: " + Colors.TEXT_PURPLE + this.getContainer().getUUID() + Colors.TEXT_RESET + " uit schip: " + this.getContainerShip().getShipName() + " gehaalt!");
        
        // this.getContainerShip().getContainerList().notify();
    }


    /**
     * Methode voor het zetten van de container
     * 
     * @param container
     */
    private void setContainer(BaseContainer container)
    {
        this._container = container;
    }


    /**
     * Methode voor het ophalen van de container
     * 
     * @return
     */
    private BaseContainer getContainer()
    {
        return this._container;
    }


    /**
     * Methode om het containerschip te zetten
     * 
     * @param ship
     */
    public void setContainerShip(ContainerShip ship)
    {
        this._ship = ship;
    }


    /**
     * Methode om het schip op te halen
     * 
     * @return
     */
    public ContainerShip getContainerShip()
    {
        return this._ship;
    }
}
