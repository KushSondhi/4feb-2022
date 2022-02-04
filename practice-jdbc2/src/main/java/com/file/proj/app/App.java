package com.file.proj.app;

import java.util.List;
import java.util.Scanner;

import com.file.proj.app.employees.Employee;
import com.file.proj.app.employees.EmployeeDAO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EmployeeDAO dao = new EmployeeDAO();
        Scanner sc  = new Scanner(System.in);
        
        Employee emp1 = new Employee(1,"Aman","2022-04-04",20000.0);
        
    }
}
