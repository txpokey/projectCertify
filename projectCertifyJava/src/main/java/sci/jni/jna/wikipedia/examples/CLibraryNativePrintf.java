package sci.jni.jna.wikipedia.examples;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

/** Simple example of native library declaration and usage. */
public class CLibraryNativePrintf {
    static final String CLIBPATH ="/lib/x86_64-linux-gnu/libc-2.23.so";

    public interface CLibrary extends Library {
    CLibrary INSTANCE = (CLibrary) Native.loadLibrary(
            (Platform.isWindows() ? "msvcrt" : "c-2.23"), CLibrary.class);
    void printf(String format, Object... args);
  }

  public static void main(String[] args) {
    CLibrary.INSTANCE.printf("Hello, World\n");
    if ((null != args)) {
        for (int i = 0; i < args.length; i++) {
            CLibrary.INSTANCE.printf("Argument %d: %s\n", i, args[i]);
        }
    }
  }
}