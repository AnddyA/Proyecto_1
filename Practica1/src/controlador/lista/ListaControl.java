/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.lista;

/**
 *
 * @author andy
 */
public class ListaControl<E> {
    private NodoLista<E> primer;
    private Integer size = 0;

    public NodoLista<E> getPrimer() {
        return primer;
    }

    public void setPrimer(NodoLista<E> primer) {
        this.primer = primer;
    }
    
    
    
}
