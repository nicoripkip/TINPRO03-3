package docks;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;

import container.Container;


/**
 * @author Nico van Ommen - 1030808
 * @since 04/03/2022
 */
public class Dock 
{
    private static final int MAX_CONTAINERS = 5;
    private static final int MAX_CRANE_PERMITS = 1;

    private ArrayBlockingQueue<Container> _containers;
    private Semaphore _permit;
    private boolean _ship_departed;
    
    
    /**
     * Constructor
     */
    public Dock()
    {
        this.setContainerStack(new ArrayBlockingQueue<Container>(MAX_CONTAINERS));
        this.setPermit(new Semaphore(MAX_CRANE_PERMITS));
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
     * @return Stack<Containers>
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
     * Methode voor het zetten van een nieuwe permit
     * 
     * @param permit
     */
    private void setPermit(Semaphore permit)
    {
        this._permit = permit;
    }


    /**
     * Methode voor het ophalen 
     * 
     * @return Semaphore
     */
    public Semaphore getPermit()
    {
        return this._permit;
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
