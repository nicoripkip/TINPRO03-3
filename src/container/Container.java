package container;


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
<<<<<<< HEAD
        super(name, dimensions);
=======
        super(name, length, width, height);
        super.generateNewUUID();
    }


    /**
     * Methode om de inhoud van de container te printen
     */
    public void printGoods()
    {
        int i;

        if (goods.length <= 0) {
            System.out.println("[info]\t\tDe container is leeg!");
            return;
        } 

        for (i = 0; i < goods.length; i++) {
            System.out.println("[info]\t\tInhoud: " + goods[i].toString());
        }
>>>>>>> refs/remotes/origin/main
    }
}
