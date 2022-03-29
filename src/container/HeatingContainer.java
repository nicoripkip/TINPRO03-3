package container;

public class HeatingContainer extends BaseContainer implements SpecialContainerInterface
{
    private boolean _elements_connected;


    /**
     * Constructor
     * 
     * @param name
     * @param dimensions
     */
    HeatingContainer(String name, int[] dimensions)
    {
        super(name, dimensions);
        super.generateNewUUID();
    }


    /**
     * 
     */
    @Override
    public void connectElements() {
        if (_elements_connected == true) {
            System.out.println("[info]\t\tVerwarmings elementen zijn al aangekoppeld!");
            return;
        }

        this._elements_connected = true;
    }


    /**
     * 
     */
    @Override
    public void disconnectElements() {
        if (_elements_connected == false) {
            System.out.println("[info]\t\tVerwarmings elementen zijn al afgekoppeld!");
            return;
        }

        this._elements_connected = false;
    }


    /**
     * 
     */
    @Override
    public boolean getConnectionState() {
        return this._elements_connected;
    }    
}
