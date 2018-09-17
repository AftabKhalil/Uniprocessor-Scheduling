package mk2;

/**
 * @author aftab
 */
public class MK2 {

    public static MK2 mk2;
    public static Processor processor;
    public static Frame f;
    public ProcessCounter pc;
    public InputTaker it;

    public MK2() throws InterruptedException {
        processor = new Processor();
        pc = new ProcessCounter();
        it = new InputTaker();
        it.setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException {
        mk2 = new MK2();
        f = new Frame();
    }
}
