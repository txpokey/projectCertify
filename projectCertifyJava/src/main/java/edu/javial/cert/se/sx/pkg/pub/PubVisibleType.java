/**
 * 
 */
package edu.javial.cert.se.sx.pkg.pub;

import edu.javial.cert.se.sx.pkg.SamePkgAsDefaultVisibleTypeButPublicAccessItself;


/**
 * @author mak
 *
 */
public class PubVisibleType {

	private SamePkgAsDefaultVisibleTypeButPublicAccessItself sneeky = new SamePkgAsDefaultVisibleTypeButPublicAccessItself() ;
	// these all fail to compile - mak
//	private boolean sneekyOperation() {
//		boolean ret = sneeky.defaultPkgOperation () ;
//	}
//	boolean sneekyOperation2() {
//		boolean ret = sneeky.defaultPkgOperation () ;
//	}
//	public boolean sneekyOperation3() {
//		boolean ret = sneeky.defaultPkgOperation () ;
//	}

}
