package trucks;


/**
 * 
 */
enum ContainerTypes {
    Normal,
    Heating,
    Cooling,
}


/**
 * @author Nico van Ommen - 1030808
 * @since 03/28/2020
 */
abstract class BaseTruck extends Thread
{
    private String _name;
    private int _speed;
    private String _type;


    /**
     * Constructor
     * 
     * @param name
     * @param speed
     * @param type
     */
    BaseTruck(String name, int speed, String type)
    {
        this.setTruckName(name);
        this.setTruckSpeed(speed);
        this.setTruckType(type);
    }


    /**
     * Methode voor het zetten van de naam van de truck
     * 
     * @param name
     */
    protected void setTruckName(String name)
    {
        this._name = name;
    }


    /**
     * Methode voor het ophalen van de naam van de truck
     * 
     * @return String
     */
    public String getTruckName()
    {
        return this._name;
    }


    /**
     * Methode voor het zetten van de snelheid van de truck
     * 
     * @param speed
     */
    protected void setTruckSpeed(int speed)
    {
        this._speed = speed;
    }


    /**
     * Methode voor het ophalen van de truck snelheid
     * 
     * @return int
     */
    public int getTruckSpeed()
    {
        return this._speed;
    }


    /**
     * Methode voor het zetten van de truck type
     * 
     * @param type
     */
    protected void setTruckType(String type)
    {
        this._type = type;
    }


    /**
     * Methode voor het ophalen van de truck type
     * 
     * @return
     */
    public String getTruckType()
    {
        return this._type;
    }
}
