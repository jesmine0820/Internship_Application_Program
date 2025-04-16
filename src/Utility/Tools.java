/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

import Dao.Database;
import java.util.Scanner;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.AWTException;

/**
 * Author - JesmineTeyKhaiJing
 * 
 * Explanations:
 * 1. Used for setting text colors.
 * 2. System operations such as System Pause and Clear Screen.
 * 
 */
public class Tools {
    
    // Define Colors
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String GREY = "\u001B[90m";
    public static final String RESET = "\u001B[0m";
    
    // Return to the last page
    public static int back(){
        return 0;
    }
    
    // Pause for 2 second to prevent overheat
    public static void pausing(){
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            
        }
    }
    
    // Exit
    public static void exit(){
        Database.setEmployer(null);
        Database.setApplicant(null);
        System.out.println("Exit...");
        pausing();
        back();
    }
    
    // System Pause function
    public static void systemPause(){
        Scanner buffer = new Scanner(System.in);
        System.out.print(BLUE + "Press ENTER to continue..." + RESET);
        buffer.nextLine();
    }
    
    // System Pause function with defined Input
    public static void systemPause(String sentence){
        Scanner buffer = new Scanner(System.in);
        System.out.print(sentence);
        buffer.nextLine();
    }
    
    // Clear screen
    public static void clearScreen(){
        try {
            Robot robot = new Robot();
            robot.setAutoDelay(10);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_L);
        } catch (AWTException ex){
            
        }
    }
}
