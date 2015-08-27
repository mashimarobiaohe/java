/**
 * @desc 第三章
 * @author p-hebiao
 *
 */
import java.util.*;

import extension.print;
//import static net.mindview.util.Print.*;
public class chapterToThree {

	public static void main(String[] args){
		print.println("hello world!!");
		
		
	}
	
	public void a(){
		int x=1, y=2, z=3;
		int a = x+y - 2/2 +z;
		int b = x+(y-2)/(2+z);
		
		print.println("a=" +a + "b = "+b);
	}
	
	public void b(){
		Tank t1 = new Tank();
		Tank t2 = new Tank();
		
		t1.level = 9;
		t2.level = 47;
		
		t1 = t2;
		
		t1.level = 27;
	}
	
	static void c(Letter y){
		y.c = 'z';
	}
	
	public void d(){
		Letter x = new Letter();
		x.c = 'a';
		c(x);
	}
	
	public void e(){
		Random rand = new Random(47);
		int i, j, k;
		j = rand.nextInt(100)+1;
		k = rand.nextInt(100)+1;
		i = j + k;
		i = j - k;
		i = j / k;
		i = j * k;
		i = j % k;
		i++;	// 先生产值，再执行运算
		i--;
		++i;	// i = i + 1; 先执行运算，再生成值
		--i;
		
		float u, v, w;
		v = rand.nextFloat();
		w = rand.nextFloat();
		u = w + v;
		u = w - v;
		u = w * v;
		u = w / v;
		u += v;
		u -= v;
		u *= v;
		u /= v;
		
		Integer n1 = new Integer(47);
		Integer n2 = new Integer(47);
		print.print(n1 == n2);
		print.print(n1 != n2);
		print.println(n1.equals(n2)); //比较两个对象的实际内容
		
	}
	//直接常量
	public void f(){
		int i1 = 0x2f;
		int i2 = 0X2F;
		int i3 = 0177;
		char c = 0xffff;
		byte b = 0x7f;
		short s = 0x7fff;
		long n1 = 200L;
		long n2 = 200l;
		long n3 = 200;
		float f1 = 1;
		float f2 = 1F;
		float f3 = 1f;
		double d1 = 1d;
		double d2 = 1D;
		float expFloat = 1.39e-43f;
		double expDouble = 47e47d;
		double expDouble2= 47e47;
				
	}
	
	
	
	
	
	
	
	
	
	
	
}

class Tank{
	int level;
}
class Letter{
	char c;
}
class TernaryIfElse{
	static int ternary(int i){
		return i < 10 ? i*100 : i*10;
	}
	static int standardIfElse(int i){
		if(i < 10)
			return i*100;
		else
			return i*10;
	}
}
class StringOperators{
	static void StringOperators(){
		int x=0, y=1, z=2;
		String s = "x, y, z";
		print.print(s + x + z + y);
		s += "(summed) =";
		print.print(s + (x +y +z));
	}
}
class Casting{
	static void main(){
		int i = 200;
		long lng = (long)i;
		lng = i;
		long lng2 = (long)200;
		lng2 = 200;
	}
}
class CastingNumbers{
	
	public static void main(String[] args){
		
		double above = 0.7, below = 0.4;
		float fabove = 0.7f, fbelow = 0.4f;
		above = (int)above;
		Math.round(above);
	}
}




























