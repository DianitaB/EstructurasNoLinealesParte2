package Materia.controllers;
import Materia.models.*;

public class ArbolBinario {
    private Node root;

    public ArbolBinario(){
        this.root=null;
    }

    public void insert(int value){
        root = insertRec(root,value);
    }

    private Node insertRec(Node padre, int value){
        if (padre== null){
            return new Node(value);
        }
        if(value<padre.getValue()){
            //Me voy a la IZQUIERDA
            padre.setLeft(insertRec(padre.getLeft(), value));
        } else if (value > padre.getValue()) {
            //Me voy a la DERECHA
            padre.setRight(insertRec(padre.getRight(), value));
        }
        return padre;
    }
    public void imprimirArbol(){
       imprimir(root);
    }
    public void imprimir(Node node){
        if (node != null){
            imprimir(node.getRight());
            System.out.println(node.getValue() + ", ");
            imprimir(node.getLeft());
        }
    }
    public boolean buscar(int value){
        return buscarRec(root,value);
    }
    
    private boolean buscarRec(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (node.getValue() == value) {
            return true;
        } else if (value < node.getValue()) {
            return buscarRec(node.getLeft(), value);
        } else {
            return buscarRec(node.getRight(), value);
        }  
    }
    
    public int getHeight(){
        return getHeightRec(root);

    }
    
    private int getHeightRec(Node node){
        if(node == null){
            return 0;
        }
        int leftHeight = getHeightRec(node.getLeft());
        int rightHeight = getHeightRec(node.getRight());
        return Math.max(leftHeight+1, rightHeight+1);
    }

    public int getWeight(){
        return getWeightRec(root);
    }
    private int getWeightRec(Node node){
        if(node == null){
            return 0;
        }
        int leftWeight = getWeightRec(node.getLeft());
        int rightWeight = getWeightRec(node.getRight());

        return leftWeight + rightWeight + 1;
    }

    public void printInOrderWithHeight(){
        System.out.println("Arbol In Order con Alturas: ");
        printInOrderWithHeightRec(root);
    }

    private void printInOrderWithHeightRec (Node node){
        if(node == null){
            return ; 
        }
        printInOrderWithHeightRec(node.getLeft());
        int height = getHeightRec(node);
        System.out.print(node.getValue() + " (h = " + height + ")" + " , ");
        System.out.println();
        printInOrderWithHeightRec(node.getRight());
    }

    public int calcularFacEquilibrio(){
        return calcularFacEquilibrioRec(root);
    }

    private int calcularFacEquilibrioRec(Node node){
        if(node == null){
            return 0;
        }
        int lefheight = getHeightRec(node.getLeft());
        int rightHeight = getHeightRec(node.getRight());
    
        return lefheight - rightHeight;
    }
    public void printFactorDeEquilibrio(){
        System.out.println("Arbol In Order Con Factor de Equilibrio: ");
        printFactorDeEquilibrioRec(root);
    }
    private void printFactorDeEquilibrioRec(Node node){
        if(node == null){
            return;
        }
        printFactorDeEquilibrioRec(node.getLeft());
        int factor = calcularFacEquilibrioRec(node);
        System.out.print(node.getValue() +  " (bf = " + factor + ")" + " , ");
        System.out.println();
        printFactorDeEquilibrioRec(node.getRight());
    }

    public boolean arbolEquilibrado(int value){
        boolean equilibrado = arbolEquilibradoRec(root);
        
        System.out.println("Arbol esta equilibrado = " + equilibrado);
        if(equilibrado == true){
            int nuevoValor = 15;
            insert(nuevoValor);
            System.out.println("Agregamos el nuevo valor: " + nuevoValor);
        }
        return equilibrado;
    }
    private boolean arbolEquilibradoRec(Node node){
        if(node == null){
            return true;
        }
        int leftHeight = getHeightRec(node.getLeft());
        int rightHeight = getHeightRec(node.getRight());
        int balance = Math.abs(leftHeight - rightHeight);
        return (balance <= 1) &&
            arbolEquilibradoRec(node.getLeft()) &&
            arbolEquilibradoRec(node.getRight());
    }

      public int calcularFacEquilibrio2(){
        return calcularFacEquilibrioRec2(root);
    }

    private int calcularFacEquilibrioRec2(Node node){
        if(node == null){
            return 0;
        }
        int lefheight = getHeightRec(node.getLeft());
        int rightHeight = getHeightRec(node.getRight());
    
        return lefheight - rightHeight;
    }

     public void printFactorDeEquilibrio2(){
        System.out.println("Arbol In Order Con Factor de Equilibrio: ");
        printFactorDeEquilibrioRec2(root);
    }
    private void printFactorDeEquilibrioRec2(Node node){
        if(node == null){
            return;
        }
        printFactorDeEquilibrioRec2(node.getLeft());
        int factor = calcularFacEquilibrioRec2(node);
        System.out.print(node.getValue() +  " (bf = " + factor + ")" + " , ");
        printFactorDeEquilibrioRec2(node.getRight());
    }

    public int nodosDesequilibrados(){
        int cantidad = nodosDesequilibradosRec(root);
        System.out.println("Nodos desequilibrados: " + cantidad);
        return cantidad;

    }
    private int nodosDesequilibradosRec(Node node) {
    if (node == null) {
        return 0;
    }
    int left = nodosDesequilibradosRec(node.getLeft());
    int right = nodosDesequilibradosRec(node.getRight());
    int bf = calcularFacEquilibrioRec(node);
    boolean desequilibrado = Math.abs(bf) > 1;
    return (desequilibrado ? 1 : 0) + left + right;
}




    
}