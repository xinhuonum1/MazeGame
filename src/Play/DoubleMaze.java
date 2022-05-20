package Play;

import javax.swing.*;
import java.awt.*;

public class DoubleMaze extends JFrame {
    public DoubleMaze(int x, int y, int hard){
        int x1 = x + hard * 2;
        int y1 = y + hard * 2;
        // 设置窗体名称
        setTitle("走迷宫游戏");
        // 获取自定义的游戏地图面板的实例对象
        DoublePanel panel=new DoublePanel(x1,y1);//改变参数，每次递增
        Container contentPane = getContentPane();
        contentPane.add(panel);
        // 执行并构建窗体设定
        pack();
    }
}
