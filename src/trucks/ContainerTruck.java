package trucks;


/**
 * @author Nico van Ommen - 1030808
 * @since 03/28/2020
 */
public class ContainerTruck extends BaseTruck 
{
    private boolean _thread_run_flag = false;
   
   
    /**
     * Constructor
     * 
     * @param name
     * @param speed
     * @param type
     */
    ContainerTruck(String name, int speed, String type)
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
