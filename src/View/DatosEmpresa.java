/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

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

/**
 *
 * @author User
 */
public class DatosEmpresa {
    public static String nombreEmpresa;
    public static ListaDobleEmpleado listaEmpleados = new ListaDobleEmpleado();
    public static ListaDobleProducto listaProductos = new ListaDobleProducto();
    public static ColaTransaccion colaTransacciones = new ColaTransaccion();


    public static void setNombreEmpresa(String nombreEmpresa) {
        DatosEmpresa.nombreEmpresa = nombreEmpresa;
        
    listaEmpleados.cargarDesdeArchivo();      
    listaProductos.cargarDesdeArchivo();      
    colaTransacciones.cargarDesdeArchivo(); 
    }
    
    

    public static void guardarDatos() {
        listaEmpleados.guardarEnArchivo();
        listaProductos.guardarEnArchivo();
        colaTransacciones.guardarEnArchivo();
    }
    
    

     public static String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public static ListaDobleEmpleado getListaEmpleados() {
        return listaEmpleados;
    }

    public static void setListaEmpleados(ListaDobleEmpleado listaEmpleados) {
        DatosEmpresa.listaEmpleados = listaEmpleados;
    }

    public static ListaDobleProducto getListaProductos() {
        return listaProductos;
    }

    public static void setListaProductos(ListaDobleProducto listaProductos) {
        DatosEmpresa.listaProductos = listaProductos;
    }

    public static ColaTransaccion getColaTransacciones() {
        return colaTransacciones;
    }

    public static void setColaTransacciones(ColaTransaccion colaTransacciones) {
        DatosEmpresa.colaTransacciones = colaTransacciones;
    }
     
     
    
}
