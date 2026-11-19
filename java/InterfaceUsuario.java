package util;
import java.util.Scanner;

public class InterfaceUsuario {
    Scanner scanner = new Scanner(System.in);

    public int pedirTipoFinanciamento() {
        int tipo;

        do {
            System.out.println("Qual o tipo de financiamento deseja realizar? ");
            System.out.println("1 - Casa");
            System.out.println("2 - Apartamento");
            System.out.println("3 - Terreno");
            System.out.print("Digite sua opção: ");

            tipo = scanner.nextInt();

            if (tipo < 1 || tipo > 3) {
                System.out.println("Opção inválida. Escolha 1, 2 ou 3.");
            }

        } while (tipo < 1 || tipo > 3);

        return tipo;
    }
    public int pedirNumeroVagasGaragem() {
        System.out.print("Digite o número de vagas da garagem: ");
        return scanner.nextInt();
    }

    public int pedirNumeroAndar() {
        System.out.print("Digite o número do andar: ");
        return scanner.nextInt();
    }

    public String pedirTipoZona() {
        System.out.print("Digite o tipo da zona (Residencial ou Comercial): ");
        return scanner.next();
    }
    public double pedirValorImovel () {
        double valorImovel;

        do {
            System.out.println("Digite o valor do imóvel: ");
            valorImovel = scanner.nextDouble();

            if (valorImovel <= 0) {
                System.out.println("Valor inválido, digite um valor maior que zero");
            }

        } while (valorImovel <= 0);
        return valorImovel;
    }

    public int pedirPrazoFinanciamento() {
        int prazo;
        do {
            System.out.println("Digite o valor do prazo: ");
            prazo = scanner.nextInt();

            if (prazo <= 0) {
                System.out.println("Prazo inválido, digite um prazo maior que zero. ");
            }
        } while (prazo <= 0);
        return prazo;
    }

    public double pedirTaxaJuros () {
        double taxaJuros;
        do {
            System.out.println("Digite o valor do taxa: ");
            taxaJuros = scanner.nextDouble();

            if  (taxaJuros < 0) {
                System.out.println("Erro: a taxa não pode ser negativa.");
            } else if (taxaJuros > 100) {
                System.out.println("Erro: a taxa não pode ser maior que 100% ao ano.");
            }
        }
        while (taxaJuros < 0);
        return taxaJuros;
    }
    public double pedirAreaConstruida() {
        System.out.print("Digite o tamanho da área construída em m²: ");
        return scanner.nextDouble();
    }

    public double pedirAreaTerreno() {
        System.out.print("Digite a área do terreno em m²: ");
        return scanner.nextDouble();
    }

}
