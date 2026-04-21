package co.edu.uniquindio.poo.Model;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Empleado> empleados = new ArrayList<>();

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        System.out.println("Empleado registrado: " + empleado.nombre);
    }

    public void mostrarTodos() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados");
            return;
        }
        for (Empleado empleado : empleados) {
            empleado.mostraInformacion();
        }
    }

    public void buscarPorDocumento(String documento) {
        for (Empleado empleado : empleados) {
            if (empleado.documento.equals(documento)) {
                empleado.mostraInformacion();
                return;
            }
        }
        System.out.println("No se encontró empleado");
    }

    public void mostrarEmpleadoConMayorSalario() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados");
            return;
        }

        Empleado mayor = empleados.get(0);

        for (Empleado empleado : empleados) {
            if (empleado.getSalarioNeto() > mayor.getSalarioNeto()) {
                mayor = empleado;
            }
        }

        System.out.println("Empleado con mayor salario:");
        mayor.mostraInformacion();
    }

    public void calcularNominaTotal() {
        float total = 0;
        for (Empleado empleado : empleados) {
            total += empleado.calcularSalarioNeto();
        }
        System.out.println("Nomina total: " + total);
    }

    public List<EmpleadoTemporal> empleadosTemporalesMasDe100Horas() {
    List<EmpleadoTemporal> lista = new ArrayList<>();

    for (Empleado empleado : empleados) {
        if (empleado instanceof EmpleadoTemporal temporal) {
            if (temporal.diasTrabajados > 100) {
                lista.add(temporal);
            }
        }
    }

    return lista;
}

    public void mostrarResumenesPago() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados");
            return;
        }

        for (Empleado empleado : empleados) {
            ResumenPago r = empleado.generarResumenPago();
            System.out.println("Documento :" + r.documento());
            System.out.println("Nombre    :" + r.nombre());
            System.out.println("Tipo      :" + r.tipoEmpleado());
            System.out.println("Bruto     :" + r.salarioBruto());
            System.out.println("Descuento :" + r.descuentos());
            System.out.println("Neto      :" + r.salarioNeto());
            System.out.println("----------------------");
        }
    }
}
