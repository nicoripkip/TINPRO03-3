package ship;


/**
 * @author Nico van Ommen - 1030808
 * @since 04/10/2022
 */
abstract class BaseShip 
{
    private String _name;

    /**
     * Constructor
     * 
     * @param name
     */
    public BaseShip(String name)
    {
        this.setShipName(name);
    }


    /**
     * Methode voor het zetten van de naam van het schip
     * 
     * @param name
     */
    public void setShipName(String name)
    {
        this._name = name;
    }
    

    /**
     * Methode voor het ophalen van de naam van het schip
     * 
     * @return String
     */
    public String getShipName()
    {
        return this._name;
    }
}
