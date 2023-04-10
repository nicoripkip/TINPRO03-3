package container;


import main.*;
import static java.lang.System.out;


/**
 * @author Nico van Ommen - 1030808
 * @since 03/29/2022
 */
public class Container extends BaseContainer {
    /**
     * Constructor
     * 
     * @param name
     * @param dimensions
     */
    public Container(String name, int[] dimensions, long id)
    {
        super(name, dimensions);
        this.generateNewUUID(id);
    }


    /**
     * Methode die de elementen aankoppeld als een container is verplaatst
     * 
     * @return void
     */
    @Override
    public void connectElements() 
    {
        out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tContainer: " + Colors.TEXT_PURPLE + this.getUUID() + Colors.TEXT_RESET + " heeft geen verwarmings- of verkoelingselementen!");
    }


    /**
     * Methode die de elementen afkoppeld als een container wordt verplaatst
     * 
     * @return void
     */
    @Override
    public void disconnectElements() 
    {
        out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tContainer: " + Colors.TEXT_PURPLE + this.getUUID() + Colors.TEXT_RESET + " heeft geen verwarmings- of verkoelingselementen!");
    }
}
