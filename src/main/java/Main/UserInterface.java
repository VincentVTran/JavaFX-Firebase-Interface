package Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class UserInterface extends JFrame {
    private JLabel background_image = new JLabel("");
    private String current_username = null;
    private String current_value = null;
    private FirebaseAccess manager = new FirebaseAccess();

    public static void main(String[] args){
        UserInterface GUI = new UserInterface();
    }

    public UserInterface(){
        setSize();
        background_image.setLayout(new BorderLayout());
        setContent();
        setContentPane(background_image);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void setContent(){ //set Center
        JPanel center_holder = new JPanel();
        center_holder.setLayout(new BoxLayout(center_holder, BoxLayout.Y_AXIS));

        center_holder.add(Box.createRigidArea(new Dimension(40,50))); //Padding

        JTextField user = new JTextField(40); //Username Text Field
        user.setMaximumSize(new Dimension(200,35));
        user.setAlignmentX(Component.CENTER_ALIGNMENT);
        center_holder.add(user);

        JTextField value = new JTextField(40);
        value.setMaximumSize(new Dimension(200,35));
        value.setAlignmentX(Component.CENTER_ALIGNMENT);
        center_holder.add(value);

        JButton submit = new JButton("Submit");
        submit.setAlignmentX(Component.CENTER_ALIGNMENT);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                current_username = user.getText();
                current_value = value.getText();
                Map<String,Object> transfer_data = returnValues();
                manager.saveData(transfer_data);
            }
        });
        center_holder.add(submit);

        background_image.add(center_holder,BorderLayout.CENTER);
    }

    private Map<String, Object> returnValues(){ //Returns value of submitted items
        Map<String, Object> data_content= new HashMap<>();
            data_content.put(current_username,current_value);
        return data_content;
    }

    private void setSize(){ //Sets size
        setMaximumSize(new Dimension(600,400));
        setMinimumSize(new Dimension(600,400));
    }
}
