package container;


/**
 * 
 */
public class CoolingContainer extends BaseContainer implements SpecialContainerInterface
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
    public CoolingContainer(String name, int length, int width, int height)
    {
        super(name, length, width, height);
        super.generateNewUUID();
    }


    /**
     * Methode voor het aankoppelen van de verkoelingselementen
     */
    public void connectElements()
    {
        System.out.println("[info]\t\tDe verkoelingselementen zijn aangekoppeld!");
        this._connected = true;
    }


    /**
     * Methode voor het afkoppelen van de verkoelingselementen
     */
    public void disconnectElements()
    {
        System.out.println("[info]\t\tDe verkoelingselementen zijn afgekoppeld!");
        this._connected = false;
    }


    /**
     * Methode voor het checken van de status van de verkoelingselementen
     */
    public void getConnectionState()
    {
        if (this._connected == true) {
            System.out.println("[info]\t\tDe verkoelingselementen zijn aangekoppeld op het moment!");
            return;
        }

        System.out.println("[info]\t\tDe verkoelingselementen zijn afgekoppeld op het moment!");
    }
}