import java.util.concurrent.Semaphore;

public class Philosopher extends Thread{
    int id;
    Fork leftFork;
    Fork rightFork;
    Semaphore waiter;

    public Philosopher(int id,Fork leftFork, Fork rightFork,Semaphore waiter)
    {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.waiter = waiter;
    }

    @Override
    public void run()
    {
        for(int i = 0; i < 3; i++) {
            try {
                waiter.acquire();
                System.out.println("Philosopher: " + id + " Thinking  ");
                leftFork.GetSem().acquire();
                System.out.println("Philosopher: " + id + " Took left fork ");
                rightFork.GetSem().acquire();
                System.out.println("Philosopher: " + id + " Took right fork ");
                System.out.println("Philosopher: " + id + " Eating ");
                rightFork.GetSem().release();
                System.out.println("Philosopher: " + id + " Put right fork ");
                leftFork.GetSem().release();
                System.out.println("Philosopher: " + id + " Put left fork ");
                waiter.release();
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}