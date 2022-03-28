/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolsystemproject;

import static schoolsystemproject.DoubleLinkedList.Head;
import static schoolsystemproject.DoubleLinkedList.Tail;
import static schoolsystemproject.DoubleLinkedList.creatNodeStudent;

/**
 *
 * @author pesho
 */
public class DoubleLinkedList2 {

    public static Teacher Head = null;
    public static Teacher Tail = null;

    public DoubleLinkedList2() {
    }

    public static Teacher creatNodeTeacher(String name, int id, String course) {
        Teacher node = new Teacher();
        node.Name = name;
        node.ID = id;
        node.Course = course;
        return node;
    }

    //Start Display
    public static void DisplayTeacher(int ID) {
        if (Head != null) {
            Teacher Temp = Head;
            while (Temp.ID != ID ) {
                Temp = Temp.Next;
            }
            System.out.println("__________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
            System.out.println("1-Teacher Name: " + Temp.Name + "\n2-ID: " + Temp.ID + "\n3-Course: " + Temp.Course);
            System.out.println("__________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
              
        }
       
    }

    //End Display
    //Start Edit
    public void EditName(String oldname, String newname) {
        Teacher Temp = Head;
        if (Temp != null) {
            while (!Temp.Name.equalsIgnoreCase(oldname)) {
                Temp = Temp.Next;
            }
            Temp.Name = newname;
            System.out.println("Done!");
        }
    }

    public void EditID(int oldId, int newId) {
        Teacher Temp = Head;
        if (Temp != null) {
            while (Temp.ID != oldId) {
                Temp = Temp.Next;
            }
            Temp.ID = newId;
            System.out.println("Done!");
        }
    }

    public void EditCourse(String oldCourse, String newCourse) {
        Teacher Temp = Head;
        if (Temp != null) {
            while (!Temp.Course.equalsIgnoreCase(oldCourse)){
                Temp = Temp.Next;
            }
            Temp.Course = newCourse;
            System.out.println("Done!");
        }
    }
    //End Display

    //Delete
    public static boolean DeleteNode(int ID) {
        boolean retval = false;
        if (Head != null) {
            if (ID == 1) {
                if (Head == Tail)// one node
                {
                    Head = Tail = null;

                } else //more than one node
                {
                    Head = Head.Next;
                    Head.Prev = null;
                }
                retval = true;
            } else {
                Teacher Object;
                Object = Head;
                for (int i = 1; i < ID && Object != null; i++) {
                    Object = Object.Next;

                } //object.id= ID
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
            
        }
        return retval;

    }

    public boolean AddTeacher(String name, int id, String course) {
        boolean retval = false;
        Teacher teacher;
        Teacher temp;
        teacher = creatNodeTeacher(name, id, course);
        if (teacher != null) {
            if (Head == null) {
                Head = teacher;
            }//end second if
            else {
                temp = Head;//like counter
                while (temp.Next != null) {

                    temp = temp.Next;

                }//end while
                temp.Next = teacher;
            }//end else
            retval = true;
        }//end first if

        return retval;
    }

    //count
    public static int count() {
        int count = 0;
        if (Head != null) {
            Teacher temp = Head;
            while (temp != null) {
                count++;
                temp = temp.Next;
            }
        }
        return count;
    }

    public static String SearchTId(int id) {
        Teacher teacher = Head;
        while (teacher != null && teacher.ID != id) {
            teacher = teacher.Next;
        }
        return teacher.Name;
    }

    /*public static int SearchTName(String name){
        Teacher teacher = Head;
        while(teacher != null && teacher.Name != name){
            teacher = teacher.Next;
        }
        return teacher.ID;
    }
*/
    public static int CountTeacher() {
        int count = 0;
        Teacher teacher = Head;
        while (teacher != null) {
            count++;
            teacher = teacher.Next;
        }
        return count;
    }
    public static boolean InsertTeacher(int loc,  String name,int id, String course) {
        boolean retval = false;
        Teacher node;
        int count = CountTeacher();
        node = creatNodeTeacher(name,id,course);
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
                Teacher temp;
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
}
