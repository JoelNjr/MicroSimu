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
public class ListaDobleEmpleado implements Serializable {
    
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
        
        // Buscar empleado por id
    public Empleado buscar(String id) 
    {
        NodoEmpleado temp = cabeza;
        while (temp != null) 
        {
            if (temp.getEmpleado().getID().equalsIgnoreCase(id)) 
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
    
    public NodoEmpleado getCabeza() 
    {
       return cabeza;
    }
    
    // Guardar en archivo
    public void guardarEnArchivo() {
    try {
        String nombreEmpresa = DatosEmpresa.getNombreEmpresa();
        FileOutputStream archivo = new FileOutputStream("empleados_" + nombreEmpresa + ".dat");
        ObjectOutputStream out = new ObjectOutputStream(archivo);
        out.writeObject(this); // guarda la lista completa
        out.close();
        archivo.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    
    
    
    // Cargar desde archivo
    public static ListaDobleEmpleado cargarDesdeArchivo() 
    {
    try {
        String nombreEmpresa = DatosEmpresa.getNombreEmpresa();
        FileInputStream archivo = new FileInputStream("empleados_" + nombreEmpresa + ".dat");
        ObjectInputStream in = new ObjectInputStream(archivo);
        ListaDobleEmpleado lista = (ListaDobleEmpleado) in.readObject();
        in.close();
        archivo.close();
        return lista;
    } catch (IOException | ClassNotFoundException e) {
        return new ListaDobleEmpleado(); // si no existe el archivo, crea una lista vacía
    }
    }

  
}
