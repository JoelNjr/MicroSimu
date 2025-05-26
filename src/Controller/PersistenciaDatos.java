/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Empresa;
import java.io.*;

/**
 *
 * @author joel.vasquez
 */
public class PersistenciaDatos {

    private static final String ARCHIVO_EMPRESA = "empresa.dat";

    public static void guardarEmpresa(Empresa empresa) 
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_EMPRESA))) {
            oos.writeObject(empresa);
            System.out.println("Empresa guardada correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar la empresa:");
            e.printStackTrace();
        }
    }

    public static Empresa cargarEmpresa() 
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_EMPRESA))) {
            return (Empresa) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se pudo cargar empresa, creando nueva...");
            return new Empresa("Mi Empresa");
        }
    }
}