package model;

public class Owner extends User { // relación de herencia
    private Wallet wallet; // relación entre clase Owner y clase Wallet
    
    public Owner(String name) {
        super();
        wallet = new Wallet();
        setName("Andrés");
    }

    public Wallet getWallet() {
        return wallet;
    }

}
