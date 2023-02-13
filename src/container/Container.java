package container;


import main.*;
import static java.lang.System.out;


/**
 * @author Nico van Ommen - 1030808
 * @since 03/29/2022
 */
public class Container extends BaseContainer {
    private String[] goods;


    /**
     * Constructor
     * 
     * @param name
     * @param dimensions
     */
    public Container(String name, int[] dimensions)
    {
        super(name, dimensions);
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
        out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tContainer: " + Colors.TEXT_PURPLE + super.getUUID() + Colors.TEXT_RESET + " heeft geen verwarmings- of verkoelingselementen!");
    }


    /**
     * Methode die de elementen afkoppeld als een container wordt verplaatst
     * 
     * @return void
     */
    @Override
    public void disconnectElements() 
    {
        out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tContainer: " + Colors.TEXT_PURPLE + super.getUUID() + Colors.TEXT_RESET + " heeft geen verwarmings- of verkoelingselementen!");
    }
}
