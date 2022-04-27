package com.epam.georgia.calc;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalculatorImplTest {

    Calculator calculator = new CalculatorImpl();

    @BeforeAll
    static void setup() {
        System.out.println("@BeforeAll - executes once before all test methods in this class");
    }

    @BeforeEach
    void init() {
        System.out.println("@BeforeEach - executes before each test method in this class");
    }

    @DisplayName("Single test successful")
    @Test
    void handle() {
        BigDecimal actualResult = calculator.handle(1d, 2d, 3d, 4d);
        assertEquals(new BigDecimal("11.00"),  actualResult);
    }

    @Test
    void handleTest2() {
        BigDecimal actualResult = calculator.handle(1d, 2d, 3d, 4d);
        assertTrue(new BigDecimal("11.00").equals(actualResult));
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach - executed after each test method.");
    }

    @AfterAll
    static void done() {
        System.out.println("@AfterAll - executed after all test methods.");
    }
}