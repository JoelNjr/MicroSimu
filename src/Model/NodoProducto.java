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
public class NodoProducto implements Serializable {
    
    private Producto producto;
    private NodoProducto anterior;
    private NodoProducto siguiente;
    
    public NodoProducto()
    {
        anterior = null;
        siguiente = null;
    }

    public NodoProducto(Producto producto) {
        this.producto = producto;
        this.anterior = null;
        this.siguiente = null;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public NodoProducto getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoProducto anterior) {
        this.anterior = anterior;
    }

    public NodoProducto getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoProducto siguiente) {
        this.siguiente = siguiente;
    }
}
