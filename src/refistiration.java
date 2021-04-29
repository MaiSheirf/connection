import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class refistiration extends JFrame{
    private JPanel mainpanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button1;
    private JLabel name_label;
    private JLabel mobile_label;
    private JLabel course_label;

    Connection con1;
    PreparedStatement insert;
    public refistiration(String title){
        super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainpanel);
        this.pack();
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                String mobile = textField2.getText();
                String course = textField3.getText();


              //  jetbrains://idea/navigate/reference?project=connection&fqn=com.mysql.jdbc.Driver
                try {
                  Class.forName("com.mysql.cj.jdbc.Driver");
                    con1 = DriverManager.getConnection("jdbc:mysql://localhost/courses", "root", "MaiMai1@3");
                    insert = con1.prepareStatement("insert into show_data(person_name,mobile,course)values(?,?,?)");
                    insert.setString(1,name);
                    insert.setString(2,mobile);
                    insert.setString(3,course);
                    insert.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Added");

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(refistiration.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(refistiration.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public static void main(String [] args){
        JFrame frame ;
        frame=new refistiration("connection with data base");
        frame.setVisible(true);


    }

}
