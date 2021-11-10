import java.util.Scanner;//Made by: Hugo Barros 25/09/2021

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira um número inteiro maior que zero.");
        if (sc.hasNextInt()) { //Limits the input to intergers
            int number = sc.nextInt();
            sc.close();
            if (number < 0) //Limits the input to positive numbers
                System.out.println("Erro: Insira um número maior que zero.");
            if (repetidos(number)) //Checks if the number has duplicates
                System.out.println("Erro: Insira um número sem algarismos repetidos.");
            desenha(number);
        } else System.out.println("Erro: Insira apenas números inteiros.");
    }

    public static int inverte(int n) {//Inverts the order of the numbers
        int invertido = 0;
        for (; n != 0; n /= 10) {
            int x = n % 10;
            invertido *= 10;
            invertido += x;
        }
        return invertido;
    }

    public static int ocorrencias(int alg, int n) { //Checks for the number of occurrences
        int nOcorrencias = 0;
        int aux;
        for (int i = 0; i < digitCounter(n); i++) {
            aux = n % 10;
            if (alg == aux)
                nOcorrencias++;
            n /= 10;
        }
        return nOcorrencias;
    }

    public static boolean repetidos(int n) {//Checks if a number has duplicates
        for (int i = 0; i < 10; i++) {
            if (ocorrencias(i, n) >= 2)
                return true;
        }
        return false;
    }

    public static int digitCounter(int n) {//Counts the number of digits a number has
        int counter = 0;
        while (n > 0) {
            counter++;
            n /= 10;
        }
        return counter;
    }

    public static int maxDigit(int n) {//Gets the max digit
        int max = 0;
        while (n > 0) {
            if ((n % 10) > max) {//Goes through the number and gets the max
                max = n % 10;
                n /= 10;
            } else n /= 10;
        }
        return max;
    }

    public static void desenha(int n) {//Prints out the graph
        int notInverted = n;//saves original input for later
        n = inverte(n);//Inverts the input, in order to print it in the right order
        int columns = digitCounter(n) * 2; //*2 because of the empty columns in beggining and between two consecutive bars
        int rows = maxDigit(n) + 1; //+1 so the numeric number is counted too
        int aux = n;
        int current = aux % 10;//variables to go through the digits
        for (int i = rows; i > 0; i--) {
            for (int j = 0; j < columns; j++) {//2 for loops to render the lines/rows and columns
                if (j % 2 == 0) { // every even column has a space
                    System.out.print(" ");
                } else { //every odd column has an '*' or a number
                    if (i == 1) //last line/row, meaning it will print out the decimal digit
                        System.out.print(current);
                    else {
                        if (i <= current + 1)// checks the condition to print the graph's columns or the spaces
                            System.out.print("*");
                        else
                            System.out.print(" ");
                    }
                    aux /= 10;// then it advances to the next digit
                    current = aux % 10;
                }
            }
            if (i != 1)// if it's not the last line/row it changes line/row
                System.out.println();
            aux = n;//resets the variable to the original form since it has finished a line/row it was on the last
            current = aux % 10;//digit of the number, it now is on the first digit again
        }
        if (digitCounter(notInverted) > digitCounter(n)) //Checks if the length of the input is bigger than the inverted
            System.out.print(" 0");//(ex: 90 -> 09, the 0 in 09 disappears)  so it just prints out a '0'
    }
}