package Play;

import javax.swing.*;

public class BeginPlay {
    private static Maze maze;
    public static int hard=0;
    public static int hardinDatabase=0;
    private static int x;
    private static int y;
    public void Begin(int x,int y){
        this.x=x;
        this.y=y;
        maze=new Maze(x,y,hard);

        maze.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 显示窗体
        maze.setVisible(true);
        maze.setLocationRelativeTo(null);//居中
    }

    public static void ContinuePlay(){
        maze.dispose();
        hard++;
        x+=hard*2;
        y+=hard*2;
        maze=new Maze(x,y,hard);
        maze.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 显示窗体
        maze.setVisible(true);
        maze.setLocationRelativeTo(null);//居中
    }
}
