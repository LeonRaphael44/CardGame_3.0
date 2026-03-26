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
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import de.cardGame.main.CardGame;
import de.cardGame.utils.StoppUhr;
import de.cardGame.utils.icons.IconManager;
import de.cardGame.utils.icons.IconPath;
import de.cardGame.utils.sprachausgabe.SprachAusgabe;
import de.cardGame.utils.words.WordTypes;
import de.cardGame.utils.words.Words;

public class StartScreenGUI extends GUI implements ActionListener {

	private JLabel subtitellbl;
	private JLabel TimePlayed;
	private JLabel NumberOfCards;
	private JLabel CardPath;
	private JButton Settings;
	private JButton PlayAudioSotry;
	private JButton PlayGame;
	private JPanel contentPanel1;
	private JPanel contentPanel2;
	private JPanel contentPanel3;

	public StartScreenGUI(JFrame lframe) {
		if (lframe == null) {
			this.frame = new JFrame();
			;
			this.frame.setSize(1052, 596);
			int width = CardGame.getGraphicsDevice().getDisplayMode().getWidth();
			int height = CardGame.getGraphicsDevice().getDisplayMode().getHeight();

			this.frame.setLocation((int) ((width / 2) - (this.frame.getSize().getWidth() / 2)),
					(int) ((height / 2) - (this.frame.getSize().getHeight() / 2)));
		} else {
			this.frame = lframe;
			this.frame.removeAll();
		}
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setLayout(new BorderLayout());
		this.frame.setResizable(true);
		this.frame.setTitle(Words.get(WordTypes.Name));
		this.frame.setAlwaysOnTop(false);
		this.frame.setVisible(true);
		this.frame.setIconImage(new IconManager(IconPath.GameIcon).getImage());

		titellbl = setupJLabel(Words.get(WordTypes.Name), Font.BOLD, 60);

		subtitellbl = setupJLabel(20, 175, Words.get(WordTypes.UnterTitel), Font.BOLD, 50, Color.green,
				SwingConstants.CENTER, SwingConstants.CENTER);

		titelPanel = setupJPanel(new BorderLayout(), 20, 175, CardGame.BackgroundColor, titellbl, BorderLayout.NORTH,
				subtitellbl, BorderLayout.CENTER);

		PanelmainEast = setupJPanel(5, 5, CardGame.BackgroundColor);

		PanelmainWest = setupJPanel(5, 5, CardGame.BackgroundColor);

		PanelmainSouth = setupJPanel(40, 20, CardGame.BackgroundColor);

		TimePlayed = setupJLabel(400, 50, Words.get(WordTypes.Versuchszeit), Font.PLAIN, 30, SwingConstants.LEFT,
				SwingConstants.BOTTOM);

		NumberOfCards = setupJLabel(400, 50, Words.get(WordTypes.CardsChoosen), Font.PLAIN, 30, SwingConstants.LEFT,
				SwingConstants.TOP);

		contentPanel1 = setupJPanel(new GridLayout(2, 1, 10, 10), CardGame.BackgroudColorMatch2, TimePlayed,
				NumberOfCards);

		CardPath = setupJLabel(Words.get(WordTypes.Kartenpfad), Font.PLAIN, 40, SwingConstants.LEFT,
				SwingConstants.TOP);

		contentPanel2 = setupJPanel(new BorderLayout(), CardGame.BackgroudColorMatch2, CardPath, BorderLayout.CENTER);

		Settings = setupJButton(Words.get(WordTypes.Settings), Font.PLAIN, 35, CardGame.BackgroudColorMatch2,
				new Color(0x06A666), IconPath.Settingsx64, this);

		PlayAudioSotry = setupJButton(Words.get(WordTypes.PlayAudioStory), Font.PLAIN, 35,
				CardGame.BackgroudColorMatch2, new Color(0x06A666), false, this);

		PlayGame = setupJButton(Words.get(WordTypes.Play), Font.PLAIN, 35, CardGame.BackgroudColorMatch2,
				new Color(0x06A666), IconPath.Play, this);

		contentPanel3 = setupJPanel(new GridLayout(1, 3, 10, 10), CardGame.BackgroundColor, Settings, PlayAudioSotry,
				PlayGame);

		contentPanel = setupJPanel(new GridLayout(3, 1, 10, 10), CardGame.BackgroundColor, contentPanel1, contentPanel2,
				contentPanel3);

		framePanel = setupJPanel(new BorderLayout(), CardGame.BackgroudColorMatch2, titelPanel, BorderLayout.NORTH,
				PanelmainEast, BorderLayout.EAST, PanelmainWest, BorderLayout.WEST, PanelmainSouth, BorderLayout.SOUTH,
				contentPanel, BorderLayout.CENTER);

		this.frame.add(framePanel, BorderLayout.CENTER);
	}

	public void removeFramePanel() {
		this.frame.remove(framePanel);
	}

	public void setFramePanel(JPanel panel) {
		this.frame.add(panel, BorderLayout.CENTER);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Settings) {
			CheckPlayBack();
			CardGame.getGUI().dispose();
			SettingsGUI gui = new SettingsGUI(null);
			CardGame.setGUI(gui.getFrame());
			CardGame.getGUI().show();
		} else if (e.getSource() == PlayGame) {
			Words.choosenWay.clear();
			Words.choosenWayAnswer.clear();
			Words.choosenWayID.clear();
			CheckPlayBack();
			StoppUhr.Run();
			CardGame.getGUI().dispose();
			CardGame.setGUI(new GameGUI(null).getFrame());
		} else if (e.getSource() == PlayAudioSotry) {
			SprachAusgabe.PlayGameInAudio();
		}

	}

	private void CheckPlayBack() {
		if (SprachAusgabe.PlayBackisRunning) {
			SprachAusgabe.stopPlayBack = true;
		}
	}

	public void setTextTimeNumberOfCardsCardPath(String Versuchszeit, String Text, int size, int versuchsmenge) {
		TimePlayed.setText(Words.get(WordTypes.Versuchszeit) + " " + Versuchszeit);
		NumberOfCards.setText(Words.get(WordTypes.CardsChoosen) + " " + versuchsmenge);
		CardPath.setFont(new Font(CardGame.getSettings().getSchriftart(), Font.BOLD, size));
		CardPath.setText("<html><body>" + Words.get(WordTypes.Kartenpfad) + "<br>" + Text + "</body></html>");
	}

	public void setPlayAudioSotryVisible(boolean value) {
		PlayAudioSotry.setVisible(value);
	}
}
