package com.zenika.hashcode.hashcode2019.output;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public abstract class AbstractSlide implements Slide {

	static Map<String, Long> scores = new HashMap<>();

	public long score(Slide other) {
		String slideId1 = this.getId();
		String slideId2 = other.getId();

		String firstKey = slideId1 + "_" + slideId2;
		String secondKey = slideId2 + "_" + slideId1;
		Long score = null;

		score = scores.get(firstKey);
		if (score != null) {
			return score;
		} else {
			score = scores.get(secondKey);
			if (score != null) {
				return score;
			}
		}

		Set<String> from_first = new TreeSet<String>(tags());
		from_first.removeAll(other.tags());
		long tags_from_first = from_first.size();

		Set<String> from_second = new TreeSet<String>(other.tags());
		from_second.removeAll(tags());
		long tags_from_second = from_second.size();

		Set<String> common = new TreeSet<String>(tags());
		common.retainAll(other.tags());
		long tags_common = common.size();

		score = Math.min(tags_from_first, Math.min(tags_from_second, tags_common));
		scores.put(firstKey, score);
		scores.put(secondKey, score);

		return score;
	}

	public abstract String getId();
}
