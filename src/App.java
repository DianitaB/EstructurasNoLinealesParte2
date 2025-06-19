import Materia.controllers.ArbolBinario;

public class App {
    public static void main(String[] args) throws Exception {
        ArbolBinario ab = new ArbolBinario();
        ab.insert(50);
        ab.insert(17);
        ab.insert(76);
        ab.insert(9);
        ab.insert(23);
        ab.insert(54);
        ab.insert(14);
        ab.insert(19);

    System.out.println("Nombre : Diana Borja");
    System.out.println();
    //ab.imprimirArbol();
    //ab.buscar(23);  
    System.out.println("La altura es: " + ab.getHeight());
    System.out.println("El peso del arbol es: " + ab.getWeight());
    System.out.println();
    ab.printInOrderWithHeight();
    System.out.println();
    ab.printFactorDeEquilibrio();
    System.out.println();
    ab.arbolEquilibrado(0);
    System.out.println();
    ab.printFactorDeEquilibrio2();
    System.out.println();
    ab.nodosDesequilibrados();


       
    }
}
