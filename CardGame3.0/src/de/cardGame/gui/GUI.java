package de.cardGame.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
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
    public JPanel titelPanel;

    public JLabel titellbl;

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

        addComponentsWithConstraintsForJPanel(jPanel, components);

        return jPanel;
    }

    public JPanel setupJPanel(LayoutManager layout, int width, int height, Color background,
            Object... components) {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(layout);
        jPanel.setPreferredSize(new Dimension(width, height));
        jPanel.setBackground(background);

        addComponentsWithConstraintsForJPanel(jPanel, components);

        return jPanel;
    }

    public void addComponentsWithConstraintsForJPanel(JPanel jPanel, Object... components) {
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

    public JLabel setupJLabel(String text, int fontSize, Color setBackgroundForJLabel) {
        JLabel jLabel = new JLabel();
        jLabel.setText(text);
        jLabel.setFont(new Font(CardGame.getSettings().getSchriftart(), Font.PLAIN, fontSize));
        jLabel.setBackground(setBackgroundForJLabel);
        jLabel.setForeground(Color.green);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setHorizontalTextPosition(SwingConstants.CENTER);

        return jLabel;
    }

    public JLabel setupJLabel(String text, int font, int fontSize) {
        JLabel jLabel = new JLabel();
        jLabel.setText(text);
        jLabel.setFont(new Font(CardGame.getSettings().getSchriftart(), font, fontSize));
        jLabel.setForeground(Color.green);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setHorizontalTextPosition(SwingConstants.CENTER);

        return jLabel;
    }

    public JLabel setupJLabel(String text, int fontSize, Color setBackgroundForJLabel, boolean isOpaque) {
        JLabel jLabel = new JLabel();
        jLabel.setText(text);
        jLabel.setFont(new Font(CardGame.getSettings().getSchriftart(), Font.PLAIN, fontSize));
        jLabel.setBackground(setBackgroundForJLabel);
        jLabel.setOpaque(isOpaque);
        jLabel.setForeground(Color.green);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setHorizontalTextPosition(SwingConstants.CENTER);

        return jLabel;
    }

    public JLabel setupJLabel(String text, int font, int fontSize, int hAlligment, int vAlligment) {
        JLabel jLabel = new JLabel();
        jLabel.setText(text);
        jLabel.setFont(new Font(CardGame.getSettings().getSchriftart(), font, fontSize));
        jLabel.setForeground(new Color(0x06A666));
        jLabel.setHorizontalAlignment(hAlligment);
        jLabel.setVerticalAlignment(vAlligment);

        return jLabel;
    }

    public JLabel setupJLabel(int width, int height, String text, int font, int fontSize, int hAlligment,
            int vAlligment) {
        JLabel jLabel = new JLabel();
        jLabel.setPreferredSize(new Dimension(width, height));
        jLabel.setText(text);
        jLabel.setFont(new Font(CardGame.getSettings().getSchriftart(), font, fontSize));
        jLabel.setForeground(new Color(0x06A666));
        jLabel.setHorizontalAlignment(hAlligment);
        jLabel.setVerticalAlignment(vAlligment);

        return jLabel;
    }

    public JLabel setupJLabel(int width, int height, String text, int font, int fontSize, Color color, int hAlligment,
            int htextPosition) {
        JLabel jLabel = new JLabel();
        jLabel.setPreferredSize(new Dimension(width, height));
        jLabel.setText(text);
        jLabel.setFont(new Font(CardGame.getSettings().getSchriftart(), font, fontSize));
        jLabel.setForeground(color);
        jLabel.setHorizontalAlignment(hAlligment);
        jLabel.setHorizontalTextPosition(htextPosition);

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

    public JButton setupJButton(String text, int font, int fontSize, Color background, Color foreground,
            boolean visible, ActionListener actionListener) {
        JButton jButton = new JButton();
        jButton.setText(text);
        jButton.setFont(new Font(CardGame.getSettings().getSchriftart(), font, fontSize));
        jButton.setBackground(background);
        jButton.setForeground(foreground);
        jButton.setFocusable(false);
        jButton.setBorder(BorderFactory.createEmptyBorder());
        jButton.setVisible(visible);

        jButton.addActionListener(actionListener);

        return jButton;

    }

    public JButton setupJButton(String text, int font, int fontSize, Color background, Color foreground,
            IconPath iconPath, ActionListener actionListener) {
        JButton jButton = new JButton();
        jButton.setText(text);
        jButton.setFont(new Font(CardGame.getSettings().getSchriftart(), font, fontSize));
        jButton.setBackground(background);
        jButton.setForeground(foreground);
        jButton.setIcon(new IconManager(iconPath).getImageIcon());
        jButton.setFocusable(false);
        jButton.setBorder(BorderFactory.createEmptyBorder());

        jButton.addActionListener(actionListener);

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

    public JButton setupJButton(String text, int fontsize, Color backgroundColor, Color foregroundColor,
            int directionHorrizontalAlligment, int directionHorizontalTextPosition, ActionListener actionListener) {
        JButton jButton = new JButton();
        jButton.setText(text);
        jButton.setFont(new Font(CardGame.getSettings().getSchriftart(), Font.PLAIN, fontsize));
        jButton.setBackground(backgroundColor);
        jButton.setForeground(foregroundColor);
        jButton.setHorizontalAlignment(directionHorrizontalAlligment);
        jButton.setHorizontalTextPosition(directionHorizontalTextPosition);
        jButton.setFocusable(false);
        jButton.setBorder(BorderFactory.createEmptyBorder());

        jButton.addActionListener(actionListener);

        return jButton;
    }

    public JButton setupJButton(String text, int font, int fontsize, Color backgroundColor, Color foregroundColor,
            int directionHorrizontalAlligment, int directionHorizontalTextPosition, boolean isOpaque,
            ActionListener actionListener) {
        JButton jButton = new JButton();
        jButton.setText(text);
        jButton.setFont(new Font(CardGame.getSettings().getSchriftart(), font, fontsize));
        jButton.setBackground(backgroundColor);
        jButton.setForeground(foregroundColor);
        jButton.setHorizontalAlignment(directionHorrizontalAlligment);
        jButton.setHorizontalTextPosition(directionHorizontalTextPosition);
        jButton.setFocusable(false);
        jButton.setOpaque(isOpaque);
        jButton.setBorder(BorderFactory.createEmptyBorder());

        jButton.addActionListener(actionListener);

        return jButton;
    }

    public JProgressBar setupJProgressBar(int min, int max, int width, int height, int value, int font, int fontSize) {
        JProgressBar jProgressBar = new JProgressBar(min, max);
        jProgressBar.setPreferredSize(new Dimension(420, 50));
        jProgressBar.setValue(value);
        jProgressBar.setStringPainted(true);
        jProgressBar.setBackground(Color.black);
        jProgressBar.setForeground(Color.red);
        jProgressBar.setFont(new Font(CardGame.getSettings().getSchriftart(), font, fontSize));

        return jProgressBar;
    }

    public JMenu setupJMenu(String arg0, int keyEvent, IconPath iconPath, Object... components) {
        JMenu jMenu = new JMenu(arg0);
        jMenu.setBackground(CardGame.BackgroundColor);
        jMenu.setFocusable(false);
        jMenu.setMnemonic(keyEvent);
        jMenu.setForeground(new Color(0x06A666));
        jMenu.setIcon(new IconManager(iconPath).getImageIcon());
        jMenu.setFont(new Font(CardGame.getSettings().getSchriftart(), Font.PLAIN, 20));

        addComponentsWithConstraintsForJMenu(jMenu, components);

        return jMenu;
    }

    public void addComponentsWithConstraintsForJMenu(JMenu jMenu, Object... components) {
        for (int i = 0; i < components.length; i++) {
            if (components[i] instanceof Component) {
                // check if next is a constraint
                if (i + 1 < components.length && !(components[i + 1] instanceof Component)) {
                    jMenu.add((Component) components[i], components[i + 1]);
                    i++; // skip constraint
                } else {
                    jMenu.add((Component) components[i]);
                }

            }
        }
    }

    public JMenuBar setupJMenuBar(int width, int height, int font, int fontSize, Object... components) {
        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.setPreferredSize(new Dimension(width, height));
        jMenuBar.setFont(new Font(CardGame.getSettings().getSchriftart(), font, fontSize));
        jMenuBar.setBackground(CardGame.BackgroundColor);
        jMenuBar.setBorder(BorderFactory.createEmptyBorder());

        addComponentsWithConstraintsForJMenuBar(jMenuBar, components);

        return jMenuBar;
    }

    public void addComponentsWithConstraintsForJMenuBar(JMenuBar jMenuBar, Object... components) {
        for (int i = 0; i < components.length; i++) {
            if (components[i] instanceof Component) {
                // check if next is a constraint
                if (i + 1 < components.length && !(components[i + 1] instanceof Component)) {
                    jMenuBar.add((Component) components[i], components[i + 1]);
                    i++; // skip constraint
                } else {
                    jMenuBar.add((Component) components[i]);
                }

            }
        }
    }

    public JMenuItem setupJMenuItem(String arg0, int keyEvent, ActionListener actionListener, IconPath iconpath) {
        JMenuItem jMenuitem = new JMenuItem(arg0);
        jMenuitem.setBackground(CardGame.BackgroundColor);
        jMenuitem.setFocusable(false);
        jMenuitem.setMnemonic(keyEvent);
        jMenuitem.setForeground(new Color(0x06A666));
        jMenuitem.addActionListener(actionListener);
        jMenuitem.setIcon(new IconManager(iconpath).getImageIcon());
        jMenuitem.setFont(new Font(CardGame.getSettings().getSchriftart(), Font.PLAIN, 20));

        return jMenuitem;
    }

    public void close() {
        this.frame.dispose();
    }

    public void actionPerformed() {

    }
}
