package Play;

import javax.swing.*;

public class BeginPlay {
    private Maze maze;
    private static int hard=0;
    private int x;
    private int y;
    public void Begin(int x,int y){
        this.x=x;
        this.y=y;
        maze=new Maze(x,y,hard);

        maze.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 显示窗体
        maze.setVisible(true);
        maze.setLocationRelativeTo(null);//居中
    }

    public void ContinuePlay(){
        hard++;
        x+=hard*2;
        y+=hard*2;
        maze=new Maze(x,y,hard);
    }
}
