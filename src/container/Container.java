package container;


import main.*;
import static java.lang.System.out;


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
    public Container(String name, int[] dimensions, ContainerTypes type)
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
            out.println(Colors.TEXT_BLUE + "[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]" + Colors.TEXT_RESET + "\t\tDe container is leeg!");
            return;
        } 

        for (i = 0; i < goods.length; i++) 
        {  
            out.println(Colors.TEXT_BLUE + "[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]" + Colors.TEXT_RESET + "\t\tInhoud: " + goods[i].toString());
        }
    }


    /**
     * Methode die de elementen aankoppeld als een container is verplaatst
     * 
     * @return void
     */
    @Override
    public void connectElements() 
    {
        if (super.getContainerType() == ContainerTypes.Cooling && this._elements_connected == true) 
        {
            out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tVerkoelings elementen zijn al aangekoppeld!");
            return;
        }
        else if (super.getContainerType() == ContainerTypes.Heating && _elements_connected == true) 
        {
            out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tVerwarmings elementen zijn al aangekoppeld!");
            return;
        }

        out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tElementen zijn aangekoppeld aan container: " + Colors.TEXT_PURPLE + super.getUUID() + " van type: " + super.getContainerType() + Colors.TEXT_RESET + "!");
        this._elements_connected = true;
    }


    /**
     * Methode die de elementen afkoppeld als een container wordt verplaatst
     * 
     * @return void
     */
    @Override
    public void disconnectElements() 
    {
        if (super.getContainerType() == ContainerTypes.Cooling && this._elements_connected == false) 
        {
            out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tVerkoelings elementen zijn al afgekoppeld!");
            return;
        }
        else if (super.getContainerType() == ContainerTypes.Heating && this._elements_connected == false) 
        {
            out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tVerwarmings elementen zijn al afgekoppeld!");
            return;
        }

        out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tElementen zijn afgekoppeld van container: " + Colors.TEXT_PURPLE + super.getUUID() + " van type: " + super.getContainerType() + Colors.TEXT_RESET + "!");
        this._elements_connected = false;
    }


    /**
     * Methode die de connectie status teruggeeft
     * 
     * @return boolean
     */
    @Override
    public boolean getConnectionState() 
    {
        return this._elements_connected;
    }
}
