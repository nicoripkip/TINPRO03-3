package ship;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import container.BaseContainer;
import container.Container;
import container.CooledContainer;
import container.HeatedContainer;


/**
 * @author Nico van Ommen - 1030808
 * @since 04/03/2022
 */
public class ContainerShip extends BaseShip
{
    private final int MAX_CONTAINERS = 100;

    
    private List<BaseContainer> _containers;
    private Random _random = new Random();
    private int _index;


    /**
     * Constructor
     * 
     * @param name
     */
    public ContainerShip(String name)
    {
        super(name);
        this.setContainerList(new LinkedList<BaseContainer>());
        this.generateShipPayload(MAX_CONTAINERS);
    }
    
    
    /**
     * Methode voor het genereren van de vracht van het schip
     * 
     * @param size
     */
    private void generateShipPayload(int size)
    {
        int i;
        int dimensions[] = {20, 20, 20};

        for (i = 0; i < size; i++) {
            switch (this._random.nextInt(3)) {
                case 0:
                    this.getContainerList().add(new Container("Container"+i, dimensions));
                    break;
                case 1:
                    this.getContainerList().add(new HeatedContainer("Container"+i, dimensions));
                    break;
                case 2:
                    this.getContainerList().add(new CooledContainer("Container"+i, dimensions));
                    break;
            }
        }
    }


    /**
     * Methode voor het zetten van de container lijst
     * 
     * @param containers
     */
    private void setContainerList(List<BaseContainer> containers)
    {
        this._containers = containers;
    }


    /**
     * Methode voor het ophalen van de container lijst
     * 
     * @return ArrayList<Container>
     */
    public List<BaseContainer> getContainerList()
    {
        return this._containers;
    }


    private int checkIndex()
    {
        this._index = 0;

        if (this.getContainerList().get(this._index).getSemaphore().availablePermits() != 0) {
            return this._index;
        }

        return this._index++;
    }


    /**
     * Methode om het aantal containers op het 
     * 
     * @return
     */
    public int getContainerCount()
    {
        return this.getContainerList().size();
    }


    /**
     * Methode voor het uitladen van het schip
     */
    public BaseContainer unload()
    {
        if (this.getContainerList().isEmpty()) {
            return null;
        }

        BaseContainer temp = this.getContainerList().get(this.checkIndex());
        this.getContainerList().remove(temp);

        return temp;
    }
}
