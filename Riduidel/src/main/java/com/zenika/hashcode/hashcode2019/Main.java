package com.zenika.hashcode.hashcode2019;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import com.zenika.hashcode.hashcode2019.input.Input;

public class Main {
	@Option(name = "-i", usage = "input to this file", metaVar = "INPUT")
	private File in = new File(".");
	@Option(name = "-o", usage = "output to this file", metaVar = "OUTPUT")
	private File out = new File(".");
    // receives other command line parameters than options
    @Argument
    private List<String> arguments = new ArrayList<String>();
	public static void main(String[] args) throws Exception {
		new Main().doMain(args);
	}

	private void doMain(String[] args) throws IOException {
		CmdLineParser parser = new CmdLineParser(this);

		// if you have a wider console, you could increase the value;
		// here 80 is also the default
		parser.setUsageWidth(80);

		try {
			// parse the arguments.
			parser.parseArgument(args);

			// you can parse additional arguments if you want.
			// parser.parseArgument("more","args");

			// after parsing arguments, you should check
			// if enough arguments are given.
			process(in, out);
		} catch (CmdLineException e) {
			// if there's a problem in the command line,
			// you'll get this exception. this will report
			// an error message.
			System.err.println(e.getMessage());
			System.err.println("java SampleMain [options...] arguments...");
			// print the list of available options
			parser.printUsage(System.err);
			System.err.println();

			return;
		}
	}
	
	/**
	 * Process input file to produce output
	 * @param in
	 * @param out
	 * @throws IOException 
	 */
	private void process(File in2, File out2) throws IOException {
		String input = FileUtils.readFileToString(in2);
		String[] lines = input.split(("\n"));
		Input inputStructure = new Input();
		for (int i = 1; i < lines.length; i++) {
			inputStructure.addPictureFrom(lines[i]);
		}
		Slideshow output = computeOutput(inputStructure);
		FileUtils.write(out2, output.toFile());
	}

	private Slideshow computeOutput(Input inputStructure) {
		throw new UnsupportedOperationException("Allez les mecs");
	}

}
