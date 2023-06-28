import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        Fork[] forks = new Fork[5];
        Philosopher[] philosophers = new Philosopher[5];
        Semaphore waiter = new Semaphore(4);
        for (int i = 0; i < 5; i++)
            forks[i] = new Fork(i + 1);

        for (int i = 0; i < 5; i++) {
            philosophers[i] = new Philosopher(i + 1, forks[i], forks[(i + 1) % forks.length], waiter);
            philosophers[i].start();
        }
    }
}
