import java.util.Scanner;

public class Visunel {


	public static void main(String[] args)
	{
		int count;
		char runchar;
		int runint;
		//平文を読み取る
        System.out.println("平文を入力してください:");
        String outstring=null;
		StringBuilder stringb = new StringBuilder();
        Scanner scan = new Scanner(System.in);
        outstring = scan.next();
		System.out.println("完了");

		//鍵を読み取る
		System.out.println("使用する鍵を入力してください:");
		String keystring=null;
		Scanner scankey = new Scanner(System.in);
        keystring = scankey.next();
		System.out.println("完了");

		int keylong[]=new int[keystring.length()];
		int usekey[]=new int[outstring.length()];
		int smalcount=0;

		//鍵に番号の割り当て
		for (count=0; count<keystring.length();count++)
		{
			runchar=keystring.charAt(count);
			runchar=(char)((int)runchar);
			if(64<runchar&&runchar<91)
			{
				runchar-=65;
			}
			else if(96<runchar&&runchar<123)
			{
				runchar-=97;
			}
			keylong[count]=runchar;
		}
		//System.out.println(keylong[0]);
		//System.out.println(keylong[1]);

		//鍵を平文の長さに調整をする。
		for(count=0;count<outstring.length();count++)
		{
			if(smalcount==keystring.length())
			{
				smalcount=0;
			}
			usekey[count]=keylong[smalcount];
			smalcount++;
		}
		//System.out.println(usekey[0]);


		//暗号表当てはめ。
		System.out.println("平文:"+outstring);
		for (count=0; count<outstring.length();count++)
		{
			//まず文字コードを0~25にする。
			runchar=outstring.charAt(count);
			runchar=((char)(int)runchar);
			//charは負の値を示すことができないのでint型に代入する。
			runint=runchar;
			if(64<runint&&runint<91)
			{
				runint-=65;
			}
			else if(96<runint&&runint<123)
			{
				runint-=97;
			}
			//鍵のcount番号をひく
			runint+=usekey[count];
			//もし、引いた数<0なら+25
			if(runint>25)
			{
				runint-=26;
			}
			//+65をする
			runchar=(char)(runint+65);
			stringb.append(runchar);
		}
		System.out.print("暗号文:"+stringb.toString());
	}

}
