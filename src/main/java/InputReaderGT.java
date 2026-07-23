import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class InputReaderGT implements Runnable {
    private final BlockingQueue<String> commandQueue;
    private volatile boolean acceptingInput = true;
    private final Scanner scanner = new Scanner(System.in);
    private volatile boolean running = true;
    private boolean valid = true;

    public InputReaderGT(BlockingQueue<String> commandQueue) {
        this.commandQueue = commandQueue;
    }

    @Override
    public void run() {
        while (running) {
            if (acceptingInput) {
                if (scanner.hasNextLine()) {
                    String input = scanner.nextLine();
                    try {
                        commandQueue.put(input);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            } else {
                try {
                    Thread.sleep(100);  // piccolo delay per non consumare CPU
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void requestInput() {
        acceptingInput = true;
    }

    public void pauseInput() {
        acceptingInput = false;
    }

    public void stop() {
        running = false;
    }
}