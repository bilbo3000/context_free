package edu.unl.cse.cfl.driver;

import edu.unl.cse.cfl.cfg.CFG;
import edu.unl.cse.cfl.utils.*;
import edu.unl.cse.cfl.pda.*;

import java.io.*;

/**
 * Driver class that initiate the application.
 * 
 * @author Dongpu
 * 
 */
public class Driver {
	public static void main(String[] args) throws IOException {
		// Read input file
		InputFileReader inputFileReader = new InputFileReader();
		inputFileReader.processInputFile(); 
		String[] rules = inputFileReader.getRules();

		// Build context-free grammar
		CFG cfg = new CFG();

		for (String rule : rules) {
			cfg.insertRule(rule);
		}

		// Build PDA and simulate
		PDA pda = new PDA(cfg);
		String[] examples = inputFileReader.getExamples();

		for (String example : examples) {
			boolean result = pda.simulate(example);

			if (result) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}
