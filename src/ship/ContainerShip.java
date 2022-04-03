package ship;

import java.util.ArrayList;

import container.Container;

/**
 * @author Nico van Ommen
 * @since 04/03/2022
 */
public class ContainerShip 
{
    private ArrayList<Container> _containers;


    /**
     * Constructor
     */
    public ContainerShip()
    {
        this.setContainerList(new ArrayList<Container>());
        this.getContainerList();
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
            this.getContainerList().add(new Container("Container"+i, dimensions));
        }
    }


    /**
     * Methode voor het zetten van de container lijst
     * 
     * @param containers
     */
    private void setContainerList(ArrayList<Container> containers)
    {
        this._containers = containers;
    }


    /**
     * Methode voor het ophalen van de container lijst
     * 
     * @return ArrayList<Container>
     */
    private ArrayList<Container> getContainerList()
    {
        return this._containers;
    }
}
