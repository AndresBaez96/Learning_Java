package view;
import model.Wallet;
public class Vista {

    public static void main(String[] args) {
        Wallet wallet1 = new Wallet(); // Importar clase Wallet, comando new para crear un objeto
        System.out.println(wallet1.saveMoney(250000));
        System.out.println(wallet1.getBalance());
    }
    
}
