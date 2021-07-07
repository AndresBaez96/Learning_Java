package classes;
public class First_class {

    private String name;
    private int id;
    private double height;
    private float weight;
    private char gender;
    private boolean isVaccinated;

    public static void main(String[] args) {
        System.out.println("Hello world!");
        //Arithmetic operators
        int resultado = 45 + 12;
        resultado = 45 - 12;
        resultado = 45 * 12;
        resultado = 45 / 12;
        resultado = 45 % 12;
        
        //Unary operators
        resultado++;
        resultado = resultado--;
        boolean respuesta = true;
        //!respuesta;

        //Boolean algebra
        respuesta = 5 < 8;
        respuesta = 5 > 8;
        respuesta = 5 >= 8;
        respuesta = 5 <= 8;
        respuesta = 5 == 8;
        respuesta = 5 != 8;

        //Logic operators
        respuesta = 5 < 8 && 4 >= 6;
        respuesta = 5 < 8 || 4 >= 6;

        //Bitwise operators
        // & and
        // | or
        // ^ xor

        //Control structures
        //---Conditionals---
        if (5 != 10) {
            //bloque de código
        }

        if (respuesta) {
            //bloque de código
        } else if(!respuesta){
            //bloque de código
        } else {
            //bloque de código
        }

        int llave = 2;
        switch (llave) {
            case 1:
                //bloque de código
                break;
            case 2:
                //bloque de código
                break;
        
            default:
                break;
        }

        //---Loops---
        while (llave > 5) {
            //bloque de código 
        }
        
        do {
            //bloque de código             
        } while (llave > 5);

        for (String string : args) {
            //bloue de código
        }
        
        // declaración de una variable ; condición ; incremento 
        for (int i = 0; i < args.length; i++) {
            
        }
    }
}
