/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.Serializable;
import Model.NodoTransaccion;
import Model.Transaccion;

/**
 *
 * @author User
 */
public class ColaTransaccion implements Serializable {
    
    private NodoTransaccion primero;
    private NodoTransaccion ultimo;

    public ColaTransaccion() 
    {
        this.primero = this.ultimo = null;
    }

    public boolean estaVacia() 
    {
        return primero == null;
    }

    public void encolar(Transaccion transaccion) 
    {
        NodoTransaccion nuevo = new NodoTransaccion(transaccion);
        if (estaVacia()) {
            primero = ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
    }

    public Transaccion desencolar() 
    {
        if (estaVacia()) return null;

        Transaccion temp = primero.getTransaccion();
        primero = primero.getSiguiente();
        if (primero == null) ultimo = null;
        return temp;
    }

    public void mostrarTransacciones() 
    {
        NodoTransaccion actual = primero;
        while (actual != null) {
            System.out.println(actual.getTransaccion());
            actual = actual.getSiguiente();
        }
    }

    public int contarTransacciones() 
    {
        int contador = 0;
        NodoTransaccion actual = primero;
        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }
}