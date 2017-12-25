package edu.javial.cert.se.sx;

import org.junit.Test;

public class TrivialFileDirCreationTest {
	TrivialFileDirCreation tool = new TrivialFileDirCreation() ;

	@Test
	public void createFile() {
		boolean createdOK = tool.createTempFile() ;
		assert createdOK : "file creation failed during unit test" ;
	}
//	@Test /*DEBUG*/
	public void createDirThenFile() {
		boolean createdOK = tool.createDirThenFile() ;
		assert createdOK : "file creation failed during unit test" ;
	}

}
