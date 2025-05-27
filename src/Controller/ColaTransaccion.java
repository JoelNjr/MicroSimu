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
    
    public NodoTransaccion getPrimero() 
    {
       return primero;
    }
    
    // Guardar en archivo
    public void guardarEnArchivo() {
    try {
        String nombreEmpresa = DatosEmpresa.getNombreEmpresa();
        FileOutputStream archivo = new FileOutputStream("transacciones_" + nombreEmpresa + ".dat");
        ObjectOutputStream out = new ObjectOutputStream(archivo);
        out.writeObject(this); // guarda la lista completa
        out.close();
        archivo.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    
    
    
    // Cargar desde archivo
    public static ColaTransaccion cargarDesdeArchivo() 
    {
    try {
        String nombreEmpresa = DatosEmpresa.getNombreEmpresa();
        FileInputStream archivo = new FileInputStream("transacciones_" + nombreEmpresa + ".dat");
        ObjectInputStream in = new ObjectInputStream(archivo);
        ColaTransaccion cola = (ColaTransaccion) in.readObject();
        in.close();
        archivo.close();
        return cola;
    } catch (IOException | ClassNotFoundException e) {
        return new ColaTransaccion(); // si no existe el archivo, crea una lista vacía
    }
    }
}