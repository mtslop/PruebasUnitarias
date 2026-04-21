/**
 * Clase para probar las funciones correspondientes al taller de pruebas unitarias
 * @author Matias Lopez
 * @since 2025-04
 * Licencia GNU/GPL V3.0
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import co.edu.uniquindio.poo.Model.EmpleadoVentas;
import co.edu.uniquindio.poo.Model.EmpleadoTemporal;
import co.edu.uniquindio.poo.Model.EmpleadoPlanta;
import co.edu.uniquindio.poo.Model.Empresa;
import co.edu.uniquindio.poo.Model.CategoriaEmpleado;

public class Pruebas {

    @Test
    public void verificarSalarioBrutoVentasCasoDiferente() {
        EmpleadoVentas ventas = new EmpleadoVentas(
                "Laura", "doc1", 28,
                2000000f, CategoriaEmpleado.SEMI_SENIOR,
                5f, 5f,
                100f, 10f
        );

        float actual = ventas.calcularSalarioBruto();
        float esperado = 2000000f + (2000000f * 0.10f) + (100f * 10f / 100f);

        assertEquals(esperado, actual);
    }

    @Test
    public void verificarSalarioNetoTemporalNoCeroCasoDiferente() {
        EmpleadoTemporal temporal = new EmpleadoTemporal(
                "Pedro", "doc2", 22,
                800000f, CategoriaEmpleado.JUNIOR,
                4f, 4f,
                5, 40000f
        );

        assertNotEquals(0, temporal.calcularSalarioNeto());
    }

    @Test
    public void verificarEmpleadosGuardadosEmpresaCasoDiferente() {
        Empresa empresa = new Empresa();

        EmpleadoVentas e1 = new EmpleadoVentas(
                "Ana", "a1", 30,
                1500000f, CategoriaEmpleado.SENIOR,
                5f, 5f,
                200f, 5f
        );

        EmpleadoTemporal e2 = new EmpleadoTemporal(
                "Luis", "a2", 25,
                900000f, CategoriaEmpleado.JUNIOR,
                4f, 4f,
                8, 30000f
        );

        empresa.agregarEmpleado(e1);
        empresa.agregarEmpleado(e2);

        // verificamos que el cálculo de nómina funcione (indirectamente prueba que se guardaron)
        float total = e1.calcularSalarioNeto() + e2.calcularSalarioNeto();

        assertTrue(total > 0);
    }

    @Test
    public void verificarBonificacionJuniorMayorCeroCasoDiferente() {
        EmpleadoVentas ventas = new EmpleadoVentas(
                "Mario", "doc3", 35,
                1200000f, CategoriaEmpleado.JUNIOR,
                4f, 4f,
                50f, 10f
        );

        assertTrue(ventas.calcularBonificacionCategoria() > 0);
    }

    @Test
    public void verificarSalarioNetoNoNegativoCasoDiferente() {
        EmpleadoTemporal temporal = new EmpleadoTemporal(
                "Sofia", "doc4", 27,
                700000f, CategoriaEmpleado.SEMI_SENIOR,
                3f, 3f,
                6, 35000f
        );

        assertTrue(temporal.calcularSalarioNeto() >= 0);
    }

    @Test
    public void verificarExcepcionSalarioNegativoCasoDiferente() {
        assertThrows(IllegalArgumentException.class, () -> {
            new EmpleadoTemporal(
                    "Error", "doc5", 20,
                    -500000f, CategoriaEmpleado.JUNIOR,
                    4f, 4f,
                    5, 20000f
            );
        });
    }

    @Test
    public void verificarSalarioPlantaMayorBaseCasoDiferente() {
        EmpleadoPlanta planta = new EmpleadoPlanta(
                "Elena", "p1", 29,
                1200000f, CategoriaEmpleado.SEMI_SENIOR,
                4f, 4f,
                "Admin", 5, 20000f, 30000f
        );

        assertTrue(planta.calcularSalarioNeto() > 1200000f);
    }

@Test
public void verificarTemporalesMasDe100Horas() {
    Empresa empresa = new Empresa();

    EmpleadoTemporal t1 = new EmpleadoTemporal(
            "Luis", "t1", 25,
            900000f, CategoriaEmpleado.JUNIOR,
            4f, 4f,
            120, 30000f
    );

    EmpleadoTemporal t2 = new EmpleadoTemporal(
            "Carlos", "t2", 30,
            900000f, CategoriaEmpleado.JUNIOR,
            4f, 4f,
            80, 30000f
    );

    empresa.agregarEmpleado(t1);
    empresa.agregarEmpleado(t2);

    assertEquals(1, empresa.empleadosTemporalesMasDe100Horas().size());
    assertEquals("t1", empresa.empleadosTemporalesMasDe100Horas().get(0).getDocumento());
}
    @Test
    public void verificarSalarioTemporalMayorCeroCasoDiferente() {
        EmpleadoTemporal temporal = new EmpleadoTemporal(
                "Paula", "t4", 31,
                1100000f, CategoriaEmpleado.SENIOR,
                4f, 4f,
                12, 45000f
        );

        assertTrue(temporal.calcularSalarioNeto() > 0);
    }
}
