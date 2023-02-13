package docks;


import java.util.List;
import container.Container;
import container.HeatedContainer;
import container.BaseContainer;


/**
 * @author Nico van Ommen - 1030808
 * @since 04/03/2022
 */
public class Dock
{
    private final int MAX_CONTAINERS = 5;

    private List<BaseContainer> _containers;
    private boolean _ship_departed;
    
    
    /**
     * Constructor
     */
    public Dock()
    {
        this.setContainerStack(new List<BaseContainer>(MAX_CONTAINERS));
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
    private void setContainerStack(List<BaseContainer> containers)
    {
        this._containers = containers;
    }


    /**
     * Methode voor het ophalen van de container stack
     * 
     * @return ArrayBlockingQueue<Container>
     */
    private List<BaseContainer> getContainers()
    {
        return this._containers;
    }


    /**
     * Methode voor het laden van de dock
     * 
     * @param container
     */
    public void load(BaseContainer container)
    {
        this.getContainers().add(container);
    }


    /**
     * Methode voor het ontladen van de docks
     * 
     * @return Container
     */
    public BaseContainer unload()
    {
        return this.getContainers().remove(this.getContainers().size()-1);
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
    public boolean containsContainerType()
    {
        int i = 0;

        for (BaseContainer c : this.getContainers()) 
        {
            if (c instanceof HeatedContainer)
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
