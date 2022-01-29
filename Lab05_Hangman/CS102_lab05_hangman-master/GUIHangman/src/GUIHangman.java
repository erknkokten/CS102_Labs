import java.awt.*;
import cs102.*;

/**
 * GUIHangman - GUI based MVC test for cs102 Hangman & IHangmanSetup
 *
 * @author David
 * @version 1.00 2013/4/7
 */

public class GUIHangman
{
	public GUIHangman()
	{
    	System.out.println( "Start of GUIHangman\n");

		HangmanModel		hangman;
		IHangmanSetup		basicSetup;
		ConsoleHangmanView	consoleView;

		basicSetup = new BasicSetup();
		hangman = new HangmanModel( basicSetup);

		consoleView = new ConsoleHangmanView();
		hangman.addView( consoleView);

		TextFieldControlPanel textFieldControlPanel = new TextFieldControlPanel(hangman);

		NewGameButtonControl newGameButtonControl = new NewGameButtonControl(hangman);

		GallowsHangmanView gallowsHangmanView = new GallowsHangmanView(hangman);

		LabelsHangmanView labelsHangmanView = new LabelsHangmanView(hangman);

		HangmanLetterButtonControls hangmanLetterButtonControls = new HangmanLetterButtonControls(hangman.getAllLetters(), 13,2);
		HangmanLetterButtonsController hangmanLetterButtonsController = new HangmanLetterButtonsController(hangman, hangmanLetterButtonControls );
		hangmanLetterButtonControls.addActionListener(hangmanLetterButtonsController);

		hangman.addView(labelsHangmanView);
		hangman.addView(gallowsHangmanView);
		hangman.addView(newGameButtonControl);
		hangman.addView(hangmanLetterButtonControls);


		new SimpleJFrame( "GUIHangman", 	// title
				gallowsHangmanView,			// center
							textFieldControlPanel, newGameButtonControl,		// north, south
				hangmanLetterButtonControls, labelsHangmanView );	// east, west

		// this is an infinite loop reading from the console... not clever!
		ConsoleControl.controlFor( hangman);
	}

	public static void main( String[] args)
	{
		new GUIHangman();

//		// This is the approved way to initialise GUIs
//		// but won't work with the ConsoleControl as is!
//		// --------------------------------------------
//		SwingUtilities.invokeLater(
//			new Runnable() {
//			    public void run() {
//	        		new GUIHangman();
//	        		new GUIHangman();
//	    		}
//			});
	}

} // end of class GUIHangman
