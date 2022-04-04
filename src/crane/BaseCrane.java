package crane;

import docks.Dock;

/**
 * @author Nico van Ommen - 1030808
 * @since 04/03/2022
 */
abstract class BaseCrane implements Runnable
{
    private String _name;
    private int _speed;
    private Dock _dock;


    /**
     * Constructor
     * 
     * @param name
     * @param speed
     */
    public BaseCrane(String name, int speed, Dock dock)
    {
        this.setCraneName(name);
        this.setCraneSpeed(speed);
        this.setDock(dock);
    }


    /**
     * Methode om de naam van de kraan te zetten
     * 
     * @param name
     */
    public void setCraneName(String name)
    {
        this._name = name;
    }


    /**
     * Methode voor het ophalen van de kraan naam
     * 
     * @return String
     */
    public String getCraneName()
    {
        return this._name;
    }


    /**
     * Methode voor het zetten van de kraan snelheid
     * 
     * @param speed
     */
    public void setCraneSpeed(int speed)
    {
        this._speed = speed;
    }


    /**
     * Methode voor het ophalen van de kraansnelheid
     * 
     * @return int
     */
    public int getCraneSpeed()
    {
        return this._speed;
    }


    /**
     * Methode om de dock te zetten
     * 
     * @param dock
     */
    public void setDock(Dock dock)
    {
        this._dock = dock;
    }


    /**
     * Methode om de dock op te halen
     * 
     * @return
     */
    public Dock getDock()
    {
        return this._dock;
    }
}
