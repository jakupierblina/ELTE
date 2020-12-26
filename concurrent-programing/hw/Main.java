
//HIGO5T
import java.io.*;
import java.util.ArrayDeque;
import java.lang.Boolean;
import java.util.concurrent.TimeUnit;
import java.lang.Runnable;
import java.lang.Thread;
import java.lang.Exception;
import java.util.ArrayList;
import java.lang.Integer;


////CAR
class Car
{
    static private int currentId=1;
    private int identifier;
    public Car()
    {
        this.identifier = currentId;
        ++currentId;
    }
    public int getId()
    {
        return this.identifier;
    }
	
    @Override
    public String toString()
    {
        return "Car " + identifier;
    }
}

/////QUEUE OF CARS
class CarQueue implements Runnable
{
    private ArrayDeque<Car> waitingCar;
    private ArrayDeque<Car> passedCar;
    private String direction;
    private Passage p;
    public CarQueue(String newDirection)
    {
        direction = newDirection;
        waitingCar = new ArrayDeque<Car>();
        passedCar = new ArrayDeque<Car>();
    }
    public CarQueue(String newDirection, Passage p)
    {
        this(newDirection);
        connectPassage(p);
    }
    public void connectPassage(Passage p)
    {
        this.p = p;
    }
    public Boolean add(Car newCar)
    {
        if(!waitingCar.contains(newCar))
        {
            waitingCar.offerLast(newCar);
            System.out.println(waitingCar.peekLast() + " has entered the " + direction + " Tunnel Queue.\n");
            return true;
        }
        return false;
    }
    public Boolean isEmpty()
    {
        return waitingCar.isEmpty();
    }
    public String transit()
    {
        synchronized(p)
        {
            while(waitingCar.peekFirst()!=null)
            {
                System.out.println(waitingCar.peekFirst() + " is now entering the Tunnel from the " + direction + ".\n");
                passedCar.offerLast(p.transit(waitingCar.pollFirst()));
                System.out.println(passedCar.peekLast() + " has exited the Tunnel.\n");
            }
        }
        return direction + " transit finished.\n";
    }
    public void run()
    {
        while(true)
        {
            if(!isEmpty())
            {
                transit();
            }
        }
    }
}

class Passage extends Thread
{
    private int passageTime;
    public Passage()
    {
        this(0);
    }
    public Passage(int time)
    {
        passageTime = time;
        setDaemon(true);
    }
    public Car transit(Car movingCar)
    {
        try
        {
            TimeUnit.SECONDS.sleep(passageTime);   
        } 
        catch (Exception e)
        {
            //TODO: handle exception
        }
        return movingCar;
    }
    public void run()
    {
        while(true)
        {
            //tunnel exists. tunnel does nothing.
        }
    }
}

class Start
{
    private ArrayList<String> directionList;
    public Start()
    {
        this(0);
    }
    public Start(int setting)
    {
        this(setting,2);
    }
    public Start(int setting, int directions)
    {
        this(setting,directions,50);
    }
    public Start(int setting, int directions, int numCars)
    {
        this(setting,directions,numCars,0);
    }
    public Start(int setting, int directions, int numCars, int transitTime)
    {
        Passage ourTunnel = new Passage(transitTime);
        directionList = new ArrayList<>();
        ArrayList<CarQueue> queues = new ArrayList<>();
        ArrayList<Thread> threadList = new ArrayList<>();
        directionList.add("East");
        directionList.add("West");
        directionList.add("North");
        directionList.add("South");
        //directions = directions % 4;
        ourTunnel.start();

        for(int i=0; i<directions; ++i)
        {
            queues.add(new CarQueue(directionList.get(i),ourTunnel));
            threadList.add(new Thread(queues.get(i)));
        }
        switch (setting)
        {
            case 0:
                for(CarQueue currentQueue : queues)
                {
                    for(int i=0; i<numCars; ++i)
                    {
                        currentQueue.add(new Car());
                    }
                }
                for(Thread currentThread : threadList)
                {
                    currentThread.start();
                }
                break;
            case 1:
                for(Thread currentThread : threadList)
                {
                    currentThread.start();
                }
                for(CarQueue currentQueue : queues)
                {
                    for(int i=0; i<numCars; ++i)
                    {
                        currentQueue.add(new Car());
                    }
                }
                break;
            case 2:
                for(Thread currentThread : threadList)
                {
                    currentThread.start();
                }
                for(int i=0; i<numCars; ++i)
                {
                    for(CarQueue currentQueue : queues)
                    {
                        currentQueue.add(new Car());
                    }
                }
                break;
            default:
                break;
        }
        System.out.println("All Done!\n");
    }
}

public class Main
{
    public static void main(String[] args)
    {
        switch (args.length)
        {
            case 0:
                new Start();
                break;
            case 1:
                new Start(Integer.parseInt(args[0]));
                break;
            case 2:
                new Start(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
                break;
            case 3:
                new Start(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]));
                break;
            case 4:
                new Start(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]),Integer.parseInt(args[3]));
                break;                
            default:
                new Start(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]),Integer.parseInt(args[3]));
                break;
        }
    }
}