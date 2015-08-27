/**
 * @desc 第五章
 * @author p-hebiao
 *
 */
import java.util.Arrays;
import java.util.Random;

import extension.print;
public class chapterToFive {

	public static void main(String[] args){

		print.println("第五章~！");
		
		a();
		b();
		c(args);
		d();
		e(args);

	}
		
	public static void a(){
		new Rock();
		new Rock2(4);
	}
	
	static void b(){
		for(int i=0; i<5; i++){
			Tree t = new Tree(i);
			t.info();
			t.info("overLoaded method!");
		}
		new Tree();
	}
	static void c(String[] args){
		OverlaodingOrder s = new OverlaodingOrder();
		s.main(args);
	}
	static void d(){
		new Person().eat(new Apple());
	}
	static void e(String[] args){
		StaticInitialization x = new StaticInitialization();
		x.main(args);
		
		ExplicitStatic e = new ExplicitStatic();
		e.main(args);
	}
}

//初始化 构造函数
class Rock{
	Rock(){
		print.println("Rock");
	}
}
class Rock2{
	Rock2(int i){
		print.println("Rock2: " + i);
	}
}
//重载
class Tree{
	int height;
	Tree(){
		print.print("planting a seedting");
		height = 0;
	}
	Tree(int initialHeight){
		height = initialHeight;
	}
	void info(){
		print.print("1");
	}
	void info(String s){
		print.println(s);
	}
}
class OverlaodingOrder{
	static void f(String s, int i){
		print.println(s +" "+ i);
	}
	static void f(int i, String s){
		print.println(s +" "+ i);
	}
	static void main(String[] args){
		f("as", 32);
		f(22, "dd");
	}
}
/**
 * 基本类型的重载
 * @author mashimaro
 * 如果传入的数据类型小于方法中说明的形式参数类型，实际数据类型就会被提升
 */
class PrimitiveOverloading{
	void f1(char x){}
	void f1(byte x){}
	void f1(short x){}
	void f1(int x){}
	void f1(long x){}
	void f1(float x){}
	void f1(double x){}
	
	void testConstVal(){
		f1(5);
	}
}

class Bird2{
	Bird2(int i){}
	Bird2(double d){}
}
class Nosynthesis{
	int i = 0;
	public static void main(String[] args){
		Bird2 b2 = new Bird2(1);
		Bird2 b3 = new Bird2(1.1);
		
		Nosynthesis x = new Nosynthesis();
		x.increment().increment().increment().print();
	}
	//增量，返回对当前对象的引用
	Nosynthesis increment(){
		i++;
		return this;
	}
	void print(){
		print.print("i =" + i);
	}
}

class Person{
	public void eat(Apple apple){
		Apple peeled = apple.getPeeled();
		print.print("Yummy");
	}
}
class Peeler{
	static Apple peel(Apple apple){
		return apple;
	}
}
class Apple{
	Apple getPeeled(){
		return Peeler.peel(this);
	}
}

class Flower{
	int petalCount = 0;
	String s = "initial value";
	
	Flower(int petals){
		petalCount = petals;
	}
	Flower(String ss){
		s = ss;
	}
	Flower(String s, int petals){
		this(petals);
//		this(s);        //Can't call two!
		this.s = s;		//Ahother use of : this 代表数据成员
	}
	Flower(){
		this("hi", 47);
	}
	void printPetalCount(){
//		this(11);		//Not inside non-constructor
		print.println("petalCount = " + petalCount + " s =" + s);
	}
	public static void main(String[] args){
		Flower x = new Flower();
		x.printPetalCount();
	}
}

class Book{
	boolean checkedOut = false;
	Book(boolean checkOut){
		checkedOut = checkOut;
	}
	void checkIn(){
		checkedOut = false;
	}
	protected void finalize(){
		if(checkedOut)
			print.println("Error : checked out");
	}
}
class TerminationCondition{
	public static void main(String[] args){
		Book novel = new Book(true);
		novel.checkIn();
		new Book(true);
		System.gc(); //强制进行终结动作
	}
}

class InitialValues{
	boolean t;
	char c;
	byte v;
	short s;
	int i;
	long l;
	float f;
	double d;
	InitialValues reference;
	void printInitialValues(){
		
	}
	
	public static void main(String[] args){
		InitialValues iv = new InitialValues();
		iv.printInitialValues();
		//另一种写法
		new InitialValues().printInitialValues();
	}
}

class Depth{}
class Measurement{
	Depth d = new Depth();
}
class MethodInit{
	int i = f();
	int f(){ return 11;}
}
class MethodInit2{
	int i = f();
	int j = g(i);  //初始化 顺序执行  不然报错
	int f(){return 11;}
	int g(int n){ return n*10;}
}
//构造器初始化   i 首先被置0 然后变成9
class Counter{
	int i;
	Counter(){
		i = 9;  
	}
}

class Window{
	Window(int marker){ 
		print.println("Window : "+ marker);
	}
}
class House{
	Window w1 = new Window(1);
	House(){
		print.print("House()");
		w3 = new Window(33);
	}
	
	Window w2 = new Window(2);
	void f(){ print.print("f()");}
	Window w3 = new Window(3);
}
class OrderOfInitialization{
	public static void main(String[] args){
		House h = new House();
		h.f();
	}
}

class Bowl{
	Bowl(int marker){
		print.print(marker);
	}
	void f1(int marker){
		print.print(marker);
	}
}
class Table{
	static Bowl bowl1 = new Bowl(1);
	Table(){
		bowl2.f1(1);
	}
	void f2(int marker){
		print.print(marker);
	}
	
	static Bowl bowl2 = new Bowl(2);
}
class Cupboard{
	Bowl bowl3 = new Bowl(3);
	static Bowl bowl4 = new Bowl(4);
	Cupboard(){
		bowl4.f1(2);
	}
	void f3(int marker){
		print.print(marker);
	}
	static Bowl bowl5 = new Bowl(5);
}

class StaticInitialization{
	public static void main(String[] args){
		new Cupboard();
		new Cupboard();
		table.f2(1);
		cupboard.f3(1);
	}
	static Table table = new Table();
	static Cupboard cupboard = new Cupboard();
}
//静态块
class Spon{
	static int i;
	static{
		i = 47;
	}
}

class Cup{
	Cup(int marker){
		print.print(marker);
	}
	void f(int marker){
		print.print(marker);
	}
}
class Cups{
	static Cup cup1;
	static Cup cup2;
	static{
		cup1 = new Cup(1);
		cup2 = new Cup(2);
	}
	Cups(){
		print.print("Cups()");
	}
}
class ExplicitStatic{
	public static void main(String[] args){
		print.print("inside main()");
		Cups.cup1.f(99);
	}
}

class Mug{
	Mug(int marker){
		print.print(marker);
	}
	void f(int marker){
		print.print(marker);
	}
}
class Mugs{
	Mug mug1;
	Mug mug2;
	{
		mug1 = new Mug(1);
		mug2 = new Mug(2);
	}
	Mugs(){
		print.print("Mugs()");
	}
	Mugs(int i){
		
	}
	
	public static void main(String[] args){
		new Mugs();
		new Mugs(1);
	}
}

/*
 * 数组初始化
 * int[] a1;
 * int a1[];
 */
class ArraysOfPrimitives{
	
	public static void main(String[] args){
		int[] a1 = {1,2,3,4,5};
		int[] a2;
		a2 = a1;
		for(int i=0; i<a2.length; i++)
			a2[i] = a2[i] + 1;
		for(int i=0; i< a1.length; i++)
			print.println(a1[i]);
	}
}
class ArrayNew{
	public static void main(String[] args){
		int[] a;
		Random rand = new Random(47);
		a = new int[rand.nextInt(20)]; //返回0到输入参数之间的一个值
		print.println(a.length + " " + Arrays.toString(a));	//属于java.util标准类库，将产生一维数组的可打印版本
	
		//在定义的同时进行初始化
		int[] b = new int[rand.nextInt(30)];
	}
}
class ArrayClassObj{
	public static void main(String[] args){
		Random rand = new Random(47);
		Integer[] a = new Integer[rand.nextInt(20)];
		
		for(int i=0; i<a.length; i++)
			a[i] = rand.nextInt(500);
		
	}
}
class ArrayInit{
	public static void main(String[] args){
		Integer[] a = {
				new Integer(1),
				new Integer(2),
				3,
		};
		Integer[] b = new Integer[]{
				new Integer(1),
				new Integer(2),
				3,
		};
		
		print.println(Arrays.toString(a));
		print.println(Arrays.toString(b));
		
	}
}
class DynamicArray{
	public static void main(String args){
		Other.main(new String[]{"fiddle", "de", "dum"});
	}
}
class Other{
	public static void main(String[] args){
		for(String s : args)
			print.println(s + "");
	}
}
//可变参数列表
class A{}
class VarArgs{
	static void printArray(Object[] args){
		for(Object obj : args)
			print.println(" " + obj);
		print.println("");
	}
	public static void main(String[] args){
		printArray(new Object[]{
				new Integer(47),
				new Float(3.14),
				new Double(11.11),
		});
		printArray(new Object[]{
				"one", "two", "three",
		});
		printArray(new Object[]{
				new A(),
				new A(),
				new A(),
		});
	}
}

class NewVarArgs{
	static void printArray(Object...args){
		for(Object obj: args)
			print.println(obj+" ");
		print.println("");
	}
	public static void main(String[] args){
		printArray(
				new Integer(47),
				new Float(3.14),
				new Double(11.11)
				);
		printArray(
			new Object[]{
				"one", "two", "three"
			}
		);
		printArray(
				new A(),
				new A(),
				new A()
		);
		//an array
		printArray(
				(Object[])new Integer[]{1,2,3,4}
				);
		// empty list is ok
		printArray();
	}
}

class OptionalTrilingArguments{
	static void f(int required, String... trailing){
		for(String s : trailing)
			print.println(s+ "");
		print.println("");
	}
	public static void main(String[] args){
		f(1, "one");
		f(2,"two", "three");
		f(0);
	}
}
//getClass() 司机会Object一部分 产生对象的类，并且打印该类
class VarargType{
	static void f(Character... args){
		print.print(args.getClass());
		print.print(args.length);
	}
	static void g(int... args){
		print.print(args.getClass());
		print.println(args.length);
	}
	public static void main(String[] args){
		f('a');
		f();
		g(1);
		g();
	}
}

class AutoboxingVarargs{
	public static void f(Integer... args){
		for(Integer i : args)
			print.println(i +" ");
	}
	public static void main(String[] args){
		f(new Integer(1), new Integer(2));
		f(4,5,6,7,8,9);
		f(10, new Integer(11), 12);
	}
}

//可变参数列表使重载变的复杂
class OverloadingVarargs{
	static void f(Character... args){
		for(Character c: args)
			print.print(c);
	}
	static void f(Integer... args){
		for(Integer i: args)
			print.print(i);
	}
	static void f(Long... args){
		for(Long l: args)
			print.print(l);
	}
	//可通过某个方法中增加一个非可变参数来解决问题
	static void f(float f, Character... args){
		for(Character c: args)
			print.print(c);
	}
}

//枚举类型
enum Spiciness{
	NOT, MILD, MEDIUM, HOT, FLAMING
}
class SimpleEnumUse{
	public static void main(String[] args){
		Spiciness howHot = Spiciness.FLAMING;
		print.print(howHot);
	}
}
class Burrito{
	Spiciness degree;
	public Burrito(Spiciness degree){
		this.degree = degree;
	}
	public void describe(){
		print.print("This burrito is ");
		switch(degree)
		{
			case NOT: 
				print.print(1);
				break;
			case MILD: 
				print.print(2);
				break;
			default: 
				print.print("default");
				break;
		}
	}
	public static void main(String[] args){
		Burrito 
			plain = new Burrito(Spiciness.NOT),
			greemChile = new Burrito(Spiciness.MEDIUM),
			jalapeno   = new Burrito(Spiciness.MILD);
		
		plain.describe();
		greemChile.describe();
		jalapeno.describe();
		
	}
	
	
}




































