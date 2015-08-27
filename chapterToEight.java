/**
 * @desc 第八章 多态
 * @author p-hebiao
 *
 */
import extension.*;
import java.math.*;

public class chapterToEight{

	public static void main(String[] args){
		print.println("第八章~!!");

		//pmt算法测试
		Pmt abvc = new Pmt();
		BigDecimal a = new BigDecimal("0.0286875");
		BigDecimal b = new BigDecimal("90000");
		BigDecimal c = new BigDecimal("4500");
		BigDecimal bv = abvc.getPMT(a, 20, b, c, 0);
		print.print(bv);
	}
}
/**
 * @desc pmt算法
 * @author Administrator
 *
 */
class Pmt{
	
	public BigDecimal getPMT(BigDecimal rate, int nper, BigDecimal pv, BigDecimal fv, int type) {
		fv = (fv == null ? BigDecimal.ZERO : fv);
		BigDecimal one = BigDecimal.ONE;
		BigDecimal x = one.divide(rate.add(one), 20, BigDecimal.ROUND_HALF_UP);
		BigDecimal result = pv.subtract(fv.multiply(x.pow(nper))).multiply(rate);
		result = result.divide(BigDecimal.ONE.subtract(x.pow(nper)), 20, BigDecimal.ROUND_HALF_UP);
		if (type == 0) {// 期初
		result = result.multiply(x);
		}
		return result.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
}

class Instrumenta{
	public void play(Note n){
		print.print("Instrument.play()");
	}
}
class Winda extends Instrumenta{
	public void play(Note n){
		print.print(n);
		super.play(n);
	}
	
	public static void tune(Instrumenta i){
		i.play(Note.MIDDLE_C);
	}
	
	public static void main(String[] args){
		Winda flute = new Winda();
		tune(flute);
	}
}

class Stringed extends Instrumenta{
	public void play(Note n){
		print.print(n);
	}
}
class Brass extends Instrumenta{
	public void play(Note n){
		print.print(n);
	}
}
class Music2{
	public static void tune(Winda i){
		i.play(Note.MIDDLE_C);
	}
	public static void tune(Stringed i){
		i.play(Note.MIDDLE_C);
	}
	public static void tune(Brass i){
		i.play(Note.MIDDLE_C);
	}
	public static void main(String[] args){
		Winda flute = new Winda();
		Stringed violin = new Stringed();
		Brass frenchHorn = new Brass();
		tune(flute);
		tune(violin);
		tune(frenchHorn);
	}
}

class Shapea{
	public void draw(){}
	public void erase(){}
}

class Actor{
	public void act(){}
}
class HappyActor extends Actor{
	public void act(){
		print.print("");
	}
}
class SadActor extends Actor{
	public void act(){
		print.print("");
	}
}
class Stage{
	private Actor actor = new HappyActor();
	public void change(){
		actor = new SadActor();
	}
	public void performPlay(){
		actor.act();
	}
}
class Transmogrigy{
	public static void main(String[] args){
		Stage stage = new Stage();
		stage.performPlay();
		stage.change();
		stage.performPlay();
	}
}

/************ 用继承进行设计  *****************/
class Useful{
	public void f(){}
	public void g(){}
}
class MoreUseful extends Useful{
	public void f(){}
	public void g(){}
	public void u(){}
	public void v(){}
	public void w(){}
}
class RTT1{
	public static void main(String[] args){
		Useful[] x = {
				new Useful(),
				new MoreUseful(),
		};
		x[0].f();
		x[1].g();
//		x[2].u();
	}
}









