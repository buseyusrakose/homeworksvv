// Buse Yüsra Köse
// b211202026
// software verification and validation
//create a parameterized test using junit5 that test all the values tested by testDivision1,
// testDivision2,testDivision3,testDivision4,testDivision5 methods.
//https://github.com/buseyusrakose/homeworksvv.git

package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "10, 2, 5",
            "10, 4, 2.5",
            "12.5, 2.5, 5",
            "10, 2.5, 4",
            "12.5, 5, 2.5"
    })
    void testDivision(float numerator, float denominator, float expectedResult) {
        assertEquals(expectedResult, Calculator.divide(numerator, denominator));
    }

    @Test
    void testDivision6() {
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> Calculator.divide(12.5f, 0),
                "IllegalArgumentException expected."
        );

        // Optional. To check whether the error messages match.
        assertEquals("Illegal Argument Exception.", exception.getMessage());
    }
}

