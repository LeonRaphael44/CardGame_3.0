package de.cardGame.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import de.cardGame.main.CardGame;

public abstract class GUI {

    public JPanel setuJPanel() {
        JPanel jPanel = new JPanel();

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
}
