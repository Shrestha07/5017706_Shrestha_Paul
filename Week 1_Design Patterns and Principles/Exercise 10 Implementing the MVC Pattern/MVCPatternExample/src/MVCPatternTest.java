import model.Student;
import view.StudentView;
import controller.StudentController;

public class MVCPatternTest {
    public static void main(String[] args) {
        // Create a model
        Student student = new Student("Srijoni Dey", 1, "A");

        // Create a view
        StudentView view = new StudentView();

        // Create a controller
        StudentController controller = new StudentController(student, view);

        // Update and display student details
        controller.updateView();

        // Change student details
        controller.setStudentName("Shrestha Paul");
        controller.setStudentGrade("A++");

        // Display updated student details
        controller.updateView();
    }
}