/**
 * 
 */
package javial.cert.sx;

/**
 * @author mak
 * 
 */
public class SingletonExamplePugh {
	// Private constructor part of the singleton pattern generally.
	private SingletonExamplePugh() {
	}

	private static int counter = -1;

    public static final synchronized int bumpCounter() {
        return ++(getInstance().counter);
    }
    public static final synchronized int getCount() {
        return getInstance().counter;
    }
	/**
	 * SingletonHolder is loaded on the first execution of
	 * Singleton.getInstance() or the first access to SingletonHolder.INSTANCE,
	 * not before.
	 */
	private static class SingletonHolder {
		private static final SingletonExamplePugh INSTANCE = new SingletonExamplePugh();
	}

	public static final SingletonExamplePugh getInstance() {
		return SingletonHolder.INSTANCE;
	}

}
