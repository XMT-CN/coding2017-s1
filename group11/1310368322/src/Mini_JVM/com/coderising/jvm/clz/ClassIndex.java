package com.coderising.jvm.clz;

public class ClassIndex {
	private int thisClassIndex;
	private int superClassIndex;
	
	public int getThisClassIndex(){
		System.out.println(thisClassIndex);
		return thisClassIndex;
	}
	
	public void setThisClassIndex(int thisClassIndex){
		this.thisClassIndex = thisClassIndex;
	}
	
	public int getSuperClassIndex(){
		return superClassIndex;
	}
	
	public void setSuperClassIndex(int superClassIndex){
		this.superClassIndex = superClassIndex;
	}
}
