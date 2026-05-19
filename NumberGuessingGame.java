package util.scanner;

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class NumberGuessingGame extends JFrame implements ActionListener {

    Random random = new Random();

    int randomNumber = random.nextInt(100) + 1;
    int attempts = 0;

    JLabel titleLabel, resultLabel, attemptsLabel;
    JTextField guessField;
    JButton guessButton, exitButton;

    NumberGuessingGame() {

        setTitle("Number Guessing Game");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titleLabel = new JLabel("Guess a Number (1-100)");
        titleLabel.setBounds(110, 30, 200, 30);
        add(titleLabel);

        guessField = new JTextField();
        guessField.setBounds(120, 70, 150, 30);
        add(guessField);

        guessButton = new JButton("Guess");
        guessButton.setBounds(70, 120, 100, 30);
        add(guessButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(210, 120, 100, 30);
        add(exitButton);

        resultLabel = new JLabel("");
        resultLabel.setBounds(140, 170, 200, 30);
        add(resultLabel);

        attemptsLabel = new JLabel("Attempts: 0");
        attemptsLabel.setBounds(140, 210, 150, 30);
        add(attemptsLabel);

        guessButton.addActionListener(this);
        exitButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == guessButton) {

            int guess = Integer.parseInt(guessField.getText());

            attempts++;

            if (guess < randomNumber) {

                resultLabel.setText("Too Low!");

            } else if (guess > randomNumber) {

                resultLabel.setText("Too High!");

            } else {

                resultLabel.setText("Correct!");
            }

            attemptsLabel.setText("Attempts: " + attempts);
        }

        if (e.getSource() == exitButton) {

            System.exit(0);
        }
    }

    public static void main(String[] args) {

        new NumberGuessingGame();
    }
}