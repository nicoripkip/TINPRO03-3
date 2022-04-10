package trucks;


import java.util.Random;

import javax.xml.stream.FactoryConfigurationError;

import docks.Dock;


/**
 * @author Nico van Ommen - 1030808
 * @since 03/28/2020
 */
abstract class BaseTruck extends Thread
{
    private String _name;
    private int _speed;
    private Dock _dock;
    protected boolean _thread_finish = false;
    private Random _random;


    /**
     * Constructor
     * 
     * @param name
     * @param speed
     * @param type
     */
    BaseTruck(String name, int speed, Dock dock)
    {
        this.setTruckName(name);
        this.setTruckSpeed(speed);
        this.setDock(dock);
        this._random = new Random();
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


    /**
     * Methode voor het genereren van een tijd met behulp van de normaal verdeleing
     * 
     * @return
     */
    protected int getTiming()
    {
        int t = (int)Math.round((double)this._random.nextGaussian()*2000+4000);

        if (t <= 1000) 
        {
            return 1000; 
        } 
        else if (t >= 6000)
        {
            return 6000;
        } 

        return t;
    }
}
