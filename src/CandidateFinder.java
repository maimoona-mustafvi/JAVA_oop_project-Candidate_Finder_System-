
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
public class CandidateFinder implements Serializable{
    ArrayList<University> universities;

    public CandidateFinder() {
        this.universities = new ArrayList<>();
    }
    

    public CandidateFinder(ArrayList<University> universities) {
        this.universities = universities;
    }

    public ArrayList<University> getUniversities() {
        return universities;
    }

    public void setUniversities(ArrayList<University> universities) {
        this.universities = universities;
    }
    
    public void addUniversity(University u){
        universities.add(u);
    }
    
    public void display(){
        for(int i = 0; i<universities.size() ; i++){
            System.out.println(i + "- " +universities.get(i).getUniName());
        }
    }

    @Override
    public String toString() {
        return ("No .of universities=" + universities );
    }
    
    public ArrayList<Student> candidateFinder(String uniName, String course, double cgpa_max , double cgpa_min, String supervisor) {
        ArrayList<University> unis = readAllCandidateFinders();
        ArrayList<Student> candidates = new ArrayList<>();
        
        
        for (University university : unis) {
            if (university.getUniName().equals(uniName)) {
                ArrayList<Student> students = university.getStudents();
                for (Student student : students) {
                    if (student instanceof BachelorStudent) {
                        BachelorStudent bs = (BachelorStudent) student;
                        if (bs.getCourse().getCoursetitle().equals(course) && (bs.getCgpa()>= cgpa_min && bs.getCgpa()<= cgpa_max)) {
                            candidates.add(bs);
                        }
                    } else if (student instanceof MastersStudent) {
                        MastersStudent ms = (MastersStudent)student;
                        if(ms.getSupervisor().equals(supervisor)){
                            candidates.add(ms);
                        }
                    }
                }
            }
        }
        return candidates;
    }
    
    
    public static void readFromFile() {
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream("candidate_finder.ser"));
            while (true) {
                CandidateFinder cf = (CandidateFinder) ois.readObject();
                System.out.println(cf.toString());
            }
        } catch (ClassNotFoundException e1) {
            System.out.println("ClassNotFoundException");
        } catch (EOFException e2) {
            // End of file reached, do nothing
        } catch (IOException e3) {
            System.out.println("File not found in reader");
        }
    }

    public static void writeToFile(ArrayList<University> universities) {
    try {
        File f = new File("candidate_finder.ser");
        ObjectOutputStream oos;
        if (f.exists()) {
            oos = new MyObjectOutputStream(new FileOutputStream(f, true));
        } else {
            oos = new ObjectOutputStream(new FileOutputStream(f));
        }
        for (University university : universities) {
            oos.writeObject(university);
        }
        oos.close();
    } catch (IOException e) {
        System.out.println("Error in the file warning: " + e.getMessage());
    }
}

    public static ArrayList<University> readAllCandidateFinders() {
    ArrayList<University> list = new ArrayList<>();
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("candidate_finder.ser"))) {
        while (true) {
            try {
                University uni = (University) ois.readObject();
                list.add(uni);
            } catch (EOFException e) {
                break; 
            }
        }
    } catch (ClassNotFoundException e) {
        System.out.println("ClassNotFoundException: " + e.getMessage());
    } catch (IOException e) {
        System.out.println("File not found in reader: " + e.getMessage());
    }
    return list;
}
    
}
