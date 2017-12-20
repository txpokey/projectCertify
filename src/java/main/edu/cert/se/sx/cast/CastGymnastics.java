/**
 * 
 */
package javial.cert.sx.cast;

/**
 * @author mak
 * 
 */
public class CastGymnastics {

	boolean getWeirdOnCasting() {
		boolean ret = false;
		castings: {
			try {
				IA ia = new A() ;
				A a = new A() ;
				B b = new B() ;
				D d = new D() ; 
				AA aa = new AA() ;
				BB bb = new BB() ;
				DD dd = new DD() ;
				//
				A aan = new AA() ;
				B bbn = new BB() ;
				D ddc = dd ;
				//
				A aaca = aa ;
				B bbcb = bb ;
				A ddca = dd ;
				IA ddi = dd ;
//				IA z = a = b = aa = bb = aac = bbc = ac = bc ;
				IA bbi = bb ;
				// 
			} catch (Exception e) {
				break castings;
			}
		}
		return ret;
	}
}
