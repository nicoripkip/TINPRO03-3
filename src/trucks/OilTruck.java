package trucks;

import docks.Dock;

/**
 * @author Nico van Ommen - 1030808
 * @since 03/28/2020
 */
public class OilTruck extends BaseTruck {
    /**
     * Constructor
     * 
     * @param name
     * @param speed
     * @param type
     */
    OilTruck(String name, int speed, Dock dock)
    {
        super(name, speed, dock);
    }
}
