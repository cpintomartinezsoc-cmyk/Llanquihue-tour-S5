package cl.duoc.llanquihue.model;

public class Persona {
    private String rut;
    private String nombre;
    private String telefono;
    private Direccion direccion;

    public Persona(String rut, String nombre, String telefono, Direccion direccion) {
        this.rut = rut;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public Direccion getDireccion() { return direccion; }
    public void setDireccion(Direccion direccion) { this.direccion = direccion; }

    @Override
    public String toString() {
        return rut + "," + nombre + "," + telefono + "," + direccion;
    }
}