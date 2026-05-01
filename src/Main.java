import java.util.*;

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

        System.out.println(operadores);


        System.out.println("Digite sua expressão: ");
        String expressao = sc.nextLine();
        List<String> tokens = tokenize(expressao);
        System.out.println("Tokens: " + tokens);
        System.out.println("=================================");
        List<String> postFix = toPostFix(tokens);
        System.out.println("Expressão em pos fixa: " + postFix);
        System.out.println("=========================");



    }

    public static List<String> tokenize(String expressao) {
        List<String> tokens = new ArrayList<>();
        String[] parts = expressao.split("(?<=[-+*/()])|(?=[-+*/()])");
        for (String part : parts) {

            String token = part.trim();
            if (!token.isEmpty()) {
                tokens.add(token);
            }
        }
        return tokens;
    }

    public static List<String> toPostFix(List<String> tokens) {
        List<String> output = new ArrayList<>();
        Stack<String> operadores = new Stack<>();

        for (String token : tokens) {
            if (token.matches("\\d+")) {
                //Se for número, vai direto pra saída
                output.add(token);
            } else if (token.equals("(")) {
                //Abre parentêses vai para a pilha de operadores
                operadores.push(token);
            } else if (token.equals(")")) {
                //Fecha parantêses: desempilha até encontrar ")
                while (!operadores.isEmpty() && !operadores.peek().equals("(")) {
                    output.add(operadores.pop());
                }
                operadores.push(token);
            }
        }
        return output;
    }



            /* Desempilha operadores restantes
            while (!operadores.isEmpty()) {
                output.add(operadores.pop());
            }

            return output;
        }*/





        public static boolean isOperator (String token){
            return token.equals("+") || token.equals("-") ||
                    token.equals("x") || token.equals("/");
        }
        private static int precedence (String op){
            if(op.equals("+") || op.equals("-")) return 1;
            if(op.equals("*") || op.equals("/"))return 2;
            return 0;
        }


    }
