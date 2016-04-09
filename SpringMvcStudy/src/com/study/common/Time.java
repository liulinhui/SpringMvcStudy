package com.study.common;
import java.util.Timer;
//TODO
           //定时器类，用来定时执行某段任务；
public class Time {
	public Timer timer;
	MyTimeTask myTimeTask=new MyTimeTask();
	public void timerStart(){
		timer = new Timer();
	     timer.schedule(myTimeTask, 0,180000);
	}
	public void timerStop(){
	       if(timer!=null) 
	          timer.cancel();
	   }
	public static void main(String[] args){
		Time myTimer=new Time();
		myTimer.timerStart();
	}
	     
	}

