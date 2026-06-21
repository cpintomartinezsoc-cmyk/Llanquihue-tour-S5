package cl.duoc.llanquihue.app;

import cl.duoc.llanquihue.data.DataManager;
import cl.duoc.llanquihue.model.Direccion;
import cl.duoc.llanquihue.model.Empleado;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataManager dataManager = new DataManager();

        List<Empleado> listaEmpleados = dataManager.cargarEmpleados();

        if (listaEmpleados.isEmpty()) {
            System.out.println("Archivo vacío o no encontrado. Inicializando base de datos de Llanquihue Tour...");
            Direccion dir1 = new Direccion("San Francisco", 312, "Llanquihue");
            Direccion dir2 = new Direccion("Tremmer", 453, "Puerto Varas");
            listaEmpleados.add(new Empleado("14232042-k", "Carlos Soto", "99495145", dir1, "Guia Volcan"));
            listaEmpleados.add(new Empleado("17555432-1", "Ana Gomez", "988776655", dir2, "Guia Lacustre"));
            listaEmpleados.add(new Empleado("19222333-4", "Juan Perez", "911223344", dir1, "Guia Volcan"));
            dataManager.guardarEmpleados(listaEmpleados);
        }


        System.out.println("Empleados Llanquihue Tour ");

        for (Empleado emp : listaEmpleados) {
            System.out.println("Nombre: " + emp.getNombre() +
                    " | Cargo: " + emp.getCargo() +
                    " | Ciudad: " + emp.getDireccion().getCiudad());
        }

        String cargoBuscar = "Guia Volcan";

        System.out.println("Busqueda: " + cargoBuscar.toUpperCase());

        boolean encontrado = false;
        for (Empleado emp : listaEmpleados) {
            if (emp.getCargo().equalsIgnoreCase(cargoBuscar)) {
                System.out.println("Nombre: " + emp.getNombre() + "Telefono: " + emp.getTelefono() + "]");
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró personal: " + cargoBuscar);
        }
    }
}