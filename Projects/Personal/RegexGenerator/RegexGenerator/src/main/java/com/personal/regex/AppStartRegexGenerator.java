package com.personal.regex;

import com.personal.regex.gui.WindowMainRegexGenerator;
import com.utils.app_info.FactoryAppInfo;
import com.utils.log.Logger;

import javafx.application.Application;

public final class AppStartRegexGenerator {

	private AppStartRegexGenerator() {
	}

	public static void main(
			final String[] args) {

		Logger.setDebugMode(false);

		FactoryAppInfo.initialize("Regex Generator", "2.0.0");

		Application.launch(WindowMainRegexGenerator.class);
	}
}
