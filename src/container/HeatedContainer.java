package container;


import main.Colors;
import static java.lang.System.out;


/**
 * @author Nico van Ommen - 1030808
 * @since 03/29/2022
 */
public class HeatedContainer extends BaseContainer
{
    private boolean _elements_connected;


    /**
     * Constructor
     * 
     * @param name
     * @param dimensions
     */
    public HeatedContainer(String name, int[] dimensions)
    {
        super(name, dimensions);
        super.generateNewUUID();
    }


    /**
     * Methode voor het aankoppelen van de verwarmingselementen
     * 
     * @return void
     */
    @Override
    public void connectElements()
    {
        if (this._elements_connected == true) {
            out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tVerwarmingselementen zijn al aangekoppeld!");
            return;
        }

        this._elements_connected = true;
        out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tVerwarmingselementen zijn aangekoppeld aan container: " + Colors.TEXT_PURPLE + super.getUUID() + Colors.TEXT_RESET + "!");
    }


    /**
     * Methode voor het afkoppelen van de verwarmingselementen
     * 
     * @return void
     */
    @Override
    public void disconnectElements()
    {
        if (this._elements_connected == false) {
            out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tVerwarmingselementen zijn al afgekoppeld!");
            return;
        }

        this._elements_connected = false;
        out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tVerwarmingselementen zijn afgekoppeld van container: " + Colors.TEXT_PURPLE + super.getUUID() +  Colors.TEXT_RESET + "!");
    }
}
