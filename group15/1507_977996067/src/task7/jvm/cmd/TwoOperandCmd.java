package task7.jvm.cmd;

import task7.jvm.clz.ClassFile;
import task7.jvm.constant.ClassInfo;
import task7.jvm.constant.ConstantInfo;
import task7.jvm.constant.ConstantPool;
import task7.jvm.constant.FieldRefInfo;
import task7.jvm.constant.MethodRefInfo;

public abstract class TwoOperandCmd extends ByteCodeCommand{
	
	int oprand1 = -1;
	int oprand2 = -1;
	
	public int getOprand1() {
		return oprand1;
	}

	public void setOprand1(int oprand1) {
		this.oprand1 = oprand1;
	}

	public void setOprand2(int oprand2) {
		this.oprand2 = oprand2;
	}

	public int getOprand2() {
		return oprand2;
	}
	
	public TwoOperandCmd(ClassFile clzFile,String opCode) {
		super(clzFile, opCode);
	}

	public int getIndex(){
		int oprand1 = this.getOprand1();
		int oprand2 = this.getOprand2();
		int index = oprand1 << 8 | oprand2;
		return index;
	}
	
	protected String getOperandAsClassInfo(ConstantPool pool){
		int index = getIndex();
		String codeTxt = getReadableCodeText();
		ClassInfo info = (ClassInfo)pool.getConstantInfo(index);
		return this.getOffset()+":"+this.getOpCode()+" "+ codeTxt +"  "+ info.getClassName();
	}
	
	protected String getOperandAsMethod(ConstantPool pool){
		int index = getIndex();
		String codeTxt = getReadableCodeText();
		ConstantInfo constInfo = this.getConstantInfo(index);
		MethodRefInfo info = (MethodRefInfo)this.getConstantInfo(index);
		return this.getOffset()+":"+this.getOpCode()+" " + codeTxt +"  "+ info.toString();
	}

	protected String getOperandAsField(ConstantPool pool){
		int index = getIndex();
		
		String codeTxt = getReadableCodeText();
		FieldRefInfo info = (FieldRefInfo)this.getConstantInfo(index);
		return this.getOffset()+":"+this.getOpCode()+" " + codeTxt +"  "+ info.toString();
	}
	public  int getLength(){
		return 3;
	}
}
