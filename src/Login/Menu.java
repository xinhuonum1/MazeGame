package Login;

import Play.BeginPlay;

import javax.swing.*;


public class Menu extends JFrame {
    private JButton button=new JButton("新游戏");
    private JButton button1=new JButton("排行榜");
    private JButton button2=new JButton("继续游戏");

    public Menu(String name){
        super(name);
        JPanel root=new JPanel();
        this.setContentPane(root);
        root.add(button);
        root.add(button1);
        root.add(button2);
        button.addActionListener((e)->{ newPlay();});
        button1.addActionListener((e)->{ Rank();});
        button2.addActionListener((e)->{continueGame();});
    }
    private void newPlay(){
        BeginPlay BP=new BeginPlay();
        BP.Begin(41,31);
}
    private void continueGame(){
        BeginPlay.hard=BeginPlay.hardinDatabase;
        BeginPlay BP=new BeginPlay();
        BP.Begin(41,31);
    }
    private void Rank(){
        rank rank=new rank();
    }
}
