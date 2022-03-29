package container;

public class CoolingContainer extends BaseContainer implements SpecialContainerInterface
{
    private boolean _elements_connected;


    /**
     * Constructor
     * 
     * @param name
     * @param dimensions
     */
    CoolingContainer(String name, int[] dimensions)
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
            System.out.println("[info]\t\tVerkoelings elementen zijn al aangekoppeld!");
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
            System.out.println("[info]\t\tVerkoelings elementen zijn al afgekoppeld!");
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
