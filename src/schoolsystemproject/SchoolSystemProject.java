package schoolsystemproject;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author pesho
 */
public class SchoolSystemProject {

    public static void main(String[] args) {
        //Student List
        DoubleLinkedList student = new DoubleLinkedList();
        student.AddStudent("Nada Rabea", 1, 3.1);
        student.AddStudent("Hager Tawfik", 2, 3.9);
        student.AddStudent("Mohamed Ali", 3, 2.5);
        student.AddStudent("Ali Hossam", 4, 2);
        student.AddStudent("Neyra Ibrahim", 5, 3.5);
        student.AddStudent("Aml Ahmed", 6, 3.67);
        student.AddStudent("Abd-elaziz", 7, 3.5);

        //Teacher List
        DoubleLinkedList2 teacher = new DoubleLinkedList2();
        teacher.AddTeacher("Ahmed Mostafa", 1, "Maths");
        teacher.AddTeacher("Mona Khalid", 2, "Science");
        teacher.AddTeacher("Mohamed Islam", 3, "Arabic");
        teacher.AddTeacher("Mai Mohamed", 4, "English");
        //Outputs
        do {
            Scanner in = new Scanner(System.in);
            System.out.print("\n1-Insert\n2-Add\n3-Edit\n4-Delete\n5-Search\n6-Display"
                    + "\n7-Maximium Grade\n8-Minimum Grade\n9-Count Numbers\n10-Average of Grades"
                    + "\nEnter What you want: ");
            int ans = in.nextInt();
            //Insert
            if (ans == 1) {
                Scanner in1 = new Scanner(System.in);
                System.out.print("1-Student\n2-Teacher\nEnter your Choise: ");
                int insert = in1.nextInt();
                if (insert == 1) {
                    Scanner in1_4 = new Scanner(System.in);
                    System.out.print("Position: ");
                    int pos = in1_4.nextInt();

                    Scanner in1_1 = new Scanner(System.in);
                    System.out.print("Name: ");
                    String name = in1_1.nextLine();

                    Scanner in1_2 = new Scanner(System.in);
                    System.out.print("ID: ");
                    int id = in1_2.nextInt();

                    Scanner in1_3 = new Scanner(System.in);
                    System.out.print("Grade: ");
                    double grade = in1_3.nextDouble();
                    student.InsertStudent(pos, name, id, grade);
                } //Edit Student ID
                else if (insert == 2) {
                    Scanner in1_4 = new Scanner(System.in);
                    System.out.print("Position: ");
                    int pos = in1_4.nextInt();

                    Scanner in2_1 = new Scanner(System.in);
                    System.out.print("Name: ");
                    String name = in2_1.nextLine();

                    Scanner in2_2 = new Scanner(System.in);
                    System.out.print("ID: ");
                    int id = in2_2.nextInt();

                    Scanner in2_3 = new Scanner(System.in);
                    System.out.print("Course: ");
                    String course = in2_3.nextLine();

                   teacher.InsertTeacher(pos,name, id ,course);
                } //Edit Student Grade
            } //Add
            else if (ans == 2) {
                Scanner in1 = new Scanner(System.in);
                System.out.print("1-Student\n2-Teacher\nEnter your Choise: ");
                int add = in1.nextInt();
                if (add == 1) {
                    Scanner in1_1 = new Scanner(System.in);
                    System.out.print("Name: ");
                    String name = in1_1.nextLine();

                    Scanner in1_2 = new Scanner(System.in);
                    System.out.print("ID: ");
                    int id = in1_2.nextInt();

                    Scanner in1_3 = new Scanner(System.in);
                    System.out.print("Grade: ");
                    double grade = in1_3.nextDouble();
                    student.AddStudent(name, id, grade);
                } //Edit Student ID
                else if (add == 2) {
                    Scanner in2_1 = new Scanner(System.in);
                    System.out.print("Name: ");
                    String name = in2_1.nextLine();

                    Scanner in2_2 = new Scanner(System.in);
                    System.out.print("ID: ");
                    int id = in2_2.nextInt();

                    Scanner in2_3 = new Scanner(System.in);
                    System.out.print("Course: ");
                    String course = in2_3.nextLine();
                    teacher.AddTeacher(name, id, course);
                }
            } //Edit
            else if (ans == 3) {
                Scanner in3 = new Scanner(System.in);
                System.out.print("1-Student\n2-Teacher\nEnter your Choise: ");
                int edit = in3.nextInt();
                //Edit Student Name
                if (edit == 1) {
                    Scanner in3_1 = new Scanner(System.in);
                    System.out.print("1-Name\n2-ID\n3-Grade\nEnter your Choise: ");
                    int edit1 = in3_1.nextInt();
                    if (edit1 == 1) {
                        Scanner in3_1_1 = new Scanner(System.in);
                        System.out.print("Old Name: ");
                        String edit1_1 = in3_1_1.nextLine();

                        Scanner in3_1_2 = new Scanner(System.in);
                        System.out.print("New Name: ");
                        String edit1_2 = in3_1_2.nextLine();
                        student.EditName(edit1_1, edit1_2);
                    } //Edit Student ID
                    else if (edit1 == 2) {
                        Scanner in3_1_1 = new Scanner(System.in);
                        System.out.print("Old ID: ");
                        int edit1_1 = in3_1_1.nextInt();

                        Scanner in3_1_2 = new Scanner(System.in);
                        System.out.print("New ID: ");
                        int edit1_2 = in3_1_2.nextInt();
                        student.EditID(edit1_1, edit1_2);
                    } //Edit Student Grade
                    else if (edit1 == 3) {
                        Scanner in3_1_1 = new Scanner(System.in);
                        System.out.print("Old Grade: ");
                        float edit1_1 = in3_1_1.nextFloat();

                        Scanner in3_1_2 = new Scanner(System.in);
                        System.out.print("New Grade: ");
                        float edit1_2 = in3_1_2.nextFloat();
                        student.EditGrade(edit1_1, edit1_2);
                    } else {
                        System.out.println("Error!");
                    }
                } //Edit Teacher
                else if (edit == 2) {
                    Scanner in3_2 = new Scanner(System.in);
                    System.out.print("1-Name\n2-ID\n3-Course\nEnter your Choise: ");
                    int edit2 = in3_2.nextInt();
                    //Edit Teacher Name
                    if (edit2 == 1) {
                        Scanner in3_1_1 = new Scanner(System.in);
                        System.out.print("Old Name: ");
                        String edit2_1 = in3_1_1.nextLine();

                        Scanner in3_1_2 = new Scanner(System.in);
                        System.out.print("New Name: ");
                        String edit2_2 = in3_1_2.nextLine();
                        teacher.EditName(edit2_1, edit2_2);
                    } //Edit Teacher ID
                    else if (edit2 == 2) {
                        Scanner in3_1_1 = new Scanner(System.in);
                        System.out.print("Old ID: ");
                        int edit2_1 = in3_1_1.nextInt();

                        Scanner in3_1_2 = new Scanner(System.in);
                        System.out.print("New ID: ");
                        int edit2_2 = in3_1_2.nextInt();
                        teacher.EditID(edit2_1, edit2_2);
                    } //Edit Teacher Course
                    else if (edit2 == 3) {
                        Scanner in3_1_1 = new Scanner(System.in);
                        System.out.print("Old Course: ");
                        String edit2_1 = in3_1_1.nextLine();

                        Scanner in3_1_2 = new Scanner(System.in);
                        System.out.print("New Course: ");
                        String edit2_2 = in3_1_2.nextLine();
                        teacher.EditCourse(edit2_1, edit2_2);
                    } else {
                        System.out.println("Error!");
                    }
                } else {
                    System.out.println("Error!");
                }
            } //Delete
            else if (ans == 4) {
                Scanner in6 = new Scanner(System.in);
                System.out.print("1-Student\n2-Teacher\nEnter your Choise: ");
                int delete = in6.nextInt();
                if (delete == 1) {
                    Scanner in6_1 = new Scanner(System.in);
                    System.out.print("Enter ID: ");
                    int delete1 = in6_1.nextInt();
                    student.DeleteNode(delete1);
                } else if (delete == 2) {
                    Scanner in6_2 = new Scanner(System.in);
                    System.out.print("Enter ID: ");
                    int delete2 = in6_2.nextInt();
                    teacher.DeleteNode(delete2);
                } else {
                    System.out.println("Error!");
                }
            } //Search
            else if (ans == 5) {
                Scanner in51 = new Scanner(System.in);
                System.out.print("1-Student\n2-Teacher\nEnter your Choise: ");
                int search1 = in51.nextInt();
                Scanner in52 = new Scanner(System.in);
                
                if (search1 == 1) {
                    Scanner in5_1 = new Scanner(System.in);
                    System.out.print("Enter ID: ");
                    int ID = in5_1.nextInt();
                    System.out.println(student.SearchSId(ID));
                
                } else if (search1 == 2 ) {
                    Scanner in5_1 = new Scanner(System.in);
                    System.out.print("Enter ID: ");
                    int ID = in5_1.nextInt();
                    System.out.println(teacher.SearchTId(ID));
                } else {
                    System.out.println("Error!");
                }
            } //Display
            else if (ans == 6) {
                Scanner in6 = new Scanner(System.in);
                System.out.print("1-Student\n2-Teacher\nEnter your Choise: ");
                int display = in6.nextInt();
                if (display == 1) {
                    Scanner in6_1 = new Scanner(System.in);
                    System.out.print("Enter ID: ");
                    int display1 = in6_1.nextInt();
                    student.DisplayStudent(display1);
                } else if (display == 2) {
                    Scanner in6_2 = new Scanner(System.in);
                    System.out.print("Enter ID: ");
                    int display2 = in6_2.nextInt();
                    teacher.DisplayTeacher(display2);
                } else {
                    System.out.println("Error!");
                }
            } //Maximum
            else if (ans == 7) {
                System.out.println("Maximam Grade: " + student.maximumGrade());
            } //Manimum
            else if (ans == 8) {
                System.out.println("Minimum Grade: " + student.MinimumGrade());
            } //Count
            else if (ans == 9) {
                Scanner in9 = new Scanner(System.in);
                System.out.print("1-Student\n2-Teacher\nEnter your Choise: ");
                int count = in9.nextInt();
                if (count == 1) {
                    System.out.println("Number of Students: " + student.CountStudents());
                } else if (count == 2) {
                    System.out.println("Number of Teacher: " + teacher.CountTeacher());
                } else {
                    System.out.println("Error!");
                }
            } //Average
            else if (ans == 10) {
                student.average();
                //
            } else {
                System.out.println("Error!");
                break;
            }

        } while (1 != 0);
    }

}
