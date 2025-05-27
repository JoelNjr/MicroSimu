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


    public static void setNombreEmpresa(String nombreEmpresa) {
        DatosEmpresa.nombreEmpresa = nombreEmpresa;
    }
    
    public static ListaDobleEmpleado listaEmpleados = ListaDobleEmpleado.cargarDesdeArchivo();

    public static void guardarDatos() {
        listaEmpleados.guardarEnArchivo();
    }
    
    public static ListaDobleProducto listaProductos = new ListaDobleProducto();
    public static ColaTransaccion colaTransacciones = new ColaTransaccion();

     public static String getNombreEmpresa() {
        return nombreEmpresa;
    }
    
}
