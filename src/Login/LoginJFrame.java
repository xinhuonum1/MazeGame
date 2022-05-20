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
    private JButton button2=new JButton("点击注册");
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
        root.add(button2);
        button.addActionListener((e)->{
            login();
        });
        button2.addActionListener((e)->{register();});
    }
    public boolean Judge(){
//        button.addActionListener((e)->{
//            login();
//        });
        return bl;
    }
    private void register(){
        String username=textField1.getText();
        String password=textField2.getText();
        if(Register.start(username, password).equals("注册成功")){
            JOptionPane.showMessageDialog(this, "注册成功");
        }else if(Register.start(username, password).equals("账号已存在")){
            JOptionPane.showMessageDialog(this, "账号已存在，请换一个名称");
        }
    }
    private void login(){
        String username=textField1.getText();
        String password=textField2.getText();
        if(Login.start(username,password)){
            this.dispose();
            bl=true;
            Menu menu=new Menu("菜单");
            menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            menu.setSize(1500,1000);
            menu.setVisible(true);
            menu.setLocationRelativeTo(null);

//            BeginPlay BP=new BeginPlay();
//            BP.Begin(41,31);
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
