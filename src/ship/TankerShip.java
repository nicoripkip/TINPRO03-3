package ship;


/**
 * @author Nico van Ommen - 1030808
 * @since 04/09/2022
 */
public class TankerShip extends BaseShip
{
    private int _capacity;


    /**
     * Constructor
     * 
     * @param name
     */
    public TankerShip(String name)
    {
        super(name);
        this._capacity = 10000;
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
