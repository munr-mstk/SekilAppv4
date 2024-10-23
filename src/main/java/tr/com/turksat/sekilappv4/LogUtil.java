package tr.com.turksat.sekilappv4;

public class LogUtil {
    /**
     * Konsola mesaj bas.
     * @param message Basalacak mesaj
     */
    public static void log(String message) {
        System.out.println(message);
    }

    /**
     * Konsola sembol ve mesaj basar.
     * @param symbol Sembol
     * @param message Basılacak mesaj
     */
    public static void log(char symbol, String message) {
        System.out.println(symbol + " " + message);
    }
}
