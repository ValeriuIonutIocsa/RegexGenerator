package com.personal.regex.gui;

import com.utils.gui_utils.CustomControlAbstr;
import com.utils.gui_utils.GuiUtils;
import com.utils.gui_utils.factories.BasicControlsFactory;
import com.utils.gui_utils.factories.LayoutControlsFactory;
import com.utils.gui_utils.objects.search_and_filter.VBoxPatterns;
import com.utils.string.regex.custom_patterns.CustomPatterns;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

class VBoxRegexGenerator extends CustomControlAbstr<VBox> {

	private final VBoxPatterns vBoxPatterns;
	private final TextField textFieldPattern;

	VBoxRegexGenerator() {

		vBoxPatterns = new VBoxPatterns(event -> generateRegex());
		textFieldPattern = BasicControlsFactory.createTextField("");
	}

	@Override
	protected VBox createRoot() {

		final VBox vBoxRoot = LayoutControlsFactory.createVBox();

		GuiUtils.addToVBox(vBoxRoot, vBoxPatterns.getRoot(),
				Pos.CENTER_LEFT, Priority.ALWAYS, 7, 7, 7, 7);

		GuiUtils.addToVBox(vBoxRoot, textFieldPattern,
				Pos.CENTER_LEFT, Priority.NEVER, 7, 7, 7, 7);

		final HBox hBoxBottom = createHBoxBottom();
		GuiUtils.addToVBox(vBoxRoot, hBoxBottom,
				Pos.CENTER_LEFT, Priority.NEVER, 7, 7, 12, 7);

		return vBoxRoot;
	}

	private HBox createHBoxBottom() {

		final HBox hBoxBottom = LayoutControlsFactory.createHBox();

		final Region region = new Region();
		GuiUtils.addToHBox(hBoxBottom, region,
				Pos.CENTER_LEFT, Priority.ALWAYS, 0, 0, 0, 0);

		final Button buttonGenerateRegex =
				BasicControlsFactory.createButton("Generate Regex");
		buttonGenerateRegex.setOnAction(event -> generateRegex());
		GuiUtils.addToHBox(hBoxBottom, buttonGenerateRegex,
				Pos.CENTER_LEFT, Priority.NEVER, 0, 7, 0, 7);

		return hBoxBottom;
	}

	private void generateRegex() {

		final CustomPatterns customPatterns = vBoxPatterns.createCustomPatterns();
		if (customPatterns != null) {

			final String patternString = customPatterns.createPatternString();
			textFieldPattern.setText(patternString);
		}
	}
}
