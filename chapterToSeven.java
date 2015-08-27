/**
 * @desc 第七章 复用类
 * @author p-hebiao
 *
 */
import java.util.Random;

import extension.*;
public class chapterToSeven {

	public static void main(String[] args){
		print.println("hello world!!");
	}
	
}

class WaterSource{
	
	private String s;
	WaterSource(){
		print.println("WaterSource()");
		s = "Constructed";
	}
	public String toString(){
		return s;
	}
}

class SprinklerSystem{
	private String value1, value2, value3, value4;
	private WaterSource source = new WaterSource();
	private int i;
	private float f;
	
	public String toString(){
		return "";
	}
	
	public static void main(String[] args){
		SprinklerSystem sprinklers = new SprinklerSystem();
		print.println(sprinklers);
	}
}

class Soap{
	private String s;
	Soap(){
		s ="Constructed";
		print.print(s);
	}
	public String toString(){ return s;}
}
class Bath{
	private String s1 = "Happy",
					s2= "Happy",
					s3,s4;
	private Soap castille;
	private int i;
	private float toy;
	
	public Bath(){
		s3 = "Joy";
		toy = 3.14f;
		castille = new Soap();
	}
	
	public String toString(){
		if(s4 == null)
			s4 = "Joy";
		return s1+"\n"+s2+"\n"+"\n";
	}
	public static void main(String[] args){
		Bath b = new Bath();
		print.print(b);
	}
}
//继承
class Cleanser{
	private String s = "Cleanser";
	public void append(String a){ s += a;}
	public void dilute(){ append("delute");}
	public void apply(){ append("apply");}
	public void scrub(){ append("scrub");}
	public String toString(){ return s;}
	
	public static void main(String[] args){
		Cleanser x = new Cleanser();
		x.dilute();x.apply();x.scrub();
		print.print(x);
	}
}
class Detergent extends Cleanser{
	public void scrub(){
		append("detergent.scrub");
		super.scrub();
	}
	public void foam(){
		append("foam");
	}
	public static void main(String[] args){
		Detergent x = new Detergent();
		x.dilute();
		x.apply();
		x.scrub();
		x.foam();
		print.print(x);
		Cleanser.main(args);
	}
}
class Art{
	Art(){
		print.print("art constructor");
	}
}
class Drawing extends Art{
	Drawing(){
		print.print("drawing constructor");
	}
}
class Carton extends Drawing{
	public Carton(){
		print.print("carton constructor");
	}
	public static void main(){
		Carton x = new Carton();
	}
}
class Game{
	Game(int i){
		print.print("game contructor");
	}
}
class BoardGame extends Game{
	BoardGame(int i){
		super(i);
		print.print("BoardGame constructor");
	}
}
class Chess extends BoardGame{
	Chess(){
		super(11);
		print.print("Chess constructor");
	}
	public static void main(){
		Chess x = new Chess();
	}
}
//代理
class SpaceShipControls{
	void up(int velocity){}
	void down(int velocity){}
	void left(int velocity){}
	void right(int velocity){}
	void forward(int velocity){}
	void back(int velocity){}
	void turboBoost(int velocity){}
}
class SpaceShip extends SpaceShipControls{
	private String name;
	public SpaceShip(String name){ this.name = name;}
	public String toString(){ return name;}
	public static void main(String[] args){
		SpaceShip protector = new SpaceShip("NSEA Protector");
		protector.forward(100);
	}
}
//代理  避免所有方法暴露出来，选择提供部分子集
class SpaceShipDelegation{
	private String name;
	private SpaceShipControls controls = new SpaceShipControls();
	public SpaceShipDelegation(String name){
		this.name = name;
	}
	public void back(int velocity){
		controls.back(velocity);
	}
	public void down(int velocity){
		controls.down(velocity);
	}
	public void left(int velocity){
		controls.left(velocity);
	}
	public void right(int velocity){
		controls.right(velocity);
	}
	public void forward(int velocity){
		controls.forward(velocity);
	}
	public void turboBoost(int velocity){
		controls.turboBoost(velocity);
	}
	public static void main(){
		SpaceShipDelegation protector = new SpaceShipDelegation("NSEA Protector");
		protector.forward(100);
	}
}

//7.4
class Plate{
	Plate(int i){
		
	}
}
class DinnerPlate extends Plate{
	DinnerPlate(int i){ 
		super(i);
	}
}
class Utensil{
	Utensil(int i){
		
	}
}
class Spoon extends Utensil{
	Spoon(int i){
		super(i);
	}
}
class Fork extends Utensil{
	Fork(int i){
		super(i);
	}
}
class Knife extends Utensil{
	Knife(int i){
		super(i);
	}
}
class Custom{
	Custom(int i){
		
	}
}
class PlaceSetting extends Custom{
	private Spoon sp;
	private Fork frk;
	private Knife kn;
	private DinnerPlate pl;
	public PlaceSetting(int i){
		super(i + 1);
		sp = new Spoon(i + 2);
		frk = new Fork(i + 3);
		kn = new Knife(i + 4);
		pl = new DinnerPlate(i + 5);
	}
	public static void main(String[] args){
		PlaceSetting x = new PlaceSetting(9);
	}
}

class Shape{
	Shape(int i){
		
	}
	void dispose(){
		
	}
}
class Circle extends Shape{
	Circle(int i){
		super(i);
	}
	void dispose(){
		super.dispose();
	}
}
class Triangle extends Shape{
	Triangle(int i){
		super(i);
	}
	void dispose(){
		super.dispose();
	}
}
class Line extends Shape{
	private int start, end;
	Line(int start, int end){
		super(start);
		this.start = start;
		this.end = end;
	}
	void dispose(){
		super.dispose();
	}
}
class CADSystem extends Shape{
	private Circle c;
	private Triangle t;
	private Line[] lines = new Line[3];
	public CADSystem(int i){
		super(i + 1);
		for(int j=0; j<lines.length; j++)
			lines[j] = new Line(j, j*j);
		c = new Circle(1);
		t = new Triangle(1);
	}
	public void dispose(){
		t.dispose();
		c.dispose();
		for(int i = lines.length - 1; i >=0; i--)
			lines[i].dispose();
		super.dispose();
	}
	public static void main(String[] args){
		CADSystem x = new CADSystem(47);
		try{
			
		}finally{
			x.dispose();
		}
	}
}
class Homer{
	char doh(char c){
		return 'd';
	}
	float doh(float f){
		return 1.0f;
	}
}
class Milhouse{
	
}
class Bart extends Homer{
	void doh(Milhouse m){
		
	}
}
class Lisa extends Homer{
//	@Override 
	void doh(Milhouse m){
		
	}
}

class Engine{
	public void start(){}
	public void rev(){}
	public void stop(){}
}
class Wheel{
	public void inflate(int psi){}
}
class Window{
	public void rollup(){}
	public void rolldown(){}
}
class Door{
	public Window window = new Window();
	public void open(){}
	public void close(){}
}
class Car{
	public Engine engine = new Engine();
	public Wheel[] wheel = new Wheel[4];
	public Door
		left = new Door(),
		right = new Door();
	public Car(){
		for(int i=0; i<4; i++)
			wheel[i] = new Wheel();
	}
	public static void main(String[] args){
		Car car = new Car();
		car.left.window.rollup();
		car.wheel[0].inflate(72);
	}
}

class Villain{
	private String name;
	protected void set(String nm){
		name = nm;
	}
	public Villain(String name){ this.name = name;}
	public String toString(){
		return name;
	}
}

class Orc extends Villain{
	private int orcNumber;
	public Orc(String name, int orcNumber){
		super(name);
		this.orcNumber = orcNumber;
	}
	public void change(String name, int orcNumber){
		set(name);
		this.orcNumber = orcNumber;
	}
	public String toString(){
		return super.toString();
	}
	public static void main(String[] args){
		Orc orc = new Orc("Limburger", 12);
		orc.change("Bob", 19);
	}
}

class Instrument{
	public void play(){}
	static void tune(Instrument i){
		i.play();
	}
}
class Wind extends Instrument{
	public static void main(String[] args){
		Wind flute = new Wind();
		Instrument.tune(flute);
	}
}

class Value{
	int i;
	public Value(int i){ this.i = i;}
}
class FinalData{
	private static Random rand = new Random(47);
	private String id;
	public FinalData(String id){ this.id = id;}
	private final int valueOne = 9;
	private static final int VALUE_TWO = 99;
	public static final int VALUE_THREE = 39;
	private final Value v2 = new Value(22);
	private Value v1 = new Value(11);
	private final int i4 = rand.nextInt(20);
	static final int INT_5 = rand.nextInt(20);
	private static final Value VAL_3 = new Value(33);
	private final int[] a = {1,2,3,4,5,6,7,8,9};
	public String toString(){
		return id;
	}
	public static void main(String[] args){
		FinalData fd1 = new FinalData("21");
		fd1.v2.i++;
		fd1.v1 = new Value(9);
		for(int i=0; i<fd1.a.length; i++)
			fd1.a[i]++;
		FinalData fd2  = new FinalData("fd2");
	}
}







































