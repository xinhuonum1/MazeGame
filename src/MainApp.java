import Login.LoginJFrame;
import Play.MapPanel;

import javax.swing.*;
import java.awt.*;

public class MainApp extends JFrame {
//    public MainApp(){
//        // 设置窗体名称
//        setTitle("走迷宫游戏");
//        // 获取自定义的游戏地图面板的实例对象
//        MapPanel panel=new MapPanel(15,15);//改变参数，每次递增
//        Container contentPane = getContentPane();
//        contentPane.add(panel);
//        // 执行并构建窗体设定
//        pack();
//    }

    public static void main(String[] args) {
        JFrame frame=new LoginJFrame("登录");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500,1000);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
//        if(frame) {
//            frame.setVisible(false);
//            MainApp app = new MainApp();
//            // 允许窗体关闭操作
//            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            // 显示窗体
//            app.setVisible(true);
//        }
    }
}
