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
    private boolean _thread_run_flag = false;
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
     * Methode v
     */
    public void run()
    {
        this.setThreatRunFlag(true);

        while (this.getThreadRunFlag() == true) {
            // TODO
        }
    }


    /**
     * Methode om de thread te stoppen
     */
    public void kill()
    {
        this.setThreatRunFlag(false);
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


    /**
     * Methode voor het zetten van de run flag
     * 
     * @param flag
     */
    private void setThreatRunFlag(boolean flag)
    {
        this._thread_run_flag = flag;
    }


    /**
     * Methode voor het ophalen van de run flag
     * 
     * @return
     */
    private boolean getThreadRunFlag()
    {
        return this._thread_run_flag;
    }
}
