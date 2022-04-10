package ship;


/**
 * @author Nico van Ommen - 1030808
 * @since 04/09/2022
 */
public class TankerShip 
{
    private String _name;
    private int _capacity;


    /**
     * Constructor
     * 
     * @param name
     */
    public TankerShip(String name)
    {
        this.setShipName(name);
        this._capacity = 10000;
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


    /**
     * Methode voor het leeghalen van het schip
     * 
     * @param liters
     * @return
     */
    public void depleate(int liters)
    {
        this._capacity -= liters;
    }


    /**
     * Methode om de checken of het schip leeg is
     * 
     * @return boolean
     */
    public boolean isEmpty()
    {
        if (this._capacity == 0)
        {
            return true;
        }

        return false;
    }
}
