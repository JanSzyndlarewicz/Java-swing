package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import Vocabulary.functions;

public class Interface {
    private JButton Check;
    private JPanel PanelName;
    private JTextField Answer;
    private JTextField Question;
    private JButton Next;

    public Interface(String polish, String english) {

        Check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = Answer.getText();
                String answer = english;

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
        Question.setText(polish);

        Next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();

                String polish = "", english1 = "", odpowiedz = "";
                String[] tmp = null;

                tmp = functions.getLine(random.nextInt(functions.countLines())+1);
                english1 = tmp[0];
                polish = tmp[1];
                Question.setText(polish);

            }
        });

    }


    public static void main(String[] args) {
        Random random = new Random();

        String polish = "", english = "", odpowiedz = "";
        String[] tmp = null;

        tmp = functions.getLine(random.nextInt(functions.countLines())+1);
        english = tmp[0];
        polish = tmp[1];

        JFrame frame = new JFrame("App");
        frame.setContentPane(new Interface(polish, english).PanelName);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
