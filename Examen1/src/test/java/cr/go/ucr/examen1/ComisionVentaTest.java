package cr.go.ucr.examen1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComisionVentaTest {

    // Pruebas de Caja Negra
    @Test
    void testClaseValida1() {
        Double resultado = ComisionVenta.getCurrentInstance().calcular(500.00);
        assertEquals(15.00, resultado, 0.01); // 3% de 500
    }

    @Test
    void testClaseValida2() {
        Double resultado = ComisionVenta.getCurrentInstance().calcular(3000.00);
        assertEquals(210.00, resultado, 0.01); // 7% de 3000
    }

    @Test
    void testClaseInvalida1() {
        Double resultado = ComisionVenta.getCurrentInstance().calcular(-100.00);
        assertEquals(-1.0, resultado, 0.01); // Valor fuera del rango
    }

    // Pruebas de Caja Blanca
    @Test
    void testClaseInvalida2() {
        Double resultado = ComisionVenta.getCurrentInstance().calcular(100000.01);
        assertEquals(-1.0, resultado, 0.01); // Valor fuera del rango superior
    }

    @Test
    void testRango12Porciento() {
        Double resultado = ComisionVenta.getCurrentInstance().calcular(10000.00); 
        assertEquals(1200.00, resultado, 0.01); // 12% de 10000
    }

    @Test
    void testRango15Porciento() {
        Double resultado = ComisionVenta.getCurrentInstance().calcular(20000.00);
        assertEquals(3000.00, resultado, 0.01); // 15% de 20000
    }

    // Tests solo para tener más cobertura
    @Test
    void testMain() {
        String[] args = {};
        ComisionVenta.main(args);
    }

    @Test
    void testSettersAndGettersRango() {
        Rango rango = new Rango(0.0, 1000.0, 3.0);

        rango.setMenor(200.0);
        assertEquals(200.0, rango.getMenor());

        rango.setMayor(2000.0);
        assertEquals(2000.0, rango.getMayor());

        rango.setValor(5.0);
        assertEquals(5.0, rango.getValor());
    }
}
