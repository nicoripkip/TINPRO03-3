package container;


import main.*;


/**
 * 
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

        if (goods.length <= 0) {
            System.out.println(Colors.TEXT_BLUE + "[info]" + Colors.TEXT_RESET + "\t\tDe container is leeg!");
            return;
        } 

        for (i = 0; i < goods.length; i++) {
            System.out.println(Colors.TEXT_BLUE + "[info]" + Colors.TEXT_RESET + "\t\tInhoud: " + goods[i].toString());
        }
    }
}
