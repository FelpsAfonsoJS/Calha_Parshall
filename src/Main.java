import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe a qunantidade de habitantes ");
        int habitantes = scanner.nextInt();

        System.out.println("Informe o consumo de Agua por Habitante ");
        double consumo = scanner.nextDouble();

        //Calculo do consumo total de agua por dia, valor real
        double consumoTotal = habitantes * consumo;
        System.out.printf("O consumo total de agua é %.2f litros por dia ", consumoTotal);

        double QD = consumoTotal / 86400.0;
        System.out.printf("%nA vazão de água em litros por segundo é %.2f L/s %n", QD);

        System.out.println("==========================================================");

        //planilha da tabela 01 verificando valor maximo e minimo
        ArrayList<CalhaParshall> tabelaCalhaParshall = new ArrayList<>();
        tabelaCalhaParshall.add(
                new CalhaParshall(
                        76,
                        "3\" Polegadas",
                        0.85,
                        53.8,
                        0.1771,
                        1.5447
                )
        );
        tabelaCalhaParshall.add(
                new CalhaParshall(
                        152,
                        "6\" Polegadas",
                        1.52,
                        110.4,
                        0.3812,
                        1.530
                )
        );
        tabelaCalhaParshall.add(
                new CalhaParshall(
                        229,
                        "9\" Polegadas",
                        2.55,
                        251.9,
                        0.5354,
                        1.530
                )
        );
        tabelaCalhaParshall.add(
                new CalhaParshall(
                        305,
                        "1\' Pés",
                        3.11,
                        455.6,
                        0.6909,
                        1.522
                )
        );
        tabelaCalhaParshall.add(
                new CalhaParshall(
                        457,
                        "11/2\' Pés",
                        4.25,
                        696.2,
                        1.0560,
                        1.538
                )
        );
        tabelaCalhaParshall.add(
                new CalhaParshall(
                        610,
                        "2\' Pés",
                        11.89,
                        936.7,
                        1.4290,
                        1.550
                )
        );
        tabelaCalhaParshall.add(
                new CalhaParshall(
                        915,
                        "3\' Pés",
                        17.26,
                        1426.0,
                        2.1840,
                        1.5666
                )
        );
        tabelaCalhaParshall.add(
                new CalhaParshall(
                        1220,
                        "4\' Pés",
                        36.79,
                        1921.0,
                        2.9630,
                        1.5738
                )
        );
        tabelaCalhaParshall.add(
                new CalhaParshall(
                        1525,
                        "5\' Pés",
                        62.80,
                        2422.0,
                        3.37320,
                        1.587
                )
        );

        //verificando qual calha parshall é a mais adequada para o valor recomendado
        for (CalhaParshall calha : tabelaCalhaParshall) {

             //Comparando
            if (QD >= calha.vazaoMinima && QD <= calha.vazaoMaxima) {
                System.out.printf(
                        "A calha parshall mais adequada é a de %s%n",
                        calha.polegadas
                );
                System.out.printf("W: %.0f mm%n",
                        calha.wMn);

                System.out.printf("Ela tem uma vazão mínima de:  %.2f L/ s%n",
                        calha.vazaoMinima);

                System.out.printf("Ela tem a vazão máxima de:  %.2f L/ s%n",
                        calha.vazaoMaxima);

                System.out.printf("O valor de K é:  %.4f%n",
                        calha.K);
                System.out.printf("O valor de N é: %.4f%n",
                        calha.N);
                break;
            }

        }
        ArrayList<DimensoesParshall> tabelaDimensoesParshall = new ArrayList<>();

        tabelaDimensoesParshall.add(
                new DimensoesParshall(
                        "1\" Polegadas",
                        22.9
                )
        );
        tabelaDimensoesParshall.add(
                new DimensoesParshall(
                        "3\" Polegadas",
                        38.1
                )
        );
        tabelaDimensoesParshall.add(
                new DimensoesParshall(
                        "6\" Polegadas",
                        45.7
                )
        );
        tabelaDimensoesParshall.add(
                new DimensoesParshall(
                        "9\" Polegadas",
                        61.0
                )
        );
        tabelaDimensoesParshall.add(
                new DimensoesParshall(
                        "1\' Pés",
                        91.5
                )
        );
        tabelaDimensoesParshall.add(
                new DimensoesParshall(
                        "1.5\' Pés",
                        91.5
                )
        );
        tabelaDimensoesParshall.add(
                new DimensoesParshall(
                        "2\' Pés",
                        91.5
                )
        );
        tabelaDimensoesParshall.add(
                new DimensoesParshall(
                        "3\' Pés",
                        91.5
                )
        );
        tabelaDimensoesParshall.add(
                new DimensoesParshall(
                        "4\' Pés",
                        91.5
                )
        );
        tabelaDimensoesParshall.add(
                new DimensoesParshall(
                        "5\' Pés",
                        91.5
                )
        );
        tabelaDimensoesParshall.add(
                new DimensoesParshall(
                        "6\' Pés",
                        91.5
                )
        );
        tabelaDimensoesParshall.add(
                new DimensoesParshall(
                        "7\' Pés",
                        91.5
                )
        );
        tabelaDimensoesParshall.add(
                new DimensoesParshall(
                        "8\' Pés",
                        91.5
                )
        );
        tabelaDimensoesParshall.add(
                new DimensoesParshall(
                        "9\' Pés",
                        91.5
                )
        );
        tabelaDimensoesParshall.add(
                new DimensoesParshall(
                        "10\' Pés",
                        91.5
                )

        );
        System.out.println("====================================");

        CalhaParshall calhaSelecionada = null;
        for (CalhaParshall calha : tabelaCalhaParshall) {;

            if (QD >= calha.vazaoMinima && QD <= calha.vazaoMaxima) {

                calhaSelecionada = calha;

                break;
            }
        }
        double Q = QD;

        double Ha = Math.pow(
                Q / calhaSelecionada.K,
                1.0 / calhaSelecionada.N
        );
        System.out.printf("o valor foi de %.2f m%n", Ha);

        double HaCM = Ha * 30.48;

        System.out.printf("Altura calculada: %.2f cm%n", HaCM);

        double haSeguroCm = HaCM * 0.70;

        System.out.printf("Altura segura: %.2f cm%n", haSeguroCm);

        for (DimensoesParshall dimensao : tabelaDimensoesParshall){
            if (haSeguroCm <= dimensao.largura){

                System.out.printf("Calha final recomendada: %s%n", dimensao.tamanho);

                System.out.printf("Largura correspondente %.2f cm%n", dimensao.largura);

                break;
            }

        }
    }

}

