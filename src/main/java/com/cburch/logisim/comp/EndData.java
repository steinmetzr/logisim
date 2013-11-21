/* Copyright (c) 2010, Carl Burch. License information is located in the
 * com.cburch.logisim.Main source code and at www.cburch.com/logisim/. */

package com.cburch.logisim.comp;

import java.awt.Point;
import com.cburch.logisim.data.BitWidth;

public class EndData {
	public static final int INPUT_ONLY = 1;
	public static final int OUTPUT_ONLY = 2;
	public static final int INPUT_OUTPUT = 3;

	private Point loc;
	private BitWidth width;
	private int i_o;
	private boolean exclusive;

	public EndData(Point loc, BitWidth width, int type, boolean exclusive) {
		this.loc = loc;
		this.width = width;
		this.i_o = type;
		this.exclusive = exclusive;
	}
	
	public EndData(Point loc, BitWidth width, int type) {
		this(loc, width, type, type == OUTPUT_ONLY);
	}

	public boolean isExclusive() { return exclusive; }
	public boolean isInput() { return (i_o & INPUT_ONLY) != 0; }
	public boolean isOutput() { return (i_o & OUTPUT_ONLY) != 0; }
	public Point getLocation() { return loc; }
	public BitWidth getWidth() { return width; }
	public int getType() { return i_o; }
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof EndData)) return false;
		if (other == this) return true;
		EndData o = (EndData) other;
		return o.loc.equals(this.loc) && o.width.equals(this.width)
			&& o.i_o == this.i_o && o.exclusive == this.exclusive;
	}
}
