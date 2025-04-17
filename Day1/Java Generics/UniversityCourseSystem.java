import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private String title;
    private int credits;

    public CourseType(String title, int credits) {
        this.title = title;
        this.credits = credits;
    }

    public String getTitle() {
        return title;
    }

    public int getCredits() {
        return credits;
    }

    public abstract String getEvaluationMethod();

    public String toString() {
        return title + " (" + credits + " credits) - " + getEvaluationMethod();
    }
}

class ExamCourse extends CourseType {
    public ExamCourse(String title, int credits) {
        super(title, credits);
    }

    public String getEvaluationMethod() {
        return "Exam-Based";
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String title, int credits) {
        super(title, credits);
    }

    public String getEvaluationMethod() {
        return "Assignment-Based";
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String title, int credits) {
        super(title, credits);
    }

    public String getEvaluationMethod() {
        return "Research-Based";
    }
}

class Course<T extends CourseType> {
    private T courseType;
    private String department;

    public Course(String department, T courseType) {
        this.department = department;
        this.courseType = courseType;
    }

    public T getCourseType() {
        return courseType;
    }

    public String getDepartment() {
        return department;
    }

    public String toString() {
        return "[" + department + "] " + courseType.toString();
    }
}

class CourseUtils {
    public static void displayCourses(List<? extends Course<? extends CourseType>> courses) {
        for (Course<? extends CourseType> course : courses) {
            System.out.println(course);
        }
    }
}

public class UniversityCourseSystem {
    public static void main(String[] args) {
        List<Course<? extends CourseType>> catalog = new ArrayList<>();

        catalog.add(new Course<>("Computer Science", new ExamCourse("Data Structures", 4)));
        catalog.add(new Course<>("Physics", new ResearchCourse("Quantum Mechanics", 3)));
        catalog.add(new Course<>("Literature", new AssignmentCourse("Modern Poetry", 2)));
        catalog.add(new Course<>("Engineering", new ExamCourse("Thermodynamics", 3)));
        catalog.add(new Course<>("Psychology", new AssignmentCourse("Behavioral Studies", 4)));

        CourseUtils.displayCourses(catalog);
    }
}
