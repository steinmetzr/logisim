/* Copyright (c) 2010, Carl Burch. License information is located in the
 * com.cburch.logisim.Main source code and at www.cburch.com/logisim/. */

package com.cburch.logisim.circuit.appear;

import java.awt.Point;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.cburch.draw.model.CanvasObject;
import com.cburch.draw.model.AbstractCanvasObject;
import com.cburch.logisim.data.Attribute;
import com.cburch.logisim.data.Bounds;
import com.cburch.logisim.data.Location;

public abstract class AppearanceElement extends AbstractCanvasObject {
	private Point location;
	
	public AppearanceElement(Point location2) {
		this.location = location2;
	}
	
	public Point getLocation() {
		return location;
	}
	
	@Override
	public boolean matches(CanvasObject other) {
		if (other instanceof AppearanceElement) {
			AppearanceElement that = (AppearanceElement) other;
			return this.location.equals(that.location);
		} else {
			return false;
		}
	}

	@Override
	public int matchesHashCode() {
		return location.hashCode();
	}

	@Override
	public List<Attribute<?>> getAttributes() {
		return Collections.emptyList();
	}

	@Override
	public <V> V getValue(Attribute<V> attr) {
		return null;
	}
	
	@Override
	public boolean canRemove() {
		return false;
	}

	@Override
	protected void updateValue(Attribute<?> attr, Object value) {
		// nothing to do
	}
/*
	public Point translate(int dx, int dy) {
		location = location.translate(dx, dy);
	}
*/
	protected boolean isInCircle(Location loc, int radius) {
		int dx = (int) (loc.getX() - location.getX());
		int dy = (int) (loc.getY() - location.getY());
		return dx * dx + dy * dy < radius * radius;
	}
	
	@Override
	public Point getRandomPoint(Bounds bds, Random rand) {
		return null; // this is only used to determine what lies on top of what - but the elements will always be on top anyway
	}

	protected Bounds getBounds(int radius) {
		return Bounds.create((int)(location.getX()) - radius, (int)(location.getY()) - radius,
				2 * radius, 2 * radius);
	}
}
