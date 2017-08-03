
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;


public class GUI {
       GUI mainGUI;
    JFrame newFrame = new JFrame("Survey");
    JButton sendMessage;
    JTextField messageBox;
    JTextArea chatBox;
    //JTextField usernameChooser;
    JFrame preFrame;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        GUI mainGUI = new GUI();
        mainGUI.preDisplay("Hello! Please take this survey");
    }


    public void preDisplay(String object) {
        newFrame.setVisible(false);
        preFrame = new JFrame("Survey");
        //usernameChooser = new JTextField();
        JLabel chooseUsernameLabel = new JLabel(object);
        JButton enterServer = new JButton("Click to take the survey");
        JPanel prePanel = new JPanel(new GridBagLayout());

        GridBagConstraints preRight = new GridBagConstraints();
        preRight.anchor = GridBagConstraints.EAST;
        GridBagConstraints preLeft = new GridBagConstraints();
        preLeft.anchor = GridBagConstraints.WEST;
        preRight.weightx = 2.0;
        preRight.fill = GridBagConstraints.HORIZONTAL;
        preRight.gridwidth = GridBagConstraints.REMAINDER;

        prePanel.add(chooseUsernameLabel, preLeft);
     //   prePanel.add(usernameChooser, preRight);
        preFrame.add(BorderLayout.CENTER, prePanel);
        preFrame.add(BorderLayout.SOUTH, enterServer);
        preFrame.setVisible(true);
        preFrame.setSize(600, 600);

        enterServer.addActionListener(new enterServerButtonListener());
    }

    public void display(String question) {
        newFrame.setVisible(true);
        JPanel southPanel = new JPanel();
        newFrame.add(BorderLayout.SOUTH, southPanel);
        southPanel.setBackground(Color.BLACK);
        southPanel.setLayout(new GridBagLayout());
        JLabel chooseUsernameLabel = new JLabel("Are you happy with the following 1-5");
      

        JLabel field=new JLabel(question);
        
        messageBox = new JTextField(30);
        sendMessage = new JButton("Submit");
        chatBox = new JTextArea();
        chatBox.setEditable(true);
        chatBox.append(question);
        newFrame.add(new JScrollPane(chatBox), BorderLayout.CENTER);
        
        chatBox.setLineWrap(true);

        GridBagConstraints left = new GridBagConstraints();
        left.anchor = GridBagConstraints.WEST;
        GridBagConstraints right = new GridBagConstraints();
        right.anchor = GridBagConstraints.EAST;
        right.weightx = 2.0;

        southPanel.add(messageBox, left);
        southPanel.add(sendMessage, right);

        chatBox.setFont(new Font("Serif", Font.PLAIN, 15));
        sendMessage.addActionListener(new sendMessageButtonListener());
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.setSize(600, 600);
    }

    class sendMessageButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (messageBox.getText().length() < 1) {
                // do nothing 
            } else if (messageBox.getText().equals(".clear")) {
                chatBox.setText("Cleared all messages\n");
                messageBox.setText("");
            } else {
                chatBox.append(messageBox.getText() + "\n");
                messageBox.setText("");
            }
        }
        
  
    	
    }

    String username;

    class enterServerButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
          //  username = usernameChooser.getText();
           preFrame.setVisible(false);
        	display("Are you happy with the following 1-5\n");

        }

    }

}

