/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Empleado;
import Model.NodoEmpleado;

/**
 *
 * @author User
 */
public class ListaDobleEmpleado {
    
    private NodoEmpleado cabeza; // apuntador a la cabeza de la lista
    private NodoEmpleado cola; // apuntador al final de la cola 
    
    public ListaDobleEmpleado()
    {
        this.cabeza = null;
        this.cola = null;
    }
    
    public void AgregarEmpleado(Empleado empleado)
    {
        NodoEmpleado nuevo = new NodoEmpleado(empleado);
        
        if(cabeza==null)
        {
            cabeza = cola = nuevo;
        }
        else
        {
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
            cola = nuevo;
        }
    }
    
        public boolean eliminarEmpleado(String id) 
        {
        NodoEmpleado actual = cabeza;
        
        while (actual != null) 
        {
            if (actual.getEmpleado().getID().equals(id)) 
            {
                if (actual == cabeza) 
                {
                    cabeza = actual.getSiguiente();
                    if (cabeza != null) cabeza.setAnterior(null);
                } 
                else if (actual == cola) 
                {
                    cola = actual.getAnterior();
                    if (cola != null) cola.setSiguiente(null);
                } 
                else 
                {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                }
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }
        
        // Buscar producto por nombre
    public Empleado buscar(String nombre) 
    {
        NodoEmpleado temp = cabeza;
        while (temp != null) 
        {
            if (temp.getEmpleado().getNombre().equalsIgnoreCase(nombre)) 
            {
                return temp.getEmpleado();
            }
            temp = temp.getSiguiente();
        }
        return null;
    }

    // Mostrar productos
    public void mostrar() {
        NodoEmpleado temp = cabeza;
        while (temp != null) {
            Empleado e = temp.getEmpleado();
            System.out.println(e.toString());
            temp = temp.getSiguiente();
        }
    }
    

    
}
