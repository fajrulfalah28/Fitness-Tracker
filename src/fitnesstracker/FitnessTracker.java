/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitnesstracker;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author fajru
 */
public class FitnessTracker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        clrscr();
  
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your gender (M/F): ");
        String gender = scanner.nextLine();

        System.out.print("Enter your age: ");
        double age = scanner.nextDouble();

        System.out.print("Enter your weight (kg): ");
        double currentWeight = scanner.nextDouble();

        System.out.print("Enter your height (cm): ");
        double height = scanner.nextDouble();
        
        double currentBMI = calcCurrentBMI(currentWeight, height);

        clrscr();
        
        System.out.println("Your current BMI is: " + numberFormat.format(currentBMI) + "kg/m^2");
        
        String bmiCategory = BMICategory(currentBMI);
        
        System.out.println("You categorized as: " + bmiCategory);
        System.out.println("BMI Reference: \n   Severe Thinness: < 16\n   Moderate Thinnes: 16 to 17\n   Mild Thinnes 17 to 18.5\n   Normal: 18.5 to 25\n   Overweight: 25 to 30\n   Obese Class I: 30 to 35\n   Obese Class II: 35 to 40\n   Obese Class III: > 40");

        
        System.out.print("\nPlanning to lower your BMI? (Y/N): ");
        String planOption = scanner.nextLine();
        planOption = scanner.nextLine();
        
        clrscr();
        
        if (planOption.equals("Y"))
        {
            System.out.println("Your current BMI is: " + numberFormat.format(currentBMI) + "kg/m^2");
            System.out.println("BMI Reference: \n   Severe Thinness: < 16\n   Moderate Thinnes: 16 to 17\n   Mild Thinnes 17 to 18.5\n   Normal: 18.5 to 25\n   Overweight: 25 to 30\n   Obese Class I: 30 to 35\n   Obese Class II: 35 to 40\n   Obese Class III: > 40");
            System.out.print("\nInput your target BMI: ");
            double targetBMI = scanner.nextDouble();
            clrscr();
            double targetWeight = currentWeight;
            double bufferBMI = currentBMI;
            
            targetWeight = bufferFinder(targetWeight, bufferBMI, targetBMI, height);
            System.out.println("Current Weight: " + currentWeight );
            System.out.println("Target Weight: " + numberFormat.format(targetWeight) );
            System.out.println("To reach your Target BMI, you need to reduce weight of " + numberFormat.format(currentWeight - targetWeight) );
            
            System.out.print("\nTo Reach your target weight, you should be in calorie deficit by reducing your calorie input or increasing your calorie output. \nPlease input your daily calorie intake: " );
            double currentCalorieIntake = scanner.nextDouble();
            
            double currentBMR = currentBMRCalc(gender, currentWeight, height, age);
            double targetBMR = targetBMRCalc(gender, targetWeight, height, age);
            
            System.out.println("\nActivity level:");
            System.out.println("1. Sedentary (little or no exercise)");
            System.out.println("2. Lightly active (light exercise or sports 1-3 days a week)");
            System.out.println("3. Moderately active (moderate exercise or sports 3-5 days a week)");
            System.out.println("4. Very active (hard exercise or sports 6-7 days a week)");
            System.out.println("5. Super active (very hard exercise or sports, physical job or training twice a day)");

            System.out.print("Enter your activity level(1 to 5): ");
            
            int activityLevel = scanner.nextInt();
            currentBMR = activityChoose(currentBMR,activityLevel);
            
            clrscr();

            currentRateCalc(currentCalorieIntake, currentBMR, targetBMR);
            
            double targetCalorieIntake = currentCalorieIntake;
            System.out.println("\nTo be in calorie deficit state, you need to: \n1 reduce calorie intake, \n2 increase activity level, \n3 both.");
            System.out.print("Enter your option: ");
            short option = scanner.nextShort();
            
            double averageBMR = averageBMRCalc(targetBMR, currentBMR);
            System.out.print("\nYour BMR on your current activity level is: "+numberFormat.format(currentBMR));
            switch(option){
                case 1:
                    System.out.print("\nTo Reach your target weight, you should be in calorie deficit by reducing your calorie input or increasing your calorie output. \nPlease input your daily calorie intake: " );
                    targetCalorieIntake = scanner.nextDouble();
                    break;
                case 2:
                    System.out.println("\nActivity level:");
                    System.out.println("1. Sedentary (little or no exercise)");
                    System.out.println("2. Lightly active (light exercise or sports 1-3 days a week)");
                    System.out.println("3. Moderately active (moderate exercise or sports 3-5 days a week)");
                    System.out.println("4. Very active (hard exercise or sports 6-7 days a week)");
                    System.out.println("5. Super active (very hard exercise or sports, physical job or training twice a day)");

                    System.out.print("Enter your activity level(1 to 5): ");
                    activityLevel = scanner.nextInt();
                    targetBMR = activityChoose2(targetBMR,activityLevel);
                    break;
                case 3:
                    System.out.print("\nTo Reach your target weight, you should be in calorie deficit by reducing your calorie input or increasing your calorie output. \nPlease input your daily calorie intake: " );
                    targetCalorieIntake = scanner.nextDouble();
                    System.out.println("\nActivity level:");
                    System.out.println("1. Sedentary (little or no exercise)");
                    System.out.println("2. Lightly active (light exercise or sports 1-3 days a week)");
                    System.out.println("3. Moderately active (moderate exercise or sports 3-5 days a week)");
                    System.out.println("4. Very active (hard exercise or sports 6-7 days a week)");
                    System.out.println("5. Super active (very hard exercise or sports, physical job or training twice a day)");

                System.out.print("Enter your activity level(1 to 5): ");
                    activityLevel = scanner.nextInt();                
                    targetBMR = activityChoose2(targetBMR,activityLevel);
                    break;
                default:
                    System.out.println("Invalid activity level!");
                    break;
            }
            averageRateCalc(targetCalorieIntake, targetBMR, currentBMR, currentWeight, targetWeight);

        }
        else {
            System.exit(0);
        }
    }
    
    public static short clrscr() {
        System.out.print("\033[H\033[2J");
        //System.out.flush();
        return 0;
    }
    
    public static double calcCurrentBMI(double currentWeight, double height){
        double currentBMI = currentWeight / ((height/100) * (height/100));
        return currentBMI;
    }
    
    public static String BMICategory (double currentBMI) {
        String bmiCategory;
        
        if (currentBMI < 18.5) {
            bmiCategory = "Underweight";
        }
        else if (currentBMI < 25) {
            bmiCategory =  "Normal";
        }
        else if (currentBMI < 30) {
            bmiCategory = "Overweight";
        }
        else {
            bmiCategory =  "Obese";
        }
        return bmiCategory;
    }
    
    public static double bufferFinder(double targetWeight, double bufferBMI, double targetBMI, double height){

        while (bufferBMI >= targetBMI) {
                targetWeight -= 0.001;
                bufferBMI = targetWeight / ((height/100) * (height/100));
        }
        
        return targetWeight;
    }
    
    public static double currentBMRCalc(String gender, double currentWeight, double height, double age){
        double currentBMR;
                    
            if (gender.equalsIgnoreCase("M")) {
                currentBMR = (((10 * currentWeight) + (6.25 * height) - (5 * age) + 5) + ((13.397 *currentWeight) + (4.799 * height) - (5.677 * age) + 88.362)) / 2;
                
            } else {
                currentBMR = (((10 * currentWeight) + (6.25 * height) - (5 * age) + 161) + ((9.247 * currentWeight) + (3.098 * height) - (4.330 * age) + 447.593)) / 2;
            }
            return currentBMR;
    }
    
    public static double targetBMRCalc(String gender, double targetWeight, double height, double age){
        double targetBMR;
                    
            if (gender.equalsIgnoreCase("M")) {
                targetBMR = (((10 * targetWeight) + (6.25 * height) - (5 * age) + 5) + ((13.397 * targetWeight) + (4.799 * height) - (5.677 * age) + 88.362)) / 2;
            } else {
                targetBMR = (((10 * targetWeight) + (6.25 * height) - (5 * age) + 161) + ((9.247 * targetWeight) + (3.098 * height) - (4.330 * age) + 447.593)) / 2;
            }
            return targetBMR;
    }
    
    public static double activityChoose(double currentBMR, int activityLevel) {
        switch (activityLevel) {
            case 1:
                currentBMR *= 1.2;
                break;
            case 2:
                currentBMR *= 1.375;
                break;
            case 3:
                currentBMR *= 1.55;
                break;
            case 4:
                currentBMR *= 1.725;
                break;
            case 5:
                currentBMR *= 1.9;
                break;
            default:
                System.out.println("Invalid activity level");
                return 0;
        }
        
        return currentBMR;
    }
    
    public static double activityChoose2(double targetBMR, int activityLevel) {
        switch (activityLevel) {
            case 1:
                targetBMR *= 1.2;
                break;
            case 2:
                targetBMR *= 1.375;
                break;
            case 3:
                targetBMR *= 1.55;
                break;
            case 4:
                targetBMR *= 1.725;
                break;
            case 5:
                targetBMR *= 1.9;
                break;
            default:
                System.out.println("Invalid activity level");
                return 0;
        }
        
        return targetBMR;
    }
    
    public static short currentRateCalc(double currentCalorieIntake, double currentBMR, double targetBMR) {
            DecimalFormat numberFormat = new DecimalFormat("#.00");
            double averageBMR = averageBMRCalc(targetBMR, currentBMR);
            double currentCalorieRate = currentCalorieRateCalc (currentCalorieIntake, currentBMR);
            double currentWeightRate = currentWeightRateCalc (currentCalorieRate);
            
            System.out.println("Your BMR on your current activity level is: "+numberFormat.format(currentBMR));
            if (currentCalorieRate < 0){
                System.out.println("Calorie State: In calorie deficit");
                System.out.println("Current calorie rate: " + currentCalorieRate + " Calorie/day");
                System.out.println("Current weight rate: " + numberFormat.format(currentWeightRate*1000) + " gr/day");
            }
            else {
                System.out.println("Calorie State: Not in calorie deficit");
                System.out.println("Current calorie rate: +" + currentCalorieRate + " Calorie/day");
                System.out.println("Current weight rate: +" + numberFormat.format(currentWeightRate*1000) + " gr/day");
            }
            return 0;
    }
    
    public static void averageRateCalc(double targetCalorieIntake, double targetBMR, double currentBMR, double currentWeight, double targetWeight) {
            DecimalFormat numberFormat = new DecimalFormat("#.00");
            double averageBMR = averageBMRCalc(targetBMR, currentBMR);
            double averageCalorieRate = averageCalorieRateCalc(targetCalorieIntake, averageBMR);
            double averageWeightRate = averageWeightRateCalc(averageCalorieRate);
            double timeToReduceWeight = timeToReduceWeightCalc (currentWeight, targetWeight, averageWeightRate);
            
            System.out.print("\nYour BMR on your current activity level is: "+numberFormat.format(targetBMR));
            if (averageCalorieRate < 0){
                System.out.println("\nCalorie State: In calorie deficit");
                System.out.println("Average calorie rate: " + numberFormat.format(averageCalorieRate) + " Calorie/day");
                System.out.println("Average weight rate: " + numberFormat.format(averageWeightRate*1000) + " gr/day");
            }
            else {
                System.out.println("\nCalorie State: Not in calorie deficit");
                System.out.println("Average calorie rate: +" + numberFormat.format(averageCalorieRate) + " Calorie/day");
                System.out.println("Average weight rate: +" + numberFormat.format(averageWeightRate*1000) + " gr/day");
            }
            
            System.out.println("You will estimately reached your target weight within "+numberFormat.format(Math.abs(timeToReduceWeight))+" day");
    }
    
    public static double currentCalorieRateCalc (double currentCalorieIntake, double currentBMR){
        double currentCalorieRate = (currentCalorieIntake - currentBMR);
        return currentCalorieRate;
    }
    
    public static double currentWeightRateCalc (double currentCalorieRate) {
        double currentWeightRate = (0.00013 * currentCalorieRate);
        return currentWeightRate;
    }
    
    public static double averageBMRCalc (double targetBMR, double currentBMR) {
        double averageBMR = ((targetBMR + currentBMR)/2);
        return averageBMR;
    }
    
    public static double averageCalorieRateCalc (double targetCalorieIntake, double averageBMR){
        double averageCalorieRate = (targetCalorieIntake - averageBMR);
        return averageCalorieRate;
    }
    
    public static double averageWeightRateCalc (double averageCalorieRate){
        double averageWeightRate = (0.00013 * averageCalorieRate);
        return averageWeightRate;
    }
    
    public static double timeToReduceWeightCalc (double currentWeight, double targetWeight, double averageWeightRate) {
        double timeToReduceWeight = ((currentWeight-targetWeight)/averageWeightRate);
        return timeToReduceWeight;
    }
    

}