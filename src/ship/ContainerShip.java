package ship;


import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import container.Container;
import container.ContainerTypes;

/**
 * @author Nico van Ommen - 1030808
 * @since 04/03/2022
 */
public class ContainerShip extends BaseShip
{
    private final int MAX_CONTAINER_LIMIT = 100;

    private ArrayBlockingQueue<Container> _containers;
    private Random _random = new Random();


    /**
     * Constructor
     * 
     * @param name
     */
    public ContainerShip(String name)
    {
        super(name);
        this.setContainerList(new ArrayBlockingQueue<Container>(MAX_CONTAINER_LIMIT));
        this.generateShipPayload(MAX_CONTAINER_LIMIT);
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

        for (i = 0; i < size; i++)
        {
            this.getContainerList().add(new Container("Container"+i, dimensions, this.getRandomcontainerType(3)));
        }
    }


    /**
     * Methode voor het zetten van de container lijst
     * 
     * @param containers
     */
    private void setContainerList(ArrayBlockingQueue<Container> containers)
    {
        this._containers = containers;
    }


    /**
     * Methode voor het ophalen van de container lijst
     * 
     * @return ArrayList<Container>
     */
    public ArrayBlockingQueue<Container> getContainerList()
    {
        return this._containers;
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
    public Container unload()
    {
        return this.getContainerList().remove();
    }


    /**
     * Methode voor het random genereren van de container type
     * 
     * @return String
     */
    private ContainerTypes getRandomcontainerType(int max)
    {
        switch (this._random.nextInt(max)) 
        {
            case 0:
                return ContainerTypes.Normal;
            case 1:
                return ContainerTypes.Heating;
            case 2:
                return ContainerTypes.Cooling;
        }

        return ContainerTypes.Normal;
    }
}
