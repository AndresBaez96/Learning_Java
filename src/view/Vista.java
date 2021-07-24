package view;
import model.Owner;
import model.Wallet;
public class Vista {

    public static void main(String[] args) {
        Wallet wallet1 = new Wallet(); // Importar clase Wallet, comando new para crear un objeto
        Owner client = new Owner("Andrés");
        Owner client2 = new Owner("Felipe");
        client.getWallet().saveMoney(500000);
        client.bankTransfer(client2.getWallet(), 200000);
        client.getWallet().cashBalance(); // toString se personaliza en la clase Transaction
        client2.getWallet().cashBalance();
    }
    
}