package equipment;


import main.Colors;
import ship.TankerShip;
import static java.lang.System.out;


/**
 * @author Nico van Ommen - 1030808
 * @since 04/10/2022
 */
public class Pump extends BaseCrane
{
    private final static int MAX_CAPACITY = 300;

    private TankerShip _ship;
    private int _pump_buffer;
    private boolean _thread_finished;
    private int _previous_time = 0;


    /**
     * Constructor
     * 
     * @param name
     * @param dock
     */
    public Pump(String name, TankerShip ship)
    {   
        super(name, 0, null);

        this.setShip(ship);
        this._pump_buffer = 0;
        this._thread_finished = false;
    }


    @Override
    public void run()
    {
        while (!this._thread_finished)
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


    /**
     * Methode voor het leeglopen van het schip
     * 
     * @throws InterruptedException
     */
    public void consume() throws InterruptedException
    {
        synchronized (this)
        {
            if (this._pump_buffer >= MAX_CAPACITY)
            {
                out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tPomp: " + Colors.TEXT_CYAN + this.getCraneName() + Colors.TEXT_RESET + " is aan het wachten tot er weer ruimte is in de buffer!");
                this.wait();
            }

            if (this.getShip().isEmpty())
            {
                out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tPomp: " + Colors.TEXT_CYAN + this.getCraneName() + Colors.TEXT_RESET + " stopt met werken aangezien het ship leeg is!");
                this.getShip().setDeparted(true);
                this._thread_finished = true;
            }

            int i;
            out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "]\t\tPomp: " + Colors.TEXT_CYAN + this.getCraneName() + Colors.TEXT_RESET + " gaat olie uit het schip pompen!");
            
            this._previous_time = this.getTiming();
            Thread.sleep(this._previous_time);
            
            for (i = 0; i < MAX_CAPACITY; i++) 
            {
                this.getShip().depleate(i);
                this.fill(i);
            }
            out.println("[" + Colors.TEXT_BLUE + "info" + Colors.TEXT_RESET + "][" + Colors.TEXT_GREEN + this._previous_time + Colors.TEXT_RESET + "]\tPomp: " + Colors.TEXT_CYAN + this.getCraneName() + Colors.TEXT_RESET + " Heeft: " + Colors.TEXT_PURPLE + i +  Colors.TEXT_RESET + "uit het schip gepompt!");

            this.notify();
        }
    }


    /**
     * Methode voor het zetten van het schip
     * 
     * @param dock
     */
    public void setShip(TankerShip ship)
    {
        this._ship = ship;
    }


    /**
     * Methode voor het ophalen van het schip
     * 
     * @return
     */
    public TankerShip getShip()
    {
        return this._ship;
    }


    /**
     * Methode om te vullen
     * 
     * @param liters
     */
    public void fill(int liters)
    {
        this._pump_buffer += liters;
    }


    /**
     * Methode voor het uitputten
     * 
     * @param liters
     */
    public void depleate(int liters)
    {
        this._pump_buffer -= liters;
    }


    /**
     * Methode voor het controleren van de grote van de buffer
     * 
     * @return boolean
     */
    public boolean isEmpty()
    {
        if (this._pump_buffer == 0)
        {
            return true;
        }

        return false;
    }
}
