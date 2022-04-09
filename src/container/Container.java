package container;


import main.*;


/**
 * @author Nico van Ommen - 1030808
 * @since 03/29/2022
 */
public class Container extends BaseContainer implements SpecialContainerInterface {
    private String[] goods;
    private boolean _elements_connected;


    /**
     * Constructor
     * 
     * @param name
     * @param dimensions
     */
    public Container(String name, int[] dimensions, String type)
    {
        super(name, dimensions, type);
        super.generateNewUUID();
    }


    /**
     * Methode om de inhoud van de container te printen
     */
    public void printGoods()
    {
        int i;

        if (goods.length <= 0) 
        {
            System.out.println(Colors.TEXT_BLUE + "[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]" + Colors.TEXT_RESET + "\t\tDe container is leeg!");
            return;
        } 

        for (i = 0; i < goods.length; i++) 
        {  
            System.out.println(Colors.TEXT_BLUE + "[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]" + Colors.TEXT_RESET + "\t\tInhoud: " + goods[i].toString());
        }
    }


    /**
     * 
     */
    @Override
    public void connectCoolingElements() {
        if (_elements_connected == true) {
            System.out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tVerkoelings elementen zijn al aangekoppeld!");
            return;
        }

        this._elements_connected = true;
    }


    /**
     * 
     */
    @Override
    public void disconnectCoolingElements() {
        if (_elements_connected == false) {
            System.out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tVerkoelings elementen zijn al afgekoppeld!");
            return;
        }

        this._elements_connected = false;
    }


    /**
     * 
     */
    @Override
    public void connectHeatingElements() {
        if (_elements_connected == true) {
            System.out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tVerwarmings elementen zijn al aangekoppeld!");
            return;
        }

        this._elements_connected = true;
    }


    /**
     * 
     */
    @Override
    public void disconnectHeatingElements() {
        if (_elements_connected == false) {
            System.out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tVerwarmings elementen zijn al afgekoppeld!");
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
