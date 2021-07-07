package model;

public class Wallet {
    
    public static final int MAX_CAPACITY = 1000000; // Constantes: acceso público, estáticas, final es para asignar un valor, siempre mayus
    private boolean hasLimit;
    private int balance; // Saldo

    // Método constructor (ctor): genera un objeto asociado a la clase
    public Wallet() {  
        super();
        balance = 0;
        hasLimit = true;
    }
    
    // Método que retorna un str, sirve para ingresar dinero
    public String saveMoney(int value){ 
        if (value < 0) {
            return "You must enter a valid quantity";
        } else if (hasLimit && value + balance > MAX_CAPACITY) {
            return "Balance cannot exceed the maximum capcity";
        } else {
            balance += value;
            return "Succesful transaction";
        }
    }
    
    // Método que retorna un str, sirve para sacar dinero
    public String takeMoney(int value) { 
        if (value > balance) {
            return "The amount is greater than the balance";
        } else {
            balance -= value;
            return "Succesful transaction";
        }
    }

    // Método de accesibilidad: devuelve el valor de un atributo
    public int getBalance() { 
        return balance;
    }
}
