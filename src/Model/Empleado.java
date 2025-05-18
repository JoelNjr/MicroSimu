
//MicroSimu
//@joel.vasquez
package Model;

public class Empleado {
    
    //Encapsulamiento: Atributos privados solo accesibles por getters/setters
    private String nombre;
    private String ID;
    private String cargo;
    private double salario;
    
    
    // Abstracción: Constructor simplifica la creación del objeto
    public Empleado(String nombre, String ID, String cargo, double salario) 
    {
        this.nombre = nombre;
        this.ID = ID;
        this.cargo = cargo;
        this.salario = salario;
    }
    
    //Encapsulamiento: Acceso controlado a los atributos

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    //Abstracción: toString() muestra la información útil del objeto
    @Override
    public String toString() {
        return "Empleado{" +
                "ID='" + ID + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Cargo='" + cargo + '\'' +
                ", Salario=" + salario +
                '}';
    }
}
