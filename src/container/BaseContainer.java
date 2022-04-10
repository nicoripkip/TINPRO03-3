package container;


import java.util.Collection;
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
    private ContainerTypes _type;
    

    /**
     * Constructor
     * 
     * @param name
     * @param dimensions
     * @param type
     */
    public BaseContainer(String name, int[] dimensions, ContainerTypes type)
    {
        this._name = name;
        this._dimensions = dimensions;
        this.setContainerType(type);
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


    /**
     * Methode voor het zetten van de container type
     * 
     * @param type
     */
    private void setContainerType(ContainerTypes type)
    {
        this._type = type;
    }


    /**
     * Methode voor het ophalen van de container type
     * 
     * @return String
     */
    public ContainerTypes getContainerType()
    {
        return this._type;
    }
}
