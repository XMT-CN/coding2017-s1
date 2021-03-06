package com.github.HarryHook.coding2017.jvm.print;

import com.github.HarryHook.coding2017.jvm.clz.ClassFile;
import com.github.HarryHook.coding2017.jvm.constant.ClassInfo;
import com.github.HarryHook.coding2017.jvm.constant.ConstantInfo;
import com.github.HarryHook.coding2017.jvm.constant.ConstantPool;
import com.github.HarryHook.coding2017.jvm.constant.FieldRefInfo;
import com.github.HarryHook.coding2017.jvm.constant.MethodRefInfo;
import com.github.HarryHook.coding2017.jvm.constant.NameAndTypeInfo;
import com.github.HarryHook.coding2017.jvm.constant.StringInfo;
import com.github.HarryHook.coding2017.jvm.constant.UTF8Info;
import com.github.HarryHook.coding2017.jvm.loader.ClassFileLoader;

public class ClassFilePrinter {
    ClassFile clzFile = null;

    public ClassFilePrinter(ClassFile clzFile) {
	this.clzFile = clzFile;
    }

    public void print() {

	if (clzFile.getAccessFlag().isPublicClass()) {
	    System.out.println("Access flag : public  ");
	}
	System.out.println("Class Name:" + clzFile.getClassName());

	System.out.println("Super Class Name:" + clzFile.getSuperClassName());

	System.out.println("minor version:" + clzFile.getMinorVersion());

	System.out.println("major version:" + clzFile.getMinorVersion());

	ConstantPoolPrinter cnstPoolPrinter = new ConstantPoolPrinter(clzFile.getConstantPool());
	cnstPoolPrinter.print();

    }

    public static void main(String[] args) {
	String path = "F:\\Coding2017\\group02\\727171008\\bin";
	ClassFileLoader loader = new ClassFileLoader();
	loader.addClassPath(path);
	String className = "com.github.HarryHook.coding2017.jvm.test.EmployeeV1";

	ClassFile clzFile = loader.loadClass(className);

	ClassFilePrinter printer = new ClassFilePrinter(clzFile);

	printer.print();
    }
}
