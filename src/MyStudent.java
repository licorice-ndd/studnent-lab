import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class MyStudent {

    Scanner sc = new Scanner(System.in);

    public boolean check(String name) {
        //a-z:character from a to z in lowercase
        //A-Z:character from A to Z in lowercase
        //\\s:character space 
        String validName = "^[a-zA-Z\\s]+$";
        return name.matches(validName);
    }

    public String inputName() {
        String name;
        //Input until input valid
        while (true) {
            try {
                System.out.print("Student name: ");
                name = sc.nextLine();
                name.trim();
                //check valid name
                if (check(name) == false) {
                    throw new Exception();
                } else if (check(name) == true) {
                    break;
                }
            } catch (Exception ex) {
                System.out.println("Invalid!");
            }
        }
        return name;
    }

    public String inputNameU() {
        String name;
        //Input until input valid
        while (true) {
            try {
                System.out.print("Student name: ");
                name = sc.nextLine();
                name.trim();
                //check valid name
                if (check(name) == true || name.equals("")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception ex) {
                System.out.println("Invalid!");
            }
        }
        return name;
    }

    public String chooseBi(String bi1, String bi2, String display) {
        String choose;
        //Input until input valid
        while (true) {
            System.out.println(display);
            choose = sc.nextLine();
            //check two options you input
            if (choose.equalsIgnoreCase(bi1) || choose.equalsIgnoreCase(bi2)) {
                break;
            } else {
                System.out.println("You need to input " + bi1 + " or " + bi2);
            }
        }
        return choose;
    }

    public int inputNumb(int min, int max, String display) {
        int numb;
        //Input until input valid
        while (true) {
            try {
                System.out.print(display);
                numb = Integer.parseInt(sc.nextLine());
                //check min and max you input
                if (numb < min || numb > max) {
                    throw new Exception();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("You must input a number");
            } catch (Exception ex) {
                System.out.println("Number must be from " + min + " to " + max);
            }
        }
        return numb;
    }

    public String inputCourse() {
        String course;
        //Input until input valid
        while (true) {
            try {
                System.out.print("Course Name: ");
                course = sc.nextLine();
                //course must be java, .net, c/c++
                if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase(".Net") || course.equalsIgnoreCase("C/C++")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception ex) {
                System.out.println("Course must be Java, .Net or C/C++");
            }
        }
        return course;
    }

    public String inputCourseU() {
        String course;
        //Input until input valid
        while (true) {
            try {
                System.out.print("Course Name: ");
                course = sc.nextLine();
                //course must be java, .net, c/c++
                if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase(".Net") || course.equalsIgnoreCase("C/C++") || course.equals("")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception ex) {
                System.out.println("Course must be Java, .Net or C/C++");
            }
        }
        return course;
    }

    public int haveNameWithID(String id, ArrayList<Student> listStu) {
        //get all element of list student
        for (int i = 0; i < listStu.size(); i++) {
            //get id you want from list student
            if (listStu.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public Student checkDuplicate(String id, String course, String semester, ArrayList<Student> listStu) {
        //get all student from list student
        for (Student s : listStu) {
            //check if a student has duplicate id, course name and semester 
            if (id.equalsIgnoreCase(s.getId()) && course.equalsIgnoreCase(s.getCourseName()) && semester.equalsIgnoreCase(s.getSemester())) {
                System.out.println("Student existed");
                return s;
            }
        }
        return null;
    }

    public Student isExistID(ArrayList<Student> listStu, String id) {
        //get all student from list student
        for (Student s : listStu) {
            //check id is exist in list or not
            if (id.equalsIgnoreCase(s.getId())) {
                System.out.println("Id da ton tai ");
                return s;
            }
        }
        return null;
    }

    public void create(ArrayList<Student> listStu) {

        //create student till user don't want, min 3
        while (true) {
            int count = 0;
            String choose, studentName = "", courseName, semester, id;
            int index = 0;
            System.out.println("Student ID: ");
            id = sc.nextLine();
            //check if list student is empty or not exist this id in list student to add student directly to list student
            index = haveNameWithID(id, listStu);
            //check have student name with this or not
            if (index != -1) {
                studentName = listStu.get(index).getStudentName();
            } else {
                studentName = inputName();
            }
            //check duplicate id, course name, semester
            do {
                courseName = inputCourse();
                System.out.println("Semester: ");
                semester = sc.nextLine();
            } while (checkDuplicate(id, courseName, semester, listStu) != null);

            listStu.add(new Student(id, studentName, courseName, semester));
            
            //check number of student to add, if over 10, let user choose y or n to continue or not
            if (listStu.size()>2) {
                choose = chooseBi("Y", "N", "Do you want to continue (Y/N)? Choose Y to continue, N to return");
                if (choose.equalsIgnoreCase("N")) {
                    break;
                }
            }
        }
        System.out.print(listStu);
    }

    public void findSort(ArrayList<Student> listStu) {
//        Collections.sort(listStu);
        System.out.println(listStu);
        ArrayList<Student> listFind = new ArrayList<>();
        boolean check = false;
        while (true) {
            try {
                String searchName = inputName();
                //get all elements of array student
                for (int i = 0; i < listStu.size(); i++) {
                    //add name we search to list search result
                    if (listStu.get(i).getStudentName().toLowerCase().contains(searchName.toLowerCase())) {
                        check = true;
                        listFind.add(listStu.get(i));
                    }
                }
                Collections.sort(listFind);
                System.out.println(listFind);
                //throw exception
                if (check == false) {
                    throw new Exception();

                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Name is not found!");
                break;
            }
        }
    }

    public ArrayList<Student> listIDchoose(ArrayList<Student> listStu, String id) {
        ArrayList<Student> listChoose = new ArrayList<>();
        //get all student from list Student
        for (int i = 0; i < listStu.size(); i++) {
            //add student with id you choosed to listChoose
            if (listStu.get(i).getId().equalsIgnoreCase(id)) {
                listChoose.add(listStu.get(i));
            }
        }
        return listChoose;
    }

    public static ArrayList<Student> listAfterDelete(ArrayList<Student> listStu, String id, ArrayList<Student> listChoose) {
        //get all element of listStu
        for (int i = 0; i < listStu.size(); i++) {
            //remove all element has id that user chose
            if (listStu.get(i).getId().equalsIgnoreCase(id)) {
                listStu.remove(i);
                i--;
            }
        }
        //update listStu after remove from listChoose
        for (int i = 0; i < listChoose.size(); i++) {
            listStu.add(listChoose.get(i));
        }
        return listStu;
    }

    public void updateOrDelete(ArrayList<Student> listStu) {
        System.out.println(listStu);
        String choose;
        ArrayList<Student> listChoose = new ArrayList<>();
        System.out.print("Student ID: ");
        String findID = sc.nextLine();
        listChoose = listIDchoose(listStu, findID);
        //check you choose student to update/ delete or not
        if (!listChoose.isEmpty()) {
            //get all student has id you choose in listChoose
            for (int i = 0; i < listChoose.size(); i++) {
                System.out.println("Stt:" + i + " " + listChoose.get(i).toString());
            }
            choose = chooseBi("U", "D", "Do you want to update (U) or delete (D) student.");
            //check you want to update
            if (choose.equalsIgnoreCase("U")) {
                int stt = inputNumb(0, listChoose.size() - 1, "Choose stt you want to update: ");
                String newID, newName, newCourse, newSem;
                //let user input info of student they want to update until it valid
                do {
                    System.out.print("Enter ID: ");
                    newID = sc.nextLine();
                    if (newID.equals("")) {
                        newID = listChoose.get(stt).getId();
                    }
                    newName = inputNameU();
                    //if user input nothing, auto get old name
                    if (newName.equals("")) {
                        newName = listChoose.get(stt).getStudentName();
                    }
                    newCourse = inputCourseU();
                    //if user input nothing, auto get old course name 
                    if (newCourse.equals("")) {
                        newCourse = listChoose.get(stt).getCourseName();
                    }
                    System.out.print("Enter semester: ");
                    newSem = sc.nextLine();
                    //if user input 0, auto get old course numb 
                    if (newSem.equals("")) {
                        newSem = listChoose.get(stt).getSemester();
                    }
                    if (newID.equalsIgnoreCase(listChoose.get(stt).getId()) && newCourse.equalsIgnoreCase(listChoose.get(stt).getCourseName())
                            && newSem.equalsIgnoreCase(listChoose.get(stt).getSemester())) {
                        break;
                    }
                } while (checkDuplicate(newID, newCourse, newSem, listStu) != null);
                //change all name with id user chose if it is not the same as old name
                if (!newName.equalsIgnoreCase(listChoose.get(stt).getStudentName())) {
                    for (Student s : listChoose) {
                        s.setStudentName(newName);
                    }
                }
                listChoose.get(stt).setCourseName(newCourse);
                listChoose.get(stt).setSemester(newSem);
                System.out.println(listStu);
            } else if (choose.equalsIgnoreCase("D")) {
                int stt = inputNumb(0, listChoose.size(), "Choose stt you want to delete: ");
                listChoose.remove(stt);
                listStu = listAfterDelete(listStu, findID, listChoose);
                System.out.println(listStu);
            }
        } else {
            System.out.println("ID not found");
        }
    }

    public boolean isExistStudentWithCourse(Student st, ArrayList<Report> report) {
        //get all element of list report
        for (int i = 0; i < report.size(); i++) {
            //increase coures numb if course is exist 
            if (report.get(i).getStudentID().equalsIgnoreCase(st.getId())
                    && report.get(i).getCourseName().equalsIgnoreCase(st.getCourseName())) {
                report.get(i).setCourseNumb(i);
                return true;
            }
        }
        return false;
    }

    public void report(ArrayList<Student> listStu) {
        ArrayList<Report> report = new ArrayList();
        //get all student from list student
        for (Student s : listStu) {
            //add report if not exist course
            if (!isExistStudentWithCourse(s, report)) {
                report.add(new Report(s.getId(), s.getStudentName(), s.getCourseName()));
            }
        }
        //print all report in list report
        for (Report r : report) {
            System.out.println(r.getStudentName() + " | " + r.getCourseName() + " | " + r.getCourseNumb());
        }
    }

    void menu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("1.Create");
        System.out.println("2.Find and Sort");
        System.out.println("3.Update/Delete");
        System.out.println("4.Report");
        System.out.println("5.exit");
    }

    public ArrayList<Student> addExample(ArrayList<Student> listStu) {
        listStu.add(new Student("1", "toan", "Java", "1"));
        listStu.add(new Student("1", "toan", "C/C++", "1"));
        listStu.add(new Student("1", "toan", "Java", "2"));
        listStu.add(new Student("2", "manh", "Java", "2"));
        listStu.add(new Student("4a", "anh", ".net", "3"));
        listStu.add(new Student("4a", "anh", "Java", "4"));
        listStu.add(new Student("5", "giang", "c/c++", "spring"));
        return listStu;
    }

    void run() {
        ArrayList<Student> listStu = new ArrayList<>();
        addExample(listStu);
        //input number to choose case unti 
        while (true) {
            menu();
            int choose = inputNumb(1, 5, "You must choose 1 to 5: ");
            switch (choose) {
                case 1:
                    create(listStu);
                    break;
                case 2:
                    findSort(listStu);
                    break;
                case 3:
                    updateOrDelete(listStu);
                    break;
                case 4:
                    report(listStu);
                    break;
                case 5:
                    return;
            }
        }
    }

}
