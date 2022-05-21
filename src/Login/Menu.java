package Login;

import Play.BeginPlay;

import javax.swing.*;


public class Menu extends JFrame {
    private JButton button=new JButton("单人游戏");
    private JButton button1=new JButton("排行榜");
    private JButton button2=new JButton("继续游戏");
    private JButton button3=new JButton("双人游戏");

    public Menu(String name){
        super(name);
        JPanel root=new JPanel();
        this.setContentPane(root);
        root.add(button);
        root.add(button1);
        root.add(button2);
        root.add(button3);
        button.addActionListener((e)->{ newPlay();this.dispose();});
        button1.addActionListener((e)->{ Rank();});
        button2.addActionListener((e)->{continueGame();this.dispose();});
        button3.addActionListener((e)->{Doubleplay();this.dispose();});
    }
    private void newPlay(){
        BeginPlay BP=new BeginPlay();
        BP.Begin(31,31);
}
    private void continueGame(){
        BeginPlay.hard=BeginPlay.hardinDatabase;
        BeginPlay BP=new BeginPlay();
        BP.Begin(11,11);
    }
    private void Rank(){
        Rank rank=new Rank();
        rank.setLocationRelativeTo(null);
    }
    private void Doubleplay(){
        BeginPlay BP=new BeginPlay();
        BP.BeginDouble(31,21);
    }
}
