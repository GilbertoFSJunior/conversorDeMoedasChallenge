package conversor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        Scanner scanner = new Scanner(System.in);

        String[][] options = {
                {"USD", "BRL"},
                {"BRL", "USD"},
                {"USD", "EUR"},
                {"EUR", "USD"},
                {"BRL", "EUR"},
                {"EUR", "BRL"},
                {"BRL", "ARS"},
                {"ARS", "BRL"},
                {"BRL", "BOB"},
                {"BOB", "BRL"},
                {"BRL", "CLP"},
                {"CLP", "BRL"},
                {"BRL", "COP"},
                {"COP", "BRL"}
        };

        while (true) {
            System.out.println("\n+$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            System.out.println("\n__________________Conversor de Moedas_______________________");
            System.out.println("\n+$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            for (int i = 0; i < options.length; i++) {
                System.out.printf("%d - %s para %s%n", (i + 1), options[i][0], options[i][1]);
            }
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int op = -1;
            try {
                op = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.next();
                continue;
            }

            if (op == 0) {
                System.out.println("+------------------------------------------+");
                System.out.println("|          Saindo do Conversor           |");
                System.out.println("+------------------------------------------+");
                break;
            }

            if (op < 1 || op > options.length) {
                System.out.println("Opção inválida.");
                continue;
            }

            System.out.print("Digite o valor a ser convertido: ");
            double valor = 0;
            try {
                valor = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.next();
                continue;
            }

            String from = options[op - 1][0];
            String to = options[op - 1][1];
            double resultado = converter.convert(from, to, valor);

            if (resultado > 0) {
                System.out.printf("+------------------------------------------+\n");
                System.out.printf("| %.2f %s = %.2f %s %" + (20 - String.format("%.2f", resultado).length() - from.length() - to.length()) + "s|\n", valor, from, resultado, to, "");
                System.out.println("+------------------------------------------+");
            } else if (valor > 0) {
                System.out.println("Conversão falhou.");
            }
        }

        scanner.close();
    }
}

