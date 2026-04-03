package com.example.number3;

import java.awt.*;
import java.awt.event.*;

public class PizzaOrderSystem extends Frame {
    private Choice pizzaSizeChoice;
    private Choice pizzaToppingsChoice;
    private Choice extraCheeseChoice;
    private Label totalLabel;
    private Button calculateButton;

    public PizzaOrderSystem() {
        setTitle("Pizza Order System");
        setSize(400, 350);
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));

        Label sizeLabel = new Label("Size:");
        add(sizeLabel);

        pizzaSizeChoice = new Choice();
        pizzaSizeChoice.setName("pizzaSizeChoice");
        pizzaSizeChoice.add("Small");
        pizzaSizeChoice.add("Medium");
        pizzaSizeChoice.add("Large");
        add(pizzaSizeChoice);

        Label toppingsLabel = new Label("Toppings:");
        add(toppingsLabel);

        pizzaToppingsChoice = new Choice();
        pizzaToppingsChoice.setName("pizzaToppingsChoice");
        pizzaToppingsChoice.add("Mushrooms");
        pizzaToppingsChoice.add("Pepperoni");
        pizzaToppingsChoice.add("Onions");
        add(pizzaToppingsChoice);

        Label cheeseLabel = new Label("Extra Cheese:");
        add(cheeseLabel);

        extraCheeseChoice = new Choice();
        extraCheeseChoice.setName("extraCheeseChoice");
        extraCheeseChoice.add("Yes");
        extraCheeseChoice.add("No");
        add(extraCheeseChoice);

        calculateButton = new Button("Calculate Total");
        calculateButton.setName("calculateButton");
        add(calculateButton);

        totalLabel = new Label("          ");
        totalLabel.setName("totalLabel");
        add(totalLabel);

        calculateButton.addActionListener(e -> {
            int total = 0;

            String size = pizzaSizeChoice.getSelectedItem();
            switch (size) {
                case "Small": total += 10; break;
                case "Medium": total += 15; break;
                case "Large": total += 20; break;
            }

            total += 2;

            if (extraCheeseChoice.getSelectedItem().equals("Yes")) {
                total += 3;
            }

            totalLabel.setText(String.valueOf(total));
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new PizzaOrderSystem();
    }
}
