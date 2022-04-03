package trucks;


import java.util.ArrayList;
import java.util.List;
import container.Container;
import main.Colors;


/**
 * @author Nico van Ommen - 1030808
 * @since 03/28/2020
 */
public class ContainerTruck extends BaseTruck 
{
    private static final int MAX_CONTAINER = 1;
    private List<Container> load = new ArrayList<Container>();
   
   
    /**
     * Constructor
     * 
     * @param name
     * @param speed
     * @param type
     */
    public ContainerTruck(String name, int speed, String type)
    {
        super(name, speed, type);
    }
    
    
    /**
     * Methode voor het uitvoeren van de thread code
     */
    public void consume() throws InterruptedException
    {
        
    }


    /**
     * Methode voor het laden van een container
     * 
     * @param container
     */
    public void loadContainer(Container container)
    {
        if (this.load.size() > MAX_CONTAINER) {
            System.out.println(Colors.TEXT_BLUE + "[info]" + Colors.TEXT_RESET + "\t\tVrachtwagen is volgeladen!");
            return;
        }

        this.load.add(container);
    }
}
