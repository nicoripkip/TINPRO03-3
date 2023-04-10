package ship;


/**
 * @author Nico van Ommen - 1030808
 * @since 04/09/2022
 */
public class TankerShip extends BaseShip
{
    private int _capacity;
    private boolean _departed;


    /**
     * Constructor
     * 
     * @param name
     */
    public TankerShip(String name)
    {
        super(name);
        this.setCapacity(2000);
        this.setDeparted(false);
    }


    /**
     * Methode voor het leeghalen van het schip
     * 
     * @param liters
     * @return int
     */
    public int depleate(int liters)
    {
        int t = this.getCapacity();
        this.setCapacity(t-=liters); 
        return this.getCapacity();
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


    /**
     * Methode om de capacity te zetten voor het tankerschip
     * 
     * @param liters
     */
    public void setCapacity(int liters)
    {
        this._capacity = liters;
    }


    /**
     * Methode voor het ophalen van de capacity van het schip
     * 
     * @return int
     */
    public int getCapacity()
    {
        return this._capacity;
    }


    /**
     * Methode voor het zetten dat het schip kan vertrekken
     * 
     * @param departed
     */
    public void setDeparted(boolean departed)
    {
        this._departed = departed;
    }


    /**
     * Methode om te kijken of het schip al vertrokken is
     * 
     * @return
     */
    public boolean getDeparted()
    {
        return this._departed;
    }
}
