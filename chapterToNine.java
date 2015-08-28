/**
 * @desc 第九章
 * @author p-hebiao
 *
 */
import java.util.*;
import java.nio.*;

import extension.*;
public class chapterToNine {

	public static void main(String[] args){
		print.println("hello world!!~ nine");
	}
	
	
	
	
	
	
	
}
/*************  抽象类和抽象方法   ***************/
abstract class Instrumentb{
	private int i;
	public abstract void play(Note n);
	public String what(){ 
		return "Instrumentb";
	}
	public abstract void adjust();
}
class Windb extends Instrumentb{
	public void play(Note n){}
	public String what(){
		return "windb";
	}
	public void adjust(){}
}
class Percussion extends Instrumentb{
	public void play(Note n){}
	public String what(){
		return "Percussion";
	}
	public void adjust(){}
}
class Stringeda extends Instrumentb{
	public void play(Note n){
		print.print(" "+n);
	}
	public String what(){
		return "Stringeda";
	}
	public void adjust(){}
}
class Brassa extends Windb{
	public void play(Note n){
		print.print(n);
	}
	public void adjust(){
		print.print("Brassa");
	}
}
class Woodwind extends Windb{
	public void play(Note n){
		print.print(n);
	}
	public String what(){
		return "Woodwind";
	}
}
class Music4{
	static void tune(Instrumentb i){
		i.play(Note.MIDDLE_C);
	}
	static void tuneAll(Instrumentb[] e){
		for(Instrumentb i : e)
			tune(i);
	}
	
	public static void main(String[] args){
		Instrumentb[] orchestra = {
				new Windb(),
				new Percussion(),
				new Stringeda(),
				new Brassa(),
				new Woodwind()
		};
		tuneAll(orchestra);
	}
}

/******************  接口  *******************/
/**
 * @desc 所有实现了该特定接口的类看起来都像这样
 */
interface Instrumentc{
	int VALUE =5;
	void play(Note n);
	void adjust();
}

/******************  完全解耦 ****************/
class  Processor{
	public String name(){
		return getClass().getSimpleName();
	}
	Object process(Object input){ 
		return input;
	}
}
//返回一个字符串，该字符串中的所有字母都被转化为大写字母
class Upcase extends Processor{
	String process(Object input){
		return ((String)input).toUpperCase();
	}
}
//方法返回一个字符串，该字符串中的字母被转换为小写字母
class Downcase extends Processor{
	String process(Object input){
		return ((String)input).toLowerCase();
	}
}
//分割字符串
class Splitter extends Processor{
	String process(Object input){
		return Arrays.toString(((String)input).split(" "));
	}
}
class Apply{
	public static void process(Processor p, Object s){
		print.print(p.name());
		print.print(p.process(s));
	}
	public static String s="Disagreement with beliefs is by definition incorrect";
	public static void main(String[] args){
		process(new Upcase(), s);
		process(new Downcase(), s);
		process(new Splitter(), s);
	}
}
class Waveform{
	private static long counter;
	private final long id = counter++;
	public String toString(){
		return "Waveform " + id;
	}
}
//getSimpleName()返回的源代码中的基础类的简单名称。如果是匿名的基础类，则返回一个空字符串。 
class Filter{
	public String name(){
		return getClass().getSimpleName();
	}
	public Waveform process(Waveform input){
		return input;
	}
}
class HighPass extends Filter{
	double cutoff;
	public HighPass(double cutoff){
		this.cutoff = cutoff;
	}
}
class BandPass extends Filter{
	double lowCutoff, highCutoff;
	public BandPass(double lowCut, double highCut){
		lowCutoff = lowCut;
		highCutoff = highCut;
	}
	public Waveform process(Waveform input){
		return input;
	}
}
//Pricessir Apply 的修改版本
interface Processora{
	String name();
	Object process(Object input);
}
class Applya{
	public static void process(Processora p, Object s){
		print.print(p.name());
		print.print(p.process(s));
	}
}
abstract class StringProcessor implements Processora{
	public String name(){
		return getClass().getSimpleName();
	}
	public abstract String process(Object input);
	public static String s ="If she weighs the same as a duck, she's made of wood";
	public static void main(String[] args){
		Applya.process(new Upcasea(), s);
		Applya.process(new Downcasea(), s);
		Applya.process(new Splittera(), s);
	}
}
class Upcasea extends StringProcessor{
	public String process(Object input){
		return ((String)input).toUpperCase();
	}
}
class Downcasea extends StringProcessor{
	public String process(Object input){
		return ((String)input).toLowerCase();
	}
}
class Splittera extends StringProcessor{
	public String process(Object input){
		return Arrays.toString(((String)input).split(" "));
	}
}
class FilterAdapter implements Processora{
	Filter filter;
	public FilterAdapter(Filter filter){
		this.filter = filter;
	}
	public String name(){
		return filter.name();
	}
	public Waveform process(Object input){
		return filter.process((Waveform)input);
	}
}
/***************** java中的多重继承  *******************/
interface CanFight{
	void fight();
}
interface CanSwim{
	void swim();
}
interface CanFly{
	void fly();
}
class ActionCharacter{
	public void fight(){}
}
class Hero extends ActionCharacter implements CanFight, CanSwim, CanFly{
	public void swim(){}
	public void fly(){}
}
class Adventure{
	public static void t(CanFight x){ x.fight();}
	public static void u(CanSwim x){ x.swim(); }
	public static void v(CanFly x){ x.fly();}
	public static void w(ActionCharacter x){ x.fight();}
	public static void main(String[] args){
		Hero h = new Hero();
		t(h);
		u(h);
		v(h);
		w(h);
	}
}
/********************  通过继承来扩展接口		********************/
interface Monster{
	void menace();
}
interface DangerousMonster extends Monster{
	void destroy();
}
interface Lethal{
	void kill();
}
class DragonZilla implements DangerousMonster{
	public void menace(){}
	public void destroy(){}
}
interface Vampire extends DangerousMonster, Lethal{
	void drinkBlood();
}
class VeryBadVampire implements Vampire{
	public void menace(){}
	public void destroy(){}
	public void kill(){}
	public void drinkBlood(){}
}
class HorrorShow{
	static void u(Monster b){b.menace();}
	static void v(DangerousMonster d){
		d.menace();
		d.destroy();
	}
	static void w(Lethal l){ l.kill();}
	public static void main(String[] args){
		DangerousMonster barney = new DragonZilla();
		u(barney);
		v(barney);
		
		Vampire vlad = new VeryBadVampire();
		u(vlad);
		v(vlad);
		w(vlad);
	}
}
/**************		适配接口		******************/
//append() 字符串追加
//rand.nextInt(n); 生成一个 大于0 小于n的随机数
//hasNext() 检查序列中是否还有元素
class RandomWords implements Readable{
	private static Random rand = new Random(47);
	private static final char[] capitals = "ABCDEFGIJKLMNOPQRSTUVWXYZ".toCharArray();
	private static final char[] lowers = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	private static final char[] vowels = "aeiou".toCharArray();
	private int count;
	public RandomWords(int count){ this.count = count;}
	public int read(CharBuffer cb){
		if(count-- == 0)
			return -1;
		cb.append(capitals[rand.nextInt(capitals.length)]);
		for(int i=0; i< 4; i++){
			cb.append(vowels[rand.nextInt(vowels.length)]);
			cb.append(lowers[rand.nextInt(lowers.length)]);
		}
		cb.append(" ");
		return 10;
	}
	public static void main(String[] args){
		Scanner s = new Scanner(new RandomWords(10));
		while(s.hasNext())
			print.println(s.next());
	}
	
	
}
class RandomDoubles{
	private static Random rand = new Random(47);
	public double next(){ return rand.nextDouble();}
	public static void main(String[] args){
		RandomDoubles rd = new RandomDoubles();
		for(int i=0; i<7; i++)
			print.println(rd.next()+ " ");
	}
}
class AdaptedRandomDoubles extends RandomDoubles implements Readable{
	private int count;
	public AdaptedRandomDoubles(int count){
		this.count = count;
	}
	public int read(CharBuffer cb){
		if(count-- == 0)
			return -1;
		String result = Double.toString(next())+ " ";
		cb.append(result);
		return result.length();
	}
	public static void main(String[] args){
		Scanner s = new Scanner(new AdaptedRandomDoubles(7));
		while(s.hasNextDouble())
			print.println(s.nextDouble() + " ");
	}
}
/***************  接口中的域     *****************/
interface Months{
	int JANUARY = 1, FEBRUARY = 2, MARCH=3,
			APRTL = 4, MAY = 5, JUNE = 6, JULY = 7,
			AUGUST = 8, SEPTEMBER = 9, OCTOBER = 10,
			NOVEMBER = 11, DECEMBER = 12;
}
interface RandVals{
	Random RAND = new Random(46);
	int RANDOM_INT = RAND.nextInt(18);
	long RANDOM_LONG = RAND.nextLong() * 10;
	float RANDOM_FLOAT = RAND.nextFloat() * 10;
	double RANDOM_DOUBLE = RAND.nextDouble()* 10;
}
class TestRandVals{
	public static void main(String[] args){
		print.print(RandVals.RANDOM_INT);
		print.print(RandVals.RANDOM_LONG);
		print.print(RandVals.RANDOM_FLOAT);
		print.print(RandVals.RANDOM_DOUBLE);
	}
}
/*************** 嵌套接口  *****************/
class Ab{
	interface B{
		void f();
	}
	public class BImp implements B{
		public void f(){}
	}
	public class BImp2 implements B{
		public void f(){}
	}
	public interface C{
		void f();
	}
	class CImp implements C{
		public void f(){}
	}
	private class CImp2 implements C{
		public void f(){}
	}
	private interface D{
		void f();
	}
	private class DImp implements D{
		public void f(){}
	}
	public class DImp2 implements D{
		public void f(){}
	}
	public D getD(){
		return new DImp2();
	}
	private D dRef;
	public void receiveD(D d){
		dRef = d;
		dRef.f();
	}
}
interface E{
	interface G{
		void f();
	}
	public interface H{
		void f();
	}
	void g();
}
class NestingInterfaces{
	public class BImp implements Ab.B{
		public void f(){}
	}
	class CImp implements Ab.C{
		public void f(){}
	}
	class EImp implements E{
		public void g(){}
	}
	class EGImp implements E.G{
		public void f(){}
	}
	class EImp2 implements E{
		public void g(){}
		class EG implements E.G{
			public void f(){}
		}
	}
	public static void main(String[] args){
		Ab a = new Ab();
		Ab a2 = new Ab();
		a2.receiveD(a.getD());
	}
}
/*********************  接口与工厂  **********************/
/**
 * 想要创建框架
 * @author Administrator
 *
 */
interface Service{
	void method1();
	void method2();
}
interface ServiceFactory{
	Service getService();
}
class Implementation1 implements Service{
	Implementation1(){}
	public void method1(){}
	public void method2(){}
}
class Implementation1Factory implements ServiceFactory{
	public Service getService(){
		return new Implementation1();
	}
}
class Implementation2 implements Service{
	Implementation2(){}
	public void method1(){}
	public void method2(){}
}
class Implementation2Factory implements ServiceFactory{
	public Service getService(){
		return new Implementation2();
	}
}
class Factories{
	public static void serviceConsumer(ServiceFactory fact){
		Service s = fact.getService();
		s.method1();
		s.method2();
	}
	public static void main(String[] args){
		serviceConsumer(new Implementation1Factory());
		serviceConsumer(new Implementation2Factory());
	}
}

interface Game_a{
	boolean move();
}
interface GameFactory{
	Game_a getGame();
}
class Checkers implements Game_a{
	private int moves = 0;
	private static final int MOVES = 3;
	public boolean move(){
		print.print(moves);
		return ++moves != MOVES;
	}
}
class CheckersFactory implements GameFactory{
	public Game_a getGame(){
		return new Checkers();
	}
}
class Chess_a implements Game_a{
	private int moves = 0;
	private static final int MOVES = 4;
	public boolean move(){
		return ++moves != MOVES;
	}
}
class ChessFactory implements GameFactory{
	public Game_a getGame(){
		return new Chess_a();
	}
}
class Games{
	public static void playGame(GameFactory factory){
		Game_a s = factory.getGame();
		while(s.move())
			;
	}
	public static void main(String[] args){
		playGame(new CheckersFactory());
		playGame(new ChessFactory());
	}
}




































