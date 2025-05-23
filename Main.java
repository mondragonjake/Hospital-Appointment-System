import java.awt.CardLayout;
import java.awt.desktop.SystemEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel{
    LogIn login = new LogIn();
    Menu menu = new Menu();
    CardLayout cardLayout = new CardLayout();
    JPanel mainPanel = new JPanel(cardLayout);

    public Main() {
        mainPanel.add(login, "Log In");
        mainPanel.add(menu, "Menu");
        addListeners();

        // Add mainPanel to this JPanel
        this.setLayout(new CardLayout());
        this.add(mainPanel);
    }

    public void addListeners() {
        login.getCloseBtn().addActionListener(terminate);
        login.getLogInBtn().addActionListener(goToMenu);
        menu.getExitBtn().addActionListener(gotoLogIn);
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
            if(e.getSource()==login.getLogInBtn()){
                cardLayout.show(mainPanel, "Menu");
            }
        }
    };

    ActionListener terminate = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==login.getCloseBtn()){
                System.exit(0);
            }
        }
    };

    ActionListener gotoLogIn = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==menu.getExitBtn()){
                cardLayout.show(mainPanel, "Log In");
            }
        }
    };
}
