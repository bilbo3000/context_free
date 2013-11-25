package edu.unl.cse.cfl.cfg;

import edu.unl.cse.cfl.utils.*;
import edu.unl.cse.cfl.utils.Variable.VariableEnum;

import java.util.*;

/**
 * Class that represents a context free grammar.
 * 
 * @author Dongpu
 * 
 */
public class CFG {
	// A map that maps variable to its derivation
	private Map<VariableEnum, ArrayList<ArrayList>> cfg = new HashMap<VariableEnum, ArrayList<ArrayList>>();

	/*
	 * Insert a rule into the CFG.
	 */
	public void insertRule(String rule) {
		int index = rule.indexOf("->");

		if (index != -1) {
			// Get left hand variable
			Variable var = new Variable(rule.charAt(0));
			ArrayList derivation = new ArrayList();

			// Get right hand derivation
			for (int i = index + 2; i < rule.length(); i++) {
				char c = rule.charAt(i);
				Variable v = new Variable(c);

				if (v.getVal() == VariableEnum.INVALID) {
					// Not a variable. Must be a terminal
					Terminal t = new Terminal(c);
					derivation.add(t);
				} else {
					derivation.add(v);
				}
			}

			// Add new derivation
			if (cfg.get(var.getVal()) == null) {
				// New entry
				ArrayList derivations = new ArrayList();
				derivations.add(derivation);
				cfg.put(var.getVal(), derivations);
			} else {
				cfg.get(var.getVal()).add(derivation);
			}
		}
	}

	/*
	 * Get the derivations for a given variable
	 */
	public ArrayList<ArrayList> getDerivations(Variable variable) {
		return this.cfg.get(variable.getVal());
	}

	/*
	 * Print CFG.
	 */
	public void printCFG() {
		Set<VariableEnum> keySet = this.cfg.keySet();

		for (VariableEnum key : keySet) {
			ArrayList<ArrayList> derivations = this.cfg.get(key);

			for (ArrayList derivation : derivations) {
				System.out.print(key.name() + "->");
				for (Object obj : derivation) {
					if (obj instanceof Variable) {
						Variable v = (Variable) obj;
						System.out.print(v.getVal().name());
					} else if (obj instanceof Terminal) {
						Terminal t = (Terminal) obj;
						System.out.print(t.getVal().name());
					}
				}
				System.out.println();
			}
		}
	}
}
