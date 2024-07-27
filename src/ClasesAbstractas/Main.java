
package ClasesAbstractas;



public class Main {
    public static void main(String[] args) {
        try {
            Menu menu = new Menu();
            menu.mostrarMenu();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error inesperado: " + e.getMessage());
        }
    }
} 
   

/*
public class Main {
public static void main(String[] args) {
    Menu menu = new Menu();
    menu.mostrarMenu();
    }
}

*/