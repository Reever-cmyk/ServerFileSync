package userinput;

import java.util.Scanner;

public class Userinput {

    /**
     * erzeugt eine input abfrage. prueft ob input in form eines Strings vorliegt.
     * laeuft solange bis ein string vorliegt speichert ihn in kleinbuchstaben.
     * @return String
     */
    public String readInputString() {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        if (isInputString(inputString)) {
            return inputString.toLowerCase();
        } else {
            return readInputString();
        }
    }

    /**
     * erzeugt eine input abfrage. prueft ob eingabe in form einer int vorliegt.
     * laeuft solange bis eine int eingegeben wurde.
     *
     * @return Integer
     */
    public  int readInputInt() {
        Scanner scanner = new Scanner(System.in);
        if (isInputInt(scanner)) {
            return scanner.nextInt();
        } else {
            System.out.println("fehler");
            return readInputInt();
        }
    }

    /**
     * prueft ob input ein String ist.
     * @param s zu pruefende eingabe
     * @return boolean
     */
    private  boolean isInputString(String s) {

        if (s == null || s.equals("")) {
            System.out.println("Fehler bei eingabe.");
            return false;
        }
        try {
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Fehler isInteger -> NumberFormatException");
        }
        return false;
    }

    /**
     * prueft ob input ein int ist.
     * @param scanner prüft ob scanner.hasNextInt()
     * @return boolean
     */
    private  boolean isInputInt(Scanner scanner) {
        return scanner.hasNextInt();

    }
}
