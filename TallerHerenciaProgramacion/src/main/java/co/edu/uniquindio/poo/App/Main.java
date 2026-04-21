package co.edu.uniquindio.poo.App;

import javax.swing.JOptionPane;
import co.edu.uniquindio.poo.Model.*;

public class Main {

    static Empresa empresa = new Empresa();

    public static void main(String[] args) {

        int opcion;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "1. Agregar Empleado planta\n2. Agregar Empleado ventas\n3. Agregar Empleado temporal\n4. Mostrar Empleados\n5. Buscar Empleado por documento\n6. Buscar Empleado con Mayor salario\n7. Mostrar Nómina total\n8. Resúmenes de los Empleados \n9. Salir del Programa"));

            switch (opcion) {
                case 1 -> agregarPlanta();
                case 2 -> agregarVentas();
                case 3 -> agregarTemporal();
                case 4 -> empresa.mostrarTodos();
                case 5 -> empresa.buscarPorDocumento(JOptionPane.showInputDialog("Documento"));
                case 6 -> empresa.mostrarEmpleadoConMayorSalario();
                case 7 -> empresa.calcularNominaTotal();
                case 8 -> empresa.mostrarResumenesPago();
            }

        } while (opcion != 9);
    }

    static void agregarPlanta() {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre");
            String doc = JOptionPane.showInputDialog("Documento");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad"));
            float salario = Float.parseFloat(JOptionPane.showInputDialog("Salario"));
            CategoriaEmpleado cat = CategoriaEmpleado.valueOf(JOptionPane.showInputDialog("Categoría").toUpperCase());
            float salud = Float.parseFloat(JOptionPane.showInputDialog("Salud %"));
            float pension = Float.parseFloat(JOptionPane.showInputDialog("Pensión %"));
            String cargo = JOptionPane.showInputDialog("Cargo");
            int horas = Integer.parseInt(JOptionPane.showInputDialog("Horas extra"));
            float vHora = Float.parseFloat(JOptionPane.showInputDialog("Valor hora"));
            float aux = Float.parseFloat(JOptionPane.showInputDialog("Auxilio"));

            empresa.agregarEmpleado(new EmpleadoPlanta(
                    nombre, doc, edad, salario, cat,
                    salud, pension, cargo, horas, vHora, aux));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    static void agregarVentas() {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre");
            String doc = JOptionPane.showInputDialog("Documento");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad"));
            float salario = Float.parseFloat(JOptionPane.showInputDialog("Salario"));
            CategoriaEmpleado cat = CategoriaEmpleado.valueOf(JOptionPane.showInputDialog("Categoría").toUpperCase());
            float salud = Float.parseFloat(JOptionPane.showInputDialog("Salud %"));
            float pension = Float.parseFloat(JOptionPane.showInputDialog("Pensión %"));
            float ventas = Float.parseFloat(JOptionPane.showInputDialog("Ventas"));
            float comision = Float.parseFloat(JOptionPane.showInputDialog("Comisión %"));

            empresa.agregarEmpleado(new EmpleadoVentas(
                    nombre, doc, edad, salario, cat,
                    salud, pension, ventas, comision));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    static void agregarTemporal() {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre");
            String doc = JOptionPane.showInputDialog("Documento");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad"));
            float salario = Float.parseFloat(JOptionPane.showInputDialog("Salario"));
            CategoriaEmpleado cat = CategoriaEmpleado.valueOf(JOptionPane.showInputDialog("Categoría").toUpperCase());
            float salud = Float.parseFloat(JOptionPane.showInputDialog("Salud %"));
            float pension = Float.parseFloat(JOptionPane.showInputDialog("Pensión %"));
            int dias = Integer.parseInt(JOptionPane.showInputDialog("Días"));
            float vDia = Float.parseFloat(JOptionPane.showInputDialog("Valor día"));

            empresa.agregarEmpleado(new EmpleadoTemporal(
                    nombre, doc, edad, salario, cat,
                    salud, pension, dias, vDia));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}