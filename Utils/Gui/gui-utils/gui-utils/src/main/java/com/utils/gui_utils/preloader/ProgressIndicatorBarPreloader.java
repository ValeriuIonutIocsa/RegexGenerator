package com.utils.gui_utils.preloader;

import com.utils.gui_utils.CustomControlAbstr;
import com.utils.gui_utils.GuiUtils;
import com.utils.gui_utils.factories.BasicControlsFactory;
import com.utils.gui_utils.factories.LayoutControlsFactory;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;

class ProgressIndicatorBarPreloader extends CustomControlAbstr<StackPane> {

	ProgressIndicatorBarPreloader() {
	}

	@Override
	protected StackPane createRoot() {

		final StackPane stackPane = LayoutControlsFactory.createStackPane(Pos.CENTER);

		final ProgressBar progressBar = new ProgressBar(-1);
		progressBar.setMinHeight(20);
		progressBar.setPrefWidth(Double.MAX_VALUE);
		progressBar.getStyleClass().add("green-accent");
		GuiUtils.addToStackPane(stackPane, progressBar, Pos.CENTER, 0, 0, 0, 0);

		final Label label = BasicControlsFactory.createLabel("loading...", "bold");
		GuiUtils.addToStackPane(stackPane, label, Pos.CENTER, 0, 0, 0, 0);

		return stackPane;
	}
}
