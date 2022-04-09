package trucks;


import docks.Dock;


/**
 * 
 */
enum ContainerTypes 
{
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
    private ContainerTypes _type;
    private Dock _dock;
    protected boolean _thread_finish = false;


    /**
     * Constructor
     * 
     * @param name
     * @param speed
     * @param type
     */
    BaseTruck(String name, int speed, String type, Dock dock)
    {
        this.setTruckName(name);
        this.setTruckSpeed(speed);
        this.setTruckType(type);
        this.setDock(dock);
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
        switch (type) 
        {
            case "normal" -> this._type = ContainerTypes.Normal;
            case "heating" -> this._type = ContainerTypes.Heating;
            case "cooling" -> this._type = ContainerTypes.Cooling;
        }
    }


    /**
     * Methode voor het ophalen van de truck type
     * 
     * @return
     */
    public ContainerTypes getTruckType()
    {
        return this._type;
    }


    /**
     * Methode voor het zetten van een nieuwe dock
     * 
     * @param dock
     */
    private void setDock(Dock dock)
    {
        this._dock = dock;
    }


    /**
     * Methode voor het ophalen van een dock
     * 
     * @return Dock
     */
    protected Dock getDock()
    {
        return this._dock;
    }
}
