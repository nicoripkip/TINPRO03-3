package trucks;

import docks.Dock;
import equipment.Pump;
import main.Colors;
import static java.lang.System.out;

/**
 * @author Nico van Ommen - 1030808
 * @since 03/28/2020
 */
public class OilTruck extends BaseTruck {
    private final int MAX_LITERS = 100;

    private int _tank_body = 0;
    private Pump _pump;
    private int _previous_time;
    

    /**
     * Constructor
     * 
     * @param name
     * @param speed
     * @param type
     */
    public OilTruck(String name, int speed, Dock dock, Pump pump)
    {
        super(name, speed, dock);

        this.setPump(pump);
    }


    /**
     * Methode voor het draaien van de thread
     * 
     */
    @Override
    public void run()
    {
        while (!super._thread_finish)
        {
            try
            {
                this.consume();
            }
            catch (InterruptedException e)
            {
                out.println("["+Colors.TEXT_RED + "error" + Colors.TEXT_RESET + "]\t\tError: " + e);
            }
        }
    }


    public void consume() throws InterruptedException
    {
        synchronized (this.getPump())
        {
            while (this.getPump().isEmpty()) 
            {
                out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tVrachtwagen: " + Colors.TEXT_YELLOW + super.getTruckName() + Colors.TEXT_RESET + " is aan het wachten tot er weer olie beschikbaar is in de pomp!");
                this.getPump().wait();
            }

            if (this.getPump().getShip().getDeparted()) 
            {
                this._thread_finish = true;
            }

            int i;
            out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tVrachtwagen: " + Colors.TEXT_YELLOW + super.getTruckName() + Colors.TEXT_RESET + " gaat olie uit de pomp pompen!");
            
            // this._previous_time = this.getTiming();
            // Thread.sleep(this._previous_time);
            
            for (i = 0; i < MAX_LITERS; i++)
            {
                this.getPump().depleate(i);
                this.load(i);
            }
            out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "][" + Colors.TEXT_GREEN + this._previous_time + Colors.TEXT_RESET + "]\tVrachtwagen: " + Colors.TEXT_YELLOW + super.getTruckName() + Colors.TEXT_RESET + " heeft: " + Colors.TEXT_PURPLE + i + " liters" + Colors.TEXT_RESET + " uit de pomp gepompt!");

            this.getPump().notify();
            Thread.sleep(super.getTiming());
        }
    }


    /**
     * Methode voor het vullen van de tank
     * 
     * @param liters
     */
    public void load(int liters)
    {
        if (this._tank_body >= MAX_LITERS)
        {
            return;
        }

        this._tank_body += liters;
    }


    /**
     * Methode voor het legen van de tank
     * 
     * @param liters
     */
    public void unload(int liters)
    {
        if (this._tank_body <= 0)
        {
            return;
        }

        this._tank_body -= liters;
    }


    /**
     * Methode voor het zetten van de pomp
     * 
     * @param pump
     */
    public void setPump(Pump pump)
    {
        this._pump = pump;
    }


    /**
     * Methode voor het ophalen van de pomp
     * 
     * @return Pump
     */
    public Pump getPump()
    {
        return this._pump;
    }
}
