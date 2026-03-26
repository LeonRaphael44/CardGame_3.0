package de.cardGame.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.SwingConstants;

import de.cardGame.andereGames.GamesGUI;
import de.cardGame.cards.Card;
import de.cardGame.main.CardGame;
import de.cardGame.utils.StoppUhr;
import de.cardGame.utils.icons.IconManager;
import de.cardGame.utils.icons.IconPath;
import de.cardGame.utils.settings.Settings;
import de.cardGame.utils.sprachausgabe.TextType;
import de.cardGame.utils.words.WordTypes;
import de.cardGame.utils.words.Words;

public class ProgrammedByGUI extends GUI implements ActionListener {

	private JLabel Namelbl, Geburtstagslbl, Copyright;
	private JButton btnZocken;

	public ProgrammedByGUI() {
		this.frame = new JFrame();
		this.frame.setSize(Integer.valueOf((int) (CardGame.getGUI().getWidth() / 1.5)),
				Integer.valueOf((int) (CardGame.getGUI().getHeight() / 1.5)));
		int width = CardGame.getGraphicsDevice().getDisplayMode().getWidth();
		int height = CardGame.getGraphicsDevice().getDisplayMode().getHeight();
		this.frame.setLocation((int) ((width / 2) - (this.frame.getSize().getWidth() / 2)),
				(int) ((height / 2) - (this.frame.getSize().getHeight() / 2)));
		this.frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.frame.setLayout(new BorderLayout());
		this.frame.setResizable(true);
		this.frame.setTitle(Words.get(WordTypes.Name));
		this.frame.setAlwaysOnTop(false);
		this.frame.setVisible(true);
		this.frame.getContentPane().setBackground(CardGame.BackgroundColor);
		this.frame.setIconImage(new IconManager(IconPath.GameIcon).getImage());

		titellbl = setupJLabel(Words.get(WordTypes.Info), 24, CardGame.BackgroundColor);

		Namelbl = setupJLabel("Name: Timon Filz", 24, CardGame.BackgroudColorMatch2);

		Geburtstagslbl = setupJLabel(Words.get(WordTypes.Geburtstag) + ": 2002",
				24, CardGame.BackgroudColorMatch2);

		btnZocken = setupJButton(Words.get(WordTypes.VielSpassBeimZocken), Font.PLAIN, 24,
				CardGame.BackgroudColorMatch2, Color.green, SwingConstants.CENTER, SwingConstants.CENTER, false, this);

		Copyright = setupJLabel("� Copyright 2021 Timon Filz",
				24, CardGame.BackgroudColorMatch2);

		PanelmainNorth = setupJPanel(new BorderLayout(), CardGame.BackgroundColor, titellbl);

		PanelmainEast = setupJPanel(new BorderLayout(), 20, 20, CardGame.BackgroundColor);

		PanelmainWest = setupJPanel(new BorderLayout(), 20, 20, CardGame.BackgroundColor);

		PanelmainSouth = setupJPanel(new BorderLayout(), 20, 20, CardGame.BackgroundColor);

		contentPanel = setupJPanel(new GridLayout(4, 1, 10, 10), CardGame.BackgroundColor, Namelbl, Geburtstagslbl,
				btnZocken, Copyright);

		framePanel = setupJPanel(new BorderLayout(), CardGame.BackgroundColor, PanelmainNorth, BorderLayout.NORTH,
				PanelmainEast, BorderLayout.EAST, PanelmainWest, BorderLayout.WEST, PanelmainSouth, BorderLayout.SOUTH,
				contentPanel, BorderLayout.CENTER);

		this.frame.add(framePanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!(e.getSource() == btnZocken)) {
			return;
		}
		this.frame.dispose();
		Settings.Cardback = 2;
		GameGUI.StopSprachausgabeAsistent();
		Words.choosenWayID.add(Card.AktiveCardID);
		Words.choosenWayAnswer.add(TextType.GameOver);
		Words.choosenWay
				.add(Words.get(WordTypes.Karte) + (Card.AktiveCardID + 1) + " + " + Words.get(WordTypes.GameOver));
		CardGame.getGUI().dispose();
		StoppUhr.Stopp();
		CardGame.setGUI(new GamesGUI(false).getFrame());

	}

}
// test