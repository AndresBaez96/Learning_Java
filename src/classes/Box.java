package classes;
/* Ejercicio 6. Crear una clase llamada Caja con 3 atributos tipo int (ancho, alto, profundo)
Debe tener dos constructores: uno vacio y otro con los parámetros asociados a los atributos
Debe tener método que calcule el volúmen de la caja*/
public class Box {
    // Atributos
    private int width;
    private int height;
    private int depth;

    // Métodos
    public Box(int width, int height, int depth) {
        super();
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public Box() {
        super();
    }

    public int volumeIs(){
        int volume = width * height * depth; 
        return volume;
    }

    public static void main(String[] args) {
        Box volume = new Box(3,2,6);
        System.out.println("The volume is: " + volume.volumeIs());
    }
}
