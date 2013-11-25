package edu.unl.cse.cfl.utils;

/**
 * Class represent a terminal
 * 
 * @author Dongpu
 * 
 */
public class Terminal {
	public static enum TerminalEnum {
		a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, SPACE, EPSILON, INVALID
	}

	private TerminalEnum val;

	public Terminal() {
		this.val = TerminalEnum.INVALID;
	}

	public Terminal(char c) {
		switch (c) {
		case 'a':
			this.val = TerminalEnum.a;
			break;
		case 'b':
			this.val = TerminalEnum.b;
			break;
		case 'c':
			this.val = TerminalEnum.c;
			break;
		case 'd':
			this.val = TerminalEnum.d;
			break;
		case 'e':
			this.val = TerminalEnum.e;
			break;
		case 'f':
			this.val = TerminalEnum.f;
			break;
		case 'g':
			this.val = TerminalEnum.g;
			break;
		case 'h':
			this.val = TerminalEnum.h;
			break;
		case 'i':
			this.val = TerminalEnum.i;
			break;
		case 'j':
			this.val = TerminalEnum.j;
			break;
		case 'k':
			this.val = TerminalEnum.k;
			break;
		case 'l':
			this.val = TerminalEnum.l;
			break;
		case 'm':
			this.val = TerminalEnum.m;
			break;
		case 'n':
			this.val = TerminalEnum.n;
			break;
		case 'o':
			this.val = TerminalEnum.o;
			break;
		case 'p':
			this.val = TerminalEnum.p;
			break;
		case 'q':
			this.val = TerminalEnum.q;
			break;
		case 'r':
			this.val = TerminalEnum.r;
			break;
		case 's':
			this.val = TerminalEnum.s;
			break;
		case 't':
			this.val = TerminalEnum.t;
			break;
		case 'u':
			this.val = TerminalEnum.u;
			break;
		case 'v':
			this.val = TerminalEnum.v;
			break;
		case 'w':
			this.val = TerminalEnum.w;
			break;
		case 'x':
			this.val = TerminalEnum.x;
			break;
		case 'y':
			this.val = TerminalEnum.y;
			break;
		case 'z':
			this.val = TerminalEnum.z;
			break;
		case '_':
			this.val = TerminalEnum.SPACE;
			break;
		case '!':
			this.val = TerminalEnum.EPSILON;
			break;
		default:
			this.val = TerminalEnum.INVALID;
			break;
		}
	}

	/*
	 * Get the value of this terminal.
	 */
	public TerminalEnum getVal() {
		return this.val;
	}
}
