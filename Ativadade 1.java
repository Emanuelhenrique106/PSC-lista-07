import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Vetor para armazenar as temperaturas dos 12 meses
        double[] temp = new double[12];

        // Vetor com os nomes dos meses por extenso
        String[] meses = {"Janeiro","Fevereiro","Março","Abril","Maio","Junho",
                          "Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};

        // Formatação para exibir valores com duas casas decimais
        DecimalFormat df = new DecimalFormat("#0.00");

        // Entrada das temperaturas (com validação)
        for (int i = 0; i < 12; i++) {
            while (true) {
                System.out.print("Temperatura média de " + meses[i] + ": ");
                String valor = sc.nextLine().trim().replace(',', '.'); // aceita vírgula ou ponto

                try {
                    temp[i] = Double.parseDouble(valor);
                    break; // sai do loop caso a entrada esteja correta
                } catch (Exception e) {
                    System.out.println("Valor inválido! Digite um número (ex: 23.5)");
                }
            }
        }

        // Cálculo da média anual
        double soma = 0;
        for (double t : temp) soma += t;
        double media = soma / 12;

        System.out.println("\n================ RESULTADO ================");
        System.out.println("Média anual das temperaturas: " + df.format(media));
        System.out.println("\nMeses com temperatura acima da média:");

        // Exibição dos meses acima da média
        boolean encontrou = false;
        for (int i = 0; i < 12; i++) {
            if (temp[i] > media) {
                System.out.println((i+1) + " - " + meses[i] + ": " + df.format(temp[i]));
                encontrou = true;
            }
        }

        if (!encontrou) System.out.println("Nenhum mês ficou acima da média anual.");

        sc.close();
    }
}