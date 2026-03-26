package de.cardGame.gui;

import java.awt.BorderLayout;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import de.cardGame.main.CardGame;
import de.cardGame.utils.icons.IconManager;
import de.cardGame.utils.icons.IconPath;
import de.cardGame.utils.words.WordTypes;
import de.cardGame.utils.words.Words;

public class KeyUseGUI extends GUI {

	private JLabel titellbl, AltA, AltB, AltC, AltP, AltE, AltH, Titelscrenn, Settings, Zurueck, KartePath;

	public KeyUseGUI() {
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

		titellbl = setupJLabel(Words.get(WordTypes.KeyUse), 60, CardGame.BackgroundColor);

		AltA = setupJLabel("Alt + A | " + Words.get(WordTypes.KeyUseVorlesen).replace("%Karte%", "(a)"),
				15, CardGame.BackgroudColorMatch2, true);

		AltB = setupJLabel("Alt + B | " + Words.get(WordTypes.KeyUseVorlesen).replace("%Karte%", "(b)"),
				15, CardGame.BackgroudColorMatch2, true);

		AltC = setupJLabel("Alt + C | " + Words.get(WordTypes.KeyUseVorlesen).replace("%Karte%", "(c)"),
				15, CardGame.BackgroudColorMatch2, true);

		AltP = setupJLabel("Alt + P | " + Words.get(WordTypes.KeyUsePages),
				15, CardGame.BackgroudColorMatch2, true);

		AltE = setupJLabel("Alt + E | " + Words.get(WordTypes.KeyUseExtras),
				15, CardGame.BackgroudColorMatch2, true);

		AltH = setupJLabel("Alt + H | " + Words.get(WordTypes.KeyUseHelp),
				15, CardGame.BackgroudColorMatch2, true);

		Titelscrenn = setupJLabel("Alt + P + T | " + Words.get(WordTypes.KeyUseTitelScreen),
				15, CardGame.BackgroudColorMatch2, true);

		Settings = setupJLabel("Alt + P + S | " + Words.get(WordTypes.KeyUseSettings),
				15, CardGame.BackgroudColorMatch2, true);

		Zurueck = setupJLabel("Alt + E + Z | " + Words.get(WordTypes.KeyUseKarteBack),
				15, CardGame.BackgroudColorMatch2, true);

		KartePath = setupJLabel("Alt + E + K | " + Words.get(WordTypes.KeyUseKartPath),
				15, CardGame.BackgroudColorMatch2, true);

		PanelmainNorth = setupJPanel(new BorderLayout(), 20, 100, CardGame.BackgroundColor, titellbl);

		PanelmainEast = setupJPanel(new BorderLayout(), 20, 20, CardGame.BackgroundColor);

		PanelmainWest = setupJPanel(new BorderLayout(), 20, 20, CardGame.BackgroundColor);

		PanelmainSouth = setupJPanel(new BorderLayout(), 20, 20, CardGame.BackgroundColor);
		// new Color(0x505050)

		contentPanel = setupJPanel(new GridLayout(5, 2, 10, 10), CardGame.BackgroundColor, AltA, AltB, AltC, AltE, AltH,
				AltP, Titelscrenn, Settings, KartePath, Zurueck);

		framePanel = setupJPanel(new BorderLayout(), CardGame.BackgroundColor, PanelmainNorth, BorderLayout.NORTH,
				PanelmainEast, BorderLayout.EAST, PanelmainWest, BorderLayout.WEST, PanelmainSouth, BorderLayout.SOUTH,
				contentPanel, BorderLayout.CENTER);

		this.frame.add(framePanel);
	}

}
