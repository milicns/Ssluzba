package controller;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.UIManager;

public class ResourceBundleController {

	private static ResourceBundleController instance = null;
	
	public static ResourceBundleController getInstance() {
		if(instance == null) {
			instance = new ResourceBundleController();
		}
		return instance;
	}
	
	private ResourceBundle resourceBundle;
	
	private ResourceBundleController() {
		Locale.setDefault(new Locale("sr","RS"));
		resourceBundle = ResourceBundle.getBundle("gui.MessageResources.MessageResources", Locale.getDefault());
	}

	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}
	
	public void changeLanguage(String lang, String country) {
		
		Locale.setDefault(new Locale(lang,country));
		resourceBundle = ResourceBundle.getBundle("gui.MessageResources.MessageResources", Locale.getDefault());
		
	}
	
	
}
