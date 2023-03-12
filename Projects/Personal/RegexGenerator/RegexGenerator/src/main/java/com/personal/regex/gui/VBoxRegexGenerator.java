package com.personal.regex.gui;

import com.utils.gui.AbstractCustomControl;
import com.utils.gui.GuiUtils;
import com.utils.gui.factories.BasicControlsFactories;
import com.utils.gui.factories.LayoutControlsFactories;
import com.utils.gui.objects.search_and_filter.VBoxPatterns;
import com.utils.string.regex.custom_patterns.CustomPatterns;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

class VBoxRegexGenerator extends AbstractCustomControl<VBox> {

	private final VBoxPatterns vBoxPatterns;
	private final TextField textFieldPattern;

	VBoxRegexGenerator() {

		vBoxPatterns = new VBoxPatterns(event -> generateRegex());
		textFieldPattern = BasicControlsFactories.getInstance().createTextField("");
	}

	@Override
	protected VBox createRoot() {

		final VBox vBoxRoot = LayoutControlsFactories.getInstance().createVBox();

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

		final HBox hBoxBottom = LayoutControlsFactories.getInstance().createHBox();

		final Region region = new Region();
		GuiUtils.addToHBox(hBoxBottom, region,
				Pos.CENTER_LEFT, Priority.ALWAYS, 0, 0, 0, 0);

		final Button buttonGenerateRegex =
				BasicControlsFactories.getInstance().createButton("Generate Regex");
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
