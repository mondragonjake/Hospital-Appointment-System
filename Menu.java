import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JPanel {
    private GridBagConstraints gbc;
    private JButton create_btn, read_btn, update_btn, delete_btn, exit_btn;
    private Dimension fieldSize = new Dimension(150, 30);

    private final Color DARK_BG = new Color(34, 34, 34);         // Background
    private final Color LIGHT_TEXT = new Color(240, 240, 240);   // Button text
    private final Color BUTTON_BG = new Color(60, 63, 65);       // Button background

    public Menu() {
        setLayout(new GridBagLayout());
        setBackground(DARK_BG); // Set dark background
        gbc = new GridBagConstraints();
        createButtons();
    }

    public void createButtons() {
        create_btn = createStyledButton("Create", 0);
        read_btn = createStyledButton("Read", 1);
        update_btn = createStyledButton("Update", 2);
        delete_btn = createStyledButton("Delete", 3);
        exit_btn = createStyledButton("Exit", 4);
    }

    private JButton createStyledButton(String text, int yPos) {
        JButton button = new JButton(text);
        button.setPreferredSize(fieldSize);
        button.setBackground(BUTTON_BG);
        button.setForeground(LIGHT_TEXT);
        button.setFocusPainted(false);
        button.setBorderPainted(false);

        gbc.gridx = 0;
        gbc.gridy = yPos;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(button, gbc);

        return button;
    }

    public JButton getCreateBtn() {
        return create_btn;
    }

    public JButton getReadBtn() {
        return read_btn;
    }

    public JButton getUpdateBtn() {
        return update_btn;
    }

    public JButton getDeleteBtn() {
        return delete_btn;
    }

    public JButton getExitBtn() {
        return exit_btn;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Menu());
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
