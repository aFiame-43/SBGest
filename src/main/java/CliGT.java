import Server.Controller.Controller;
import Server.Model.Dipartimento;
import Server.Model.Ingrediente;
import Server.Model.OrderItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingDeque;


public class CliGT{
    private String command;
    private InputReaderGT inputReader;
    private String[] tokens;
    private Controller controller; //sarà da rimuovere assolutamente
    private LinkedBlockingDeque<String> commandQueue;

    public CliGT(InputReaderGT inputReader, Controller controller, LinkedBlockingDeque<String> commandQueue) {
        this.inputReader = inputReader;
        this.controller = controller;
        this.commandQueue = commandQueue;
        Thread inputThread = new Thread(inputReader);
        inputThread.start();
    }

    public void run() throws Exception {
        System.out.println("CLI running, please insert a command or digit help for command list");

        commandQueue.put("arrivoinmagazzino birramoretti 100");
        commandQueue.put("addmenu birra 5 spillatrice birramoretti 1");
        commandQueue.put("neworder 7 fiamma amministratore 0 birra 2");


        while (true) {
            System.out.println(">");
            inputReader.requestInput();
            command = commandQueue.take();
            tokens = command.trim().split("\\s+");
            if(true) {
                switch (tokens[0].toLowerCase()) {
                    case "neworder":
                        nuovoOrdine(tokens);
                        break;
                    case "seeorders":
                        vediOrdini();
                        break;
                    case "addmenu":
                        addToMenu(tokens);
                        break;
                    case "arrivoinmagazzino":
                        arrivoInMagazzino(tokens);
                        break;

                    default:
                        System.out.println("Unknown command: " + command);
                        System.out.println("Digit help for command list");
                        break;
                }
            } else {
                System.out.println("This is an invalid command or you can't use this command now");
                System.out.println("Digit commands for commands list");
                System.out.println("Digit help for active commands list");
            }
        }
    }

    public void nuovoOrdine(String[] tokens){ // neworder numtavolo nomepersona cassiere sconto prodotto1 quantita1 prodotto2 quantita2
        if(tokens.length%2 != 0) {
            ArrayList<OrderItem> tempList = new ArrayList<>();
            for(int i=5; i <= tokens.length-2; i=i+2){
                tempList.add(new OrderItem(tokens[i], Integer.parseInt(tokens[i + 1])));
            }
            controller.nuovoOrdine(tempList, tokens[1], tokens[2], tokens[3], BigDecimal.valueOf(Integer.parseInt(tokens[4])));
        } else System.out.println("Invalid command tokens");
    }

    public void vediOrdini(){
        System.out.println(controller.vediOrdini());
    }

    public void addToMenu(String[] tokens){ // addmenu nome prezzo dipartimento ingrediente1 quantita1 ingrediente2 quantita2
        if(tokens.length%2==0){
            ArrayList<Ingrediente> tempIng = new ArrayList<>();
            for(int i=4; i <= tokens.length-2; i = i+2){
                tempIng.add(new Ingrediente(tokens[i], Integer.parseInt(tokens[i+1])));
            }
            controller.nuovoMenuItem(tokens[1], BigDecimal.valueOf(Integer.parseInt(tokens[2])), new Dipartimento(tokens[3]), tempIng);
            System.out.println("Item added");
        } else System.out.println("undefined error");
    }

    public void arrivoInMagazzino(String[] tokens){ //arrivoinmagazzino ingrediente quantita
        if(tokens.length%2!=0){
            controller.arrivoInMagazzino(new Ingrediente(tokens[1], Integer.parseInt(tokens[2])));
            System.out.println("Prodotto arrivato");
        } else System.out.println("undefined error");
    }
}