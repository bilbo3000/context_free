package edu.unl.cse.cfl.utils;

import java.io.*;
import java.util.*;

/**
 * Class that reads the input file.
 * 
 * @author Dongpu
 * 
 */
public class InputFileReader {
	private String fileName = "";
	private int numOfRules = 0;
	private ArrayList<String> rules = new ArrayList<String>();;
	private ArrayList<String> examples = new ArrayList<String>();
	
	/*
	 * Read number of rules, rules, and examples from input file.
	 */
	public void processInputFile() throws IOException {
		BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));

		// Read number of rules
		String numOfRulesStr = bufReader.readLine();
		this.numOfRules = Integer.parseInt(numOfRulesStr);

		// Read rules
		for (int i = 0; i < this.numOfRules; i++) {
			rules.add(bufReader.readLine());
		}

		// Read examples
		String example = "";

		while ((example = bufReader.readLine()) != null) {
			examples.add(example);
		}
	}

	/*
	 * Get number of rules.
	 */
	public int getNumOfRules() {
		return this.numOfRules;
	}

	/*
	 * Get rules.
	 */
	public String[] getRules() {
		return this.rules.toArray(new String[0]);
	}

	/*
	 * Get examples.
	 */
	public String[] getExamples() {
		return this.examples.toArray(new String[0]);
	}
}
