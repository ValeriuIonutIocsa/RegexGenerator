package com.personal.regex;

import com.personal.regex.gui.ApplicationRegexGenerator;
import com.utils.log.Logger;

import javafx.application.Application;

public final class AppStartRegexGenerator {

	private AppStartRegexGenerator() {
	}

	public static void main(
			final String[] args) {

		Logger.setDebugMode(false);

		Application.launch(ApplicationRegexGenerator.class);
	}
}
