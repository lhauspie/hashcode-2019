package com.zenika.hashcode.hashcode2019.input;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class Picture {
	public long index;
	public Orientation orientation;
	public Set<String> tags = new TreeSet<String>();


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Picture [index=");
		builder.append(index);
		builder.append(", orientation=");
		builder.append(orientation);
		builder.append(", tags=");
		builder.append(tags);
		builder.append("]");
		return builder.toString();
	}


	public Picture tagged(Collection<String> asList) {
		tags.addAll(asList);
		return this;
	}
}