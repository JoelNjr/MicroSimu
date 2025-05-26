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
public class NodoEmpleado implements Serializable {
    
    private Empleado empleado;
    private NodoEmpleado anterior;
    private NodoEmpleado siguiente;
    
    public NodoEmpleado()
    {
        anterior = null;
        siguiente = null;
    }
    
    public NodoEmpleado(Empleado empleado)
    {
        this.empleado = empleado;
        this.anterior = null;
        this.siguiente = null;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public NodoEmpleado getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoEmpleado anterior) {
        this.anterior = anterior;
    }

    public NodoEmpleado getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoEmpleado siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
    
}
