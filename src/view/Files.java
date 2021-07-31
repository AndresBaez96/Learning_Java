package view;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Files {
    public static void main(String[] args) {
    try {
        OutputStream output = new FileOutputStream("./data/data.properties"); //Llama a una carpeta donde se va a guardar el archivo
        Properties prop = new Properties(); 
        prop.setProperty("nombre", "Andres");
        prop.setProperty("edad", "25");
        prop.store(output, null); // Guarda las propiedades seteadas anteriormente
        System.out.println(prop);
        output.close();

    } catch (Exception e) {
        
    }
    try {
        InputStream input = new FileInputStream("./data/data.properties"); // Llama a la carpeta donde se guardan los datos
        Properties prop = new Properties();
        prop.load(input); 
        System.out.println(prop.getProperty("nombre"));
        System.out.println(prop.getProperty("edad"));
        input.close();

    } catch (Exception e) {
        // Todo: handle exception
    }
}
    
}