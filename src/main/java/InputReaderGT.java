import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class InputReaderGT implements Runnable {
    private final BlockingQueue<String> commandQueue;
    private volatile boolean acceptingInput = false;
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
                    while(input.equalsIgnoreCase("phase_changed") || input.equalsIgnoreCase("shipcheck") || input.equalsIgnoreCase("endgame")) {
                        System.out.println("you can't use this command");
                        valid = false;
                        if(scanner.hasNextLine()) {
                            input = scanner.nextLine();
                        } else {
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    if(valid) {
                        try {
                            commandQueue.put(input);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
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