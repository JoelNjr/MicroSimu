/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.ListaDobleEmpleado;
import Controller.ListaDobleProducto;
import Controller.ColaTransaccion;

/**
 *
 * @author User
 */

public class Empresa {
    
    private String nombre;
    private ListaDobleEmpleado empleados;
    private ListaDobleProducto productos;
    private ColaTransaccion transacciones;
    
    public Empresa (String nombre)
    {
        this.nombre = nombre;
        this.empleados = new ListaDobleEmpleado();
        this.productos = new ListaDobleProducto();
        this.transacciones = new ColaTransaccion();
    }
    
    //Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaDobleEmpleado getEmpleados() {
        return empleados;
    }

    public ListaDobleProducto getProductos() {
        return productos;
    }

    public ColaTransaccion getTransacciones() {
        return transacciones;
    }
    
    // ==========================
    // Funcionalidades
    // ==========================
    
        public void registrarEmpleado(Empleado empleado) {
        empleados.AgregarEmpleado(empleado);
    }

    public void registrarProducto(Producto producto) {
        productos.AgregarProducto(producto);
    }

    public void registrarTransaccion(Transaccion transaccion) {
        transacciones.encolar(transaccion);
    }

    public void mostrarEmpleados() {
        empleados.mostrar();
    }

    public void mostrarProductos() {
        productos.mostrar();
    }

    public void mostrarTransacciones() {
        transacciones.mostrarTransacciones();
    }
    
    
    
}
