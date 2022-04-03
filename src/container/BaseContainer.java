package container;


import java.util.UUID;


/**
 * @author Nico van Ommen - 1030808
 * @since 03/29/2022
 */
abstract class BaseContainer 
{
    private UUID _uuid;
    private String _name;
    private int[] _dimensions;
    private String _holder;
    

    /**
     * Constructor
     */
    public BaseContainer(String name, int[] dimensions)
    {
        this._name = name;
        this._dimensions = dimensions;
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
