package org.example;

import org.example.database.Create;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Create create = new Create();
        create.createDatabase("HW13");


    }
}
