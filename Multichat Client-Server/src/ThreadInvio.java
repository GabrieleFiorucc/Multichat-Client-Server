import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ThreadInvio implements Runnable {
    private Scanner sc;
    private PrintWriter out;

    public ThreadInvio(Socket socket) throws IOException {
        sc = new Scanner(System.in);
        out = new PrintWriter(socket.getOutputStream());
    }

    public void run() {
        String message;
        boolean primo = true;
        while (!Thread.currentThread().isInterrupted()) {
            if (primo) {
                System.out.println("Dammi il nome utente:");
            }
            message = sc.nextLine();
            System.out.println(message);
            System.out.flush();
            if (primo) {
                System.out.println("Utente acquisito, scrivi messaggio:");
                primo = false;
            }
        }
    }
}
