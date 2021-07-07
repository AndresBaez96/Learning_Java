package classes;

import java.util.Scanner;

public class Exercise1 {
    /* Ejercicio 1. Implemente un algoritmo que dado un
    nombre en una variable de tipo cadena,
    imprima un saludo en consola */
    public static String ex1(String name){
        return "Hi " + name;
    }

    /* Ejercicio 2. Implemente un algoritmo que reciba un número por
    teclado y cuente cuántas cifras (o dígitos) contiene e
    imprima el mensaje en consola */
    public static String ex2(int number){
        int counter = 0;
        while (number != 0) {
            number /= 10;
            counter++; 
        }
        return "The number " + "has " + counter + " digit(s)";
    }

    /* Ejercicio 3. Escribe un programa Java que lee un número entero por teclado y obtiene y
    muestra por pantalla el doble y el triple de ese número */
    public static String ex3(int number) {
        return "The double of " + number + " is " + number * 2 + " and the triple is " + number * 3;
    }

    /* Ejercicio 4. Escribe un programa que lea una cantidad de grados centígrados y la pase a
    grados Fahrenheit. La fórmula es: F = 32 + ( 9 * C / 5) */
    public static String ex4(int number) {
        return number + "°C equals " + (32 + (9 * number / 5)) + "°F";
    }

    /* Ejercicio 5. Escribe un programa java que lea una variable de tipo entero y asígnale un valor.
    A continuación muestra un mensaje indicando si la variable es par o impar.
    Utiliza el operador condicional ( ? : ) para resolverlo. */
    public static String ex5(int number) {
        String resultado = (number % 2 == 0)?" is even":" is odd";
        return number + resultado;
    }
    public static void main(String[] args) {
        // Ejercicio 1.
        String name = "Andrés";
        String result = ex1(name);
        System.out.println(result);
        System.out.println();

        // Ejercicio 2.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = sc.nextInt();
        System.out.println(ex2(number));
        System.out.println();

        // Ejercicio 3.
        System.out.println("Enter a second number: ");
        int number2 = sc.nextInt();
        System.out.println(ex3(number2));
        System.out.println();

        // Ejercicio 4.
        System.out.println("Enter the temperature in °C ");
        int temperature = sc.nextInt();
        System.out.println(ex4(temperature));

        // Ejercicio 5.
        System.out.println("Enter the final number: ");
        int number3 = sc.nextInt();
        System.out.println(ex5(number3));
    }
}
