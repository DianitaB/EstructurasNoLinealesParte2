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
            System.out.print(node.getValue() + ", ");
            imprimir(node.getLeft());
        }
    }
}