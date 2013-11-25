package edu.unl.cse.cfl.utils;

/**
 * Class represent a variable in CFG.
 * 
 * @author Dongpu
 * 
 */
public class Variable {
	// Variable enum list.
	public static enum VariableEnum {
		A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, INVALID
	}

	private VariableEnum val;

	private Variable() {
		this.val = VariableEnum.INVALID;
	}

	public Variable(char c) {
		switch (c) {
		case 'A':
			this.val = VariableEnum.A;
			break;
		case 'B':
			this.val = VariableEnum.B;
			break;
		case 'C':
			this.val = VariableEnum.C;
			break;
		case 'D':
			this.val = VariableEnum.D;
			break;
		case 'E':
			this.val = VariableEnum.E;
			break;
		case 'F':
			this.val = VariableEnum.F;
			break;
		case 'G':
			this.val = VariableEnum.G;
			break;
		case 'H':
			this.val = VariableEnum.H;
			break;
		case 'I':
			this.val = VariableEnum.I;
			break;
		case 'J':
			this.val = VariableEnum.J;
			break;
		case 'K':
			this.val = VariableEnum.K;
			break;
		case 'L':
			this.val = VariableEnum.L;
			break;
		case 'M':
			this.val = VariableEnum.M;
			break;
		case 'N':
			this.val = VariableEnum.N;
			break;
		case 'O':
			this.val = VariableEnum.O;
			break;
		case 'P':
			this.val = VariableEnum.P;
			break;
		case 'Q':
			this.val = VariableEnum.Q;
			break;
		case 'R':
			this.val = VariableEnum.R;
			break;
		case 'S':
			this.val = VariableEnum.S;
			break;
		case 'T':
			this.val = VariableEnum.T;
			break;
		case 'U':
			this.val = VariableEnum.U;
			break;
		case 'V':
			this.val = VariableEnum.V;
			break;
		case 'W':
			this.val = VariableEnum.W;
			break;
		case 'X':
			this.val = VariableEnum.X;
			break;
		case 'Y':
			this.val = VariableEnum.Y;
			break;
		case 'Z':
			this.val = VariableEnum.Z;
			break;
		default:
			this.val = VariableEnum.INVALID;
			break;
		}
	}

	/*
	 * Get the value of this variable.
	 */
	public VariableEnum getVal() {
		return this.val;
	}
}
