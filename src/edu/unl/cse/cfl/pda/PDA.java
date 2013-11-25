package edu.unl.cse.cfl.pda;

import java.util.*;
import edu.unl.cse.cfl.cfg.CFG;
import edu.unl.cse.cfl.utils.*;

/**
 * Class that simulates a PDA.
 * 
 * @author Dongpu
 * 
 */
public class PDA {
	private CFG cfg;
	private static final int MAX = 100;
	private boolean accept = false;

	public PDA(CFG cfg) {
		this.cfg = cfg;
	}

	/*
	 * Simulate a PDA.
	 */
	public boolean simulate(String input) {
		// Push start variable
		Variable v = new Variable('S');
		Stack s = new Stack();
		s.push(v);

		String newInput = "";

		// Remove all epsilon from input string
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != '!') {
				newInput += input.charAt(i);
			}
		}
		return simulateHelper(newInput, s, 0);
	}

	private boolean simulateHelper(String input, Stack s, int level) {
		if (level > MAX) {
			// Exceeds the maximum number of steps, reject current copy
			return false;
		}

		if (input.length() == 0 && s.isEmpty()) { // Accept
			return true;
		}

		if (input.length() != 0 && s.isEmpty()) {
			// Reject if cannot finish process input string
			return false;
		}

		Object tos = s.pop(); // Get top of stack

		if (tos instanceof Terminal) { // Top of stack is a terminal
			if (input.length() == 0) { // Reject
				return false;
			}

			char currChar = input.charAt(0);
			Terminal currTerminal = new Terminal(currChar);
			Terminal tosTerminal = (Terminal) tos;

			if (currTerminal.getVal() == tosTerminal.getVal()) {
				return simulateHelper(input.substring(1), s, level + 1);
			} else {
				return false;
			}
		} else if (tos instanceof Variable) { // Top of stack is a variable
			Variable tosVariable = (Variable) tos;
			ArrayList<ArrayList> derivations = this.cfg
					.getDerivations(tosVariable);

			for (ArrayList derivation : derivations) { // Try all copies of
														// derivations
				Stack sCopy = (Stack) s.clone();

				for (int i = derivation.size() - 1; i >= 0; i--) { // Push all
																	// symbols
					Object symbol = derivation.get(i);

					if (symbol instanceof Terminal) {
						Terminal symbolTerminal = (Terminal) symbol;

						if (symbolTerminal.getVal() == Terminal.TerminalEnum.EPSILON) {
							continue; // Do not push epsilon
						}
					}

					sCopy.push(symbol);
				}

				boolean result = simulateHelper(input, sCopy, level + 1);

				if (result) {
					return true;
				}
			}
		}
		return false;
	}
}
