package com.zenika.hashcode.hashcode2019.output;

import java.util.Set;
import java.util.TreeSet;

public abstract class AbstractSlide implements Slide {
	public long score(Slide other) {
		Set<String> from_first = new TreeSet<String>(tags());
		from_first.removeAll(other.tags());
		int tags_from_first = from_first.size();
		Set<String> from_second = new TreeSet<String>(other.tags());
		from_second.removeAll(tags());
		int tags_from_second = from_second.size();
		Set<String> common = new TreeSet<String>(tags());
		common.retainAll(other.tags());
		int tags_common = common.size();
		return Math.min(tags_from_first, Math.min(tags_from_second, tags_common));
	}

}
