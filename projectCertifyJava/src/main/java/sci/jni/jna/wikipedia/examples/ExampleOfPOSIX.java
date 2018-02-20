package sci.jni.jna.wikipedia.examples;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

/** Simple example of native C POSIX library declaration and usage. */
public class ExampleOfPOSIX {

    public interface POSIX extends Library {
        POSIX INSTANCE = (POSIX) Native.loadLibrary(
                (Platform.isWindows() ? "msvcrt" : "c-2.23"), POSIX.class);
        public int chmod(String filename, int mode);
        public int chown(String filename, int user, int group);
        public int rename(String oldpath, String newpath);
        public int kill(int pid, int signal);
        public int link(String oldpath, String newpath);
        public int mkdir(String path, int mode);
        public int rmdir(String path);
    }

}