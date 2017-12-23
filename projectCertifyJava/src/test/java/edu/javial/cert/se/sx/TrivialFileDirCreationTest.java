package edu.javial.cert.se.sx;

import org.junit.Test;

public class TrivialFileDirCreationTest {
	TrivialFileDirCreation tool = new TrivialFileDirCreation() ;


//	@Test /*DEBUG*/
	public void createFile() {
//		TrivialFileDirCreation tool = new TrivialFileDirCreation() ;
		boolean createdOK = tool.createFile() ;
		assert createdOK : "file creation failed during unit test" ;
		boolean createdOKAgain = tool.createFileAgain() ;
		assert createdOKAgain : "file creation failed during unit test, 2nd attempt" ;
	}
	@Test
	public void createDirThenFile() {
//		TrivialFileDirCreation tool = new TrivialFileDirCreation() ;
		boolean createdOK = tool.createDirThenFile() ;
		assert createdOK : "file creation failed during unit test" ;
	}

}
