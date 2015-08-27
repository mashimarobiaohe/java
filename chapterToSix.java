/**
 * @desc 第六章
 * @author p-hebiao
 *
 */

import java.util.ArrayList;
import java.io.*;

import extension.*;
public class chapterToSix {

	public static void main(String[] args){
		print.println("第六章");
		
		a(args);
		b();
	}
	
	public static void a(String[] args){
		PrintTest p = new PrintTest();
		p.main(args);
//		test.testPrivate();   包访问权限控制
	}
	
	public static void b(){
		ChocolateChip2 p2 = new ChocolateChip2();
		p2.main();
	}
}

class FullQualification{
	public static void main(String[] args){
		java.util.ArrayList list = new java.util.ArrayList();

		
	}
	void a(){
		ArrayList l = new java.util.ArrayList();
	}
}
class PrintTest{
	public static void main(String[] args){
		print.println();
		print.print(100);
		print.print(100L);
		print.print(3.14159);
		
		int[] result = range.range(10,12);
		print.println(result);
	}
}
class Cookie{
	public Cookie(){
		print.print("Cookie constructor");
	}
	protected void bite(){
		print.println("bite");
	}
}
class Dinner{
	public static void main(String[] args){
		Cookie x = new Cookie();
		x.bite();
	}
}
class Sundae{
	private Sundae(){}
	static Sundae makeASundae(){
		return new Sundae();
	}
}
class demo{
	private demo(){}
	static demo makeADemo(){
		return new demo();
	}
}
class IceCream{
	public static void main(String[] args){
		//! Sundae x = new Sundae();
		Sundae x = Sundae.makeASundae();
		demo a = demo.makeADemo();
	}
}

class ChocolateChip extends Cookie{
	public ChocolateChip(){
		print.print("ChocolateChip constructor");
	}
	public void chomp(){
		//访问包权限
	}
	public static void main(String[] args){
		ChocolateChip x = new ChocolateChip();
		x.chomp();
	}
}

class ChocolateChip2 extends test{
	
	public static void main(){
		test.testPublic();
		
//		! testPrivate();
	}
}

class Soup1{
	private Soup1(){}
	public static Soup1 makeSoup1(){
		return new Soup1();
	}
}
//设计模式 单例
class Soup2{
	private Soup2(){}
	private static Soup2 ps1 = new Soup2();
	public static Soup2 access(){
		return ps1;
	}
	public void f(){}
}
class Soup3{
	private Soup3(){}
	private static Soup3 sp3 = new Soup3();
	public static Soup3 access(){
		return sp3;
	}
}
class Lunch{
	void testPrivate(){}
	void testStatic(){
		Soup1 soup = Soup1.makeSoup1();
	}
	void testSingleton(){
		Soup2.access().f();
	}
}




























































