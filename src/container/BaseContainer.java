package container;


import java.util.concurrent.Semaphore;


/**
 * @author Nico van Ommen - 1030808
 * @since 03/29/2022
 */
public abstract class BaseContainer 
{
    private final int TOTAL_SEMAPHORE_PERMITS = 1;


    private long _uuid;
    private String _name;
    private int[] _dimensions;
    private Semaphore _semaphore; 


    /**
     * Constructor
     * 
     * @param name
     * @param dimensions
     * @param type
     */
    public BaseContainer(String name, int[] dimensions)
    {
        this.setName(name);
        this.setDimensions(dimensions);
        this.setSemaphore(new Semaphore(TOTAL_SEMAPHORE_PERMITS));
    }


    /**
     * Methode voor het laden van de container om ervoor te zorgen dat er maar 1 container per keer gepakt kan worden
     * 
     * @throws InterruptedException
     */
    public void load() throws InterruptedException
    {
        this.getSemaphore().acquire();
    }


    /**
     * Methode voor het ontkoppelen van een container om ervoor te zorgen dat maar 1 container losgekoppeld wordt
     * 
     * @throws InterruptedException
     */
    public void unload() throws InterruptedException
    {
        this.getSemaphore().release();
    }


    /**
     * Functie voor het genereren van een unieke sleutel
     */
    public void generateNewUUID(long id)
    {
        this._uuid = id;
    }


    /**
     * Methode voor het ophalen van de unieke sleutel
     * 
     * @return UUID 
     */
    public long getUUID()
    {
        return this._uuid;
    }


    /**
     * Methode voor het zetten van de naam van de container
     * 
     * @param name
     */
    public void setName(String name)
    {
        this._name = name;
    }


    /**
     * Methode voor het zetten van de dimensies van de container
     * 
     * @param dimensions
     */
    public void setDimensions(int[] dimensions)
    {
        this._dimensions = dimensions;
    }


    /**
     * Methode voor het zetten van een semaphore
     * 
     * @param semaphore
     */
    public void setSemaphore(Semaphore semaphore)
    {
        this._semaphore = semaphore;
    }


    public String getName()
    {
        return this._name;
    }


    public int[] getDimensions()
    {
        return this._dimensions;
    }


    /**
     * Methode voor het ophalen van een semaphore
     * 
     * @return Semaphore
     */
    public Semaphore getSemaphore()
    {
        return this._semaphore;
    }


    public abstract void connectElements();
    public abstract void disconnectElements();
}
