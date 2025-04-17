import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private String candidateName;
    private int experienceYears;

    public JobRole(String candidateName, int experienceYears) {
        this.candidateName = candidateName;
        this.experienceYears = experienceYears;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public abstract String getRequiredSkills();

    public String toString() {
        return candidateName + " (" + experienceYears + " yrs) - Skills: " + getRequiredSkills();
    }
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }

    public String getRequiredSkills() {
        return "Java, Data Structures, Algorithms";
    }
}

class DataScientist extends JobRole {
    public DataScientist(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }

    public String getRequiredSkills() {
        return "Python, Machine Learning, Statistics";
    }
}

class ProductManager extends JobRole {
    public ProductManager(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }

    public String getRequiredSkills() {
        return "Product Strategy, UX, Communication";
    }
}

class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public T getJobRole() {
        return jobRole;
    }

    public String toString() {
        return jobRole.toString();
    }
}

class ResumeProcessor {
    public static <T extends JobRole> void screenResume(Resume<T> resume) {
        System.out.println("Screening Resume: " + resume);
    }

    public static void processPipeline(List<? extends JobRole> jobRoles) {
        for (JobRole role : jobRoles) {
            System.out.println("Pipeline Screening: " + role);
        }
    }
}

public class ResumeScreeningSYstem {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> seResume = new Resume<>(new SoftwareEngineer("Alice", 4));
        Resume<DataScientist> dsResume = new Resume<>(new DataScientist("Bob", 3));
        Resume<ProductManager> pmResume = new Resume<>(new ProductManager("Charlie", 6));

        ResumeProcessor.screenResume(seResume);
        ResumeProcessor.screenResume(dsResume);
        ResumeProcessor.screenResume(pmResume);

        List<JobRole> pipeline = new ArrayList<>();
        pipeline.add(seResume.getJobRole());
        pipeline.add(dsResume.getJobRole());
        pipeline.add(pmResume.getJobRole());

        System.out.println("\n=== Screening Pipeline ===");
        ResumeProcessor.processPipeline(pipeline);
    }
}
