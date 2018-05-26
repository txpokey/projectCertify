/**
 * 
 */
package edu.javial.cert.spring.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StoryListReader {
	private static Log log = LogFactory.getLog(StoryListReader.class);
	private static String CONFIG_FILENAME = "story_configuration.xml" ;
	private static String STORY_BEAN = "StoryList" ;

//	public static void main(String args[]) {
		// XmlBeanFactory beanFactory = new XmlBeanFactory(new
		// ClassPathResource(
		// "story_configuration.xml"));
		// StoryList storyList = (StoryList) beanFactory.getBean("StoryList");
		// List myStories = storyList.getStories();
		// for (int i = 0; i < myStories.size(); i++) {
		// Story currentStory = (Story) myStories.get(i);
		// System.out.println("\"" + currentStory.getTitle() + "\" by "
		// + currentStory.getAuthor() + ":");
		// System.out.println(currentStory.getContent());
		// System.out.println();
		// }
//		StoryListReader reader = new StoryListReader() ;
//		reader.storyReader() ;
//	}

	// TODO fix regression : now doing spring5
	public boolean storyReader() {
		boolean ret = false;
//		reader: {
//			try {
//				XmlBeanFactory beanFactory = new XmlBeanFactory(
//						new ClassPathResource(CONFIG_FILENAME));
//				StoryList storyList = (StoryList) beanFactory
//						.getBean(STORY_BEAN);
//				List<Story> myStories = storyList.getStories();
//				for (Story currentStory :myStories ) {
////					Story currentStory = (Story) myStories.get(i);
//					System.out.println("\"" + currentStory.getTitle()
//							+ "\" by " + currentStory.getAuthor() + ":");
//					System.out.println(currentStory.getContent());
//					System.out.println();
//				}
//				ret = true;
//			} catch (Exception e) {
//				log.fatal( "something went wrong" ,e ) ;
//				break reader;
//			}
//		}
		return ret = true ; // STUBBED
	}

}
