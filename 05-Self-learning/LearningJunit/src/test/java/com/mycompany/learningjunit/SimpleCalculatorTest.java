/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.learningjunit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author prashnamshrestha
 */
public class SimpleCalculatorTest {
    
    @Test
    public void testAdd() {
        var calculator = new SimpleCalculator();
        
        int result = calculator.add(5, 7);
        
        assertEquals(12, result, "5 + 7 should equal to 12");
    }
    
}
