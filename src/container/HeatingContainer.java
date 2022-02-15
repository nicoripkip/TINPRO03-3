package container;


/**
 * 
 */
public class HeatingContainer extends BaseContainer implements SpecialContainerInterface
{
    private String[] _goods;
    private Boolean _connected;


    /**
     * Constructor
     * 
     * @param name
     * @param length
     * @param width
     * @param height
     */
    public HeatingContainer(String name, int length, int width, int height)
    {
        super(name, length, width, height);
        super.generateNewUUID();
    }


    /**
     * Methode voor het aankoppelen van de verwarmingselementen
     */
    public void connectElements() 
    {
        System.out.println("[info]\t\tDe verwarmingselementen zijn aangekoppeld!");
        this._connected = true;
    }


    /**
     * Methode voor het afkoppelen van de verwarmingselementen
     */
    public void disconnectElements() 
    {
        System.out.println("[info]\t\tDe verwarmingselementen zijn afgekoppeld!");
        this._connected = false;
    }


    /**
     * Methode voor het controleren van de status van de verwarmingselementen
     */
    public void getConnectionState() 
    {
        if (this._connected == true) {
            System.out.println("[info]\t\tDe verwarmingselementen zijn aangekoppeld op het moment!");
            return;
        }

        System.out.println("[info]\t\tDe verwarmingselementen zijn afgekoppeld op het moment!");
    }
}