package container;


/**
 * @author Nico van Ommen - 1030808
 * @since 04/03/2022
 */
public interface SpecialContainerInterface 
{
    /**
     * Methode voor het verbinden van de elementen
     */
    public void connectElements();


    /**
     * Methode voor het loskoppelen van de elementen
     */
    public void disconnectElements();


    /**
     * Methode voor het controleren van de elementen status
     */
    public boolean getConnectionState();
}
