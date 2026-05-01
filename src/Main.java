import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> pilhaNumeros = new Stack<>();
        Stack<String> operadores = new Stack<>();
        char c;
        int numerosPositivos = Integer.MAX_VALUE;

        operadores.add("+");
        operadores.add("-");
        operadores.add("*");
        operadores.add("/");

        //int numerosPositivos = Integer.MAX_VALUE;
        //pilhaNumeros.add(numerosPositivos);
        //System.out.println(numerosPositivos);
        System.out.println(operadores);


        System.out.println("Digite sua expressão: ");
        String expressao = sc.nextLine();

        for (int i = 0; i < expressao.length(); i++) {
            c = expressao.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder numeroCompleto = new StringBuilder();
                while (i < expressao.length() && Character.isDigit(expressao.charAt(i))) {
                    numeroCompleto.append(expressao.charAt(i));
                    i++;
                }
                int valor = Integer.parseInt(numeroCompleto.toString());
                pilhaNumeros.add(valor);
                System.out.println("Numero adicionado: " + valor);
            }
        }
        System.out.println("Pilha final: " + pilhaNumeros);
    }
}