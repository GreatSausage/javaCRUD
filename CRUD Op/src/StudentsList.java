import java.util.*;
import java.util.List;
import java.util.ArrayList;

class Students {
    private int studentId;
    private String studentName;
    private String Year;
    Students(int studentId, String studentName, String Year) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.Year = Year;
    }
    public int getstudentId() {
        return studentId;
    }
    public String getstudentName() {
        return studentName;
    }
    public String getYear() {
        return Year;
    }
    public String toString() {
        return studentId + " " + studentName + " " + Year;
    }
}

class crudOperation {
    public static void main(String[] args) {
        List<Students> students = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        int ch;
        do {
            System.out.println("1.INSERT");
            System.out.println("2.DISPLAY");
            System.out.println("3.SEARCH");
            System.out.println("4.DELETE");
            System.out.println("5.UPDATE");
            System.out.print("ENTER YOUR CHOICE : ");
            ch = s.nextInt();
            switch (ch) {
                //Insert Operation
                case 1:
                    System.out.print("ENTER STUDENT ID : ");
                    int id = s.nextInt();
                    System.out.print("ENTER STUDENT NAME : ");
                    String name = s1.nextLine();
                    System.out.print("ENTER YEAR LEVEL : ");
                    String year = s1.nextLine();
                    students.add(new Students(id, name, year));
                    System.out.println("-----------------------------------------------");
                    System.out.println("RECORD INSERT SUCCESFULLY");
                    System.out.println("-----------------------------------------------");
                    break;
                //Display Operation
                case 2:
                    System.out.println("-----------------------------------------------");
                    Iterator < Students > i = students.iterator();
                    while (i.hasNext()) {
                        Students e = i.next();
                        System.out.println(e);
                    }
                    System.out.println("-----------------------------------------------");
                    break;
                //Search Opeartion
                case 3:
                    boolean found = false;
                    System.out.print("ENTER STUDENT'S ID : ");
                    int idd = s.nextInt();
                    System.out.println("-----------------------------------------------");
                    i = students.iterator();
                    while (i.hasNext()) {
                        Students e = i.next();
                        if (e.getstudentId() == idd) {
                            System.out.println(e);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("RECORD NOT FOUND");
                    }
                    System.out.println("-----------------------------------------------");
                    break;
                //Delete Operation
                case 4:
                    found = false;
                    System.out.print("ENTER STUDENT ID TO DELETE : ");
                    id = s.nextInt();
                    System.out.println("-----------------------------------------------");
                    i = students.iterator();
                    while (i.hasNext()) {
                        Students e = i.next();
                        if (e.getstudentId() == id) {
                            i.remove();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("RECORD NOT FOUND");
                    } else {
                        System.out.println("RECORD IS DELETED SUCCESSFULLY");
                    }
                    System.out.println("-----------------------------------------------");
                    break;
                //Update Opeartion
                case 5:
                    found = false;
                    System.out.print("ENTER STUDENT ID TO UPDATE : ");
                    id = s.nextInt();
                    ListIterator < Students > li = students.listIterator();
                    while (li.hasNext()) {
                        Students e = li.next();
                        if (e.getstudentId() == id) {
                            System.out.print("ENTER NEW NAME : ");
                            name = s1.nextLine();
                            System.out.print("ENTER YEAR LEVEL : ");
                            year = s1.nextLine();
                            li.set(new Students(id, name, year));
                            found = true;
                        }
                    }
                    System.out.println("-----------------------------------------------");
                    if (!found) {
                        System.out.println("RECORD NOT FOUND");
                    } 
                    else {
                        System.out.println("RECORD IS UPDATED SUCCESSFULLY");
                    }
                    System.out.println("-----------------------------------------------");
                    break;
            }
        }
        while (ch != 0);
    }

}