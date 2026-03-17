package de.cardGame.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

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
}
