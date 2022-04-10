package equipment;

import docks.Dock;
import java.util.Random;

/**
 * @author Nico van Ommen - 1030808
 * @since 04/03/2022
 */
abstract class BaseCrane extends Thread
{
    private String _name;
    private int _speed;
    private Dock _dock;
    private Random _random;


    /**
     * Constructor
     * 
     * @param name
     * @param speed
     * @param dock
     */
    public BaseCrane(String name, int speed, Dock dock)
    {
        this.setCraneName(name);
        this.setCraneSpeed(speed);
        this.setDock(dock);
        this._random = new Random();
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


    /**
     * Methode voor het genereren van een tijd met behulp van de normaal verdeleing
     * 
     * @return
     */
    protected int getTiming()
    {
        int t = (int)Math.round((double)this._random.nextGaussian()*1700+3000);

        if (t <= 1000) 
        {
            return 1000;
        } 
        else if (t >= 6000)
        {
            return 6000;
        } 
        else
        {
            return t;
        }
    }
}
