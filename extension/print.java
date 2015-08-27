package extension;
/**
 * @desc ¥Ú”°
 * @author p-hebiao
 *
 */
public class print {

	//¥Ú”°
	public static void print(Object c){
		System.out.println(c);
	}
	
	//Print a newline by itself
	public static void println(){
		System.out.println();
	}
	
	public static void println(Object obj){
		System.out.println(obj);
	}
	
	public static void printnb(Object obj){
		System.out.print(obj);
	}
	
//	public static PrintStream 
//	printf(String format, Object... args){
//		return System.out.print(format, args);
//	}
	
	public static void main(String[] args){
		System.out.print(args);
	}
}
