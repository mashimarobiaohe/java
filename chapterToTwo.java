//: object/print.java
import extension.print;

/**
 * @desc 第二章
 * @author p-hebiao
 * @see print	引用其他类
 * @version 1.0
 */
public class chapterToTwo {

	//作用于定义的变量只可用于作用域结束之前
	int x = 12;
	int d;
	char w;
	boolean s;
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		
		//加载库时搜索的路径列表
		print.println(System.getProperty("java.library.path"));
		//用户的账号信息
		print.println(System.getProperty("user.name"));
		
		chapterToTwo n = new chapterToTwo();
		print.println(n.w);
		print.println(n.s);
		print.println(n.d);
		demo();
	}
	
	public static void demo(){
		
		String s = new String("asdf!");
		print.println(s);
		
		
		/**
		 * <ol>
		 * <li> Item one
		 * <li> Item two
		 * <li> Item three
		 * </ol>
		 */
		sf();
	}
	
	/**
	 * 存储位置
	 * 1.寄存器
	 * 2.堆栈
	 * 3.堆 --java对象
	 * 4.常量存储
	 * 5.非RAM存储
	 */
	
	//基本类型
	public static void baseType(){
		
		int  q = 13;
		char c = 'x';
		Character ch1 = new Character(c);
		Character ch2 = new Character('x');
	}
	/**
	 * 
	 */
	public static void atypeName(){
		ATypeName a = new ATypeName();
		DataOnly  b = new DataOnly();
		b.i = 12;
		b.d = 1.1;
		b.b = true;
		
		StaticTest st1 = new StaticTest();
		StaticTest st2 = new StaticTest();
		st1.i = 12;
		st2.i++;
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	int storage(String s){
		return s.length() * 2;
	}
	/**
	 * 
	 * @return
	 */
	boolean flag(){
		return true;
	}
	/**
	 * 
	 * @return
	 */
	double naturalLogBase(){
		return 2.718;
	}
	
	public static void sf(){
		//创建对象调用
		Incrementable a = new Incrementable();
		a.increment();
		//静态直接调用
		Incrementable.increment();
		
		StaticTest st = new StaticTest();
		print.println(st.i);
		
		
	}
}




class ATypeName{}
class DataOnly{
	int i;
	double d;
	boolean b;
}
class StaticTest{
	static int i = 47;
}
class Incrementable{
	static void increment(){
		StaticTest.i++;
	}
}
class AllTheColorsOfTheRainbow{
	int anInterRepresentingColors;
	void changeTheHueOfTheColor(int newHue){
		
	}
}





