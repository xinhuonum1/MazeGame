package Login;

import Play.BeginPlay;
import Play.Maze;

import javax.swing.*;
import java.awt.*;

public class LoginJFrame extends JFrame {
    private static boolean bl=false;
    private JTextField textField1=new JTextField(20);
    private JTextField textField2=new JTextField(20);
    private JButton button=new JButton("点击登录");
    public LoginJFrame(String name){
        super(name);
        JPanel root=new JPanel();
        this.setContentPane(root);
//        JButton button=new JButton("点击登录");
        root.add(textField1);
        root.add(textField2);
        textField1.setText("账号");
        textField2.setText("密码");
        textField1.setPreferredSize(new Dimension(100,50));
        textField2.setPreferredSize(new Dimension(100,50));
        root.add(button);
        button.addActionListener((e)->{
            login();
        });
    }
    public boolean Judge(){
//        button.addActionListener((e)->{
//            login();
//        });
        return bl;
    }
    private void login(){
        String username=textField1.getText();
        String password=textField2.getText();
        if(Login.start(username,password)){
            this.dispose();
            bl=true;
            BeginPlay BP=new BeginPlay();
            BP.Begin(15,15);
            // 允许窗体关闭操作
//            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            // 显示窗体
//            app.setVisible(true);
//            app.setLocationRelativeTo(null);//居中
        }else{
            JOptionPane.showMessageDialog(this, "账号密码错误");
        }
    }
}
