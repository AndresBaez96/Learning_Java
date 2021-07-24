package model;

import java.util.ArrayList;

public class Wallet {
    
    private static final double MAX_CAPACITY = 1000000; // Constantes: acceso público, estáticas, final es para asignar un valor, siempre mayus
    private static final double TRANSFERENCE_TAX = 0.2; // Porcentaje
    private boolean hasLimit;
    private double balance; // Saldo
    private ArrayList<Transaction> transactions; // ArrayList genérico con <> se guarda un solo tipo de datos

    // Método constructor (ctor): genera un objeto asociado a la clase
    public Wallet() {  
        super();
        balance = 0;
        hasLimit = true;
        transactions = new ArrayList<>(); // Lista vacía 
        
    }
    
    // Método que retorna un str, sirve para ingresar dinero
    public String saveMoney(double value){ 
        if (value < 0) {
            return "You must enter a valid quantity";
        } else if (hasLimit && value + balance > MAX_CAPACITY) {
            return "Balance cannot exceed the maximum capacity";
        } else {
            balance += value;
            Transaction transaction = new Transaction(value, "today", 1);
            transactions.add(transaction); // agrega el objeto transaction al ArrayList transactions como ingreso
            return "Succesful transaction";
        }
    }
    
    // Método que retorna un str, sirve para sacar dinero
    public String takeMoney(double value) { 
        if (value > balance) {
            return "The amount is greater than the balance";
        } else {
            balance -= value;
            Transaction transaction = new Transaction(value, "today", 2);
            transactions.add(transaction); // agrega el objeto transaction al ArrayList transactions como egreso
            return "Succesful transaction";
        }
    }

    public double taxTransfer(double value) {
        return TRANSFERENCE_TAX*value/100;
    }

    // Método de accesibilidad: devuelve el valor de un atributo
    public double getBalance() { 
        return balance;
    }

    //
    public String breakLimits(){
        if (hasLimit = false) {  //!haslimit
            return "Your account hasn't limits";
        } else {
            if (MAX_CAPACITY - balance <= 100000){
                hasLimit = false;
                return "Your account hasn't limits anymore";
            } else {
                return "You are missing "+ (100000 - (MAX_CAPACITY - balance)) + " to unlock the limit of your account";
            }
        }

    }

    public void cashBalance() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}