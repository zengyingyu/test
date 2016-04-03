package test;

import java.beans.Encoder;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class Test {
	
	public void test(){
		try{
			throw new NullPointerException("11");
		}finally{
			//throw new NullPointerException("22");
		}
	}
	public static String excuteJs(String paras) throws ScriptException,FileNotFoundException, NoSuchMethodException {
        ScriptEngineManager engineManager = new ScriptEngineManager();  
        ScriptEngine engine = engineManager.getEngineByName("JavaScript"); //得到脚本引擎
        engine.eval(new java.io.FileReader("C:\\Users\\应玉\\Desktop\\prefit.js"));
        Invocable inv = (Invocable)engine;  
        Object a = inv.invokeFunction("fun",  paras);  
        return a.toString();
    }
	public static void main(String args[]) throws FileNotFoundException, NoSuchMethodException, ScriptException{
		Date date = new Date();
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 a HH:mm:ss");
		String dims="TF1;020;;;;;;;;;;;;;;;;;;;;;;Mozilla;Netscape;5.0%20%28Windows%29;20100101;undefined;true;Windows%20NT%206.3%3B%20WOW64;true;Win32;undefined;"
		       		+ "Mozilla/5.0%20%28Windows%20NT%206.3%3B%20WOW64%3B%20rv%3A33.0%29%20Gecko/20100101%20Firefox/33.0;"
		       		+ "zh-CN;undefined;reserve-cn.apple.com;undefined;undefined;undefined;undefined;false;false;"
		       		+ date.getTime()
		       		+";8;2005/6/7%20%u4E0B%u53489%3A33%3A44;1920;1080;;19.0;;;;2010;25;-480;-480;"
		       		//+ Encoder.escape(sdf.format(date))
					+";24;1920;1040;0;0;Adobe%20Acrobat%7CAdobe%20PDF%20Plug-In%20For%20Firefox%20and%20Netscape%2011.0.12;;;;;"
					+ "Shockwave%20Flash%7CShockwave%20Flash%2019.0%20r0;;;;;;;;;;;;;26;;;;;;;;;;;;;;;5.6.1-0;;";
		System.out.println(excuteJs(dims));
	}

}
