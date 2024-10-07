import javax.swing.*;

public class Runner {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Editor(); // Create an instance of Editor
        });
    }
}
