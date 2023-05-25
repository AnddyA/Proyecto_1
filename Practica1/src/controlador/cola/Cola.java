/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.cola;

import controlador.lista.ListaControl;
import controlador.lista.exception.PosicionException;
import controlador.lista.exception.VacioException;

/**
 *
 * @author andy
 */
public class Cola<E> extends ListaControl<E>{

    private int tope;

    public Cola(int tope) {
        this.tope = tope;
    }

    public boolean isFull() {
        return (size() >= tope);
    }

    public void queue(E data) throws VacioException {
        if (isFull()) {
            throw new VacioException("La cola esta llena");
        }

        this.insertar(data);
    }

    public E dequeue() throws VacioException, PosicionException {
        if (isEmpty()) {
            throw new VacioException("La cola vacia");
        }

        return this.delete(0);
    }

    public int getTop() {
        return this.tope;
    }
}
