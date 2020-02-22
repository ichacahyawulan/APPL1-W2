/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readwrite;

/**
 *
 * @author IchaCahyaWulan
 */
// ****************************************************************************
// Warning.java
//
// Reads student data from a text file and writes data to another text file.
// ****************************************************************************
import java.util.Scanner;
import java.io.*;
public class Warning
{
    // --------------------------------------------------------------------
    // Reads student data (name, semester hours, quality points) from a
    // text file, computes the GPA, then writes data to another file
    // if the student is placed on academic warning.
    // --------------------------------------------------------------------
    public static void main (String[] args)
    {
        int creditHrs; // number of semester hours earned
        double qualityPts; // number of quality points earned
        double gpa; // grade point (quality point) average
        String line, name, inputName = "students.dat";
        String outputName = "warning.dat";
        try
        {
            File fileMhs = new File("E:\\_polban\\_smt4\\APPL\\students.dat");
            File warningMhs = new File("E:\\_polban\\_smt4\\APPL\\warning.dat");
            // Set up scanner to input file
            Scanner scan = new Scanner(fileMhs);
            // Set up the output file stream
            PrintWriter outFile = new PrintWriter(warningMhs);
            // Print a header to the output file
            outFile.println ();
            outFile.println ("Students on Academic Warning");
            outFile.println ();
            // Process the input file, one token at a time
            while (scan.hasNext())
            {
                // Get the credit hours and quality points and
                // determine if the student is on warning. If so,
                // write the student data to the output file.
                name = scan.next();
                creditHrs = scan.nextInt();
                qualityPts = scan.nextDouble();
                gpa = qualityPts / creditHrs;
                line = name + " " + creditHrs +" " + gpa;
                if(gpa < 1.5 && creditHrs < 30){
                    outFile.println(line + "\n");
                }else if(gpa < 1.75 && creditHrs < 60){
                    outFile.println(line + "\n");
                }else if(gpa < 2){
                    outFile.println(line);
                }
            }
            // Close output file
            outFile.close();
        }
        catch (FileNotFoundException exception)
        {
            System.out.println ("The file " + inputName + " was not found.");
        }
        catch (IOException exception)
        {
            System.out.println (exception);
        }
        catch (NumberFormatException e)
        {
            System.out.println ("Format error in input file: " + e);
        }
    }
}