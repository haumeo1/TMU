/**
 * For this problem, you will complete code for reading in Student information
 * from a file, store it in a map, prints the contents of the map, and allows
 * for updating values in the map. You are to complete the following tasks
 *
 * - Read students from a file into a map
 * - Implement printAllInfo which prints each student in the map
 * - Update the grades of certain students as described
 */

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class StudentGrades
{
    /**
     * Extracts a Map of students from the given filenam
     * @param filename The filename to read from
     * @return A Map of Students indexed by name
     */
    public static Map<String, Student> getStudents(String filename)
    {
        //-----------Start below here. To do: approximate lines of code = 1
        // Create a map called students with key of type String (student id) and value of type Student
        // Use a TreeMap to ensure that it is iterated in alphabetic order of the keys
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
        Map<String,Student> result = new TreeMap<>();
        try {
            File studentData = new File(filename);
            Scanner in = new Scanner(studentData);
            
            while (in.hasNextLine()) {
                String line = in.nextLine();
                //-----------Start below here. To do: approximate lines of code = 9
                // Create a scanner to process each line
                // You can assume the file is well formatted as follows
                // The first String is the name, the second is the student ID
                // Then there are groups of two items. The first is course name and the second is course grade
                // See the Student Class for details on creating a student and adding a course and grade to it
                // Remember to add each student found to the map, where the ID is the key
                Scanner word = new Scanner(line);
                
                String name = word.next();
                String ID = word.next();
                Student t1 = new Student(name, ID);
                while(word.hasNext()){
                    String course = word.next();
                    String grade = word.next();
                    t1.addCourseAndGrade(course, grade);
                }

                result.put(ID, t1);
                
                
                
                
                
                
                
                
                
                
                
                //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
            }

        } catch (IOException exception) {
            System.out.println("Error processing file: " + exception);
            System.exit(0);
        }
        return result;
    }

    /**
     * Gets a String with the info for each student in the map, one on a new line.
     *
     * @param students The student map to print
     * @return The info for all students in the map
     */
    public static String getAllInfoString(Map<String, Student> students)
    {

        //-----------Start below here. To do: approximate lines of code = 5
        // Print all the info for all students in the map
        // HINT: Use the toString method of a Student
        // HINT: Use .trim() to get rid of last space
        String result = new String();
        int count = 0;
        for(String i : students.keySet()){
            result += students.get(i).toString().trim();
            count+=1;
            if(count == students.size()){
                break;
            }
            result += "\n";
        }
        
        return result;
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
    public static void main(String[] args)
    {
        Map<String, Student> students = getStudents("students.txt");

        System.out.println("------ Test 1: Print out inputted students ------");
        runPrintAllInfoTest(students, "Joe DD1234 CPS209 B- CPS109 A-\nAdam HH2123 CPS209 B CPS109 D+\nJames JJ2345 CPS209 B+ CPS109 C+\nMiriam MM3456 CPS209 A+ CPS109 A+");

        //-----------Start below here. To do: approximate lines of code = 6
        // Update the course grade of a student with given id
        //ID: "DD1234" CPS209 update grade to B+
        //ID: "JJ2345" CPS209 update grade to A-
        //ID: "HH2123" CPS209 update grade to B+
        
        students.get("DD1234").updateGrade("CPS209", "B+");
        students.get("JJ2345").updateGrade("CPS209", "A-");
        students.get("HH2123").updateGrade("CPS209", "B+");

        
        
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.

        System.out.println("\n------ Test 2: Print out after updates ------");
        runPrintAllInfoTest(students, "Joe DD1234 CPS209 B+ CPS109 A-\nAdam HH2123 CPS209 B+ CPS109 D+\nJames JJ2345 CPS209 A- CPS109 C+\nMiriam MM3456 CPS209 A+ CPS109 A+");

        System.out.println("\n------ Test 3: Try Another Input File ------");
        students = getStudents("students2.txt");
        runPrintAllInfoTest(students, "Joe DL1234 CPS305 C- CPS109 A-\nAdam HH2125 CPS310 C- CPS209 B+\nJames JJ2345 CPS209 B+ CPS109 C+");
    }

    public static void runPrintAllInfoTest(Map<String, Student> students, String expected) {
        printTestResult(testStringOutput("getAllInfoString", "\n" + getAllInfoString(students), "\n" + expected));
    }

    public static void printTestResult(boolean pass)
    {
        if (pass) {
            System.out.println("*** TEST PASSES ***\n");
        } else {
            System.out.println("*******************************************");
            System.out.println("*************** TEST FAILED ***************");
            System.out.println("*******************************************\n");
        }
    }

    public static boolean testStringOutput(String methodName, String output, String expected)
    {
        System.out.println("OUTPUT of " + methodName + ":   " + output);

        if (output == null && expected == null) {
            return true;
        } else if (output == null || !output.equals(expected)) {
            System.out.println("EXPECTED of " + methodName + ": " + expected);
            System.out.println("    INCORRECT OUTPUT");
            return false;
        }
        return true;
    }
}
