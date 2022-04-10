package docks;


import java.util.concurrent.ArrayBlockingQueue;
import container.Container;
import container.ContainerTypes;


/**
 * @author Nico van Ommen - 1030808
 * @since 04/03/2022
 */
public class Dock
{
    private static final int MAX_CONTAINERS = 5;

    private ArrayBlockingQueue<Container> _containers;
    private boolean _ship_departed;
    
    
    /**
     * Constructor
     */
    public Dock()
    {
        this.setContainerStack(new ArrayBlockingQueue<Container>(MAX_CONTAINERS));
    }


    /**
     * Methode voor het ophalen van de grootte van de containers op de dock
     * 
     */
    public int getContainerLength()
    {
        return this.getContainers().size();
    }


    /**
     * Methode om de container stack te initialiseren
     * 
     * @param containers
     */
    private void setContainerStack(ArrayBlockingQueue<Container> containers)
    {
        this._containers = containers;
    }


    /**
     * Methode voor het ophalen van de container stack
     * 
     * @return ArrayBlockingQueue<Container>
     */
    private ArrayBlockingQueue<Container> getContainers()
    {
        return this._containers;
    }


    /**
     * Methode voor het laden van de dock
     * 
     * @param container
     */
    public void load(Container container)
    {
        this.getContainers().add(container);
    }


    /**
     * Methode voor het ontladen van de docks
     * 
     * @return Container
     */
    public Container unload()
    {
        return this.getContainers().remove();
    }


    /**
     * Methode voor het zetten van het ship departed
     * 
     * @param shipDeparted
     */
    public void setShipDeparted(boolean shipDeparted)
    {
        this._ship_departed = shipDeparted;
    }


    /**
     * Methode voor het ophalen van het ship departed
     * 
     * @return boolean
     */
    public boolean getShipDeparted()
    {
        return this._ship_departed;
    }


    /**
     * Methode voor het checken of een container aanwezig is
     * 
     * @param type
     * @return
     */
    public boolean containsContainerType(ContainerTypes type)
    {
        int i = 0;

        for (Container c : this.getContainers()) 
        {
            if (c.getContainerType() == type)
            {
                i++;
            }
        }

        if (i > 0)
        {
            return true;
        }

        return false;
    }
}
