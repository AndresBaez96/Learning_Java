package model;

public class Owner extends User { // relación de herencia
    private Wallet wallet; // relación entre clase Owner y clase Wallet
    
    public Owner(String name) {
        super();
        wallet = new Wallet();
        setName(name);
    }

    public Wallet getWallet() {
        return wallet;
    }

    public String compareWallet(Wallet compareWallet){
        Wallet myWallet = getWallet();

        if (myWallet.getBalance() > compareWallet.getBalance()) {
            return "My wallet has more balance";
        } else if (myWallet.getBalance() == compareWallet.getBalance()) {
            return "Both wallets have the same balance";
        } else {
            return "The other wallet has more balance";
        }
    }

    public String bankTransfer(Wallet transferWallet,double value) {
        Wallet myWallet = getWallet();
        transferWallet.saveMoney(value);
        myWallet.takeMoney(value + myWallet.taxTransfer(value));
        return "Succesful transference";
    }

    @Override
    public String toString() {
        // Auto-generated method stub
        return "Name: "+getName();
    }
}
