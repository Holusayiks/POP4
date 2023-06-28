import java.util.concurrent.Semaphore;

public class Fork
{
    int id;
    private Semaphore sem;
    public Fork(int id)
    {
        this.id = id;
        sem = new Semaphore(1);
    }
    public Semaphore GetSem(){
        return sem;
    }
}