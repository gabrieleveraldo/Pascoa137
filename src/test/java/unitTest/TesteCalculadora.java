package unitTest;// Biblioteca

import br.com.iterasys.Calculadora;
import com.sun.jdi.IntegerValue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static br.com.iterasys.Calculadora.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Classe
public class TesteCalculadora {
    // Atributos

    //Funções e Métodos

    @Test
    public void testeSomarDoisNumeros() {
        //Configura
        //Valores de Entrada
        double num1 = 7;
        double num2 = 5;
        // Valores de saída
        double resultadoEsperado = 12;

        //Executa
        double resultadoAtual = Calculadora.somarDoisNumeros_(num1, num2);

        //Valida
        assertEquals(resultadoEsperado, resultadoAtual);
    }
    //   Teste de Umidade Data Driven - direcionado por dados
    @ParameterizedTest
    @CsvSource(value = {
            "7,5,12",
            "56 , 44 , 100" ,
            "10, 0, 10",
            "15, -5, 10",
            "-8, -6, -14"
    }, delimiter = ',') // usamos virgula como separador dos valores
    public void testeSomarDoisNumerosLendoLista(String txtNum1, String txtNum2, String resultadoEsperado) { //usa Strinh pois os numeros estão em formato de texto
        //Configura
        // Os dados de entrada e o resultado esperado vem da lista

        //Executa
        double resultadoAtual = Calculadora.somarDoisNumeros_(Integer.valueOf(txtNum1), Integer.valueOf(txtNum2));

        //Valida
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);
    }

    @Test
    public void testeMultiplicarDoisNumeros() {
        double num1 = 5;
        double num2 = 3;
        double resultadoEsperado = 15;
        double resultadoAtual = Calculadora.multiplicarDoisNumeros_(num1, num2);
        assertEquals(resultadoEsperado, resultadoAtual);
    }
    @ParameterizedTest
    @CsvSource(value = {
            "5, 5, 25" ,
            "6, 6, 36" ,
            "2, 3, 6",
            "10, 5, 50" ,
            "6, 3, 18"
    }, delimiter = ',')
    public void testeMultiplicarDoisNumerosLendoLista(String txtNum1, String txtNum2, String resultadoEsperado) {
        double resultadoAtual = Calculadora.multiplicarDoisNumeros_(Integer.valueOf(txtNum1),Integer.valueOf(txtNum2));
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);
    }

    @Test
    public void testeSubtrairDoisNumeros() {
        double num1 = 10;
        double num2 = 5;
        double resultadoEsperado = 5;
        double resultadoAtual = subtrairDoisNumeros_(num1, num2);
        assertEquals(resultadoEsperado, resultadoAtual);

    }

    @Test
    public void testeDividirDoisNumeros() {
        double num1 = 20;
        double num2 = 5;
        double resultadoEsperado = 4;
        double resultadoAtual = dividirDoisNumeros_(num1, num2);
        assertEquals(resultadoEsperado, resultadoAtual);
    }
    @ParameterizedTest
    @CsvSource (value = {
            "10, 5, 2",
            "20, 2, 10",
            "36, 6, 6",
            "49, 7, 7"
    }, delimiter = ',')
    public void testeDividirDoisNumerosLendoLista(String txtNum1, String txtNum2, String resultadoEsperado) {
        double resultadoAtual = Calculadora.dividirDoisNumeros_(Integer.valueOf(txtNum1),Integer.valueOf(txtNum2));
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);

    }
    @Test
    public void testeSomarTresNumeros(){
        double num1 = 20.5;
        double num2 = 12;
        double num3 = 1;
        double resultadoEsperado = 33.5;
        double resultadoAtual = somarTresNumeros_(num1,num2,num3);
        assertEquals(resultadoEsperado, resultadoAtual);
    }
    @ParameterizedTest
    @CsvSource (value = {
            "10, 10, 10, 30",
            "5, 3, 2, 10",
            "6, 10, 2, 18",
            "100, 3000, 1, 3101"
    }, delimiter = ',')
    public void testeSomarTresNumerosLendoLista (String txtNum1, String txtNum2, String txtNum3, String resultadoEsperado){
        double resultadoAtual = Calculadora.somarTresNumeros_(Integer.valueOf(txtNum1),Integer.valueOf(txtNum2),Integer.valueOf(txtNum3));
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);
    }

    @Test
    public void testeDividirDoisNumerosInteiros(){
        int numA = 8;
        int numB= 0;
        String resultadoEsperado = "Não é possível dividir por 0";
        String resultadoAtual = dividirDoisNumerosInteiros_ (numA,numB);
        assertEquals(resultadoEsperado,resultadoAtual);
        System.out.println(numA + " / " + numB + " = " + resultadoAtual);

    }
    @ParameterizedTest //teste com o arquivo e não a lista
    @CsvFileSource(resources = "csv/massaSomar.csv", numLinesToSkip = 1, delimiter = ',')
    public void testeSomarDoisNumerosLendoArquivo(String txtNum1, String txtNum2, String resultadoEsperado){
        double resultadoAtual = Calculadora.somarDoisNumeros_(Integer.valueOf(txtNum1), Integer.valueOf(txtNum2));
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);
    }
}





