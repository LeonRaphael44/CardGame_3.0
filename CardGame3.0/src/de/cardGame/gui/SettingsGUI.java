package de.cardGame.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import de.cardGame.cards.Card;
import de.cardGame.cards.generate.CardGenDe;
import de.cardGame.cards.generate.CardGenEn;
import de.cardGame.main.CardGame;
import de.cardGame.utils.StoppUhr;
import de.cardGame.utils.icons.IconManager;
import de.cardGame.utils.icons.IconPath;
import de.cardGame.utils.settings.Settings;
import de.cardGame.utils.sprachausgabe.TextType;
import de.cardGame.utils.words.WordTypes;
import de.cardGame.utils.words.Words;

public class SettingsGUI extends GUI implements ActionListener, ChangeListener {

	private JPanel titelPanel;
	private JPanel mainEast;
	private JPanel mainWest;
	private JPanel mainSouth;
	private JPanel contentPanel;
	private JPanel contentPanelleft;
	private JPanel contentPanelcenter;
	private JPanel contentPanelright;
	private JPanel contentPanelcenter1, contentPanelcenter2, contentPanelcenter3, contentPanelcenter4,
			contentPanelcenter5, contentPanelcenter6;
	private JLabel languagelbl;
	private JLabel schriftartlbl;
	private JComboBox<String> langugagecbb;
	private JComboBox<String> schriftartcbb;
	private JSlider slider;
	private JLabel slidertitellbl;
	private JLabel sliderbottomlbl;
	private JLabel titellbl;
	private JCheckBox AutoPlayAfterGameEndckb;
	private JCheckBox AutoSaveAfterChangesckb;
	private JButton Speichern;
	private JButton PlayDirect;
	private JButton Titelscreen;

	private JRadioButton Meanlich;
	private JRadioButton Weiblich;
	private JPanel groupPanelstimme;
	private JLabel groupstimmelbl;
	private JLabel designlbl;
	private JRadioButton Hell;
	private JRadioButton Dunkel;
	private JPanel groupPanelDesign;

	private ButtonGroup vorlesestimme = new ButtonGroup();
	private ButtonGroup groupdesign = new ButtonGroup();

	private int AudioValue;
	private boolean AutoSave;
	private boolean PlaySotryAfterGameend;
	private String stimmenart;
	private String schriftart;
	private String design;
	private String sprache;

	public SettingsGUI(JFrame frame) {
		if (frame == null) {
			this.frame = new JFrame();
			this.frame.setSize(1052, 596);
			int width = CardGame.getGraphicsDevice().getDisplayMode().getWidth();
			int height = CardGame.getGraphicsDevice().getDisplayMode().getHeight();

			this.frame.setLocation((int) ((width / 2) - (this.frame.getSize().getWidth() / 2)),
					(int) ((height / 2) - (this.frame.getSize().getHeight() / 2)));
		} else {
			CardGame.setGUI(null);
			this.frame = frame;
		}
		Settings st = CardGame.getSettings();
		setAudioValue(st.getAudiovalue());
		setAutoSave(st.isAutoSave());
		setPlaySotryAfterGameend(st.isAutoplayaftergame());
		setStimmenart(st.getStimmenArt());
		setSchriftart(st.getSchriftart());
		setdesign(st.getDesign());
		setSprache(st.getLanguage());
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setLayout(new BorderLayout());
		this.frame.setResizable(true);
		this.frame.setAlwaysOnTop(false);
		this.frame.setTitle(Words.get(WordTypes.Name));
		this.frame.setIconImage(new IconManager(IconPath.GameIcon).getImage());

		titellbl = setupJLabel(Words.get(WordTypes.Settings), Color.green, Font.BOLD, 40,
				SwingConstants.CENTER);

		titelPanel = setupJPanel(new BorderLayout(), 10, 75, CardGame.BackgroundColor, titellbl, BorderLayout.CENTER);

		mainEast = setupJPanel(5, 5, CardGame.BackgroundColor);

		mainWest = setupJPanel(5, 5, CardGame.BackgroundColor);

		mainSouth = setupJPanel(5, 5, CardGame.BackgroundColor);

		slidertitellbl = setupJLabel(5, 60, Words.get(WordTypes.Volume), new Color(0x06A666), Font.BOLD, 30,
				SwingConstants.CENTER);

		slider = new JSlider(0, 100, CardGame.getSettings().getAudiovalue());
		slider.setBackground(CardGame.BackgroudColorMatch2);
		slider.setForeground(new Color(0x06A666));
		slider.setPreferredSize(new Dimension(50, 400));
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(10);
		slider.setPaintTrack(true);
		slider.setMajorTickSpacing(50);
		slider.setFont(new Font(CardGame.getSettings().getSchriftart(), Font.PLAIN, 20));
		slider.setPaintLabels(true);
		slider.addChangeListener(this);
		slider.setOrientation(SwingConstants.VERTICAL);
		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				sliderbottomlbl.setText(slider.getValue() + "%");
				setAudioValue(slider.getValue());
			}
		});

		sliderbottomlbl = setupJLabel(5, 60, CardGame.getSettings().getAudiovalue() + "%", new Color(0x06A666),
				Font.BOLD, 30,
				SwingConstants.CENTER);

		contentPanelleft = setupJPanel(new BorderLayout(), CardGame.BackgroudColorMatch2, sliderbottomlbl,
				BorderLayout.NORTH, slider, BorderLayout.CENTER, sliderbottomlbl, BorderLayout.SOUTH);

		languagelbl = setupJLabel(250, 30, Words.get(WordTypes.Sprache), new Color(
				0x06A666), Font.PLAIN, 30, SwingConstants.LEFT, SwingConstants.CENTER, CardGame.BackgroudColorMatch2,
				5);

		langugagecbb = new JComboBox<>(CardGame.getSettings().getLanguages(CardGame.getSettings().getLanguage()));
		langugagecbb.setBackground(CardGame.BackgroudColorMatch2);
		langugagecbb.setForeground(new Color(0x06A666));
		langugagecbb.setBorder(BorderFactory.createLineBorder(CardGame.BackgroudColorMatch2, 10));
		langugagecbb.setFont(new Font(CardGame.getSettings().getSchriftart(), Font.PLAIN, 30));
		langugagecbb.setBorder(BorderFactory.createEmptyBorder());
		langugagecbb.addActionListener(this);
		if (getSprache().equalsIgnoreCase("De_de")) {
			langugagecbb.setSelectedIndex(1);
		} else if (getSprache().equalsIgnoreCase("En_en")) {
			langugagecbb.setSelectedIndex(0);
		}

		contentPanelcenter1 = setupJPanel(new BorderLayout(), CardGame.BackgroudColorMatch2, languagelbl,
				BorderLayout.WEST, langugagecbb, BorderLayout.CENTER);

		schriftartlbl = setupJLabel(250, 30, Words.get(WordTypes.Schriftart), new Color(0x06A666), Font.PLAIN,
				30, SwingConstants.LEFT, SwingConstants.CENTER, IconPath.Fontx64,
				CardGame.BackgroudColorMatch2, 5);

		schriftartcbb = new JComboBox<>(CardGame.getSettings().getSchriftArten());
		schriftartcbb.setBackground(CardGame.BackgroudColorMatch2);
		schriftartcbb.setForeground(new Color(0x06A666));
		schriftartcbb.setBorder(BorderFactory.createLineBorder(CardGame.BackgroudColorMatch2, 10));
		schriftartcbb.setFont(new Font(CardGame.getSettings().getSchriftart(), Font.PLAIN, 30));
		schriftartcbb.setBorder(BorderFactory.createEmptyBorder());
		schriftartcbb.setSelectedItem(CardGame.getSettings().getSchriftart());
		schriftartcbb.addActionListener(this);

		contentPanelcenter2 = setupJPanel(new BorderLayout(), CardGame.BackgroudColorMatch2, schriftartlbl,
				BorderLayout.WEST, schriftartcbb, BorderLayout.CENTER);

		AutoPlayAfterGameEndckb = setupJCheckBox(false, Words.get(WordTypes.AutoPlayAfterGameEnd),
				CardGame.BackgroudColorMatch2, new Color(0x06A666), SwingConstants.LEFT, 20,
				CardGame.getSettings().isAutoplayaftergame(), this);

		contentPanelcenter3 = setupJPanel(new BorderLayout(), CardGame.BackgroudColorMatch2,
				AutoPlayAfterGameEndckb, BorderLayout.CENTER);

		AutoSaveAfterChangesckb = setupJCheckBox(false, Words.get(WordTypes.AutoSave),
				CardGame.BackgroudColorMatch2, new Color(0x06A666), SwingConstants.LEFT, 20,
				CardGame.getSettings().isAutoplayaftergame(), this);

		contentPanelcenter4 = setupJPanel(new BorderLayout(), CardGame.BackgroudColorMatch2,
				AutoSaveAfterChangesckb, BorderLayout.CENTER);

		groupstimmelbl = setupJLabel(200, 30, Words.get(WordTypes.VorleseStimme), new Color(0x06A666), Font.PLAIN,
				25, SwingConstants.LEFT, SwingConstants.CENTER, CardGame.BackgroudColorMatch2, 5);

		Dunkel = setupJRadioButton(Words
				.get(WordTypes.Male), false, CardGame.BackgroudColorMatch2, new Color(0x06A666),
				SwingConstants.CENTER, this);

		Weiblich = setupJRadioButton(Words
				.get(WordTypes.Female), false, CardGame.BackgroudColorMatch2, new Color(0x06A666),
				SwingConstants.CENTER, this);

		if (CardGame.getSettings().getStimmenArt().equalsIgnoreCase("W")) {
			Weiblich.setSelected(true);
		} else if (CardGame.getSettings().getStimmenArt().equalsIgnoreCase("M")) {
			Meanlich.setSelected(true);
		}

		vorlesestimme.add(Meanlich);
		vorlesestimme.add(Weiblich);

		groupPanelstimme = setupJPanel(new GridLayout(2, 1, 5, 5), CardGame.BackgroudColorMatch2, Meanlich, Weiblich);

		contentPanelcenter5 = setupJPanel(new BorderLayout(), CardGame.BackgroudColorMatch2, groupstimmelbl,
				BorderLayout.WEST, groupPanelstimme, BorderLayout.CENTER);

		designlbl = setupJLabel(200, 30, Words.get(WordTypes.Design), new Color(0x06A666), Font.PLAIN, 25,
				SwingConstants.LEFT, SwingConstants.CENTER, CardGame.BackgroudColorMatch2, 5);

		Dunkel = setupJRadioButton(Words
				.get(WordTypes.Dunkel), false, CardGame.BackgroudColorMatch2, new Color(0x06A666),
				SwingConstants.CENTER,
				this);

		Hell = setupJRadioButton(Words
				.get(WordTypes.Hell), false, CardGame.BackgroudColorMatch2, new Color(0x06A666), SwingConstants.CENTER,
				this);

		if (getdesign().equalsIgnoreCase("Dunkel")) {
			Dunkel.setSelected(true);
		} else if (getdesign().equalsIgnoreCase("Hell")) {
			Hell.setSelected(true);
		}

		groupPanelDesign = setupJPanel(new GridLayout(2, 1, 5, 5), CardGame.BackgroudColorMatch2, Dunkel, Hell);

		groupdesign.add(Dunkel);
		groupdesign.add(Hell);

		contentPanelcenter6 = setupJPanel(new BorderLayout(), CardGame.BackgroudColorMatch2, designlbl,
				BorderLayout.WEST, groupPanelDesign, BorderLayout.CENTER);

		contentPanelcenter = setupJPanel(new GridLayout(6, 1, 5, 5), CardGame.BackgroundColor,
				contentPanelcenter1, contentPanelcenter2, contentPanelcenter3, contentPanelcenter4, contentPanelcenter5,
				contentPanelcenter6);

		Speichern = setupJButton(Words.get(WordTypes.SpeichernButton), IconPath.Savex64);

		Titelscreen = setupJButton(Words.get(WordTypes.TitelScreenButton), IconPath.Startscreenx64);

		PlayDirect = setupJButton(Words.get(WordTypes.PlayDirectButton), IconPath.DirectPlay);

		contentPanelright = setupJPanel(new GridLayout(3, 1, 5, 5), CardGame.BackgroundColor, Titelscreen,
				PlayDirect, Speichern);

		contentPanel = setupJPanel(new GridLayout(1, 3, 5, 5), CardGame.BackgroundColor, contentPanelright,
				contentPanelcenter, contentPanelleft);

		contentPanel.add(contentPanelright);// Ist jetzt einfach links eigentlich ist das contentPanelleft hier
		contentPanel.add(contentPanelcenter);
		contentPanel.add(contentPanelleft);// Ist jetzt einfach rechts eigentlich ist das contentPanelright hier

		framePanel = setupJPanel(new BorderLayout(), CardGame.BackgroudColorMatch2, titelPanel, BorderLayout.NORTH,
				mainEast, BorderLayout.EAST, mainWest, BorderLayout.WEST, mainSouth, BorderLayout.SOUTH, contentPanel,
				BorderLayout.CENTER);

		this.frame.add(framePanel);
		this.frame.setVisible(true);
	}

	public JButton setupJButton(String text, IconPath iconPath) {
		JButton jButton = new JButton();
		jButton.setPreferredSize(new Dimension(180, 30));
		jButton.setText(text);
		jButton.setFont(new Font(CardGame.getSettings().getSchriftart(), Font.PLAIN, 30));
		jButton.setForeground(new Color(0x06A666));
		jButton.setBackground(CardGame.BackgroudColorMatch2);
		jButton.setFocusable(false);
		jButton.addActionListener(this);
		jButton.setIcon(new IconManager(iconPath).getImageIcon());
		jButton.setBorder(BorderFactory.createEmptyBorder());
		jButton.setVerticalAlignment(SwingConstants.CENTER);
		jButton.setHorizontalAlignment(SwingConstants.CENTER);

		return jButton;
	}

	public int getAudioValue() {
		return AudioValue;
	}

	public void setAudioValue(int audioValue) {
		AudioValue = audioValue;
	}

	public boolean isAutoSave() {
		return AutoSave;
	}

	public void setAutoSave(boolean autoSave) {
		AutoSave = autoSave;
	}

	public boolean isPlaySotryAfterGameend() {
		return PlaySotryAfterGameend;
	}

	public void setPlaySotryAfterGameend(boolean playSotryAfterGameend) {
		PlaySotryAfterGameend = playSotryAfterGameend;
	}

	public String getStimmenart() {
		return stimmenart;
	}

	public void setStimmenart(String stimmenart) {
		this.stimmenart = stimmenart;
	}

	public String getSchriftart() {
		return schriftart;
	}

	public void setSchriftart(String schriftart) {
		this.schriftart = schriftart;
	}

	public String getdesign() {
		return design;
	}

	public void setdesign(String design) {
		this.design = design;
	}

	public String getSprache() {
		return sprache;
	}

	public void setSprache(String sprache) {
		this.sprache = sprache;
	}

	private int IsSecondTime = 0;

	@Override
	public void actionPerformed(ActionEvent e) {
		Settings st = CardGame.getSettings();
		if (e.getSource() == Titelscreen) {
			CardGame.getGUI().dispose();
			CardGame.setGUI(new StartScreenGUI(null).getFrame());
		} else if (e.getSource() == Speichern) {
			if (st.isAutoSave()) {
				CardGame.getGUI().dispose();
				CardGame.setGUI(new StartScreenGUI(null).getFrame());
			} else {
				ProgressBarGUI progressBarGUI = new ProgressBarGUI(Words.get(WordTypes.SavingTitel), 7);
				progressBarGUI.fill(0);
				progressBarGUI.Warten(100);
				st.setAudiovalue(getAudioValue());
				progressBarGUI.fill(1);
				progressBarGUI.Warten(100);
				st.setAutoplayaftergame(isPlaySotryAfterGameend());
				progressBarGUI.fill(2);
				progressBarGUI.Warten(100);
				st.setAutoSave(isAutoSave());
				progressBarGUI.fill(3);
				progressBarGUI.Warten(100);
				st.setDesign(getdesign());
				progressBarGUI.fill(4);
				progressBarGUI.Warten(100);
				st.setLanguage(getSprache());
				progressBarGUI.fill(5);
				progressBarGUI.Warten(100);
				st.setSchriftart(getSchriftart());
				progressBarGUI.fill(6);
				progressBarGUI.Warten(100);
				st.setStimmenArt(getStimmenart());
				progressBarGUI.fill(7);
				progressBarGUI.Warten(100);
				st.save();
				progressBarGUI.Warten(100);
				progressBarGUI.progressend(Words.get(WordTypes.SavingEnd));
				// KartenSpiel.setGUI(new StartScreenGUI(null).getFrame());
			}
		} else if (e.getSource() == PlayDirect) {
			CardGame.getGUI().dispose();
			st.setAudiovalue(getAudioValue());
			st.setAutoplayaftergame(isPlaySotryAfterGameend());
			st.setAutoSave(isAutoSave());
			st.setDesign(getdesign());
			st.setLanguage(getSprache());
			st.setSchriftart(getSchriftart());
			st.setStimmenArt(getStimmenart());
			st.save();
			GameGUI gui = new GameGUI(null);
			if (Words.choosenWayID.size() >= 2) {
				Card c = Card.getCardByID(Words.choosenWayID.get(Words.choosenWayID.size() - 2));
				if (Words.choosenWayAnswer.get(Words.choosenWayAnswer.size() - 1) == TextType.A
						|| Words.choosenWayAnswer.get(Words.choosenWayAnswer.size() - 1) == TextType.Weiter) {
					gui.setCardText(c.getNextA());
				} else if (Words.choosenWayAnswer.get(Words.choosenWayAnswer.size() - 1) == TextType.B) {
					gui.setCardText(c.getNextB());
				} else if (Words.choosenWayAnswer.get(Words.choosenWayAnswer.size() - 1) == TextType.C) {
					gui.setCardText(c.getNextC());
				} else if (Words.choosenWayAnswer.get(Words.choosenWayAnswer.size() - 1) == TextType.GameOver) {
					gui.setCardText(0);
				}
			} else {
				gui.setCardText(0);
			}
			CardGame.setGUI(gui.getFrame());
			StoppUhr.Run();
		} else if (e.getSource() == Weiblich) {
			setStimmenart("W");
			if (CardGame.getSettings().isAutoSave()) {
				CardGame.getSettings().setStimmenArt(getStimmenart());
				CardGame.getSettings().save();
			}
		} else if (e.getSource() == Meanlich) {
			setStimmenart("M");
			if (CardGame.getSettings().isAutoSave()) {
				CardGame.getSettings().setStimmenArt(getStimmenart());
				CardGame.getSettings().save();
			}
		} else if (e.getSource() == Dunkel) {
			setdesign("Dunkel");
			if (CardGame.getSettings().isAutoSave()) {
				CardGame.getSettings().setDesign(getdesign());
				CardGame.getSettings().save();
			}
			CardGame.setBackgroundColor(true, getdesign());
		} else if (e.getSource() == Hell) {
			setdesign("Hell");
			if (CardGame.getSettings().isAutoSave()) {
				CardGame.getSettings().setDesign(getdesign());
				CardGame.getSettings().save();
			}
			CardGame.setBackgroundColor(true, getdesign());
		} else if (e.getSource() == AutoSaveAfterChangesckb) {
			setAutoSave(AutoSaveAfterChangesckb.isSelected());
			CardGame.getSettings().setAutoSave(isAutoSave());
			CardGame.getSettings().save();
		} else if (e.getSource() == AutoPlayAfterGameEndckb) {
			setPlaySotryAfterGameend(AutoPlayAfterGameEndckb.isSelected());
			if (CardGame.getSettings().isAutoSave()) {
				CardGame.getSettings().setAutoplayaftergame(isPlaySotryAfterGameend());
				CardGame.getSettings().save();
			}
		} else if (e.getSource() == schriftartcbb) {
			setSchriftart(schriftartcbb.getSelectedItem().toString());
			if (CardGame.getSettings().isAutoSave()) {
				CardGame.getSettings().setSchriftart(getSchriftart());
				CardGame.getSettings().save();
			}
			if (IsSecondTime >= 1) {
				UpdateComponets();
			}
		} else if (e.getSource() == langugagecbb) {
			if (langugagecbb.getItemCount() >= 1) {
				if (langugagecbb.getSelectedItem().toString()
						.equalsIgnoreCase(Words.get(WordTypes.DEUTSCH, getSprache()))) {
					setSprache("De_de");
					languagelbl.setIcon(new IconManager(IconPath.DeutscheFlagge).getImageIcon());
					CardGenDe.generateCards(false);
				} else if (langugagecbb.getSelectedItem().toString()
						.equalsIgnoreCase(Words.get(WordTypes.ENGLISCH, getSprache()))) {
					setSprache("En_en");
					languagelbl.setIcon(new IconManager(IconPath.EnglischeFlagge).getImageIcon());
					CardGenEn.generateCards(false);

				}
				if (CardGame.getSettings().isAutoSave()) {
					CardGame.getSettings().setLanguage(getSprache());
					CardGame.getSettings().save();
				}
				if (IsSecondTime >= 1 && langugagecbb.getSelectedItem().toString() != null) {
					UpdateComponets();
				}
			}
			IsSecondTime++;
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == slider) {
			setAudioValue(slider.getValue());
			if (CardGame.getSettings().isAutoSave()) {
				CardGame.getSettings().setAudiovalue(getAudioValue());
				CardGame.getSettings().save();
			}
		}

	}

	private void UpdateComponets() {
		titellbl.setFont(new Font(getSchriftart(), Font.PLAIN, 40));
		titellbl.setText(Words.get(WordTypes.Settings, getSprache()));
		slidertitellbl.setFont(new Font(getSchriftart(), Font.PLAIN, 30));
		slidertitellbl.setText(Words.get(WordTypes.Volume, getSprache()));
		slider.setFont(new Font(getSchriftart(), Font.PLAIN, 20));
		sliderbottomlbl.setFont(new Font(getSchriftart(), Font.PLAIN, 30));
		sliderbottomlbl.setText(CardGame.getSettings().getAudiovalue() + "%");
		languagelbl.setFont(new Font(getSchriftart(), Font.PLAIN, 30));
		languagelbl.setText(Words.get(WordTypes.Sprache, getSprache()));
		langugagecbb.setFont(new Font(getSchriftart(), Font.PLAIN, 30));
		langugagecbb.removeAllItems();
		for (int i = 0; i < CardGame.getSettings().getLanguages(getSprache()).length; i++) {
			langugagecbb.addItem(CardGame.getSettings().getLanguages(getSprache())[i]);
		}
		if (getSprache().equalsIgnoreCase("De_de")) {
			langugagecbb.setSelectedIndex(1);
		} else if (getSprache().equalsIgnoreCase("En_en")) {
			langugagecbb.setSelectedIndex(0);
		}
		schriftartcbb.setFont(new Font(getSchriftart(), Font.PLAIN, 30));
		schriftartlbl.setFont(new Font(getSchriftart(), Font.PLAIN, 30));
		schriftartlbl.setText(Words.get(WordTypes.Schriftart, getSprache()));
		AutoPlayAfterGameEndckb.setFont(new Font(getSchriftart(), Font.PLAIN, 25));
		AutoPlayAfterGameEndckb.setText(Words.get(WordTypes.AutoPlayAfterGameEnd, getSprache()));
		AutoSaveAfterChangesckb.setFont(new Font(getSchriftart(), Font.PLAIN, 25));
		AutoSaveAfterChangesckb.setText(Words.get(WordTypes.AutoSave, getSprache()));
		Speichern.setFont(new Font(getSchriftart(), Font.PLAIN, 30));
		Speichern.setText(Words.get(WordTypes.SpeichernButton, getSprache()));
		PlayDirect.setFont(new Font(getSchriftart(), Font.PLAIN, 30));
		PlayDirect.setText(Words.get(WordTypes.PlayDirectButton, getSprache()));
		Titelscreen.setFont(new Font(getSchriftart(), Font.PLAIN, 30));
		Titelscreen.setText(Words.get(WordTypes.TitelScreenButton, getSprache()));
		Meanlich.setFont(new Font(getSchriftart(), Font.PLAIN, 25));
		Meanlich.setText(Words.get(WordTypes.Male, getSprache()));
		Weiblich.setFont(new Font(getSchriftart(), Font.PLAIN, 25));
		Weiblich.setText(Words.get(WordTypes.Female, getSprache()));
		groupstimmelbl.setFont(new Font(getSchriftart(), Font.PLAIN, 25));
		groupstimmelbl.setText(Words.get(WordTypes.VorleseStimme, getSprache()));
		Dunkel.setFont(new Font(getSchriftart(), Font.PLAIN, 25));
		Dunkel.setText(Words.get(WordTypes.Dunkel, getSprache()));
		Hell.setFont(new Font(getSchriftart(), Font.PLAIN, 25));
		Hell.setText(Words.get(WordTypes.Hell, getSprache()));
		designlbl.setFont(new Font(getSchriftart(), Font.PLAIN, 25));
		designlbl.setText(Words.get(WordTypes.Design, getSprache()));
		if (getdesign().equalsIgnoreCase("Dunkel")) {
			Dunkel.setSelected(true);
		} else if (getdesign().equalsIgnoreCase("Hell")) {
			Hell.setSelected(true);
		}
	}

}
