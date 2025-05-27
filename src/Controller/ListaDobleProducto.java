/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.Serializable;
import java.io.*;
import Model.Empresa;
import Model.Empleado;
import Model.Producto;
import Model.Transaccion;
import Model.NodoEmpleado;
import Model.NodoProducto;
import Model.NodoTransaccion;
import Controller.ListaDobleProducto;
import Controller.ListaDobleEmpleado;
import Controller.ColaTransaccion;
import Controller.PersistenciaDatos;
import View.DatosEmpresa;

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
        
        
         // Buscar producto por CODIGO
    public Producto buscar(String CODIGO) 
    {
        NodoProducto temp = cabeza;
        while (temp != null) 
        {
            if (temp.getProducto().getCodigo().equalsIgnoreCase(CODIGO)) 
            {
                return temp.getProducto();
            }
            temp = temp.getSiguiente();
        }
        return null;
    }
    
         // Buscar producto por NOMBRE
    public Producto buscarpornombre (String NOMBRE) 
    {
        NodoProducto temp = cabeza;
        while (temp != null) 
        {
            if (temp.getProducto().getNombre().equalsIgnoreCase(NOMBRE)) 
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
    
     public NodoProducto getCabeza() 
    {
       return cabeza;
    }
     
    public Producto getProductoPorIndice(int indice) {
    NodoProducto actual = cabeza;
    int contador = 0;
    while (actual != null) {
        if (contador == indice) {
            return actual.getProducto();
        }
        actual = actual.getSiguiente();
        contador++;
    }
    return null;
    }
    
    public void reemplazarEnIndice(int indice, Producto nuevoProducto) {
    NodoProducto actual = cabeza;
    int contador = 0;
    while (actual != null) {
        if (contador == indice) {
            actual.setProducto(nuevoProducto);
            return;
        }
        actual = actual.getSiguiente();
        contador++;
    }
}


    
    // Guardar en archivo
    public void guardarEnArchivo() {
    try {
        String nombreEmpresa = DatosEmpresa.getNombreEmpresa();
        FileOutputStream archivo = new FileOutputStream("productos_" + nombreEmpresa + ".dat");
        ObjectOutputStream out = new ObjectOutputStream(archivo);
        out.writeObject(this); // guarda la lista completa
        out.close();
        archivo.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    
    
    
    // Cargar desde archivo
    public static ListaDobleProducto cargarDesdeArchivo() 
    {
    try {
        String nombreEmpresa = DatosEmpresa.getNombreEmpresa();
        FileInputStream archivo = new FileInputStream("productos_" + nombreEmpresa + ".dat");
        ObjectInputStream in = new ObjectInputStream(archivo);
        ListaDobleProducto lista = (ListaDobleProducto) in.readObject();
        in.close();
        archivo.close();
        return lista;
    } catch (IOException | ClassNotFoundException e) {
        return new ListaDobleProducto(); // si no existe el archivo, crea una lista vacía
    }
    }

}
