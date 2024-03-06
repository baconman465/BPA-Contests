//Constentant Number: 00077764
//Time started and time ended are in times.txt

import java.io.FileNotFoundException;
import java.io.File;
import java.util.*; 
import java.text.DecimalFormat;

public class SeatingChartBuilder
   {
      //SC1
      static Scanner sc = new Scanner(System.in); 
      public static void main (String args []){
            //First prompt text: "How many test students do you want to create?"
            System.out.println("How many test students do you want to create?");

            int studentCount = integerInputManager();

            String[] studentNames = {"Walter","Jones","Rose","Wilson" ,"Jack", "Rodriguez" , "Elizabeth" , "Smith", "Earl", "Carter", "Linda", "Ward", "Christopher", 
            "Turner", "Martin", "Murphy", "Betty", "Garcia", "Shawn", "Taylor","Sean", "Simmons", "Joshua", "Evans", "Norma", "Mitchell", "Brenda", "Johnson", "Donna", 
            "Clark", "Irene", "Diaz","Marilyn", "Coleman","Arthur", "Collins","Henry", "Hall","Howard", "Robinson","Jerry", "Green","Maria", "Price", "Evelyn", "Bell", 
            "Janet", "Moore", "Susan", "Foster"};
            //SC2
            ArrayList<Students> studentList = new ArrayList<Students>();

            studentList = setStudents(studentList, studentNames, studentCount);
            
            printStudents(studentList);

         
         
         //Student Names
         /*"Walter","Jones","Rose","Wilson" ,"Jack", "Rodriguez" , "Elizabeth" , "Smith", "Earl", "Carter", "Linda", "Ward", "Christopher", 
            "Turner", "Martin", "Murphy", "Betty", "Garcia", "Shawn", "Taylor","Sean", "Simmons", "Joshua", "Evans", "Norma", "Mitchell", "Brenda", "Johnson", "Donna", 
            "Clark", "Irene", "Diaz","Marilyn", "Coleman","Arthur", "Collins","Henry", "Hall","Howard", "Robinson","Jerry", "Green","Maria", "Price", "Evelyn", "Bell", 
            "Janet", "Moore", "Susan", "Foster"  */

         
      }


         private static ArrayList<Students> setStudents(ArrayList<Students> stuList, String [] allNames, int nc){
            /*
             * Purpose: To create as many students as the user requests
             * 
             * Input parameters:
             * stuList: The list to put the student objects into
             * allNames: The list of names to pick from
             * nc: The number of students to make
             * 
             * Output:
             * stuList: The list that the student objects have been put into
            */

            //SC6
            Random rand = new Random();
            
            //creates as many students as the user entered
            for(int i=0; i<nc; i++){
               //SC8
               //SC9
               //SC10
               //SC8-10 were done on one line
               stuList.add(new Students(allNames[rand.nextInt(0, allNames.length)], allNames[rand.nextInt(0, allNames.length)], rand.nextInt(9, 13), rand.nextDouble(1,4)));
               //if first name is equal to last name, removes student from list and decrements i
               if(stuList.get(i).getFirstName().equals(stuList.get(i).getLastName())){
                  stuList.remove(i);
                  i--;
               }
            }
            return stuList;
         }
 
   
         private static void printStudents(ArrayList<Students> students){
            /*
             * Purpose: To print a pre-existing list of students
             * 
             * Input parameters:
             * students: The list of students to print
            */

            //SC7
            //formats gpa to have 2 decimal points
            DecimalFormat GPAFormat = new DecimalFormat("#.00");
            for(int i=0; i<students.size(); i++){
               //SC11
               System.out.println((i+1) + ") " + students.get(i).getWholeName() + " | Grade Level: " + students.get(i).getGradeLevel() + " | GPA: " + GPAFormat.format(students.get(i).getGPA()));
            }
         }
   
      
              
      private static int integerInputManager()
      {
         /*
          * Purpose: To validate the user input pertaining to how many student objects to create
         */

         Boolean validNum;
         int count = 0;
         do {
            System.out.print("Please enter in a value bewteen 1 and 50: ");

            //SC3
            //checks if user entered an int
            try {
               count = sc.nextInt();
            }
            //SC4
            catch (InputMismatchException e) {
               System.out.println("\nPlease Enter a correct value.");
               validNum = false;
               sc.next();
               continue;
            }

            //SC5
            // checks if num is in bounds
            if (count < 1 || count > 50) {
               System.out.println("Your entry is out of range.\n");
               validNum = false;
               continue;
            }

            validNum = true;
         } while (!validNum);
         return count;
      }  

   }
   
//Given
///////////////////////////////////////////////////
class Students
   {
   String first_Name;
   String last_Name;
   int grade_Level;
   double GPA;
      
   public Students()
      {
      first_Name = "Dee";
      last_Name =  "Fault";
      grade_Level = 0;
      GPA = 0.0;
      }

   public Students(String fn, String ln, int gl, double gpa)
      {
      first_Name = fn;
      last_Name =  ln;
      grade_Level = gl;
      GPA = gpa;
      }
      
      //last, first
   public String getWholeName()
      {
      return last_Name + ", "+first_Name;
      }
      
   public String getFirstName()
      {
      return first_Name;
      }
      
   public String getLastName()
      {
      return last_Name;
      }
      
   public double getGPA()
      {
      return GPA;
      }
      
   public int getGradeLevel()
      {
      return grade_Level;
      }
      
   public void setFirstName(String fn)
      {
      first_Name = fn;
      }
    
   public void setLastName(String ln)
      {
      last_Name = ln;
      }
      
   }