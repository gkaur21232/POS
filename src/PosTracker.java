import java.io.IOException;

/**
 * use of list to manage objects
 */
public class PosTracker {

    /** creates and populates a program of study, then saves it using serialization **/

    public static void main(String[] args) throws IOException{
    ProgramOfStudy pos = new ProgramOfStudy();

    pos.addCourse(new Course("CSC", 130, "Algorithms and Data Structures", "A-"));
    pos.addCourse(new Course("ARCH", 320, "Computer Architecture", "A"));
    pos.addCourse(new Course("CSC", 60, "Unix & C", "A+"));

    Course arch = pos.find("ARCH", 320);
    pos.replace(arch, new Course("FRE", 110, "Beginning French", "B+"));

    System.out.println(pos);
    pos.save("Program of Study");
    }
}
