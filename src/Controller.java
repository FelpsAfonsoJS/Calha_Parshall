import java.util.ArrayList;

// CONTROLLER: contém a lógica do fluxo principal
public class Controller {
    private final View view = new View();

    public void start() {
        boolean continuar = true;
        while (continuar) {
            // Entrada: ler somente inteiros conforme pedido
            int habitantes = view.readPositiveInt("Informe a quantidade de habitantes: ");
            int consumo = view.readPositiveInt("Informe o consumo de água por habitante (inteiro): ");

            // Modelo: construir tabelas de referência
            ArrayList<CalhaParshall> tabelaCalhaParshall = buildTabelaCalhaParshall();
            ArrayList<DimensoesParshall> tabelaDimensoesParshall = buildTabelaDimensoesParshall();

            // Cálculos iniciais
            double consumoTotal = (double) habitantes * (double) consumo; // litros/dia
            System.out.printf("O consumo total de agua é %.2f litros por dia %n", consumoTotal);

            double QD = consumoTotal / 86400.0; // L/s
            System.out.printf("A vazão de água em litros por segundo é %.2f L/s %n", QD);
            System.out.println("==========================================================");

            // Encontrar a calha adequada (apenas uma passagem)
            CalhaParshall calhaSelecionada = null;
            for (CalhaParshall calha : tabelaCalhaParshall) {
                if (QD >= calha.vazaoMinima && QD <= calha.vazaoMaxima) {
                    calhaSelecionada = calha;
                    // Imprime dados da calha encontrada
                    System.out.printf("W: %.0f mm%n", calha.wMn);
                    System.out.printf("Ela tem uma vazão mínima de:  %.2f L/s%n", calha.vazaoMinima);
                    System.out.printf("Ela tem a vazão máxima de:  %.2f L/s%n", calha.vazaoMaxima);
                    System.out.printf("O valor de K é:  %.4f%n", calha.K);
                    System.out.printf("O valor de N é: %.4f%n", calha.N);
                    System.out.println("====================================");
                    System.out.printf("A calha parshall mais adequada é a de %s%n", calha.polegadas);
                    break;
                }
            }

            // Tratativa para evitar NullPointerException
            if (calhaSelecionada == null) {
                System.out.println("Nenhuma calha Parshall adequada encontrada para a vazão calculada.");
                // pergunta se quer continuar
                continuar = view.askContinue();
                if (!continuar) view.close();
                continue;
            }

            // Verificar parâmetros K e N válidos
            if (calhaSelecionada.K <= 0.0 || calhaSelecionada.N <= 0.0) {
                System.out.println("Parâmetros K ou N inválidos na calha selecionada.");
                continuar = view.askContinue();
                if (!continuar) view.close();
                continue;
            }

            // Cálculo de Ha e conversões
            double Ha = Math.pow(QD / calhaSelecionada.K, 1.0 / calhaSelecionada.N);
            double HaCM = Ha * 30.48; // converte (supõe-se Ha em pés)
            double haSeguroCm = HaCM * 0.70; // 70% da profundidade

            System.out.printf("Ha (pés): %.4f, Ha (cm): %.2f, 70%% de Ha (cm): %.2f%n", Ha, HaCM, haSeguroCm);

            // Selecionar dimensão que acomode a altura segura
            boolean foundDimension = false;
            for (DimensoesParshall dimensao : tabelaDimensoesParshall) {
                if (haSeguroCm <= dimensao.largura) {
                    System.out.printf("Calha final recomendada: %s%n", dimensao.tamanho);
                    System.out.printf("Largura correspondente %.2f cm%n", dimensao.largura);
                    foundDimension = true;
                    break;
                }
            }

            if (!foundDimension) {
                System.out.println("Nenhuma dimensão disponível comporta a altura segura; considere revisar a tabela de dimensões.");
            }

            // Pergunta se usuário quer realizar outro cálculo
            continuar = view.askContinue();
            if (!continuar) view.close();
        }
    }

    // MODEL helpers: constroem as tabelas usadas pelo algoritmo
    private ArrayList<CalhaParshall> buildTabelaCalhaParshall() {
        ArrayList<CalhaParshall> tabela = new ArrayList<>();
        tabela.add(new CalhaParshall(76, "3\" Polegadas", 0.85, 53.8, 0.1771, 1.5447));
        tabela.add(new CalhaParshall(152, "6\" Polegadas", 1.52, 110.4, 0.3812, 1.530));
        tabela.add(new CalhaParshall(229, "9\" Polegadas", 2.55, 251.9, 0.5354, 1.530));
        tabela.add(new CalhaParshall(305, "1' Pés", 3.11, 455.6, 0.6909, 1.522));
        tabela.add(new CalhaParshall(457, "11/2' Pés", 4.25, 696.2, 1.0560, 1.538));
        tabela.add(new CalhaParshall(610, "2' Pés", 11.89, 936.7, 1.4290, 1.550));
        tabela.add(new CalhaParshall(915, "3' Pés", 17.26, 1426.0, 2.1840, 1.5666));
        tabela.add(new CalhaParshall(1220, "4' Pés", 36.79, 1921.0, 2.9630, 1.5738));
        tabela.add(new CalhaParshall(1525, "5' Pés", 62.80, 2422.0, 3.37320, 1.587));
        return tabela;
    }

    private ArrayList<DimensoesParshall> buildTabelaDimensoesParshall() {
        ArrayList<DimensoesParshall> tabela = new ArrayList<>();
        tabela.add(new DimensoesParshall("1\" Polegadas", 22.9));
        tabela.add(new DimensoesParshall("3\" Polegadas", 38.1));
        tabela.add(new DimensoesParshall("6\" Polegadas", 45.7));
        tabela.add(new DimensoesParshall("9\" Polegadas", 61.0));
        tabela.add(new DimensoesParshall("1' Pés", 91.5));
        tabela.add(new DimensoesParshall("1.5' Pés", 91.5));
        tabela.add(new DimensoesParshall("2' Pés", 91.5));
        tabela.add(new DimensoesParshall("3' Pés", 91.5));
        tabela.add(new DimensoesParshall("4' Pés", 91.5));
        tabela.add(new DimensoesParshall("5' Pés", 91.5));
        tabela.add(new DimensoesParshall("6' Pés", 91.5));
        tabela.add(new DimensoesParshall("7' Pés", 91.5));
        tabela.add(new DimensoesParshall("8' Pés", 91.5));
        tabela.add(new DimensoesParshall("9' Pés", 91.5));
        tabela.add(new DimensoesParshall("10' Pés", 91.5));
        return tabela;
    }
}

