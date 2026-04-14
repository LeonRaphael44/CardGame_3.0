package de.cardGame.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import de.cardGame.cards.Card;
import de.cardGame.main.CardGame;
import de.cardGame.utils.StoppUhr;
import de.cardGame.utils.icons.IconManager;
import de.cardGame.utils.icons.IconPath;
import de.cardGame.utils.sprachausgabe.SprachAusgabe;
import de.cardGame.utils.sprachausgabe.TextType;
import de.cardGame.utils.words.WordTypes;
import de.cardGame.utils.words.Words;

public class GameGUI extends GUI implements ActionListener {

	private JLabel StoryCreator, ProgrammedBy, PlaceHolderProgrammedBy;

	private JButton titelbtn, Storybtn, Abtn, Bbtn, Cbtn, VorlesenAbtn, VorlesenBbtn, VorlesenCbtn = new JButton();

	private JMenuBar menuBar;
	private JMenu Pages, Extras, Help;
	private JMenuItem Startscreen, Settings, PageBack, ProgrammedByHelp, KeyUse, CardPath, kannstdulesen;

	public GameGUI(JFrame lframe) {
		if (lframe == null) {
			this.frame = new JFrame();
			this.frame.setSize(1052, 596);
			int width = CardGame.getGraphicsDevice().getDisplayMode().getWidth();
			int height = CardGame.getGraphicsDevice().getDisplayMode().getHeight();

			this.frame.setLocation((int) ((width / 2) - (this.frame.getSize().getWidth() / 2)),
					(int) ((height / 2) - (this.frame.getSize().getHeight() / 2)));
		} else {
			this.frame = lframe;
		}
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setLayout(new BorderLayout());
		this.frame.setResizable(true);
		this.frame.setTitle(Words.get(WordTypes.Name));
		this.frame.setAlwaysOnTop(false);
		this.frame.setVisible(true);
		this.frame.getContentPane().setBackground(Color.DARK_GRAY);
		this.frame.setIconImage(new IconManager(IconPath.GameIcon).getImage());

		titelbtn = setupJButton(Words.get(WordTypes.Karte) + "1", 60,
				CardGame.BackgroundColor, Color.green,
				SwingConstants.CENTER, SwingConstants.CENTER, this);
		titelbtn.setActionCommand("TITLE");

		CardPath = setupJMenuItem(Words.get(WordTypes.CardPath), KeyEvent.VK_K,
				this, IconPath.CardPathx32);
		CardPath.setActionCommand("CARD_PATH");

		Settings = setupJMenuItem(Words.get(WordTypes.Settings), KeyEvent.VK_S, this, IconPath.Settingsx32);
		Settings.setActionCommand("SETTINGS");

		Startscreen = setupJMenuItem(Words.get(WordTypes.StartScreen), KeyEvent.VK_T, this, IconPath.Startscreenx32);
		Startscreen.setActionCommand("STARTSCREEN");

		ProgrammedByHelp = setupJMenuItem(Words.get(WordTypes.ProgrammedBy), 0, this,
				IconPath.ProgrammedByx32);
		ProgrammedByHelp.setActionCommand("HELP");

		KeyUse = setupJMenuItem(Words.get(WordTypes.KeyUse), 0, this, IconPath.KeyUsex32);
		KeyUse.setActionCommand("KEY_USE");

		PageBack = setupJMenuItem(Words.get(WordTypes.PageBack), KeyEvent.VK_Z, this, IconPath.CardBackx32);
		PageBack.setActionCommand("PAGEBACK");

		kannstdulesen = setupJMenuItem(Words.get(WordTypes.KannstDuLesen), 0, this, IconPath.KannstDuLesen);
		kannstdulesen.setVisible(false);
		kannstdulesen.setActionCommand("KANNST_DU_LESEN");

		Pages = setupJMenu(Words.get(WordTypes.Pages), KeyEvent.VK_P, IconPath.Pagesx32, Settings, Startscreen);

		Help = setupJMenu(Words.get(WordTypes.Help), KeyEvent.VK_H, IconPath.Helpx32, ProgrammedByHelp, KeyUse);

		Extras = setupJMenu(Words.get(WordTypes.Pages), KeyEvent.VK_E, IconPath.Extrasx32, PageBack, CardPath);

		menuBar = setupJMenuBar(420, 32, Font.PLAIN, 20, Pages, Extras, Help, kannstdulesen);

		this.frame.setJMenuBar(menuBar);

		// the text while the game is running (below button C)

		StoryCreator = setupJLabel(Words.get(WordTypes.StoryBasedOn), 400, 20);

		ProgrammedBy = setupJLabel("© Copyright 2021 Timon Filz", 220, 20);

		PlaceHolderProgrammedBy = setupJLabel("Placeholder", 220, 20);

		Storybtn = setupJButton(CardGame.cards.get(0).getText(), 26,
				CardGame.BackgroudColorMatch2, new Color(0x06A666),
				SwingConstants.LEFT, SwingConstants.LEFT, this);
		Storybtn.setVerticalTextPosition(SwingConstants.TOP);
		Storybtn.setVerticalAlignment(SwingConstants.TOP);
		Storybtn.setActionCommand("STORY");

		// the buttons for choosing
		Abtn = setupAbcButton("A");
		Abtn.setActionCommand("A");

		Bbtn = setupAbcButton("B");
		Bbtn.setActionCommand("B");

		Cbtn = setupAbcButton("C");
		Cbtn.setActionCommand("C");

		VorlesenAbtn = setupVorleseButton('a');
		VorlesenAbtn.setActionCommand("READ_A");

		VorlesenBbtn = setupVorleseButton('b');
		VorlesenBbtn.setActionCommand("READ_B");

		VorlesenCbtn = setupVorleseButton('c');
		VorlesenCbtn.setActionCommand("READ_C");

		contentPanelTop = setupJPanel(new BorderLayout(), 40, 40, new Color(0x505050), Storybtn,
				BorderLayout.CENTER);

		contentPanelBottom_Right = setupJPanel(new GridLayout(3, 1, 10, 10), 100, 40, CardGame.BackgroundColor,
				Abtn, Bbtn, Cbtn);

		contentPanelBottom_Left = setupJPanel(new GridLayout(3, 1, 10, 10), 100, 40, CardGame.BackgroundColor,
				VorlesenAbtn, VorlesenBbtn, VorlesenCbtn);

		contentPanelBottom = setupJPanel(new BorderLayout(), 40, 40, CardGame.BackgroundColor,
				contentPanelBottom_Left, BorderLayout.WEST, contentPanelBottom_Right, BorderLayout.CENTER);

		contentPanel = setupJPanel(new GridLayout(2, 1, 10, 10), 0, 0, CardGame.BackgroundColor, contentPanelTop,
				contentPanelBottom);

		PanelmainNorth = setupMainJPanel(new BorderLayout(), 100, 100, CardGame.BackgroundColor, titelbtn,
				BorderLayout.CENTER);
		PanelmainEast = setupMainJPanel(null, 20, 20, CardGame.BackgroundColor);
		PanelmainWest = setupMainJPanel(null, 20, 20, CardGame.BackgroundColor);
		PanelmainSouth = setupMainJPanel(new BorderLayout(), 40, 30, CardGame.BackgroundColor, StoryCreator,
				BorderLayout.CENTER, ProgrammedBy, BorderLayout.EAST, PlaceHolderProgrammedBy, BorderLayout.WEST);

		framePanel = setupJPanel(new BorderLayout(), new Color(
				0x505050), PanelmainNorth, BorderLayout.NORTH, PanelmainEast, BorderLayout.EAST, PanelmainWest,
				BorderLayout.WEST, PanelmainSouth, BorderLayout.SOUTH, contentPanel, BorderLayout.CENTER);

		this.frame.add(framePanel);

		setCardText(0);
	}

	public void setCardText(int id) {
		Card C = CardGame.cards.get(id);
		Card.AktiveCardID = id;
		if (id == 15 || id == 43 || id == 50
				|| (id == 26 && !Card.German && CardGame.getSettings().getStimmenArt().equalsIgnoreCase("W"))
				|| (id == 64 && !Card.German && CardGame.getSettings().getStimmenArt().equalsIgnoreCase("W"))
				|| (id == 45 && Card.German && CardGame.getSettings().getStimmenArt().equalsIgnoreCase("M"))
				|| ((id == 11 || id == 21 || id == 35 || id == 39 || id == 65) && !Card.German
						&& CardGame.getSettings().getStimmenArt().equalsIgnoreCase("M"))
				|| (id == 13 && !Card.German && CardGame.getSettings().getStimmenArt().equalsIgnoreCase("M"))) {
			kannstdulesen.setVisible(true);
		} else {
			kannstdulesen.setVisible(false);
		}
		titelbtn.setText(Words.get(WordTypes.Karte) + String.valueOf((id + 1)));

		if (C.getAntwortA() != null) {
			Abtn.setText(C.getAntwortA());
			Abtn.setVisible(true);
			VorlesenAbtn.setVisible(true);
			Bbtn.setText(C.getAntwortB());
			Bbtn.setVisible(true);
			VorlesenBbtn.setVisible(true);
			Cbtn.setText(C.getAntwortC());
			Cbtn.setVisible(true);
			VorlesenCbtn.setVisible(true);
			Storybtn.setText(C.getText());
		} else if (C.isSonder()) {
			Abtn.setText(C.getAntwortA());
			Abtn.setVisible(true);
			VorlesenAbtn.setVisible(true);
			Bbtn.setText(C.getAntwortB());
			Bbtn.setVisible(true);
			VorlesenBbtn.setVisible(true);
			Cbtn.setVisible(false);
			VorlesenCbtn.setVisible(false);
			Storybtn.setText(C.getText());
		} else if (C.isBlank()) {
			Abtn.setText(Words.get(WordTypes.Weiter));
			Abtn.setVisible(true);
			VorlesenAbtn.setVisible(true);
			Bbtn.setVisible(false);
			VorlesenBbtn.setVisible(false);
			Cbtn.setVisible(false);
			VorlesenCbtn.setVisible(false);
			Storybtn.setText(C.getText());
		} else if (C.isOver()) {
			Abtn.setText(Words.get(WordTypes.GameOver));
			Abtn.setVisible(true);
			VorlesenAbtn.setVisible(true);
			Bbtn.setVisible(false);
			VorlesenBbtn.setVisible(false);
			Cbtn.setVisible(false);
			VorlesenCbtn.setVisible(false);
			Storybtn.setText(C.getText());
		}
		this.frame.setVisible(true);
	}

	public JPanel setupMainJPanel(LayoutManager layout, int arg0, int arg1, Color background, Object... components) {
		JPanel jPanel = new JPanel();
		jPanel.setLayout(layout);
		jPanel.setPreferredSize(new Dimension(arg0, arg1));
		jPanel.setBackground(background);
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

		return jPanel;
	}

	public JLabel setupJLabel(String text, int arg0, int arg1) {
		JLabel jLabel = new JLabel();
		jLabel.setText(text);
		jLabel.setPreferredSize(new Dimension(arg0, arg1));
		jLabel.setFont(new Font(CardGame.getSettings().getSchriftart(), Font.PLAIN, 12));
		jLabel.setForeground(new Color(0x808000));
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setVerticalTextPosition(SwingConstants.TOP);
		jLabel.setHorizontalTextPosition(SwingConstants.CENTER);

		return jLabel;
	}

	public JButton setupAbcButton(String button) {
		JButton jButton = new JButton();
		switch (button) {
			case "A":
				jButton.setText(CardGame.cards.get(0).getAntwortA());
				break;
			case "B":
				jButton.setText(CardGame.cards.get(0).getAntwortB());
				break;
			case "C":
				jButton.setText(CardGame.cards.get(0).getAntwortC());
				break;
		}

		jButton.setFont(new Font(CardGame.getSettings().getSchriftart(), Font.PLAIN, 25));
		jButton.setForeground(new Color(0x06A666));
		jButton.setBackground(CardGame.BackgroudColorMatch2);
		jButton.setHorizontalAlignment(SwingConstants.LEFT);
		jButton.setVerticalTextPosition(SwingConstants.CENTER);
		jButton.setVerticalAlignment(SwingConstants.CENTER);
		jButton.setHorizontalTextPosition(SwingConstants.LEFT);
		jButton.setFocusable(false);
		jButton.addActionListener(this);
		jButton.setBorder(BorderFactory.createEmptyBorder());

		return jButton;
	}
	// * The value of button has to be in lowercase
	// and also in ' ' not in " " */

	public JButton setupVorleseButton(char button) {
		JButton jButton = new JButton();
		jButton.setForeground(new Color(0x06A666));
		jButton.setBackground(CardGame.BackgroudColorMatch2);
		jButton.setFocusable(false);
		jButton.setMnemonic(button);
		jButton.addActionListener(this);
		jButton.setIcon(new IconManager(IconPath.Playx64).getImageIcon());
		jButton.setBorder(BorderFactory.createEmptyBorder());

		return jButton;
	}

	private boolean vorgelesenA = false, vorgelesenB = false, vorgelesenC = false;

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "TITLE":
				setPlayButtonsIconsAfterEnd();
				SprachausgabenAsistent(TextType.Card);
				break;
			case "STORY":
				setPlayButtonsIconsAfterEnd();
				SprachausgabenAsistent(TextType.Story);
				break;
			case "A":
				handleAnswerOfButtonA();
				break;
			case "B":
				handleAnswerOfButton(TextType.B, 'b', CardGame.cards.get(Card.AktiveCardID).getNextB());
				break;
			case "C":
				handleAnswerOfButton(TextType.C, 'c', CardGame.cards.get(Card.AktiveCardID).getNextC());

				break;
			case "READ_A":
				handleReadButtonA(e, vorgelesenA, VorlesenAbtn, true, false, false);
				break;
			case "READ_B":
				handleReadButton(e, vorgelesenB, VorlesenBbtn, false, true, false, TextType.B);
				break;
			case "READ_C":
				handleReadButton(e, vorgelesenC, VorlesenCbtn, false, false, true, TextType.C);
				break;
			case "CARD_PATH":
				ShowCardPath();
				break;
			case "STARTSCREEN":
				de.cardGame.utils.settings.Settings.Cardback = 2;
				StopSprachausgabeAsistent();
				Words.choosenWayID.add(Card.AktiveCardID);
				Words.choosenWayAnswer.add(TextType.GameOver);
				Words.choosenWay
						.add(Words.get(WordTypes.Karte) + (Card.AktiveCardID + 1) + " + "
								+ Words.get(WordTypes.GameOver));
				CardGame.getGUI().dispose();
				StartScreenGUI startScreenGUI = new StartScreenGUI(null);
				StoppUhr.Stopp();
				SetCardPathinStartScreen(startScreenGUI);
				CardGame.setGUI(startScreenGUI.getFrame());
				startScreenGUI.setPlayAudioSotryVisible(true);
				if (CardGame.getSettings().isAutoplayaftergame()) {
					SprachAusgabe.PlayGameInAudio();
				}
				break;
			case "SETTINGS":
				StopSprachausgabeAsistent();
				CardGame.getGUI().dispose();
				StoppUhr.Stopp();
				CardGame.setGUI(new SettingsGUI(null).getFrame());
				break;
			case "PAGEBACK":
				if (de.cardGame.utils.settings.Settings.Cardback <= 2
						&& de.cardGame.utils.settings.Settings.Cardback >= 1) {
					de.cardGame.utils.settings.Settings.Cardback--;
					StopSprachausgabeAsistent();
					if (Words.choosenWay.size() >= 1) {
						setCardText(Words.choosenWayID.get((Words.choosenWayID.size() - 1)));
						Words.choosenWayAnswer.remove((Words.choosenWayAnswer.size() - 1));
						Words.choosenWayID.remove((Words.choosenWayID.size() - 1));
						Words.choosenWayAnswer.remove((Words.choosenWayAnswer.size() - 1));
						Words.choosenWayID.remove((Words.choosenWayID.size() - 1));
						Words.choosenWay.remove((Words.choosenWay.size() - 1));
					} else {
						setCardText(0);
					}
				} else {
					JOptionPane.showMessageDialog(CardGame.getGUI(), Words.get(WordTypes.NOMoreCardsBack));
				}
				break;
			case "HELP":
				new ProgrammedByGUI();
				break;
			case "KEY_USE":
				new KeyUseGUI();
				break;
			case "KANNST_DU_LESEN":

				handleQuiz();
				break;

		}

	}

	private void handleReadButtonA(ActionEvent e, boolean readButton, JButton button, boolean readA, boolean readB,
			boolean readC) {
		if (readButton) {
			button.setIcon(new IconManager(IconPath.Playx64).getImageIcon());
			vorgelesenA = false;
			vorgelesenB = false;
			vorgelesenC = false;
		} else {
			button.setIcon(new IconManager(IconPath.Stopx64).getImageIcon());
			vorgelesenA = readA;
			vorgelesenB = readB;
			vorgelesenC = readC;
		}
		switch (e.getActionCommand()) {
			case "READ_A":
				VorlesenBbtn.setIcon(new IconManager(IconPath.Playx64).getImageIcon());
				VorlesenCbtn.setIcon(new IconManager(IconPath.Playx64).getImageIcon());
				break;
			case "READ_B":
				VorlesenAbtn.setIcon(new IconManager(IconPath.Playx64).getImageIcon());
				VorlesenCbtn.setIcon(new IconManager(IconPath.Playx64).getImageIcon());
				break;
			case "READ_C":
				VorlesenAbtn.setIcon(new IconManager(IconPath.Playx64).getImageIcon());
				VorlesenBbtn.setIcon(new IconManager(IconPath.Playx64).getImageIcon());
				break;

		}
		handleReadButtonATextType();
	}

	private void handleReadButtonATextType() {
		if (Card.getCardByID(Card.AktiveCardID).isOver()) {
			SprachausgabenAsistent(TextType.GameOver);
		} else if (Card.getCardByID(Card.AktiveCardID).isBlank()) {
			SprachausgabenAsistent(TextType.Weiter);
		} else {
			SprachausgabenAsistent(TextType.A);
		}

	}

	private void handleReadButton(ActionEvent e, boolean readButton, JButton button, boolean readA, boolean readB,
			boolean readC,
			TextType textType) {
		if (readButton) {
			button.setIcon(new IconManager(IconPath.Playx64).getImageIcon());
			vorgelesenA = false;
			vorgelesenB = false;
			vorgelesenC = false;
		} else {
			button.setIcon(new IconManager(IconPath.Stopx64).getImageIcon());
			vorgelesenA = readA;
			vorgelesenB = readB;
			vorgelesenC = readC;
		}
		switch (e.getActionCommand()) {
			case "READ_A":
				VorlesenBbtn.setIcon(new IconManager(IconPath.Playx64).getImageIcon());
				VorlesenCbtn.setIcon(new IconManager(IconPath.Playx64).getImageIcon());
				break;
			case "READ_B":
				VorlesenAbtn.setIcon(new IconManager(IconPath.Playx64).getImageIcon());
				VorlesenCbtn.setIcon(new IconManager(IconPath.Playx64).getImageIcon());
				break;
			case "READ_C":
				VorlesenAbtn.setIcon(new IconManager(IconPath.Playx64).getImageIcon());
				VorlesenBbtn.setIcon(new IconManager(IconPath.Playx64).getImageIcon());
				break;

		}
		SprachausgabenAsistent(textType);
	}

	private void handleAnswerOfButton(TextType textType, char buttonLetterInLowerCase, int id) {
		setPlayButtonsIconsAfterEnd();
		Words.choosenWayID.add(Card.AktiveCardID);
		Words.choosenWayAnswer.add(TextType.Story);
		StopSprachausgabeAsistent();
		Words.choosenWayID.add(Card.AktiveCardID);
		Words.choosenWayAnswer.add(textType);
		Words.choosenWay
				.add(Words.get(WordTypes.Karte) + (Card.AktiveCardID + 1) + " + " + buttonLetterInLowerCase + ")");
		setCardText(id);
	}

	private void handleAnswerOfButtonA() {
		setPlayButtonsIconsAfterEnd();
		Words.choosenWayID.add(Card.AktiveCardID);
		Words.choosenWayAnswer.add(TextType.Story);
		StopSprachausgabeAsistent();
		if (Abtn.getText().equalsIgnoreCase(Words.get(WordTypes.GameOver))) {
			de.cardGame.utils.settings.Settings.Cardback = 2;
			Words.choosenWayID.add(Card.AktiveCardID);
			Words.choosenWayAnswer.add(TextType.GameOver);
			Words.choosenWay.add(
					Words.get(WordTypes.Karte) + (Card.AktiveCardID + 1) + " + "
							+ Words.get(WordTypes.GameOver));
			CardGame.getGUI().dispose();
			StartScreenGUI startScreenGUI = new StartScreenGUI(null);
			StoppUhr.Stopp();
			SetCardPathinStartScreen(startScreenGUI);
			CardGame.setGUI(startScreenGUI.getFrame());
			startScreenGUI.setPlayAudioSotryVisible(true);
			if (CardGame.getSettings().isAutoplayaftergame()) {
				SprachAusgabe.PlayGameInAudio();
			}
		} else if (Abtn.getText().equalsIgnoreCase(Words.get(WordTypes.Weiter))) {
			Words.choosenWayID.add(Card.AktiveCardID);
			Words.choosenWayAnswer.add(TextType.Weiter);
			Words.choosenWay.add(
					Words.get(WordTypes.Karte) + (Card.AktiveCardID + 1) + " + " + Words.get(WordTypes.Weiter));
			setCardText(CardGame.cards.get(Card.AktiveCardID).getNextA());
		} else {
			Words.choosenWayID.add(Card.AktiveCardID);
			Words.choosenWayAnswer.add(TextType.A);
			Words.choosenWay.add(Words.get(WordTypes.Karte) + (Card.AktiveCardID + 1) + " + a)");
			setCardText(CardGame.cards.get(Card.AktiveCardID).getNextA());
		}
	}

	private void handleQuiz() {
		try {
			if (Card.AktiveCardID == 43 || Card.AktiveCardID == 50) {
				String intput = JOptionPane.showInputDialog(Words.get(WordTypes.Card43und50Fehler));
				if (intput.equalsIgnoreCase(Words.get(WordTypes.Roulette))) {
					JOptionPane.showMessageDialog(null, Words.get(WordTypes.Richtig),
							Words.get(WordTypes.Card43und50Fehler), JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, Words.get(WordTypes.Falsch),
							Words.get(WordTypes.Card43und50Fehler), JOptionPane.ERROR_MESSAGE);
				}
			}
			if (Card.AktiveCardID == 26 && !Card.German) {
				String intput = JOptionPane.showInputDialog(Words.get(WordTypes.Card26Fehler));
				if (intput.equalsIgnoreCase(Words.get(WordTypes.marrythem))) {
					JOptionPane.showMessageDialog(null, Words.get(WordTypes.Richtig),
							Words.get(WordTypes.Card26Fehler), JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, Words.get(WordTypes.Falsch),
							Words.get(WordTypes.Card26Fehler), JOptionPane.ERROR_MESSAGE);
				}
			}
			if (Card.AktiveCardID == 64 && !Card.German) {
				String intput = JOptionPane.showInputDialog(Words.get(WordTypes.Card64Fehler));
				if (intput.equalsIgnoreCase(Words.get(WordTypes.your))) {
					JOptionPane.showMessageDialog(null, Words.get(WordTypes.Richtig),
							Words.get(WordTypes.Card64Fehler), JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, Words.get(WordTypes.Falsch),
							Words.get(WordTypes.Card64Fehler), JOptionPane.ERROR_MESSAGE);
				}
			}
			if (Card.AktiveCardID == 45 && Card.German) {
				String intput = JOptionPane.showInputDialog(Words.get(WordTypes.Card45Fehler));
				if (intput.equalsIgnoreCase(Words.get(WordTypes.das))) {
					JOptionPane.showMessageDialog(null, Words.get(WordTypes.Richtig),
							Words.get(WordTypes.Card45Fehler), JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, Words.get(WordTypes.Falsch),
							Words.get(WordTypes.Card45Fehler), JOptionPane.ERROR_MESSAGE);
				}
			}
			if ((Card.AktiveCardID == 11 || Card.AktiveCardID == 21 || Card.AktiveCardID == 35
					|| Card.AktiveCardID == 39 || Card.AktiveCardID == 65) && !Card.German) {
				String intput = JOptionPane.showInputDialog(Words.get(WordTypes.Card11_21_35_39_65Fehler));
				if (intput.equalsIgnoreCase(Words.get(WordTypes.colleague))) {
					JOptionPane.showMessageDialog(null, Words.get(WordTypes.Richtig),
							Words.get(WordTypes.Card11_21_35_39_65Fehler), JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, Words.get(WordTypes.Falsch),
							Words.get(WordTypes.Card11_21_35_39_65Fehler), JOptionPane.ERROR_MESSAGE);
				}
			}
			if (Card.AktiveCardID == 13 && !Card.German) {
				String intput = JOptionPane.showInputDialog(Words.get(WordTypes.Card13Fehler));
				if (intput.equalsIgnoreCase(Words.get(WordTypes.whom))) {
					JOptionPane.showMessageDialog(null, Words.get(WordTypes.Richtig),
							Words.get(WordTypes.Card13Fehler), JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, Words.get(WordTypes.Falsch),
							Words.get(WordTypes.Card13Fehler), JOptionPane.ERROR_MESSAGE);
				}
			}
			if (Card.AktiveCardID == 15) {
				String intput = JOptionPane.showInputDialog(Words.get(WordTypes.Card15Fehler));
				if (intput.equalsIgnoreCase(Words.get(WordTypes.two))) {
					JOptionPane.showMessageDialog(null, Words.get(WordTypes.Richtig),
							Words.get(WordTypes.Card15Fehler), JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, Words.get(WordTypes.Falsch),
							Words.get(WordTypes.Card15Fehler), JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (NullPointerException nullPointerException) {

		}
	}

	}

	private void SetCardPathinStartScreen(StartScreenGUI startScreenGUI) {
		if (Words.choosenWay.size() > 50) {
			startScreenGUI.setTextTimeNumberOfCardsCardPath(
					StoppUhr.SetTitle(StoppUhr.std, StoppUhr.min, StoppUhr.sek, false),
					Words.choosenWay.toString().replace("[", "").replace("]", "").replace(", ", " → "), 10,
					Words.choosenWay.size());
		} else if (Words.choosenWay.size() < 30) {
			startScreenGUI.setTextTimeNumberOfCardsCardPath(
					StoppUhr.SetTitle(StoppUhr.std, StoppUhr.min, StoppUhr.sek, false),
					Words.choosenWay.toString().replace("[", "").replace("]", "").replace(", ", " → "), 20,
					Words.choosenWay.size());
		} else {
			startScreenGUI.setTextTimeNumberOfCardsCardPath(
					StoppUhr.SetTitle(StoppUhr.std, StoppUhr.min, StoppUhr.sek, false),
					Words.choosenWay.toString().replace("[", "").replace("]", "").replace(", ", " → "), 15,
					Words.choosenWay.size());
		}
	}

	@SuppressWarnings("deprecation")
	private void ShowCardPath() {
		JOptionPane p;
		String text = Words.choosenWay.toString().replace("[", "").replace("]", "");
		System.out.println(text);
		if (Words.choosenWay.size() > 0) {
			String[] karten = text.split(",");
			int br = 10;
			for (int i = 0; i < karten.length; i++) {
				if (i == br) {
					karten[i] = "<br>" + karten[i];
					br = br + 10;
				}
			}
			Words.choosenWay.clear();
			for (int i = 0; i < karten.length; i++) {
				Words.choosenWay.add(karten[i]);
			}
			String ende = Words.choosenWay.toString().replace("[", "").replace("]", "").replace(", ", " → ");
			System.out.println(ende);

			p = setupJOptionPane(Words.getHtmlText(ende));
		} else {
			p = setupJOptionPane(Words.getHtmlText(Words.get(WordTypes.NoCardsChoosen)));
		}
	}

	private JOptionPane setupJOptionPane(Object message) {
		JOptionPane p = new JOptionPane(message);
		p.setBackground(Color.DARK_GRAY);
		p.setFont(new Font(CardGame.getSettings().getSchriftart(), Font.PLAIN, 12));
		JDialog dialog = p.createDialog(Words.get(WordTypes.CardPath));
		dialog.setBackground(Color.DARK_GRAY);
		dialog.setFont(new Font(CardGame.getSettings().getSchriftart(), Font.PLAIN, 12));
		dialog.setAlwaysOnTop(true);
		dialog.show();

		return p;
	}

	public void setPlayButtonsIconsAfterEnd() {
		VorlesenAbtn.setIcon(new IconManager(IconPath.Playx64).getImageIcon());
		VorlesenBbtn.setIcon(new IconManager(IconPath.Playx64).getImageIcon());
		VorlesenCbtn.setIcon(new IconManager(IconPath.Playx64).getImageIcon());
		vorgelesenA = false;
		vorgelesenB = false;
		vorgelesenC = false;
	}

	public static void StopSprachausgabeAsistent() {
		if (sa != null) {
			if (sa.isRunning()) {
				sa.Stop();
			}
		}
	}

	private static SprachAusgabe sa = null;
	Timer t = null;

	private void SprachausgabenAsistent(TextType X) {
		if (sa == null) {
			voiceOutput(X);
		} else {
			if (sa.isRunning()) {
				if (sa.getPlayedcard() == Card.getCardByID(Card.AktiveCardID)) {
					if (sa.getPlayedText().equals(X)) {
						stopVoiceOutput();
					} else {
						stopVoiceOutput();
						voiceOutput(X);
					}
				} else {
					stopVoiceOutput();
					voiceOutput(X);
				}
			} else {
				voiceOutput(X);
			}
		}
	}

	private void voiceOutput(TextType x) {
		sa = new SprachAusgabe(Card.getCardByID(Card.AktiveCardID), x);
		t = new Timer();
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				setPlayButtonsIconsAfterEnd();
			}
		}, sa.getCliplength() / 1000);
	}

	private void stopVoiceOutput() {
		sa.Stop();
		if (t != null) {
			t.cancel();
			t = null;
		}
	}

}
