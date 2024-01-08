/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitnesstracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mnrf
 */
public class FitnessTrackerTest {
    
    public FitnessTrackerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class FitnessTracker.
     *//*
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        FitnessTracker.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of clrscr method, of class FitnessTracker.
     */
    @Test
    public void testClrscr() {
        System.out.println("clrscr");
        //FitnessTracker.clrscr();
        short expResult = 0;
        short result = FitnessTracker.clrscr();
        System.out.print(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of calcCurrentBMI method, of class FitnessTracker.
     */
    @Test
    public void testCalcCurrentBMI() {
        System.out.println("calcCurrentBMI");
        double currentWeight = 75;
        double height = 168;
        double expResult = 26.57;
        double result = FitnessTracker.calcCurrentBMI(currentWeight, height);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of BMICategory method, of class FitnessTracker.
     */
    @Test
    public void testBMICategory() {
        System.out.println("BMICategory");
        double currentBMI = 24;
        String expResult = "Normal";
        String result = FitnessTracker.BMICategory(currentBMI);
        assertEquals(expResult, result);
    }

    /**
     * Test of bufferFinder method, of class FitnessTracker.
     */
    @Test
    public void testBufferFinder() {
        System.out.println("bufferFinder");
        double targetWeight = 75;
        double bufferBMI = 26.57;
        double targetBMI = 24;
        double height = 168;
        double expResult = 67.74;
        double result = FitnessTracker.bufferFinder(targetWeight, bufferBMI, targetBMI, height);
        assertEquals(expResult, result, 0.01);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of currentBMRCalc method, of class FitnessTracker.
     */
    @Test
    public void testCurrentBMRCalc() {
        System.out.println("currentBMRCalc");
        String gender = "M";
        double currentWeight = 75;
        double height = 168;
        double age = 17;
        double expResult = 1761.43;
        double result = FitnessTracker.currentBMRCalc(gender, currentWeight, height, age);
        assertEquals(expResult, result, 0.01);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of targetBMRCalc method, of class FitnessTracker.
     */
    @Test
    public void testTargetBMRCalc() {
        System.out.println("targetBMRCalc");
        String gender = "M";
        double targetWeight = 56.45;
        double height = 168;
        double age = 17;
        double expResult = 1544.42;
        double result = FitnessTracker.targetBMRCalc(gender, targetWeight, height, age);
        assertEquals(expResult, result, 0.01);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of activityChoose method, of class FitnessTracker.
     */
    @Test
    public void testActivityChoose() {
        System.out.println("activityChoose");
        double currentBMR = 2000;
        int activityLevel = 1;
        double expResult = 2400;
        double result = FitnessTracker.activityChoose(currentBMR,activityLevel);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of activityChoose2 method, of class FitnessTracker.
     */
    @Test
    public void testActivityChoose2() {
        System.out.println("activityChoose2");
        double currentBMR = 2000;
        int activityLevel = 1;
        double expResult = 2400;
        double result = FitnessTracker.activityChoose2(currentBMR,activityLevel);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of currentRateCalc method, of class FitnessTracker.
     */
    @Test
    public void testCurrentRateCalc() {
        System.out.println("currentRateCalc");
        double currentCalorieIntake = 2200;
        double currentBMR = 2550;
        double targetBMR = 1780;
        double expResult = 0;
        double result = FitnessTracker.currentRateCalc(currentCalorieIntake, currentBMR, targetBMR);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of averageRateCalc method, of class FitnessTracker.
     */
    @Test
    public void testAverageRateCalc() {
        System.out.println("averageRateCalc");
        double targetCalorieIntake = 2000;
        double targetBMR = 1780;
        double currentBMR = 2550;
        double currentWeight = 75;
        double targetWeight = 57;
        FitnessTracker.averageRateCalc(targetCalorieIntake, targetBMR, currentBMR, currentWeight, targetWeight);
    }

    /**
     * Test of currentCalorieRateCalc method, of class FitnessTracker.
     */
    @Test
    public void testCurrentCalorieRateCalc() {
        System.out.println("currentCalorieRateCalc");
        double currentCalorieIntake = 2200;
        double currentBMR = 2550;
        double expResult = -350;
        double result = FitnessTracker.currentCalorieRateCalc(currentCalorieIntake, currentBMR);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of currentWeightRateCalc method, of class FitnessTracker.
     */
    @Test
    public void testCurrentWeightRateCalc() {
        System.out.println("currentWeightRateCalc");
        double currentCalorieRate = -350;
        double expResult = -0.0455;
        double result = FitnessTracker.currentWeightRateCalc(currentCalorieRate);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of averageBMRCalc method, of class FitnessTracker.
     */
    @Test
    public void testAverageBMRCalc() {
        System.out.println("averageBMRCalc");
        double targetBMR = 1780;
        double currentBMR = 2550;
        double expResult = 2165;
        double result = FitnessTracker.averageBMRCalc(targetBMR, currentBMR);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of averageCalorieRateCalc method, of class FitnessTracker.
     */
    @Test
    public void testAverageCalorieRateCalc() {
        System.out.println("averageCalorieRateCalc");
        double targetCalorieIntake = 2000;
        double averageBMR = 2165;
        double expResult = -165;
        double result = FitnessTracker.averageCalorieRateCalc(targetCalorieIntake, averageBMR);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of averageWeightRateCalc method, of class FitnessTracker.
     */
    @Test
    public void testAverageWeightRateCalc() {
        System.out.println("averageWeightRateCalc");
        double averageCalorieRate = -165;
        double expResult = -0.021;
        double result = FitnessTracker.averageWeightRateCalc(averageCalorieRate);
        assertEquals(expResult, result, 0.01);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of timeToReduceWeightCalc method, of class FitnessTracker.
     */
    @Test
    public void testTimeToReduceWeightCalc() {
        System.out.println("timeToReduceWeightCalc");
        double currentWeight = 75;
        double targetWeight = 56.45;
        double averageWeightRate = -0.047;
        double expResult = -394.68;
        double result = FitnessTracker.timeToReduceWeightCalc(currentWeight, targetWeight, averageWeightRate);
        assertEquals(expResult, result, 0.01);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
