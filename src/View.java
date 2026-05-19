import java.util.Scanner;

// VIEW: responsável por interação com o usuário (entrada/saída)
public class View {
    private final Scanner scanner = new Scanner(System.in);

    // Lê um inteiro, repetindo até o usuário fornecer um inteiro positivo
    public int readPositiveInt(String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value > 0) {
                    break;
                } else {
                    System.out.println("Por favor informe um valor inteiro maior que zero.");
                }
            } else {
                System.out.println("Entrada inválida. Informe um número inteiro.");
                scanner.next(); // descarta token inválido
            }
        }
        return value;
    }

    // Pergunta se o usuário deseja continuar
    public boolean askContinue() {
        System.out.print("Deseja fazer outro cálculo? (S/n): ");
        String resp = scanner.next();
        return resp.equalsIgnoreCase("s") || resp.equalsIgnoreCase("sim") || resp.isEmpty();
    }

    public void close() {
        scanner.close();
    }
}

