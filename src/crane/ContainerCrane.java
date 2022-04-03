package crane;


/**
 * @author Nico van Ommen - 1030808
 * @since 04/03/2022
 */
public class ContainerCrane extends BaseCrane
{
    public ContainerCrane(String name, int speed)
    {
        super(name, speed);
    }


    /**
     * Functie die de threat laat starten
     */
    public void produce() throws InterruptedException
    {
        while (true) 
        {
            synchronized (this) 
            {

            }
        }
    }
}
