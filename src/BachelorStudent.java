
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PMYLS
 */
public class BachelorStudent extends Student implements Serializable{
    private double cgpa;
    Course course;

    public BachelorStudent() {
        
    }

    
    public BachelorStudent(String name, String id , double cgpa , Course course) {
        super(name, id);
        this.cgpa = cgpa;
        this.course = course;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
    @Override
    public String toString(){
        return (super.toString()+ " , CGPA : "+cgpa);
    }
    
    public static void readFromFile() {
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream("bachelor_students.ser"));
            while (true) {
                BachelorStudent bs = (BachelorStudent) ois.readObject();
                System.out.println(bs.getName());
            }
        } catch (ClassNotFoundException e1) {
            System.out.println("ClassNotFoundException");
        } catch (EOFException e2) {
            // End of file reached, do nothing
        } catch (IOException e3) {
            System.out.println("File not found in reader");
        }
    }

    public static void writeToFile(BachelorStudent bs) {
        try {
            File f = new File("bachelor_students.ser");
            ObjectOutputStream oos;
            if (f.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }
            oos.writeObject(bs);
            oos.close();
        } catch (IOException e) {
            System.out.println("Error in the file warning: " + e.getMessage());
        }
    }

    public static ArrayList<BachelorStudent> readAllBachelorStudents() {
        ArrayList<BachelorStudent> list = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("bachelor_students.ser"))) {
            while (true) {
                BachelorStudent bs = (BachelorStudent) ois.readObject();
                list.add(bs);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: " + e.getMessage());
        } catch (EOFException e) {
            // End of file reached, do nothing
        } catch (IOException e) {
            System.out.println("File not found in reader: " + e.getMessage());
        }
        return list;
    }

    public static void deleteFromFile(String id) {
        ArrayList<BachelorStudent> list = readAllBachelorStudents();
        for(int i = 0; i<list.size() ; i++){
            if(list.get(i).getId().equals(id)){
                list.remove(i);
            }
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("bachelor_students.ser"))) {
            for (BachelorStudent bs : list) {
                oos.writeObject(bs);
            }
        } catch (IOException e) {
            System.out.println("Error in the file warning: " + e.getMessage());
        }
    }

}

