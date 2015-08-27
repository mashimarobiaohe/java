/**
 * @desc 第四章
 * @author p-hebiao
 *
 */
import java.util.Random;

import extension.print;
public class chapterToFour {

	public static void main(String[] args){
		print.println("第四章，控制执行流程");
		
		IfElse t = new IfElse();
		t.main(args);
		
		ListCharacters l = new ListCharacters();
		l.main(args);
		l.m();
		
		ForEachFloat m = new ForEachFloat();
		m.main();
		
		ForEachInt q = new ForEachInt();
		q.main(args);
		
		LabeledFor w = new LabeledFor();
		w.main(args);
		
	}
}

class IfElse{
	static int result =0;
	static void test(int testval, int target){
		if(testval > target)
			result = +1;
		else if(testval < target)
			result = -1;
		else
			result = 0;
	}
	public static void main(String[] args){
		test(10, 5);
		print.print(result);
		test(5,10);
		print.print(result);
		test(5,5);
		print.print(result);
	}
}

class WhileTest{
	static boolean condition(){
		boolean result = Math.random() < 0.99;
		print.print(result);
		return result;
	}
	
	public static void main(String[] args){
		while(condition())
			print.println("Insite 'while'");
		print.println("Exited 'while'");
	}
	
	static void doWhile(){
		do
			print.print("do it");
		while(condition());
	}
}

class ListCharacters{
	public static void main(String[] args){
		for(char c=0; c<128; c++)
			if(Character.isLowerCase(c))
				print.println("value: " + (int)c + " character: " + c);
	}
	
	public static void m(){
		for(int i=1, j=i+10; i<5; i++,j=i*2)
			print.println("i =" + i + " j =" + j);
	}
	
}

class ForEachFloat{
	public static void main(){
		Random rand = new Random(47);
		float f[] = new float[10];
		for(int i=0; i<10; i++)
			f[i] = rand.nextFloat();
		for(float x : f)
			print.println(x);
		for(char c: "An African Swallow".toCharArray())
			print.print(c+" ");
		
		print.println("");
		
	}
}

class ForEachInt{
	public static void main(String[] args){
		int[] t = new int[]{1,2,3,4,5,7,8,9};
		for(int i : t)
			print.print(i+ " - ");
	}
}

class BreakAndContinue{
	public static void main(String[] args){
		for(int i=0; i<100; i++){
			if(i ==74)break;
			if(i %9 !=0)continue;
			print.print(i+" ");
		}
		
		print.println("");
		
		int[] t = new int[100];
		for(int i : t){
			if(i == 72)break;
			if(i % 9 !=0)continue;
			print.print(i+" ");
		}
		
		print.println("");
		
		int i = 0;
		while(true){
			i++;
			int j = i* 27;
			if(j == 1269)break;
			if(i % 10 !=0)continue;
			print.print(i+" ");
		}
	}
}

class LabeledFor{
	public static void main(String[] args){
		int i = 0;
		outer: //Can't have statements here
			for(; true ;){
				inner: //Can't have statements here
					for(;i<10;i++){
						print.print(i);
						if(i ==2){
							print.print("continue");
							continue;
						}
						if(i == 3){
							print.print("break");
							i++;
							break;
						}
						if(i == 7){
							print.print("break outer");
							continue outer;
						}
						if(i == 8){
							print.print("break nuter");
							break outer;
						}
						for(int k=0; k<5; k++){
							if(k == 3){
								print.print("continue inner");
								continue inner;
							}
						}
					}
			}
	}
}

class LabledWhile{
	public static void main(String[] args){
		int i = 0;
		outer:
			while(true){
				i++;
				print.print("i =" + i);
				if(i == 1)
					continue;
				if(i == 3)
					continue outer;
				if(i == 5)
					break;
				if(i == 7)
					break outer;
			}
	}
}

class VowelsAndConsonants{
	
	public static void main(String[] args){
	
		Random rand = new Random(47);
		for(int i=0; i<100; i++){
			int c = rand.nextInt(26) + 'a';   //产生0-26之间的一个值
			print.print((char)c + ". " + c + ": ");
			switch(c)
			{
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					print.print("vowel");
					break;
				case 'y':
				case 'w':
					print.print("Sometimes a vowel");
					break;
				default :
					print.print("consonant");
			}
		}
	}
}


















