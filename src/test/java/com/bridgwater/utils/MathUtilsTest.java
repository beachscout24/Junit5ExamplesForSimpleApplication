package com.bridgwater.utils;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@DisplayName("Tests for Math Utils")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MathUtilsTest {

    private MathUtils mathUtils;

    @BeforeEach
    void setUp(TestInfo testInfo, TestReporter testReporter) {
        mathUtils = new MathUtils();
        testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tag " + testInfo.getTags());
    }

    @Nested
    @Tag("Math")
    @DisplayName("When addition is applied then result should be summation of numbers")
    class AdditionTest{
        @Test
        @DisplayName("When you add 2 numbers then return sum should be 5")
        void testAddMethod() {
            assertEquals(5, mathUtils.add(4, 1), () -> "The numbers should equal 5");
        }

        @Test
        @DisplayName("When you add 1 positive number and 1 negative number then return sum should be 12")
        void testAddPositiveAndNegativeNumbersMethod() {
            assertEquals(12, mathUtils.add(13, -1), () -> "The numbers should equal 12");
        }

        @Test
        @DisplayName("When you add 2 negative numbers then return sum should be -5")
        void testAddNegativeNumbersMethod() {
            assertEquals(-5, mathUtils.add(-4, -1), () -> "The numbers should equal -5");
        }
    }

    @Nested
    @Tag("Math")
    @DisplayName("When subtraction is applied then result should be subtraction of numbers")
    class SubtractionTests{
        @Test
        @DisplayName("When you subtract 2 positive numbers then the result should be 6")
        void testSubtractMethod() {
            assertEquals(6, mathUtils.subtract(18,12), () -> "The subtraction of 2 numbers should be 6");
        }

        @Test
        @DisplayName("When you subtract 1 positive number and 1 negative number then return sum should be 14")
        void testSubtractPostiveAndNegativeNumbersMethod() {
            assertEquals(14, mathUtils.subtract(13, -1), () -> "The numbers should equal 14");
        }

        @Test
        @DisplayName("When you subtract 2 negative numbers then return subtraction should be -1")
        void testAddNegativeNumbersMethod() {
            assertEquals(-1, mathUtils.subtract(-12, -11), () -> "The numbers should equal -1");
        }

    }

    @Test
    @Tag("Math")
    @DisplayName("Tests for all scenarios of multiplication")
    void testMultiplyMethod() {
                assertAll(
                () -> assertEquals(9216, mathUtils.multiply(96,96), () -> "The multiplication of 2 positive numbers should be 9216"),
                () -> assertEquals(0, mathUtils.multiply(0,96), () -> "The multiplication of 2 numbers and one number is zero should be 0"),
                () -> assertEquals(2, mathUtils.multiply(-2,-1), () -> "The multiplication of 2 negative numbers should be 2")
        );
    }

    @Nested
    @Tag("Math")
    @DisplayName("When division is applied then result should be division of the numbers")
    class DivisionTests{
        @Test
        @DisplayName("When you divide 2 positive numbers then the result should be 6")
        void testDivideMethod() {
            assertEquals(6, mathUtils.divide(36,6), () -> "The division of 2 numbers should be 6");
        }

        @Test
        @DisplayName("When you divide 2 positive numbers then the result should be -6")
        void testDividePostiveAndNegativeNumbersMethod() {
            assertEquals(-6, mathUtils.divide(-30,5), () -> "The division of 2 numbers should be -6");
        }

        @Test
        @DisplayName("When you divide 2 negative numbers then the result should be 5")
        void testDivideNegativeNumbersMethod() {
            assertEquals(5, mathUtils.divide(-30,-6), () -> "The division of 2 numbers should be 5");
        }

        @Test
        @DisplayName("When you divide by zero then the result should be ArithmeticException")
        void testDivideByZeroMethod() {
            assumeTrue(true);
            assertThrows(ArithmeticException.class, () -> mathUtils.divide(5,0), () -> "The division by zero should throw ArithmeticException");
        }
    }

    @Nested
    @Tag("Circle")
    @DisplayName("When a radius is given then the result is the circumference")
    class circumferenceTests {

        @ParameterizedTest(name = "Radius of {0} returns circumference of {0} squared times PI.")
        @ValueSource(ints = {-2, 0, 10})
        void testComputeCircleArea(Integer number) {
            BigDecimal actual = new BigDecimal(number);
            actual = actual.multiply(new BigDecimal(Math.PI)).multiply(new BigDecimal(number));
            BigDecimal finalActual = actual;
            assertEquals(actual, mathUtils.computeCircleArea(BigDecimal.valueOf(number)), () -> "The area should equal " + finalActual);
        }
    }

    @AfterEach
    void tearDown(){
        mathUtils = null;
    }
}