package com.zenika.hashcode.hashcode2019.computer.riduidel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.zenika.hashcode.hashcode2019.input.Input;
import com.zenika.hashcode.hashcode2019.input.Picture;
import com.zenika.hashcode.hashcode2019.output.HorizontalSlide;
import com.zenika.hashcode.hashcode2019.output.Slideshow;
import com.zenika.hashcode.hashcode2019.output.VerticalSlide;

public class Computer {
	public static class ByScoreComparator implements Comparator<Slideshow> {

		@Override
		public int compare(Slideshow o1, Slideshow o2) {
			return (int) (o2.score()-o1.score());
		}
		
	}
	public Slideshow compute(Input inputStructure) {
		return compute(inputStructure.pictures);
	}

	private Slideshow compute(List<Picture> pictures) {
		Collection<Slideshow> slideshows = generate(new Slideshow(), pictures);
		Set<Slideshow> sorted = new TreeSet<>(new ByScoreComparator());
		sorted.addAll(slideshows);
		return sorted.iterator().next();
	}

	private Collection<Slideshow> generate(Slideshow parent, List<Picture> pictures) {
		Collection<Slideshow> returned = new ArrayList<>();
		if(pictures.isEmpty()) {
			returned.add(parent);
		} else {
			for(Picture p : pictures) {
				switch(p.orientation) {
				case H: 
					returned.addAll(generateSlideshows(parent, pictures, p));
					break;
				case V:
					returned.addAll(generateVerticalSlideshows(parent, pictures, p));
					break;
				}
			}
		}
		return returned;
	}

	private Collection<? extends Slideshow> generateVerticalSlideshows(Slideshow parent, List<Picture> pictures,
			Picture picture) {
		Collection<Slideshow> returned = new ArrayList<>();
		List<Picture> others = new ArrayList<>();
		others.addAll(pictures);
		others.remove(picture);
		// Now create a vertical slide with all vertical images
		for(Picture p : others) {
			switch(p.orientation) {
			case H: break;
			case V:
				returned.addAll(generateSlideshows(parent, others, picture, p));
			}
		}
		return returned;
	}

	private Collection<Slideshow> generateSlideshows(Slideshow parent, List<Picture> pictures, Picture...p) {
		List<Picture> others = new ArrayList<>();
		others.addAll(pictures);
		others.removeAll(Arrays.asList(p));
		Collection<Slideshow> generatedSlideshows = generate(createHorizontalSlideshowWith(parent, p), others);
		return generatedSlideshows;
	}

	private Slideshow createHorizontalSlideshowWith(Slideshow s, Picture...p) {
		Slideshow returned = new Slideshow();
		returned.addAll(s.getSlides());
		if(p.length==1) {
			returned.add(new HorizontalSlide(p[0]));
		} else if(p.length==2) {
			returned.add(new VerticalSlide(p[0], p[1]));
		}
		return returned;
	}

}
