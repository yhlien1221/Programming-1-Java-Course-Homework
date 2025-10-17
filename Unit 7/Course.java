public class Course {
    private String id;   // Unique identifier for each course
    private String name; // Name of the course


    public Course(String id, String name) {
        this.id = id;
        this.name = name;
    }


    public String getId() { return id; }
    public String getName() { return name; }
}
