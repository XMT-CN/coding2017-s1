package com.dudy.learn01.coderising.jvm.cmd;


import com.dudy.learn01.coderising.jvm.clz.ClassFile;
import com.dudy.learn01.coderising.jvm.constant.ConstantPool;

public class GetFieldCmd extends TwoOperandCmd {

	public GetFieldCmd(ClassFile clzFile, String opCode) {
		super(clzFile,opCode);		
	}

	@Override
	public String toString(ConstantPool pool) {
		
		return super.getOperandAsField(pool);
	}

	
	

}
