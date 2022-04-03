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
}
