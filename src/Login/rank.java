package Login;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class rank extends JFrame{

    static {
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    private JScrollPane scpDemo;
    private JTableHeader jth;
    private JTable tabDemo;
    private JButton btnShow;
    private JButton bt1;
    private JButton bt2;
    public rank()
    {
        super("排行榜");		//JFrame的标题名称
        this.setSize(660,600);		//控制窗体大小
        this.setLayout(null);		//自定义布局
        this.setLocation(400,100);	//点击运行以后，窗体在屏幕的位置
        this.scpDemo = new JScrollPane();
        this.bt1=new JButton("确定");
        this.bt2=new JButton("取消");
        this.btnShow = new JButton("显示");
        this.bt1.setBounds(100, 480, 100, 30);
        this.bt2.setBounds(380, 480, 100, 30);
        this.scpDemo.setBounds(10,50,580,400);	//设置滚动框大小
        this.btnShow.setBounds(10,10,120,30);	//设置按钮
        this.btnShow.addActionListener(new ActionListener()	//给“显示数据”按钮添加事件响应。
        {
            public void actionPerformed(ActionEvent ae)
            {
                btnShow_ActionPerformed(ae);
            }
        });

        this.bt1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        this.bt2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        add(this.scpDemo);
        add(this.btnShow);
        add(this.bt1);
        add(this.bt2);
        this.setVisible(true);
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void btnShow_ActionPerformed(ActionEvent ae)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/java?useSSL=true";//注意设置时区
            String username = "root";
            String passwords = "20020803Aa";
            Connection conn=DriverManager.getConnection(url, username, passwords);
            String sql = "select username,max from rank1  order by max desc limit 10;";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            int count = 0;
            while(rs.next())
            {
                count++;
            }
            rs = pstm.executeQuery();
            // 将查询获得的记录数据，转换成适合生成JTable的数据形式
            Object[][] info = new Object[count][2];
            String []title= {"username","max"};
            count = 0;
            while(rs.next())
            {
                info[count][0] = rs.getString("username");
                info[count][1] = rs.getInt("max");
                count++;
            }
            // 创建JTable
            this.tabDemo = new JTable(info,title);
            // 显示表头
            this.jth = this.tabDemo.getTableHeader();
            // 将JTable加入到带滚动条的面板中
            this.scpDemo.getViewport().add(tabDemo);
        }
        catch(ClassNotFoundException cnfe)
        {
            cnfe.printStackTrace();
            JOptionPane.showMessageDialog(null,"数据源错误","错误",JOptionPane.ERROR_MESSAGE);
        }
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
            JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
        }
    }

}
