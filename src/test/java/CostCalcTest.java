import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CostCalcTest {
    double consumption = (5/100.0);

    @Test
    void calculateCost() {
        double distance = 100;
        double price = 1.5;
        assertEquals(7.5, CostCalc.calculateCost(consumption, distance, price), 0.01, "Cost must be calculated.");
    }

    @Test
    void calculateFuelNeeded() {
        double distance = 100;
        assertEquals(5, CostCalc.calculateFuelNeeded(consumption, distance), 0.01, "Fuel needed must be calculated.");
    }
}