package com.personal.regex;

import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import org.junit.jupiter.api.Test;

import com.utils.io.PathUtils;
import com.utils.io.folder_creators.FactoryFolderCreator;
import com.utils.log.Logger;

class AppStartRegexGeneratorTest {

	private static final String[] DIGIT_NAMES = {
			"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

	@Test
	void testGenerateTestFile() throws Exception {

		final String testFileFolderPathString = Paths.get(PathUtils.createRootPath(),
				"tmp", "RegexGenerator", "regex_test_files").toString();

		Logger.printProgress("generating test files inside folder:");
		Logger.printLine(testFileFolderPathString);

		FactoryFolderCreator.getInstance().createDirectories(testFileFolderPathString, true);

		for (int i = 0; i < 100; i++) {

			final Path testFilePath = Paths.get(testFileFolderPathString,
					"regex_test_file_" + i + ".txt");
			Logger.printLine(testFilePath);

			try (final PrintStream printStream = new PrintStream(
					new BufferedOutputStream(Files.newOutputStream(testFilePath)))) {

				final Random random = new Random();
				final int rowCount = 1000;
				for (int row = 0; row < rowCount; row++) {

					final int columnCount = 10;
					for (int column = 0; column < columnCount; column++) {

						final int digit = random.nextInt(10);
						final String digitName = DIGIT_NAMES[digit];
						printStream.print(digitName);
						if (column < columnCount - 1) {
							printStream.print(' ');
						}
					}
					printStream.println();
				}
			}
		}
	}
}
