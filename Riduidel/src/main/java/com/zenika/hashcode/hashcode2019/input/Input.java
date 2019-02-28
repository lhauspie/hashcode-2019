package com.zenika.hashcode.hashcode2019.input;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
	private long horizontal = 0;
	private long vertical = 0;
	public List<Picture> pictures = new LinkedList<Picture>();
	public void addPictureFrom(String string) {
		String[] data = string.split(" ");
		Picture newPicture = new Picture();
		newPicture.orientation = Orientation.valueOf(data[0]);
		newPicture.tagsCount =  Integer.parseInt(data[1]);
		for (int i = 2; i < data.length; i++) {
			newPicture.tags.add(data[i]);
			newPicture.index = i-2;
		}
		addPicture(newPicture);
	}
	private void addPicture(Picture newPicture) {
		switch(newPicture.orientation) {
		case H: horizontal++; break;
		case V: vertical++; break;
		}
		pictures.add(newPicture);
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Input [pictures=");
		for (Picture picture : pictures) {
			builder.append(picture).append("\n");
		}
		builder.append("]");
		return builder.toString();
	}

	public double possibleMaxScore() {
		long tags = 0;
		for (Picture picture : pictures) {
			tags+= picture.tagsCount;
		}
		
		return (tags/3)*(vertical/2+horizontal);
	}
	
	public Collection<Picture> getHorizontal() {
	  return pictures.stream().filter(p -> p.orientation == Orientation.H).collect(Collectors.toList());
	}

	public Collection<Picture> getVertical() {
    return pictures.stream().filter(p -> p.orientation == Orientation.V).collect(Collectors.toList());
  }
}