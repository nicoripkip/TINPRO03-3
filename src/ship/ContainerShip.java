package ship;

import java.util.ArrayList;

import container.Container;

/**
 * @author Nico van Ommen
 * @since 04/03/2022
 */
public class ContainerShip
{
    private final int MAX_CONTAINER_LIMIT = 100;
    private ArrayList<Container> _containers;
    private String _name;


    /**
     * Constructor
     */
    public ContainerShip(String name)
    {
        this.setContainerList(new ArrayList<Container>());
        this.generateShipPayload(MAX_CONTAINER_LIMIT);
        this.setName(name);
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
    public ArrayList<Container> getContainerList()
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
        return this.getContainerList().remove(this.getContainerCount()-1);
    }


    /**
     * Methode om de naam van het schip te zetten
     * 
     * @param name
     */
    private void setName(String name)
    {
        this._name = name;
    }


    /**
     * Methode om de naam van het schip op te halen
     * 
     * @return String
     */
    public String getName()
    {
        return this._name;
    }
}
