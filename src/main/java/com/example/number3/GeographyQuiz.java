package com.example.number3;

import java.awt.*;
import java.awt.event.*;

public class GeographyQuiz extends Frame {
    private Panel panel1, panel2, panel3, panel4;
    private TextField question1TextField, question2TextField, question3TextField;
    private Label scoreLabel1, scoreLabel2, scoreLabel3, scoreLabel4;
    private Button nextButton, backButton;
    private CardLayout cardLayout;
    private Panel cardPanel;
    private int currentPanel = 1;
    private int score = 0;
    private final String[] answers = {"Paris", "Tokyo", "Berlin"};

    public GeographyQuiz() {
        setTitle("Geography Quiz");
        setSize(450, 400);
        setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        cardPanel = new Panel(cardLayout);

        panel1 = new Panel(new BorderLayout());
        panel1.setName("panel1");
        scoreLabel1 = new Label("Your Score: 0/3");
        scoreLabel1.setName("scoreLabel");
        Panel content1 = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 30));
        Label q1Label = new Label("What is the capital of France?");
        q1Label.setFont(new Font("Arial", Font.BOLD, 12));
        content1.add(q1Label);
        question1TextField = new TextField(20);
        question1TextField.setName("question1TextField");
        content1.add(question1TextField);
        panel1.add(scoreLabel1, BorderLayout.NORTH);
        panel1.add(content1, BorderLayout.CENTER);

        panel2 = new Panel(new BorderLayout());
        panel2.setName("panel2");
        scoreLabel2 = new Label("Your Score: 0/3");
        scoreLabel2.setName("scoreLabel");
        Panel content2 = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 30));
        Label q2Label = new Label("What is the capital of Japan?");
        q2Label.setFont(new Font("Arial", Font.BOLD, 12));
        content2.add(q2Label);
        question2TextField = new TextField(20);
        question2TextField.setName("question2TextField");
        content2.add(question2TextField);
        panel2.add(scoreLabel2, BorderLayout.NORTH);
        panel2.add(content2, BorderLayout.CENTER);

        panel3 = new Panel(new BorderLayout());
        panel3.setName("panel3");
        scoreLabel3 = new Label("Your Score: 0/3");
        scoreLabel3.setName("scoreLabel");
        Panel content3 = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 30));
        Label q3Label = new Label("What is the capital of Germany?");
        q3Label.setFont(new Font("Arial", Font.BOLD, 12));
        content3.add(q3Label);
        question3TextField = new TextField(20);
        question3TextField.setName("question3TextField");
        content3.add(question3TextField);
        panel3.add(scoreLabel3, BorderLayout.NORTH);
        panel3.add(content3, BorderLayout.CENTER);

        panel4 = new Panel(new BorderLayout());
        panel4.setName("panel4");
        scoreLabel4 = new Label("Your Score: 0/3");
        scoreLabel4.setName("scoreLabel");
        Panel content4 = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 50));
        Label congratsLabel = new Label("Congratulations! You have finished the quiz.");
        congratsLabel.setFont(new Font("Arial", Font.BOLD, 12));
        content4.add(congratsLabel);
        panel4.add(scoreLabel4, BorderLayout.NORTH);
        panel4.add(content4, BorderLayout.CENTER);

        cardPanel.add(panel1, "1");
        cardPanel.add(panel2, "2");
        cardPanel.add(panel3, "3");
        cardPanel.add(panel4, "4");
        add(cardPanel, BorderLayout.CENTER);

        Panel buttonPanel = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        backButton = new Button("Back");
        backButton.setName("backButton");
        backButton.setVisible(false);
        buttonPanel.add(backButton);

        nextButton = new Button("Next");
        nextButton.setName("nextButton");
        buttonPanel.add(nextButton);

        add(buttonPanel, BorderLayout.SOUTH);

        nextButton.addActionListener(e -> {
            computeScore();
            currentPanel++;
            cardLayout.show(cardPanel, String.valueOf(currentPanel));
            updateButtons();
        });

        backButton.addActionListener(e -> {
            currentPanel--;
            cardLayout.show(cardPanel, String.valueOf(currentPanel));
            updateButtons();
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void computeScore() {
        score = 0;
        if (question1TextField.getText().trim().equalsIgnoreCase(answers[0])) score++;
        if (question2TextField.getText().trim().equalsIgnoreCase(answers[1])) score++;
        if (question3TextField.getText().trim().equalsIgnoreCase(answers[2])) score++;
        String scoreText = "Your Score: " + score + "/3";
        scoreLabel1.setText(scoreText);
        scoreLabel2.setText(scoreText);
        scoreLabel3.setText(scoreText);
        scoreLabel4.setText(scoreText);
    }

    private void updateButtons() {
        backButton.setVisible(currentPanel > 1);
        nextButton.setVisible(currentPanel < 4);
    }

    public static void main(String[] args) {
        new GeographyQuiz();
    }
}
