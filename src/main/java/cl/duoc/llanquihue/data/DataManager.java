package cl.duoc.llanquihue.data;

import cl.duoc.llanquihue.model.Direccion;
import cl.duoc.llanquihue.model.Empleado;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static final String FILE_PATH = "empleados.txt";

    public void guardarEmpleados(List<Empleado> lista) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Empleado emp : lista) {
                writer.write(emp.toString() + "\n");
            }
            System.out.println("Datos guardados" + FILE_PATH);
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public List<Empleado> cargarEmpleados() {
        List<Empleado> lista = new ArrayList<>();
        File archivo = new File(FILE_PATH);
        if (!archivo.exists()) {
            return lista;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 5) {
                    String[] datosDireccion = partes[3].split(";");
                    Direccion dir = new Direccion(
                            datosDireccion[0],
                            Integer.parseInt(datosDireccion[1].trim()),
                            datosDireccion[2]
                    );
                    Empleado emp = new Empleado(partes[0], partes[1], partes[2], dir, partes[4]);
                    lista.add(emp);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al cargar los datos : " + e.getMessage());
        }
        return lista;
    }
}