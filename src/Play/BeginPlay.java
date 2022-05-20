package Play;

import Login.Menu;
import Login.Save;

import javax.swing.*;

public class BeginPlay {
    private static Maze maze;
    private static DoubleMaze doublemaze;
    public static int hard=0;
    public static int hardinDatabase=0;
    public static String username;
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
        Save.start(BeginPlay.username,Math.max(BeginPlay.hard,BeginPlay.hardinDatabase));
        if(hard>hardinDatabase){
            hardinDatabase=hard;
        }
        maze=new Maze(x,y,hard);
        maze.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 显示窗体
        maze.setVisible(true);
        maze.setLocationRelativeTo(null);//居中
    }
    public void BeginDouble(int x,int y){
        this.x=x;
        this.y=y;
        doublemaze=new DoubleMaze(x,y,hard);

        doublemaze.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 显示窗体
        doublemaze.setVisible(true);
        doublemaze.setLocationRelativeTo(null);//居中
    }
    public static void ContinueDoublePlay(){
        doublemaze.dispose();
        hard++;
        x+=hard*2;
        y+=hard*2;
//        Save.start(BeginPlay.username,Math.max(BeginPlay.hard,BeginPlay.hardinDatabase));
        doublemaze=new DoubleMaze(x,y,hard);
        doublemaze.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 显示窗体
        doublemaze.setVisible(true);
        doublemaze.setLocationRelativeTo(null);//居中
    }
    public static void OnereturnMenu(){
        maze.dispose();
//        doublemaze.dispose();
        Save.start(BeginPlay.username,Math.max(BeginPlay.hard,BeginPlay.hardinDatabase));
        Menu menu=new Menu("菜单");
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setSize(1500,1000);
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
    }
    public static void DoublereturnMenu(){
//        maze.dispose();
        doublemaze.dispose();
        Menu menu=new Menu("菜单");
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setSize(1500,1000);
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
    }
}
