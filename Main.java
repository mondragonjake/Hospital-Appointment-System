import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel {
    LogIn login = new LogIn();
    Menu menu = new Menu();
    CardLayout cardLayout = new CardLayout();
    JPanel mainPanel = new JPanel(cardLayout);
    PreparedStatements ps = new PreparedStatements();

    public Main() {
        mainPanel.add(login, "Log In");
        mainPanel.add(menu, "Menu");
        addListeners();

        this.setLayout(new CardLayout());
        this.add(mainPanel);
    }

    private void addListeners() {
        login.getCloseBtn().addActionListener(terminate);
        login.getLogInBtn().addActionListener(goToMenu);
        menu.getExitBtn().addActionListener(goToLogIn);
    }

    private boolean logInCredentials() {
        return ps.setConnection(
            "jdbc:mysql://localhost:3306/hospital_db", 
            login.getUserText(), 
            login.getPassText()
        );
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Main Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Main());
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    ActionListener goToMenu = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (logInCredentials()) {
                cardLayout.show(mainPanel, "Menu");
            } else {
                // Optionally show an error message
                System.out.println("Invalid credentials.");
            }
        }
    };

    ActionListener terminate = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    };

    ActionListener goToLogIn = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(mainPanel, "Log In");
        }
    };
}
