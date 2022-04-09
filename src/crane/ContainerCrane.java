package crane;


import java.util.concurrent.Semaphore;
import java.util.function.Supplier;

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
    private Container _container;
    private ContainerShip _ship;
    private boolean _thread_finish = false;
    

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
        while (!this._thread_finish) 
        {
            try 
            {
                this.consume();
                this.produce();
            }
            catch (InterruptedException e)
            {
                System.out.println("["+Colors.TEXT_RED + "error" + Colors.TEXT_RESET + "]\t\tError: " + e);
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
        synchronized (super.getDock()) 
        {
            while (super.getDock().getContainerLength() >= 5) 
            {
                System.out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tKraan: " + this.getCraneName() + " is aan het wachten tot er weer ruimte is op de dock!");
                super.getDock().wait();
            }        
            
            super.getDock().load(this.getContainer());
            System.out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tKraan: " + this.getCraneName() + " heeft nu container: " + this.getContainer().getUUID() + " op de kade gezet!");

            super.getDock().notify();
            super.getDock().getPermit().release();
            Thread.sleep(10);
        }
    }


    /**
     * Methode voor het ophalen van data uit de containership buffer
     * 
     * @param ship
     */
    public void consume() throws InterruptedException
    {
        synchronized (this.getContainerShip()) 
        {
            while (this.getContainerShip().getContainerCount() == 0) 
            {
                System.out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tKraan: " + this.getCraneName() + " is aan het wachten tot er weer een nieuw schip aankomt!");
                this._thread_finish = true;
                super.getDock().setShipDeparted(this._thread_finish);
                return;
            }
            while (super.getDock().getPermit().availablePermits() == 0) {
                System.out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tKraan: " + this.getCraneName() + " is aan het wachten tot hij weer containers mag pakken!");
                this.getContainerShip().wait();
            }

            this.setContainer(this.getContainerShip().unload());
            System.out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tKraan: " + this.getCraneName() + " haalt nu container: " + this.getContainer().getUUID() + " uit schip: " + this.getContainerShip().getName() + " gehaalt!");
            
            this.getContainerShip().notify();
            Thread.sleep(10);
        }
    }


    /**
     * Methode voor het zetten van de container
     * 
     * @param container
     */
    private void setContainer(Container container)
    {
        this._container = container;
    }


    /**
     * Methode voor het ophalen van de container
     * 
     * @return
     */
    private Container getContainer()
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
