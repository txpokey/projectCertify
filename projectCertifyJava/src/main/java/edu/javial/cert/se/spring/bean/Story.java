/**
 * 
 */
package edu.javial.cert.se.spring.bean;

/**
 * @author mak
 * Story POJO
 * http://en.wikibooks.org/wiki/Java_Programming/Spring_framework
 */
public class Story {
	 
    private String title;
    private String author;
    private String content;

    public Story () {
    } 
    public void setTitle(String title) {
            this.title = title;
    }
    public String getTitle() {
            return title;
    }
    public void setAuthor(String author) {
            this.author = author;
    }
    public String getAuthor() {
            return author;
    }
    public void setContent(String content) {
            this.content = content;
    }
    public String getContent() {
            return content;
    }
}