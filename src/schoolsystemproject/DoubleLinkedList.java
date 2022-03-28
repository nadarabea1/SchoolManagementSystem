/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolsystemproject;

import java.util.LinkedList;
import static schoolsystemproject.DoubleLinkedList2.Head;

/**
 *
 * @author pesho
 */
public class DoubleLinkedList {

    public static Student Head = null;
    public static Student Tail = null;

    public static Student creatNodeStudent(String name, int id, double grade) {
        Student node = new Student();
        node.Name = name;
        node.ID = id;
        node.Grade = grade;
        return node;
    }

    //Start Display
    public static boolean DisplayStudent(int ID) {
        boolean retval = false;
        if (Head != null) {
            Student Temp = Head;
            while (Temp != null && Temp.ID != ID) {
                Temp = Temp.Next;
            }
            System.out.println("__________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
            System.out.println("1-Name| " + Temp.Name + "\n2-ID| " + Temp.ID + "\n3-Grade| " + Temp.Grade);
            System.out.print("___________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
            retval = true;
        }
        return retval;
    }

    /*public static void DisplayTeacher(int ID) {
        if (Head != null) {
            Student Temp = Head;
            while (Temp != null && Temp.ID != ID) {
                Temp = Temp.Next;
            }
            System.out.print("1-Teacher Name: " + Temp.Name + "\n2-ID: " + Temp.ID + "\n3-Course: " + Temp.Course);
        }
    }*/
    //End Display
    //Start Edit
    public void EditName(String oldname, String newname) {
        Student Temp = Head;
        if (Temp != null) {
            while (!Temp.Name.equalsIgnoreCase(oldname)) {
                Temp = Temp.Next;
            }
            Temp.Name = newname;
            System.out.println("Done!");
        }
    }

    public void EditID(int oldId, int newId) {
        Student Temp = Head;
        if (Temp != null) {
            while (Temp.ID != oldId) {
                Temp = Temp.Next;
            }
            Temp.ID = newId;
            System.out.println("Done!");
        }
    }

    public void EditGrade(double oldGrade, double newGrade) {
        Student Temp = Head;
        if (Temp != null) {
            while (Temp.Grade != oldGrade) {
                Temp = Temp.Next;
            }
            Temp.Grade = newGrade;
            System.out.println("Done!");
        }
    }

    /*public void EditCourse(String oldCourse, String newCourse) {
        Student Temp = Head;
        if (Temp != null) {
            while (Temp.Course == oldCourse) {
                Temp = Temp.Next;
            }
            Temp.Course = oldCourse;
            System.out.println("Done!");
        }
    }*/
    //End Display
    //Delete
    public static boolean DeleteNode(int ID) {
        boolean retval = false;
        if (Head != null) {
            if (ID == 1) {
                if (Head == Tail) {
                    Head = Tail = null;

                } else {
                    Head = Head.Next;
                    Head.Prev = null;
                }
                retval = true;
            } else {
                Student Object;
                Object = Head;
                for (int i = 1; i < ID && Object != null; i++) {
                    Object = Object.Next;

                }
                if (Object != null) {
                    if (Object == Tail) {
                        Tail = Tail.Prev;
                        Tail.Next = null;
                    } else {
                        Object.Prev.Next = Object.Next;
                        Object.Next.Prev = Object.Prev;

                    }
                    retval = true;

                }
            }
            System.out.println("Done!");
        }
        return retval;

    }

    public static double average() {
        double count = 0;
        double sum = 0;
        Student Temp = Head;
        while (Temp != null) {
            count++;
            sum = sum + Temp.Grade;
            Temp = Temp.Next;
        }
        double Average = sum / count;
        System.out.println("Average of Grades: " + Average);
        return Average;
    }

    /*public boolean AddTeacher(String Name, int ID, String Course) {
        boolean retval = false;
        Node node = creatNodeTeacher(Name, ID, Course);
        if (node != null) {
            if (Head == null) {
                Head = Tail = node;
            } else {
                node.Prev = Tail;
                Tail.Next = node;
                Tail = node;
            }
            retval = true;
        }
        return retval;
    }*/
    //count
    public int count() {
        int count = 0;
        if (Head != null) {
            Student temp = Head;
            while (temp != null) {
                count++;
                temp = temp.Next;
            }
        }
        return count;
    }

    public static boolean InsertStudent(int loc,  String name,int id, double grade) {
        boolean retval = false;
        Student node;
        int count = CountStudents();
        node = creatNodeStudent(name,id,grade);
        if (node != null) {// Node exist
            if(loc > count -1){
                return retval;
            }
            if (Head == null) { //No List
                Head = Tail = node;
            } else //There is a List
            if (loc == 0) { // First Node
                node.Prev = Head;
                Head.Prev = node;
                Head = node;
            } else { //Middle or Last
                Student temp;
                temp = Head;
                for (int i = 0; i < loc - 1 && temp != null; i++) {
                    temp = temp.Next;
                }
                if (temp == null || temp == Tail) { //Insert Last Node
                    Tail.Next = node;
                    node.Prev = Tail;
                    Tail = node;
                } else { //Insert in Middle
                    temp.Next.Prev = node; //1
                    node.Next = temp.Next; //2
                    node.Prev = temp; //3
                    temp.Next = node; //4
                }
            }//end else middle or last
//end elsethere is a list
            retval = true;
        }//end if Node exist
        return retval;
    }

    public boolean AddStudent(String name, int id, double grade) {
        boolean retval = false;
        Student student;
        Student temp;
        student = creatNodeStudent(name, id, grade);
        if (student != null) {
            if (Head == null) {
                Head = student;
            }//end second if
            else {
                temp = Head;//like counter
                while (temp.Next != null) {

                    temp = temp.Next;

                }//end while
                temp.Next = student;
            }//end else
            retval = true;
        }//end first if

        return retval;
    }

    public double maximumGrade() {
        Student current = Head;
        double max = Head.Grade;
        if (Head == null) {

            System.out.println("There is no grades");
        } else {
            while (current != null) {
                if (max < current.Grade) {

                    max = current.Grade;
                }

                current = current.Next;

            }//end of while 

        }//end of else   
        return max;

    }//end of if
    public static String SearchSId(int id) {
        Student student = Head;
        while (student != null && student.ID != id) {
            student = student.Next;
        }
        return student.Name;
    }
/*
    public static int SearchSName(String name){
        Student student = Head;
        while(student != null && student.Name != name){
            student = student.Next;
        }
        return student.ID;
    }*/
    /*public static String SearchSId(int id) {
        Student student = Head;
        while (student != null && student.ID != id) {
            student = student.Next;
        }
        return student.Name;
    }

    public static int SearchSName(String name) {
        Student student = Head;
        while (student != null && student.Name != name) {
            student = student.Next;
        }
        return student.ID;
    }*/

    public static int CountStudents() {
        int count = 0;
        Student student = Head;
        while (student != null) {
            count++;
            student = student.Next;
        }
        return count;
    }

    public double MinimumGrade() {
        Student current = Head;
        double min = Head.Grade;
        if (Head == null) {

            System.out.println("There is no grades");
        } else {
            while (current != null) {
                if (min > current.Grade) {

                    min = current.Grade;
                }

                current = current.Next;

            }//end of while 

        }//end of else   
        return min;

    }//end of if
}
