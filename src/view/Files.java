package view;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Files {
    public static void main(String[] args) {
    try {
        OutputStream output = new FileOutputStream("./data/data.properties"); //Llama a una carpeta donde se va a guardar el archivo
        Properties prop = new Properties(); 
        prop.setProperty("nombre", "Andres");
        prop.setProperty("edad ", "25");
        prop.store(output, null); // Guarda las propiedades seteadas anteriormente
        
        System.out.println(prop);

    } catch (Exception e) {
        
    }
}
    
}