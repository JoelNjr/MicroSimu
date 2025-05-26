/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class NodoTransaccion implements Serializable {
    
    private Transaccion transaccion;
    private NodoTransaccion siguiente;
    
    public NodoTransaccion()
    {
        siguiente = null;
    }

    public NodoTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
        this.siguiente = null;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    public NodoTransaccion getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoTransaccion siguiente) {
        this.siguiente = siguiente;
    }
}
