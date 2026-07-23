import Server.Controller.Controller;
import Server.Model.Magazzino;
import Server.Model.Menu;

import java.util.concurrent.LinkedBlockingDeque;

public class main {
    public static void main(String[] args) throws Exception {
        Magazzino magazzino = new Magazzino();
        Menu menu = new Menu();

        LinkedBlockingDeque<String> commandQueue = new LinkedBlockingDeque<>();
        InputReaderGT ir = new InputReaderGT(commandQueue);
        Controller controller = new Controller(magazzino, menu);
        CliGT cli = new CliGT(ir, controller, commandQueue);
        cli.run();
    }
}