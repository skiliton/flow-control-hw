package ua.repeta;

import java.util.Scanner;

import static ua.repeta.Tasks.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Task 1:");
        System.out.println(task1(100,0));
        System.out.println();

        System.out.println("Task 2:");
        Scanner scanner = new Scanner(System.in);
        System.out.println(task2(scanner));
        scanner.close();
        System.out.println();

        System.out.println("Task 3:");
        task3A(5).forEach(System.out::println);
        task3B(5).forEach(System.out::println);
    }
}
