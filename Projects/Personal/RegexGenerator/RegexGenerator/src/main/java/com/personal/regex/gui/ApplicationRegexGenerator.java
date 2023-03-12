package com.personal.regex.gui;

import com.personal.regex.gui.res.ImagesRegexGenerator;
import com.utils.app_info.AppInfo;
import com.utils.app_info.FactoryAppInfo;
import com.utils.gui.GuiUtils;
import com.utils.gui.factories.BasicControlsFactories;
import com.utils.gui.factories.BasicControlsFactoryImplJfx;
import com.utils.gui.stages.StageUtils;
import com.utils.gui.styles.vitesco.VitescoStyleUtils;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ApplicationRegexGenerator extends Application {

	static {
		BasicControlsFactories.setInstance(new BasicControlsFactoryImplJfx());
	}

	@Override
	public void start(
			final Stage primaryStage) {

		final AppInfo appInfo = FactoryAppInfo.computeInstance("Regex Generator", "2.0.0");
		final String title = appInfo.getAppTitleAndVersion();
		primaryStage.setTitle(title);
		primaryStage.setWidth(700);
		primaryStage.setHeight(330);
		primaryStage.setMinWidth(500);
		primaryStage.setMinHeight(330);
		StageUtils.centerOnScreen(primaryStage);
		GuiUtils.setAppIcon(primaryStage, ImagesRegexGenerator.createImageApp());

		final VBoxRegexGenerator vBoxRegexGenerator = new VBoxRegexGenerator();
		final Scene scene = new Scene(vBoxRegexGenerator.getRoot());
		VitescoStyleUtils.configureVitescoStyle(scene,
				"com/personal/regex/gui/style_regex_generator.css");
		primaryStage.setScene(scene);

		primaryStage.setOnShown(event -> scene.getRoot().requestFocus());

		primaryStage.show();
	}
}
