import Server.Model.Ordine;

import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        System.out.println("Inserire oggetti ordine");
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();
        Ordine ordine = new Ordine(1, "1", "Fiamma");
        ordine.addToComanda(input1, Integer.parseInt(input2));
        System.out.println(ordine.toString());
    }
}