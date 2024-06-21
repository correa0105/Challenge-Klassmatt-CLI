import java.util.InputMismatchException;
import java.util.Scanner;

public class Jogador {
    private String simbolo;
    private Scanner scanner;

    public Jogador(String simbolo, Scanner scanner) {
        this.simbolo = simbolo;
        this.scanner = scanner;
    }

    public void jogar(Tabuleiro tabuleiro) {
        int linha, coluna;
        boolean jogadaValida;
        do {
            System.out.println("Digite a linha (entre 1 e 3) da sua jogada, jogador " + simbolo + ":");
            linha = solicitarNumero();
            System.out.println("Agora digite a coluna (entre 1 e 3) da sua jogada, jogador " + simbolo + ":");
            coluna = solicitarNumero();
            jogadaValida = tabuleiro.realizarJogada(linha, coluna, simbolo.charAt(0));
            if (!jogadaValida) {
                System.out.println("A posição já está preenchida, escolha outra.");
            }
        } while (!jogadaValida);
    }

    private int solicitarNumero() {
        int numero;
        while (true) {
            try {
                numero = scanner.nextInt();
                if (numero < 1 || numero > 3) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido. Por favor, digite um número entre 1 e 3.");
                scanner.nextLine();
            }
        }
        return numero;
    }
}
