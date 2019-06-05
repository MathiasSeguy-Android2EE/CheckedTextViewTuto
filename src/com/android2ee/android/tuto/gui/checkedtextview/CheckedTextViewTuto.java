/**
* <ul>
* Android Tutorial, An <strong>Android2EE</strong>'s project.</br>
* Produced by <strong>Dr. Mathias SEGUY</strong> with the smart contribution of <strong>Julien PAPUT</strong>.</br>
* Delivered by <strong>http://android2ee.com/</strong></br>
* Belongs to <strong>Mathias Seguy</strong></br>
* ****************************************************************************************************************</br>
* This code is free for any usage but can't be distribute.</br>
* The distribution is reserved to the site <strong>http://android2ee.com</strong>.</br>
* The intelectual property belongs to <strong>Mathias Seguy</strong>.</br>
* <em>http://mathias-seguy.developpez.com/</em></br>
* </br>
* For any information (Advice, Expertise, J2EE or Android Training, Rates, Business):</br>
* <em>mathias.seguy.it@gmail.com</em></br>
* *****************************************************************************************************************</br>
* Ce code est libre de toute utilisation mais n'est pas distribuable.</br>
* Sa distribution est reservée au site <strong>http://android2ee.com</strong>.</br>
* Sa propriété intellectuelle appartient à <strong>Mathias Séguy</strong>.</br>
* <em>http://mathias-seguy.developpez.com/</em></br>
* </br>
* Pour tous renseignements (Conseil, Expertise, Formations J2EE ou Android, Prestations, Forfaits):</br>
* <em>mathias.seguy.it@gmail.com</em></br>
* *****************************************************************************************************************</br>
* Merci à vous d'avoir confiance en Android2EE les Ebooks de programmation Android.
* N'hésitez pas à nous suivre sur twitter: http://fr.twitter.com/#!/android2ee
* N'hésitez pas à suivre le blog Android2ee sur Developpez.com : http://blog.developpez.com/android2ee-mathias-seguy/
* *****************************************************************************************************************</br>
* com.android2ee.android.tuto</br>
* 25 mars 2011</br>
*/
package com.android2ee.android.tuto.gui.checkedtextview;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * @author (Julien PAPUT sous la direction du Dr. Mathias Séguy)
 * @goals This class aims to:
 *        <ul>
 *        <li>Ask to the User what he like and show the result.</li>
 *        </ul>
 */

public class CheckedTextViewTuto extends Activity {
	/******************************************************************************************/
	/** Attributes **************************************************************************/
	/******************************************************************************************/
	/** The chocolate CheckedTextView */
	CheckedTextView CheckedTextViewChocolate;
	/** The television CheckedTextView */
	CheckedTextView CheckedTextViewTelevision;
	/** The internet CheckedTextView */
	CheckedTextView CheckedTextViewInternet;
	/** The chocolate CheckedTextView */
	CheckedTextView CheckedTextViewNicotine;
	/** The chocolate CheckedTextView */
	CheckedTextView CheckedTextViewHug;
	/** The chocolate CheckedTextView */
	CheckedTextView CheckedTextViewSanta;
	/**
	 * A list that stores the elements selected and is used to display the show message that rezumes
	 * those choices
	 */
	ArrayList<String> selectedComponents;
	/**
	 * 
	 */
	private final static String selectedComponentsStringBundleKey="SelectedComponentsStr";
	/**
	 * 
	 */
	ArrayList<Integer> selectedComponentsId;
	/**
	 A list that stores the id of elements selected 
	 */
	private final static String selectedComponentsBundleKey="SelectedComponentsId";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// instanciate the lists
		selectedComponents = new ArrayList<String>();
		selectedComponentsId= new ArrayList<Integer>();
		// Instanciate the checkTextView
		CheckedTextViewChocolate = (CheckedTextView) findViewById(R.id.checkedtextviewchocolate);
		CheckedTextViewTelevision = (CheckedTextView) findViewById(R.id.checkedtextviewtelevision);
		CheckedTextViewInternet = (CheckedTextView) findViewById(R.id.checkedtextviewinternet);
		CheckedTextViewNicotine = (CheckedTextView) findViewById(R.id.checkedtextviewnicotine);
		CheckedTextViewHug = (CheckedTextView) findViewById(R.id.checkedtextviewhug);
		CheckedTextViewSanta = (CheckedTextView) findViewById(R.id.checkedtextviewsantaclaus);

		// Adding a click listener on the checkTextView Chocolate that react when the user clic on
		addListener(CheckedTextViewChocolate, getString(R.string.me2chocolate),
				getString(R.string.chocolate));
		// Adding a click listener on the checkTextView television that react when the user clic on
		addListener(CheckedTextViewTelevision, getString(R.string.me2television),
				getString(R.string.television));
		// Adding a click listener on the checkTextView internet that react when the user clic on
		addListener(CheckedTextViewInternet, getString(R.string.me2internet),
				getString(R.string.internet));
		// Adding a click listener on the checkTextView nicotine that react when the user clic on
		addListener(CheckedTextViewNicotine, getString(R.string.me2nicotine),
				getString(R.string.nicotine));
		// Adding a click listener on the checkTextView hug that react when the user clic on
		addListener(CheckedTextViewHug, getString(R.string.me2hug), getString(R.string.hug));
		// Adding a click listener on the checkTextView santa that react when the user clic on
		addListener(CheckedTextViewSanta, getString(R.string.me2santaclaus),
				getString(R.string.santaclaus));
		/******************************************************************************************/
		/** Retrieve the selection ****************************************************************/
		/******************************************************************************************/
		// Define the button that show the Toaster
		Button btn = (Button) findViewById(R.id.btnShow);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showChoices();
			}
		});
	}

	/******************************************************************************************/
	/** Private Methods **************************************************************************/
	/******************************************************************************************/

	/**
	 * Method to add a listener on a CheckTextView that display a Toast using the message if the
	 * CheckTextView is selected 
	 * @param checkTextView
	 *            The component that handles the listener
	 * @param message
	 *            The message to displays within the Toast
	 * @param componentString
	 *            The message associated with the component to be displayed by the show button
	 */
	private void addListener(final CheckedTextView checkTextView, final String message,
			final String componentString) {
		checkTextView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// check the checkTextView and make and show the toaster
				((CheckedTextView) v).toggle();
				if (((CheckedTextView) v).isChecked()) {
					//Display the toast
					Toast.makeText(CheckedTextViewTuto.this, message, Toast.LENGTH_SHORT).show();
					//add the component String in the selected components list
					selectedComponents.add(componentString);
					selectedComponentsId.add(checkTextView.getId());
				} else {
					//reomve the component String from the selected components list
					selectedComponents.remove(componentString);
					selectedComponentsId.remove(checkTextView.getId());
				}
			}
		});
	}

	/**
	 * showChoices() Make a text message and Show it in a Toaster.
	 */
	private void showChoices() {
		StringBuilder text = new StringBuilder(getString(R.string.choice));
		String ret = "\r\n\t";
		text.append(ret);
		//browse the list of selected components and for each add it to the displayed message
		for (String componentStr : selectedComponents) {
			text.append(componentStr);
			text.append(ret);
		}
		// Make and Show the Toaster
		Toast.makeText(CheckedTextViewTuto.this, text, Toast.LENGTH_LONG).show();
	}
	
	/******************************************************************************************/
	/** Managing lifeCycle **************************************************************************/
	/******************************************************************************************/
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onSaveInstanceState(android.os.Bundle)
	 * This method save the state of all the CheckedTextView 
	 * And the different element selected
	 */
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// Save the components that are selected
		outState.putIntegerArrayList(selectedComponentsBundleKey, selectedComponentsId);
		outState.putStringArrayList(selectedComponentsStringBundleKey, selectedComponents);
		//And then leave the system do its stuff
		super.onSaveInstanceState(outState);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onRestoreInstanceState(android.os.Bundle)
	 * Restore the element selected and the state of all the checkedtextView
	 */
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// Retrieve the components that was selected
		selectedComponentsId=savedInstanceState.getIntegerArrayList(selectedComponentsBundleKey);
		selectedComponents=savedInstanceState.getStringArrayList(selectedComponentsStringBundleKey);
		//and now restore component state
		for(Integer id:selectedComponentsId){
			((CheckedTextView) findViewById(id)).toggle();
		}
		//And then leave the system do its stuff
		super.onRestoreInstanceState(savedInstanceState);
	}
}