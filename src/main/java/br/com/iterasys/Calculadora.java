// 1- Pacote: Conjunto de Classes
package br.com.iterasys;

//2- Bibliotecas

// 3- Classes
public class Calculadora {
    // 3.1 -  Atributos - Caracteristicas

    // 3.2 - Funções e métodos
    public static double somarDoisNumeros_(double num1, double num2) {
        return num1 + num2;
    }

    public static double multiplicarDoisNumeros_(double num1, double num2) {
        return num1 * num2;
    }

    public static double subtrairDoisNumeros_(double num1, double num2) {
        return num1 - num2;
    }

    public static double dividirDoisNumeros_(double num1, double num2) {

        return num1 / num2;
    }

    public static double somarTresNumeros_(double num1, double num2, double num3) {

        return num1 + num2 + num3;
    }

    public static String dividirDoisNumerosInteiros_(int numA, int numB) {
        try {
            return String.valueOf(numA / numB);
        } catch (Exception e) {
            return "Não é possível dividir por 0";
        }
    }

    public static double somarDoisNumeros_(int numA, int numB) {
        return numA + numB;
    }
}












