package docks;


import java.util.LinkedList;
import java.util.List;
import container.HeatedContainer;
import container.BaseContainer;
import container.CooledContainer;


/**
 * @author Nico van Ommen - 1030808
 * @since 04/03/2022
 */
public class Dock
{
    public final int MAX_CONTAINERS = 5;

    private List<BaseContainer> _containers;
    private boolean _ship_departed;
    private int _index;
    
    
    /**
     * Constructor
     */
    public Dock()
    {
        this.setContainerList(new LinkedList<BaseContainer>());
    }


    /**
     * Methode voor het ophalen van de grootte van de containers op de dock
     * 
     */
    public int getContainerLength()
    {
        return this.getContainerList().size();
    }


    /**
     * Methode om de container stack te initialiseren
     * 
     * @param containers
     */
    private void setContainerList(List<BaseContainer> containers)
    {
        this._containers = containers;
    }


    /**
     * Methode voor het ophalen van de container stack
     * 
     * @return ArrayBlockingQueue<Container>
     */
    public List<BaseContainer> getContainerList()
    {
        return this._containers;
    }


    /**
     * Methode voor het controleren of de container op de index in questie gepakt kan worden
     * 
     * @return
     */
    private int checkIndex()
    {
        this._index = 0;

        if (this.getContainerList().get(this._index).getSemaphore().availablePermits() != 0) {
            return this._index;
        }

        this._index++;

        if (this._index > this.getContainerList().size()) {
            return -1;
        } else {
            return this._index;
        }
    }


    /**
     * Methode voor het laden van de dock
     * 
     * @param container
     * @throws InterruptedException
     */
    public void load(BaseContainer container) throws InterruptedException
    {
        container.getSemaphore().release();
        this.getContainerList().add(container);
    }


    /**
     * Methode voor het ontladen van de docks
     * 
     * @return Container
     * @throws InterruptedException
     */
    public BaseContainer unload() throws InterruptedException
    {
        if (this.getContainerList().isEmpty()) {
            return null;
        }

        int index = 0;
        int i;

        for (i = 0; i < this.getContainerList().size(); i++) {
            if (this.getContainerList().get(i) instanceof HeatedContainer || this.getContainerList().get(i) instanceof CooledContainer) {
                index = i;
                break;
            }
        }

        if (index == 0) {
            index = this.checkIndex();
        }

        if (index == -1) {
            return null;
        }

        this.getContainerList().get(index).getSemaphore().acquire();
        BaseContainer temp = this.getContainerList().get(index);
        this.getContainerList().remove(temp);

        return temp;
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
}
