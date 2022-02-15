package container;


import java.util.UUID;


/**
 * 
 */
abstract class BaseContainer 
{
    private UUID _uuid;
    private String _name;
    private int _length;
    private int _width;
    private int _height;
    private String _holder;
    

    /**
     * Constructor
     */
    public BaseContainer(String name, int length, int width, int height)
    {
        this._name = name;
        this._length = length;
        this._width = width;
        this._height = height;
    }


    /**
     * Functie voor het genereren van een unieke sleutel
     */
    public void generateNewUUID()
    {
        this._uuid = UUID.randomUUID();
    }


    /**
     * Methode voor het ophalen van de unieke sleutel
     * 
     * @return UUID 
     */
    public UUID getUUID()
    {
        return this._uuid;
    }
}
