package crane;


/**
 * @author Nico van Ommen - 1030808
 * @since 04/03/2022
 */
abstract class BaseCrane extends Thread 
{
    private String _name;
    private int _speed;


    /**
     * Constructor
     * 
     * @param name
     * @param speed
     */
    public BaseCrane(String name, int speed)
    {
        this.setCraneName(name);
        this.setCraneSpeed(speed);
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
}
