package edu.javial.cert.se.spring.bean;

import org.junit.Test;

public class StoryListReaderTest {
	@Test
	public void readerTest() {
		StoryListReader reader = new StoryListReader();
		boolean OK = reader.storyReader();
		assert OK : "reader test failed" ;
	}
}
