/**
 * 
 */
package javial.cert.spring.bean;

import java.util.List;

/**
 * @author mak
 * StoryList POJO
 * http://en.wikibooks.org/wiki/Java_Programming/Spring_framework
 */
public class StoryList {
	 
    private List<Story> stories;

    public StoryList (){
    }
    public void setStories(List<Story> stories) {
            this.stories = stories;
    }
    public List<Story> getStories() {
            return stories;
    }
}
