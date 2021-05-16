package com.utils.html.sections.scripts;

import com.utils.io.IoUtils;

public class HtmlSectionScriptResource extends HtmlSectionScript {

	private final String resourceFilePathString;

	public HtmlSectionScriptResource(
			final String resourceFilePathString) {

		this.resourceFilePathString = resourceFilePathString;
	}

	@Override
	protected String createJsScriptContent() {
		return IoUtils.resourceFileToString(resourceFilePathString);
	}
}
