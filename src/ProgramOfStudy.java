import java.io.*;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;

/**
 * A list of courses taken and planned, for individual students
 */

public class ProgramOfStudy {
    private List<Course> list;

    //construct empty program of study
    public ProgramOfStudy(){
        list = new LinkedList<Course>();
    }

    //add specified course to end of course list
    public void addCourse(Course course){
        if(course != null)
            list.add(course);
    }

    //find and return course matching prefix and number
    public Course find(String prefix, int number){
        for(Course course : list)
            if(prefix.equals(course.getPrefix()) && number == course.getNumber())
                return course;


         return null;
    }

    /**
     * add specified course after target course. Does nothing if either course is null
     * or if target is not found.
     */
    public void addCourseAfter(Course target, Course newCourse){
        if(target == null || newCourse == null)
            return;
        int targetIndex = list.indexOf(target);
        if (targetIndex != -1)
            list.add(targetIndex + 1, newCourse);
    }

    /** Replaces specified course with new course. Again, does nothing if null or if not found **/
    public void replace(Course target, Course newCourse){
        if(target == null || newCourse == null)
            return;
        int targetIndex = list.indexOf(target);
        if(targetIndex != -1)
            list.set(targetIndex, newCourse);
    }

    /**
     * creates and returns a string representation of this Program of Study
     */
    public String toString(){
        String result = "";
        for(Course course : list)
            result += course + "\n";
        return result;
    }

    /**
     * returns an iterator for this Program of Study.
     */
    public Iterator<Course> iterator(){
        return list.iterator();
    }

    /**
     * saves a serialized version of this Program of Study to specified file name
     */
    public void save(String fileName) throws IOException{
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.flush();
        oos.close();
    }

    /**
     * Loads a serialized Program of Study from the specified file
     */
    public static ProgramOfStudy load(String fileName) throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ProgramOfStudy pos = (ProgramOfStudy) ois.readObject();
        ois.close();

        return pos;
    }
}
