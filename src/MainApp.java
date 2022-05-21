import Login.LoginJFrame;

import javax.swing.*;

public class MainApp extends JFrame {
    public static void main(String[] args) {
        JFrame frame=new LoginJFrame("登录");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500,1000);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
//        }
    }
}
