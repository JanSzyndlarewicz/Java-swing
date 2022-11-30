package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface {
    private JButton Go;
    private JPanel PanelName;
    private JTextField Answer;
    private JTextField Question;
    private boolean ifClicked = false;

    public Interface() {
        Go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = Answer.getText();
                String answer = "cat";

                if(answer.equals(name)){
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Dobrze!");
                }
                else{
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), answer);
                }
                Answer.setText("");

            }
        });

        Question.setEditable(false);
        Question.setText("kot");

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new Interface().PanelName);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
