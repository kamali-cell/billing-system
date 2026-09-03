package com.billing;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void testCalculateBill() {
        App app = new App();
        // Basic plan check: $15 base + (12GB - 10GB limit) * $2 = $19.00
        assertEquals(19.00, app.calculateBill("basic", 12.0), 0.01);
    }
}
