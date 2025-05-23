import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogIn extends JPanel {
    private GridBagConstraints gbc;
    private JLabel username_label, pass_label;
    private JTextField username_txt;
    private JPasswordField pass_txt;
    private JButton logIn_btn, close_btn;
    private Dimension fieldSize = new Dimension(200, 30); // Better size for modern feel

    private final Color DARK_BG = new Color(34, 34, 34);        // Dark gray
    private final Color LIGHT_TEXT = new Color(240, 240, 240);  // Near white
    private final Color BUTTON_BG = new Color(60, 63, 65);      // Dark button

    public LogIn() {
        setLayout(new GridBagLayout());
        setBackground(DARK_BG);
        gbc = new GridBagConstraints();
        createLabels();
        createTxt();
        createButton();
    }

    public void createLabels() {
        username_label = new JLabel("Username:");
        username_label.setPreferredSize(new Dimension(70, 25));
        username_label.setOpaque(true);
        username_label.setForeground(DARK_BG);
        username_label.setBackground(Color.white);

        username_label.setHorizontalAlignment(JLabel.CENTER);
        username_label.setVerticalAlignment(JLabel.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5,5,5,5);
        add(username_label, gbc);

        pass_label = new JLabel("Password:");
        pass_label.setPreferredSize(new Dimension(70, 25));
        pass_label.setOpaque(true);
        pass_label.setForeground(DARK_BG);
        pass_label.setBackground(Color.white);

        pass_label.setHorizontalAlignment(JLabel.CENTER);
        pass_label.setVerticalAlignment(JLabel.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(5,5,5,5);
        add(pass_label, gbc);
    }

    public void createTxt() {
        username_txt = new JTextField();
        username_txt.setPreferredSize(fieldSize);
        username_txt.setBackground(Color.DARK_GRAY);
        username_txt.setForeground(LIGHT_TEXT);
        username_txt.setCaretColor(LIGHT_TEXT);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(5,5,5,5);
        add(username_txt, gbc);

        pass_txt = new JPasswordField();
        pass_txt.setPreferredSize(fieldSize);
        pass_txt.setBackground(Color.DARK_GRAY);
        pass_txt.setForeground(LIGHT_TEXT);
        pass_txt.setCaretColor(LIGHT_TEXT);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(5,5,5,5);
        add(pass_txt, gbc);
    }

    public void createButton() {
        logIn_btn = new JButton("Start");
        logIn_btn.setPreferredSize(fieldSize);
        logIn_btn.setBackground(BUTTON_BG);
        logIn_btn.setForeground(LIGHT_TEXT);
        logIn_btn.setFocusPainted(false);
        logIn_btn.setBorderPainted(false);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(5,5,5,5);
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(logIn_btn, gbc);

        close_btn = new JButton("Close");
        close_btn.setPreferredSize(fieldSize);
        close_btn.setBackground(BUTTON_BG);
        close_btn.setForeground(LIGHT_TEXT);
        close_btn.setFocusPainted(false);
        close_btn.setBorderPainted(false);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(5,5,5,5);
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(close_btn, gbc);
    }

    public JButton getLogInBtn(){
        return logIn_btn;
    }

    public JButton getCloseBtn(){
        return close_btn;
    }

    public String getUserText(){
        String user = username_txt.getText();
        username_txt.setText("");
        return user;
    }

    public String getPassText(){
        String pass = new String(pass_txt.getPassword());
        pass_txt.setText("");
        return pass;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new LogIn());
        frame.setSize(800, 500);;
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
