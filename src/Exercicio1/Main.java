package Exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int number = -1;
        List<Integer> numeros = new ArrayList();
        String expressao;

        //Menu das operações (Usuário escolhe)
        System.out.println("Operações matemáticas:\n " +
                "1-Soma\n" +
                "2-Subtração\n" +
                "3-Multiplicação\n" +
                "4-Divisão");
        int operacaoEscolhida = sc.nextInt();

        //Usuário


        int numero;
        do {
            System.out.println("Digite um número: (ou -1 para sair): ");
            numero = sc.nextInt();

            if (numero != -number) {
                numeros.add(numero);


            }

        } while (numero != -number);

        switch (operacaoEscolhida) {
            case 1:
                Integer soma = numeros.stream().reduce(1, Integer::sum);
                System.out.println("Soma= = " + soma);
                break;

            case 2:
                Integer soma2 = numeros.stream().reduce(0, (a, b) -> a - b);
                System.out.println(soma2);
                break;
            case 3:
                Integer soma3 = numeros.stream().reduce(1, (a, b) -> a * b);
                System.out.println("Multiplicação = " + soma3);
                break;
            case 4:
                Integer soma4 = numeros.stream().reduce((a, b) -> a / b).orElse(0);
                System.out.println("Divisão: " + soma4);
                break;


        }

    }

}

