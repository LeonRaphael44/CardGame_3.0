package de.cardGame.utils.words;

public enum WordTypes {

	Settings("Einstellungen", "Settings"),
	KeyUseVorlesen("Es wird %Karte% vorgelesen.", "%Karte% is read out loud."),
	KeyUsePages("Das Men� Seiten wird ge�ffnet.", "The Pages men� opens."),
	KeyUseExtras("Das Men� Extras wird ge�ffnet.", "The Extras men� opens."),
	KeyUseHelp("Das Men� Hilfe wird ge�ffnet.", "The Help men� opens."),
	KeyUseSettings("Das Men� Seiten wird ge�ffnet und Einstellungen wird ausgew�hlt.",
			"The men� Pages is opened and Settings is selected."),
	KeyUseTitelScreen("Das Men� Seiten wird ge�ffnet und Titelseite wird ausgew�hlt.",
			"The Pages men� opens and Titlesecreen is selected."),
	KeyUseKartPath("Das Men� Extras wird ge�ffnet und Kartenpfad wird ausgew�hlt.",
			"The Extra men� opens and Cardpath is selected."),
	KeyUseKarteBack("Das Men� Extras wird ge�ffnet und Karte zur�ck wird ausgew�hlt.",
			"The men� Extras is opened and card back is selected."),
	Volume("Lautst�rke", "Volume"),
	Name("Digitales Kartenlabyrinth", "Digital Card Maze"),
	Versuchszeit("Versuchszeit: ", "Time played: "),
	Kartenpfad("Kartenpfad: ", "Card Path: "),
	UnterTitel("Finde deinen Weg!", "Find your Way!"),
	DEUTSCH("Deutsch", "German"),
	Karte("Karte ", "Card "),
	ENGLISCH("Englisch", "English"),
	Pages("Seiten", "Pages"),
	Help("Hilfe", "Help"),
	CardPath("Kartenpfad", "Card Path"),
	Extras("Extras", "Extras"),
	NoCardsChoosen("Noch keine Karten ausgew�hlt", "No cards selected yet"),
	StartScreen("Titelseite", "Startscreen"),
	ProgrammedBy("Programmiert von", "Programmed by"),
	Geburtstag("Geburtsjahr", "Year of birth"),
	VielSpassBeimZocken("Viel Spa� beim Zocken :D", "Have fun playing :D"),
	KeyUse("Tasten-Kombinationen", "Key combination "),
	Info("Info", "Info"),
	PageBack("Karte zur�ck", "Card back"),
	CardsChoosen("Anzahl der gespielten Karten:", "Number of selected Cards:"),
	Schriftart("Schriftart: ", "Font: "),
	AutoSave("Automatische Speicherung: ", "Autosave: "),
	AutoPlayAfterGameEnd("Automatisch Geschichte abspielen nach Spielende: ", "Autoplay Story after End of the Game: "),
	AudioDateiTypeNichtverwendbar("Audiodateitype nicht verwendbar", "Audio file type cannot be used!"),
	Male("M�nnlich", "Male"),
	Female("Weiblich", "Female"),
	Hell("Hell", "Light"),
	Design("Darstellung: ", "Design: "),
	Dunkel("Dunkel", "Dark"),
	SavingTitel("Speichern...", "Saveing..."),
	LoadCardsTitel("Lade Karten", "Loading Cards"),
	LoadCardsEnd("Alle Karten geladen", "All Cards loaded"),
	SavingEnd("Alle Einstellungen gespeichert", "All settings saved"),
	SpeichernButton("Speichern", "Save"),
	PlayDirectButton("Direkt Spielen", "Play directly"),
	TitelScreenButton("Titelseite", "Startscreen"),
	VorleseStimme("Vorlesestimme: ", "Reading voice: "),
	Play("Spielen", "Play"),
	PlayAudioStory("Geschichte abspielen", "Play Story"),
	StoryBasedOn("Geschichte basierend auf Hypertext-Spielkarten von Ruth Wajnryb",
			"Story based on Hypertext Game Cards by Ruth Wajnryb"),
	Sprache("Sprache: ", "Language: "),
	GameOver("Spiel vorbei", "Game Over"),
	NOMoreCardsBack("Es gib nur 2 Karten Zur�ck. Diese sind aber schon aufgebraucht.",
			"There are only 2 cards back. But these have already been used up. "),
	Weiter("Weiter", "Continue"),
	Richtig("Richtig", "right"),
	your("deine", "your"),
	das("das", "this"),
	whom("werm", "whom"),
	colleague("Kollege", "colleague"),
	marrythem("heirate sie", "marry them"),
	Roulette("Roulette", "roulette"),
	two("2", "2"),
	Card15Fehler(
			"Auf dieser Karte gibt es einen inhaltlichen Fehler. Finde heraus, wie viele Personen verschwinden, ohne dass man erf�hrt, was mit ihnen passiert ist. Gib die gesuchte Zahl hier ein:",
			"There is a content-related mistake on this card. Find out how many persons just vanish into thin air without the reader getting to know what has happened to them. Type in the correct number here:"),
	Card26Fehler("H�ren Sie der Leserin zu und finden Sie die beiden W�rter, die nicht zum geschriebenen Text passen.",
			"Listen to the female reader and find the two words that do not match the written text."),
	Card43und50Fehler(
			"Auf dieser Karte gibt es einen inhaltlichen Fehler. Finde das Wort, das durch ein anderes Wort ersetzt werden muss. Gib das neue Wort hier ein:",
			"There is a content-related mistake on this card. Find the word that has to be replaced. Type in the new word here:"),
	Card64Fehler("H�ren Sie der Leserin zu und finden Sie das eine Wort aus dem Text, das sie nicht laut vorliest.",
			"Listen to the female reader and find the one word from the text that she does not read out loud."),
	Card45Fehler(
			"Lass dir den Kartentext vom m�nnlichen Sprecher vorlesen und finde das Wort, das nicht im geschriebenen Text steht.",
			"Let the male speaker read the card text to you and find the word that is not in the written text."),
	Card11_21_35_39_65Fehler(
			"H�ren Sie dem m�nnlichen Sprecher zu und finden Sie das eine Wort, das nicht richtig ausgesprochen wird.",
			"Listen to the male speaker and find the one word that is not pronounced correctly."),
	Card13Fehler(
			"H�ren Sie dem m�nnlichen Sprecher zu und finden Sie das eine Wort, das nicht richtig ausgesprochen wird.",
			"Listen to the male speaker and find the one word that is not pronounced correctly."),
	KannstDuLesen("Kannst du lesen?", "can you read?"),
	Falsch("Falsch", "wrong"),
	// GamesGUI
	Games("Andere Spiele", "Other Games"),
	NameZuLang("Der gew�hlte Name ist zu lang/kurz!", "The choosen name is too long/short!"),
	// GamesGUI

	// schereSteinPapier
	SchereSteinPapier("Schere Stein Papier", "Rock Paper Scissors"),
	Score("Spielstand", "Score"),
	hasWon("hat gewonnen!", "has Won!"),
	Tie("Unentschieden", "tie!")
	// schereSteinPapier

	;

	private String Deutsch;
	private String Englisch;

	WordTypes(String Deutsch, String Englisch) {
		this.Deutsch = Deutsch;
		this.Englisch = Englisch;
	}

	public String getDeutsch() {
		return Deutsch;
	}

	public String getEnglisch() {
		return Englisch;
	}

}
