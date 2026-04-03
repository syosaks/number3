package com.example.number3;

import java.awt.*;
import java.awt.event.*;

public class NumberCounter extends Frame {
    private Label countLabel;
    private Button increaseButton;
    private Button decreaseButton;
    private int count = 0;

    public NumberCounter() {
        setTitle("Number Counter");
        setSize(400, 200);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));

        countLabel = new Label("0");
        countLabel.setName("countLabel");

        decreaseButton = new Button("Decrease");
        decreaseButton.setName("decreaseButton");

        increaseButton = new Button("Increase");
        increaseButton.setName("increaseButton");

        add(countLabel);
        add(decreaseButton);
        add(increaseButton);

        increaseButton.addActionListener(e -> {
            count++;
            countLabel.setText(String.valueOf(count));
        });

        decreaseButton.addActionListener(e -> {
            count--;
            countLabel.setText(String.valueOf(count));
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new NumberCounter();
    }
}
