import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tabuleiro tabuleiro = new Tabuleiro();
        Jogador jogadorX = new Jogador("X", scanner);
        Jogador jogadorO = new Jogador("O", scanner);

        tabuleiro.inicializar();
        tabuleiro.exibir();

        while (!tabuleiro.verificarVitoria() && !tabuleiro.jaPreenchido()) {
            System.out.println("Jogador X:");
            jogadorX.jogar(tabuleiro);
            tabuleiro.exibir();
            if (tabuleiro.verificarVitoria() || tabuleiro.jaPreenchido()) break;

            System.out.println("Jogador O:");
            jogadorO.jogar(tabuleiro);
            tabuleiro.exibir();
        }

        char ultimoJogador = tabuleiro.getUltimoJogador();
        if (tabuleiro.verificarVitoria()) {
            System.out.println("Parabéns! Jogador " + (ultimoJogador == 'X' ? "X" : "O") + " venceu!");
        } else {
            System.out.println("Empate!");
        }
        scanner.close();
    }
}
