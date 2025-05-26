/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.Serializable;
import Model.NodoProducto;
import Model.Producto;

/**
 *
 * @author User
 */
public class ListaDobleProducto implements Serializable {
    
    private NodoProducto cabeza; // apuntador a la cabeza de la lista
    private NodoProducto cola; // apuntador al final de la cola 
    
    public ListaDobleProducto()
    {
        this.cabeza = null;
        this.cola = null;
    }
    
    public void AgregarProducto(Producto producto)
    {
        NodoProducto nuevo = new NodoProducto(producto);
        
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
    
    
        public boolean EliminarProducto(String CODIGO) 
        {
        NodoProducto actual = cabeza;
        
        while (actual != null) 
        {
            if (actual.getProducto().getCodigo().equalsIgnoreCase(CODIGO)) 
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
    public Producto buscar(String nombre) 
    {
        NodoProducto temp = cabeza;
        while (temp != null) 
        {
            if (temp.getProducto().getNombre().equalsIgnoreCase(nombre)) 
            {
                return temp.getProducto();
            }
            temp = temp.getSiguiente();
        }
        return null;
    }

    // Mostrar productos
    public void mostrar() {
        NodoProducto temp = cabeza;
        while (temp != null) {
            Producto p = temp.getProducto();
            System.out.println("Nombre: " + p.getNombre() +
                               ", Precio: $" + p.getPrecioventa() +
                               ", Stock: " + p.getStock());
            temp = temp.getSiguiente();
        }
    }

    // Calcular ganancias potenciales
    public double calcularGanancias() {
        double total = 0;
        NodoProducto temp = cabeza;
        while (temp != null) {
            Producto p = temp.getProducto();
            total += p.getPrecioventa() * p.getStock();
            temp = temp.getSiguiente();
        }
        return total;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }
    
}
