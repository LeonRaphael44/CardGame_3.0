package de.cardGame.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import de.cardGame.main.CardGame;

public abstract class GUI {

    public JFrame frame;
    public JPanel framePanel;
    public JPanel PanelmainNorth;
    public JPanel PanelmainEast;
    public JPanel PanelmainWest;
    public JPanel PanelmainSouth;
    public JPanel contentPanel;
    public JPanel contentPanelTop;
    public JPanel contentPanelBottom;
    public JPanel contentPanelBottom_Left;
    public JPanel contentPanelBottom_Right;

    public GUI() {
        this.frame = new JFrame();
    }

    public JPanel setupJPanel(Component addAttr) {
        JPanel jPanel = new JPanel();
        jPanel.setBackground(CardGame.BackgroundColor);
        jPanel.setLayout(new BorderLayout());
        jPanel.add(addAttr);

        return jPanel;
    }

    public JButton setupJButton() {
        JButton jButton = new JButton();

        return jButton;
    }

    public JLabel setupJLabel(String setText, Color setBackgroundForJLabel) {
        JLabel jLabel = new JLabel();
        jLabel.setText(setText);
        jLabel.setFont(new Font(CardGame.getSettings().getSchriftart(), Font.PLAIN, 24));
        jLabel.setBackground(setBackgroundForJLabel);
        jLabel.setOpaque(true);
        jLabel.setForeground(Color.green);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setHorizontalTextPosition(SwingConstants.CENTER);

        return jLabel;
    }

    public JFrame getFrame() {
        return this.frame;
    }

    public JPanel setupJPanel() {
        JPanel jPanel = new JPanel();

        return jPanel;
    }

    public JPanel setupJPanel(LayoutManager layout, Color background) {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(layout);
        jPanel.setBackground(background);

        return jPanel;
    }

    public JPanel setupJPanel(int width, int height, Color background) {
        JPanel jPanel = new JPanel();
        jPanel.setPreferredSize(new Dimension(width, height));
        jPanel.setBackground(background);

        return jPanel;
    }

    public JPanel setupJPanel(LayoutManager layout, Color background, Object... components) {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(layout);
        jPanel.setBackground(background);

        addComponentsWithConstraints(jPanel, components);

        return jPanel;
    }

    public JPanel setupJPanel(LayoutManager layout, int width, int height, Color background,
            Object... components) {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(layout);
        jPanel.setPreferredSize(new Dimension(width, height));
        jPanel.setBackground(background);

        addComponentsWithConstraints(jPanel, components);

        return jPanel;
    }

    public void addComponentsWithConstraints(JPanel jPanel, Object... components) {
        for (int i = 0; i < components.length; i++) {
            if (components[i] instanceof Component) {
                // check if next is a constraint
                if (i + 1 < components.length && !(components[i + 1] instanceof Component)) {
                    jPanel.add((Component) components[i], components[i + 1]);
                    i++; // skip constraint
                } else {
                    jPanel.add((Component) components[i]);
                }

            }
        }
    }
}
