package container;


import main.Colors;
import static java.lang.System.out;


/**
 * @author Nico van Ommen - 1030808
 * @since 03/29/2022
 */
public class CooledContainer extends BaseContainer
{
    private boolean _elements_connected;


    /**
     * Constructor
     * 
     * @param name
     * @param dimensions
     */
    public CooledContainer(String name, int[] dimensions, long id)
    {
        super(name, dimensions);
        this.generateNewUUID(id);
    }


    /**
     * Methode voor het aankoppelen van de verkoelingselementen
     * 
     * @return void
     */
    @Override
    public void connectElements()
    {
        if (this._elements_connected == true) {
            out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tVerkoelingselementen zijn al aangekoppeld!");
            return;
        }

        this._elements_connected = true;
        out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tVerkoelingselementen zijn aangekoppeld aan container: " + Colors.TEXT_PURPLE + super.getUUID() + Colors.TEXT_RESET + "!");
    }


    /**
     * Methode voor het afkoppelen van de verkoelingselementen
     * 
     * @return void
     */
    @Override
    public void disconnectElements()
    {
        if (this._elements_connected == false) {
            out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tVerkoelingselementen zijn al afgekoppeld!");
            return;
        }

        this._elements_connected = false;
        out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tVerkoelingselementen zijn afgekoppeld van container: " + Colors.TEXT_PURPLE + super.getUUID() +  Colors.TEXT_RESET + "!");
    }
}
