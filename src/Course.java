import java.io.Serializable;

/**
 * Represents a course that might be taken by student
 */
public class Course implements Serializable {

    private String prefix;
    private int number;
    private String title;
    private String grade;

    /**
     * Constructs the course with specified info
     */
    public Course(String prefix, int number, String title, String grade){
        this.prefix = prefix;
        this.number = number;
        this.title = title;
        if(grade == null)
            this.grade = "";
        else
            this.grade = grade;
    }

    /**
     * Constructs the course with specified info, with no grade
     */
    public Course(String prefix, int number, String title){
        this(prefix, number, title, "");
    }

    /**
     * Returns the prefix of the course descriptions
     */
    public String getPrefix(){
        return prefix;
    }
    /**
     * returns the number of course
     */
    public int getNumber(){
        return number;
    }

    /**
     * Returns the title of course
     */
    public String getTitle(){
        return title;
    }

    /**
     * Return grade for course
     */
    public String getGrade(){
        return grade;
    }

    /**
     * Sets grade for  course
     */
    public void setGrade(String grade){
        this.grade = grade;
    }

    /**
     * returns true if course has been taken
     */
    public boolean taken(){
        return !grade.equals("");
    }
    /**
     * Determines if this course is equal to the one specified,
     * based on prefix and number
     */
    public boolean equal(Object other){
        boolean result = false;
        if(other instanceof  Course){
            Course otherCourse = (Course) other;
            if(prefix.equals(otherCourse.getPrefix()) && number == otherCourse.getNumber())
                result = true;
        }
        return result;
    }

    /**
     * creates and returns string representation of course
     */
    public String toString(){
        String result = prefix + " " + number + ": " + title;
        if(!grade.equals(""))
            result += " [" + grade + "]";
        return result;
    }

}

