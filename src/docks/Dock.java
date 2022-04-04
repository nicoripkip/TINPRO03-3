package docks;


import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import container.Container;

/**
 * @author Nico van Ommen - 1030808
 * @since 04/03/2022
 */
public class Dock {
    private Stack<Container> _containers;
    
    
    /**
     * Constructor
     */
    public Dock()
    {
        this.setContainerStack(new Stack<Container>());
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
    private void setContainerStack(Stack<Container> containers)
    {
        this._containers = containers;
    }


    /**
     * Methode voor het ophalen van de container stack
     * 
     * @return Stack<Containers>
     */
    private Stack<Container> getContainers()
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
        return this.getContainers().remove(this.getContainerLength()-1);
    }
}
