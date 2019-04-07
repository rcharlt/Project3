package com.company;

import java.util.Collections;
import java.util.Scanner;
/* Rylee Charlton, 04/04/2019, Project 3
 */

public class Main {

    private static TaskCollection taskCollection = new TaskCollection();
    private static boolean running = true;
    private static Scanner scan = new Scanner(System.in);

    private static void displayMenu(){ //Display menu and ask for a menu option every loop

        System.out.println("What would you like to do?");
        System.out.println("(1)- Add task. ");
        System.out.println("(2)- Remove task. ");
        System.out.println("(3)- Edit a task.");
        System.out.println("(4)- View full to-do list.");
        System.out.println("(5) List Tasks according to priority");
        System.out.println("(0)- Exit ");


        String input = scan.nextLine();

        switch(input){
            case "1": taskCollection.addTask(); //Run add task method in taskList
                break;
            case "2": taskCollection.remTask(); //Run remove task method in taskList
                break;
            case "3": taskCollection.editTask(); //Run edit task method in taskList
                break;
            case "4":
                Collections.sort(taskCollection.taskCollection);
                for(Task task: taskCollection) {
                    System.out.println(task.getTaskNum() +") " + task.getTitle() + " ~ " + task.getPriority() +"\n" + task.getDescription());
                }//Run list task method in taskList
                break;
            case "5": taskCollection.listTasksPriority(); //Run listTaskPriority method in taskList
                break;
            case "0": running=false; //Exit program
                break;
            default:
                System.out.println("Invalid input. Please try again, enter an integer value (1-5 or 0 to exit)"); //Invalid input
        }
    }
    public static void main(String[] args) {

        while(running){ //While program is running, keep asking for options
            displayMenu();
        }
    }
}