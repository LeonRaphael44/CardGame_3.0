package de.cardGame.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import de.cardGame.main.CardGame;
import de.cardGame.utils.icons.IconManager;
import de.cardGame.utils.icons.IconPath;

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

    public JPanel setupJPanel(Component addAttr) {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.setBackground(CardGame.BackgroundColor);
        jPanel.add(addAttr);

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

    public JLabel setupJLabel() {
        JLabel jLabel = new JLabel();

        return jLabel;
    }

    public JLabel setupJLabel(String text, Color foreground, int style, int sizeOfFont,
            int alligment) {
        JLabel jLabel = new JLabel();
        jLabel.setText(text);
        jLabel.setForeground(foreground);
        jLabel.setFont(new Font(CardGame.getSettings().getSchriftart(), style, sizeOfFont));
        jLabel.setHorizontalAlignment(alligment);

        return jLabel;
    }

    public JLabel setupJLabel(int width, int height, String text, Color foreground, int style, int sizeOfFont,
            int alligment) {
        JLabel jLabel = new JLabel();
        jLabel.setPreferredSize(new Dimension(width, height));
        jLabel.setText(text);
        jLabel.setForeground(foreground);
        jLabel.setFont(new Font(CardGame.getSettings().getSchriftart(), style, sizeOfFont));
        jLabel.setHorizontalAlignment(alligment);

        return jLabel;
    }

    public JLabel setupJLabel(String setText, int fontSize, Color setBackgroundForJLabel) {
        JLabel jLabel = new JLabel();
        jLabel.setText(setText);
        jLabel.setFont(new Font(CardGame.getSettings().getSchriftart(), Font.PLAIN, fontSize));
        jLabel.setBackground(setBackgroundForJLabel);
        jLabel.setForeground(Color.green);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setHorizontalTextPosition(SwingConstants.CENTER);

        return jLabel;
    }

    public JLabel setupJLabel(String setText, int fontSize, Color setBackgroundForJLabel, boolean isOpaque) {
        JLabel jLabel = new JLabel();
        jLabel.setText(setText);
        jLabel.setFont(new Font(CardGame.getSettings().getSchriftart(), Font.PLAIN, fontSize));
        jLabel.setBackground(setBackgroundForJLabel);
        jLabel.setOpaque(isOpaque);
        jLabel.setForeground(Color.green);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setHorizontalTextPosition(SwingConstants.CENTER);

        return jLabel;
    }

    public JLabel setupJLabel(int width, int height, String text, Color foreground, int style, int sizeOfFont,
            int horizontalAlligment, int verticalAlligment, Color color, int thickness) {
        JLabel jLabel = new JLabel();
        jLabel.setPreferredSize(new Dimension(width, height));
        jLabel.setText(text);
        jLabel.setForeground(foreground);
        jLabel.setFont(new Font(CardGame.getSettings().getSchriftart(), style, sizeOfFont));
        jLabel.setHorizontalAlignment(horizontalAlligment);
        jLabel.setVerticalAlignment(verticalAlligment);
        jLabel.setBorder(BorderFactory.createLineBorder(color, thickness));

        return jLabel;
    }

    public JLabel setupJLabel(int width, int height, String text, Color foreground, int style, int sizeOfFont,
            int horizontalAlligment, int verticalAlligment, IconPath iconPath, Color color, int thickness) {
        JLabel jLabel = new JLabel();
        jLabel.setPreferredSize(new Dimension(width, height));
        jLabel.setText(text);
        jLabel.setForeground(foreground);
        jLabel.setFont(new Font(CardGame.getSettings().getSchriftart(), style, sizeOfFont));
        jLabel.setHorizontalAlignment(horizontalAlligment);
        jLabel.setVerticalAlignment(verticalAlligment);
        jLabel.setIcon(new IconManager(iconPath).getImageIcon());
        jLabel.setBorder(BorderFactory.createLineBorder(color, thickness));

        return jLabel;
    }

    public JRadioButton setupJRadioButton(String text, boolean focusable, Color background, Color foreground,
            int verticalTextPosition, ActionListener listener) {
        JRadioButton jRadioButton = new JRadioButton(text);
        jRadioButton.setFocusable(focusable);
        jRadioButton.setBackground(background);
        jRadioButton.setForeground(foreground);
        jRadioButton.setVerticalTextPosition(verticalTextPosition);
        jRadioButton.setFont(new Font(CardGame.getSettings().getSchriftart(), Font.PLAIN, 25));

        jRadioButton.addActionListener(listener);

        return jRadioButton;
    }

    public JCheckBox setupJCheckBox(boolean focusable, String text, Color background, Color foreground,
            int horizontalTextPosition, int iconTextgap, boolean selcted, ActionListener actionListener) {
        JCheckBox jCheckBox = new JCheckBox();
        jCheckBox.setFocusable(focusable);
        jCheckBox.setText(text);
        jCheckBox.setBackground(background);
        jCheckBox.setForeground(foreground);
        jCheckBox.setHorizontalTextPosition(horizontalTextPosition);
        jCheckBox.setIconTextGap(iconTextgap);
        jCheckBox.setSelected(selcted);
        jCheckBox.setFont(new Font(CardGame.getSettings().getSchriftart(), Font.PLAIN, 25));

        jCheckBox.addActionListener(actionListener);

        return jCheckBox;
    }

    public JComboBox<String> setupJComboBox(String[] items, Object anObject, ActionListener actionListener) {
        JComboBox<String> jComboBox = new JComboBox<String>(items);
        jComboBox.setBackground(CardGame.BackgroudColorMatch2);
        jComboBox.setForeground(new Color(0x06A666));
        jComboBox.setBorder(BorderFactory.createLineBorder(CardGame.BackgroudColorMatch2, 10));
        jComboBox.setFont(new Font(CardGame.getSettings().getSchriftart(), Font.PLAIN, 30));
        jComboBox.setBorder(BorderFactory.createEmptyBorder());
        jComboBox.setSelectedItem(anObject);

        jComboBox.addActionListener(actionListener);

        return jComboBox;
    }

    public JButton setupJButton() {
        JButton jButton = new JButton();

        return jButton;
    }

    public JButton setupJButton(String text, IconPath iconPath, ActionListener actionListener) {
        JButton jButton = new JButton();
        jButton.setPreferredSize(new Dimension(180, 30));
        jButton.setText(text);
        jButton.setFont(new Font(CardGame.getSettings().getSchriftart(), Font.PLAIN, 30));
        jButton.setForeground(new Color(0x06A666));
        jButton.setBackground(CardGame.BackgroudColorMatch2);
        jButton.setFocusable(false);
        jButton.setIcon(new IconManager(iconPath).getImageIcon());
        jButton.setBorder(BorderFactory.createEmptyBorder());
        jButton.setVerticalAlignment(SwingConstants.CENTER);
        jButton.setHorizontalAlignment(SwingConstants.CENTER);

        jButton.addActionListener(actionListener);

        return jButton;
    }
}
