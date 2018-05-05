package DesignPattern.Singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class mySingleton implements Serializable,Cloneable{
	//private static mySingleton soleInstance = new mySingleton();//Eagerly creating instance on load time of class
	private static mySingleton soleInstance = null;
	private mySingleton() {
		System.out.println("Creating Instance...");
	}
	public static mySingleton getInstance() {
		if(soleInstance == null) {
			soleInstance = new mySingleton();//Lazily creating instance  
		}
		return soleInstance;
	}
 @Override
protected Object clone() throws CloneNotSupportedException {
	// TODO Auto-generated method stub
	return super.clone();
}   
}

class TestClass {
	public static mySingleton useServiceSingleton() {
		mySingleton singleton = mySingleton.getInstance();
		System.out.println("singleton HashCode::"+ singleton.hashCode());
		return singleton;
	}
	public static void main(String []args) {
		mySingleton s1 = mySingleton.getInstance();
		mySingleton s2 = mySingleton.getInstance();
		
		System.out.println("s1 HashCode::"+ s1.hashCode());
		System.out.println("s2 HashCode::"+ s2.hashCode());
		
			//Violating Singleton using Reference API
		try {
			Class cls = Class.forName("DesignPattern.Singleton.mySingleton");
			Constructor<mySingleton> construct = cls.getDeclaredConstructor();
			construct.setAccessible(true);
			mySingleton s3 = construct.newInstance();
			System.out.println("s3 HashCode::"+ s3.hashCode());
	
			//Violating Singleton using Serialization
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/home/progen/eclipse-workspace/temp/file.ser"));
			oos.writeObject(s2);
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/home/progen/eclipse-workspace/temp/file.ser"));
			mySingleton s4 = (mySingleton) ois.readObject();
			System.out.println("s4 HashCode::"+ s4.hashCode());
			
			//Violating Singleton using Cloneable
			mySingleton s5 = (mySingleton) s2.clone();
			System.out.println("s5 HashCode::"+ s5.hashCode());
			
			//Violating Singleton using Multithereading
		    ExecutorService exService = Executors.newFixedThreadPool(2);
		    exService.submit(TestClass::useServiceSingleton);
		    exService.submit(TestClass::useServiceSingleton);
		    exService.shutdown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}