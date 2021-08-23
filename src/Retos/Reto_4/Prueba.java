package Retos.Reto_4;

public class Prueba {
    public static void main(String[] args) throws Exception {
        Controller controller = new Controller("jdbc:mysql://127.0.0.1:3306/proyectos");
        // controller.req1();
        // controller.printReq1();
        // controller.req2();
        // controller.printReq2();
        controller.req3();
        controller.printReq3();

    }
}
