
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
public class MastersStudent extends Student implements Serializable{
    private String thesisTitle ;
    private String supervisor;

    public MastersStudent() {
    }  

    public MastersStudent(String thesisTitle, String supervisor, String name, String id) {
        super(name, id);
        this.thesisTitle = thesisTitle;
        this.supervisor = supervisor;
    }

    public String getThesisTitle() {
        return thesisTitle;
    }

    public void setThesisTitle(String thesisTitle) {
        this.thesisTitle = thesisTitle;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }
    
    public String toString(){
        return (super.toString()+ " , Thesis title : " + thesisTitle + " , Supervisior Name :" + supervisor);
    }
    
    public static void readFromFile() {
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream("masters_students.ser"));
            while (true) {
                MastersStudent ms = (MastersStudent) ois.readObject();
                System.out.println(ms.getName());
            }
        } catch (ClassNotFoundException e1) {
            System.out.println("ClassNotFoundException");
        } catch (EOFException e2) {
            // End of file reached, do nothing
        } catch (IOException e3) {
            System.out.println("File not found in reader");
        }
    }

    public static void writeToFile(MastersStudent ms) {
        try {
            File f = new File("masters_students.ser");
            ObjectOutputStream oos;
            if (f.exists()) {
                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }
            oos.writeObject(ms);
            oos.close();
        } catch (IOException e) {
            System.out.println("Error in the file warning: " + e.getMessage());
        }
    }

    public static ArrayList<MastersStudent> readAllMastersStudents() {
        ArrayList<MastersStudent> list = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("masters_students.ser"))) {
            while (true) {
                MastersStudent ms = (MastersStudent) ois.readObject();
                list.add(ms);
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
        ArrayList<MastersStudent> list = readAllMastersStudents();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                list.remove(i);
            }
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("masters_students.ser"))) {
            for (MastersStudent ms : list) {
                oos.writeObject(ms);
            }
        } catch (IOException e) {
            System.out.println("Error in the file warning: " + e.getMessage());
        }
    }
}

