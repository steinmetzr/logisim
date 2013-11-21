/* Copyright (c) 2010, Carl Burch. License information is located in the
 * com.cburch.logisim.Main source code and at www.cburch.com/logisim/. */

package com.cburch.logisim.circuit;

import java.awt.Point;
import java.util.ArrayList;

import com.cburch.logisim.data.BitWidth;

public class WidthIncompatibilityData {
	private ArrayList<Point> points;
	private ArrayList<BitWidth> widths;

	public WidthIncompatibilityData() {
		points = new ArrayList<Point>();
		widths = new ArrayList<BitWidth>();
	}

	public void add(Point p, BitWidth w) {
		for (int i = 0; i < points.size(); i++) {
			if (p.equals(points.get(i)) && w.equals(widths.get(i))) return;
		}
		points.add(p);
		widths.add(w);
	}

	public int size() {
		return points.size();
	}

	public Point getPoint(int i) {
		return points.get(i);
	}

	public BitWidth getBitWidth(int i) {
		return widths.get(i);
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof WidthIncompatibilityData)) return false;
		if (this == other) return true;

		WidthIncompatibilityData o = (WidthIncompatibilityData) other;
		if (this.size() != o.size()) return false;
		for (int i = 0; i < this.size(); i++) {
			Point p = this.getPoint(i);
			BitWidth w = this.getBitWidth(i);
			boolean matched = false;
			for (int j = 0; j < o.size(); j++) {
				Point q = this.getPoint(j);
				BitWidth x = this.getBitWidth(j);
				if (p.equals(q) && w.equals(x)) { matched = true; break; }
			}
			if (!matched) return false;
		}
		return true;
	}
}
