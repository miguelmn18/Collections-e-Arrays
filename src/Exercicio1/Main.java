package Exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int number = -1;
        List<Integer> numeros = new ArrayList();
        StringBuilder expressao = new StringBuilder();

        //Menu das operações (Usuário escolhe)
        int operacaoEscolhida = getOperacaoEscolhida(sc);

        int numero;
        do {
            System.out.println("Digite um número: (ou -1 para sair): ");
            numero = sc.nextInt();

            if (numero != number) {
                //adiciona os numeros ao array
                numeros.add(numero);

                if (operacaoEscolhida == 1){
                    expressao.append(numero).append("+");
                    System.out.println(expressao);

                } else if(operacaoEscolhida == 2){
                    expressao.append(numero).append("-");
                    System.out.println(expressao);

                } else if(operacaoEscolhida ==3){
                    expressao.append(numero).append("x");
                    System.out.println(expressao);

                } else if (operacaoEscolhida == 4) {
                    expressao.append(numero).append("/");
                    System.out.println(expressao);
                }
            }
        } while (numero != number);
        expressao.deleteCharAt(expressao.length() -1);
        extracted(operacaoEscolhida, numeros, expressao);
    }

    private static void extracted(int operacaoEscolhida, List<Integer> numeros, StringBuilder expressao) {
        switch (operacaoEscolhida) {
            case 1:
                Integer soma = numeros.stream().reduce(0, Integer::sum);
                System.out.println(expressao);
                System.out.println("Soma = " + soma);
                break;

            case 2:
                Integer soma2 = numeros.stream().reduce(0, (a, b) -> a - b);
                System.out.println(expressao.toString());
                System.out.println("Subtração = " + soma2);
                break;
            case 3:
                Integer soma3 = numeros.stream().reduce(1, (a, b) -> a * b);
                System.out.println(expressao.toString());
                System.out.println("Multiplicação = " + soma3);
                break;
            case 4:
                Integer soma4 = numeros.stream().reduce((a, b) -> a / b).orElse(0);
                System.out.println(expressao.toString());
                System.out.println("Divisão: " + soma4);
                break;

            default:
                System.out.println("Opção inexistente!");


        }
    }

    private static int getOperacaoEscolhida(Scanner sc) {
        System.out.println("Operações matemáticas:\n " +
                "1-Soma\n" +
                "2-Subtração\n" +
                "3-Multiplicação\n" +
                "4-Divisão");
        int getOperacaoEscolhida = sc.nextInt();
        return getOperacaoEscolhida;
    }

}

