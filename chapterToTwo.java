//: object/print.java
import extension.print;

/**
 * @desc �ڶ���
 * @author p-hebiao
 * @see print	����������
 * @version 1.0
 */
public class chapterToTwo {

	//�����ڶ���ı���ֻ���������������֮ǰ
	int x = 12;
	int d;
	char w;
	boolean s;
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		
		//���ؿ�ʱ������·���б�
		print.println(System.getProperty("java.library.path"));
		//�û����˺���Ϣ
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
	 * �洢λ��
	 * 1.�Ĵ���
	 * 2.��ջ
	 * 3.�� --java����
	 * 4.�����洢
	 * 5.��RAM�洢
	 */
	
	//��������
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
		//�����������
		Incrementable a = new Incrementable();
		a.increment();
		//��ֱ̬�ӵ���
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





