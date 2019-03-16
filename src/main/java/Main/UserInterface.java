package Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;


public class UserInterface extends JFrame {
    private JLabel background_image = new JLabel(new ImageIcon("background.png"));
    private String current_username = null;
    private String current_value = null;
    private FirebaseAccess manager = new FirebaseAccess();
    private Map<String, Object> data_content = new HashMap<>();

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
        center_holder.setOpaque(false);
        center_holder.setLayout(new BoxLayout(center_holder, BoxLayout.Y_AXIS));

        center_holder.add(Box.createRigidArea(new Dimension(40,50))); //Padding

        JTextField link = new JTextField(40);
        link.setText("Link");
        link.setToolTipText("Link");
        link.setMaximumSize(new Dimension(200,35));
        link.setAlignmentX(Component.CENTER_ALIGNMENT);
        center_holder.add(link);

        JTextField user = new JTextField(40); //Username Text Field
        user.setText("Key");
        user.setToolTipText("Key");
        user.setMaximumSize(new Dimension(200,35));
        user.setAlignmentX(Component.CENTER_ALIGNMENT);
        center_holder.add(user);

        JTextField value = new JTextField(40);
        value.setText("Value");
        value.setToolTipText("Value");
        value.setMaximumSize(new Dimension(200,35));
        value.setAlignmentX(Component.CENTER_ALIGNMENT);
        center_holder.add(value);

        JButton submit = new JButton("Submit");
        submit.setAlignmentX(Component.CENTER_ALIGNMENT);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                current_username = user.getText();
                current_value = value.getText();
                saveValues();
                manager.connectFirebase(link.getText());
                manager.saveData(data_content);
            }
        });
        center_holder.add(submit);

        JButton get = new JButton("Get data (Requires Username Only)");
        get.setAlignmentX(Component.CENTER_ALIGNMENT);
        get.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                current_username = user.getText();
                manager.getData(current_username);
            }
        });
        center_holder.add(get);

        background_image.add(center_holder,BorderLayout.CENTER);
    }

    private void saveValues(){ //Returns value of submitted items
            data_content.put(current_username,current_value);
    }

    private void setSize(){ //Sets size
        setMaximumSize(new Dimension(600,400));
        setMinimumSize(new Dimension(600,400));
    }
}
