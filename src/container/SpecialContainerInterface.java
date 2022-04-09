package container;


/**
 * @author Nico van Ommen - 1030808
 * @since 04/03/2022
 */
public interface SpecialContainerInterface {
    /**
     * 
     */
    public void connectCoolingElements();


    /**
     * 
     */
    public void disconnectCoolingElements();


    /**
     * 
     */
    public void connectHeatingElements();


    /**
     * 
     */
    public void disconnectHeatingElements();


    /**
     * 
     */
    public boolean getConnectionState();
}
