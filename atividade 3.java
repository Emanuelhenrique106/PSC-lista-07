import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Notas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Lista para armazenar as notas digitadas
        List<Double> notas = new ArrayList<>();

        System.out.println("=== SISTEMA DE LEITURA DE NOTAS ===");
        System.out.println("Digite as notas. Para encerrar, digite -1.\n");

        // Leitura das notas com validação para aceitar apenas números
        while (true) {
            System.out.print("Digite uma nota: ");
            String entrada = sc.nextLine().trim().replace(',', '.');

            try {
                double valor = Double.parseDouble(entrada);
                if (valor == -1) break; // encerra a entrada
                notas.add(valor);       // armazena apenas se não for -1
            } catch (Exception e) {
                System.out.println("Entrada inválida! Digite um número válido.");
            }
        }

        System.out.println("\n===== RESULTADOS =====");

        // 1. Quantidade de valores lidos
        System.out.println("Quantidade de notas informadas: " + notas.size());

        // 2. Exibir valores na ordem original
        System.out.print("Notas na ordem informada: ");
        for (double n : notas) System.out.print(n + " ");

        // 3. Exibir valores na ordem inversa (um por linha)
        System.out.println("\n\nNotas na ordem inversa:");
        List<Double> invertida = new ArrayList<>(notas);
        Collections.reverse(invertida);
        for (double n : invertida) System.out.println(n);

        // 4 e 5. Soma e média
        double soma = 0;
        for (double n : notas) soma += n;
        double media = notas.isEmpty() ? 0 : soma / notas.size(); // evita divisão por zero
        System.out.println("\nSoma dos valores: " + soma);
        System.out.println("Média das notas: " + media);

        // 6. Quantidade acima da média
        int acimaMedia = 0;
        for (double n : notas) if (n > media) acimaMedia++;
        System.out.println("Quantidade de valores acima da média: " + acimaMedia);

        // 7. Quantidade abaixo de 7
        int abaixoDeSete = 0;
        for (double n : notas) if (n < 7) abaixoDeSete++;
        System.out.println("Quantidade de valores abaixo de 7: " + abaixoDeSete);

        // 8. Mensagem de encerramento
        System.out.println("\nFim do programa. Obrigado por utilizar!");

        sc.close();
    }
}
