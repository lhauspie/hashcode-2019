package com.zenika.hashcode.hashcode2019.input;

import java.util.Set;
import java.util.TreeSet;

public class Picture {
	public Orientation orientation;
	public Set<String> tags = new TreeSet<String>();
	@Override
	public String toString() {
		return "Picture [orientation=" + orientation + ", tags=" + tags + "]";
	}
}