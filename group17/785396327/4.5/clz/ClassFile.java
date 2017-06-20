package clz;

import constant.ClassInfo;
import constant.ConstantInfo;
import constant.ConstantPool;
import field.Field;
import method.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IBM on 2017/4/10.
 */
public class ClassFile {
    private int minorVersion;
    private int majorVersion;

    private AccessFlag accessFlag;
    private ClassIndex clzIndex;
    private ConstantPool pool;
    private List<Field> fields = new ArrayList<Field>();
    private List<Method> methods = new ArrayList<Method>();

    public ClassIndex getClzIndex() {
        return clzIndex;
    }
    public AccessFlag getAccessFlag() {
        return accessFlag;
    }
    public void setAccessFlag(AccessFlag accessFlag) {
        this.accessFlag = accessFlag;
    }



    public ConstantPool getConstantPool() {
        return pool;
    }
    public int getMinorVersion() {
        return minorVersion;
    }
    public void setMinorVersion(int minorVersion) {
        this.minorVersion = minorVersion;
    }
    public int getMajorVersion() {
        return majorVersion;
    }
    public void setMajorVersion(int majorVersion) {
        this.majorVersion = majorVersion;
    }
    public void setConstPool(ConstantPool pool) {
        this.pool = pool;

    }
    public void setClassIndex(ClassIndex clzIndex) {
        this.clzIndex = clzIndex;
    }

    public void addField(Field f){
        this.fields.add(f);
    }
    public List<Field> getFields(){
        return this.fields;
    }
    public void addMethod(Method m){
        this.methods.add(m);
    }
    public List<Method> getMethods() {
        return methods;
    }


    public void print(){

        if(this.accessFlag.isPublicClass()){
            System.out.println("Access flag : public  ");
        }
        System.out.println("Class Name:"+ getClassName());

        System.out.println("Super Class Name:"+ getSuperClassName());

        System.out.println("Constant pool:");


    }

    public String getClassName(){
        int thisClassIndex = this.clzIndex.getThisClassIndex();
        ClassInfo thisClass = (ClassInfo)this.getConstantPool().getConstantInfo(thisClassIndex);
        return thisClass.getClassName();
    }
    public String getSuperClassName(){
        ClassInfo superClass = (ClassInfo)this.getConstantPool().getConstantInfo(this.clzIndex.getSuperClassIndex());
        return superClass.getClassName();
    }

    public Method getMethod(String methodName, String paramAndReturnType) {
        if (methods != null) {
            for (Method method : methods) {
                String name = getConstantPool().getUTF8String(method.getNameIndex());
                String desc = getConstantPool().getUTF8String(method.getDescriptorIndex());
                if(name.equals(methodName)&&desc.equals(paramAndReturnType))
                    return method;
            }
        }
        return null;
    }
    public Method getMainMethod(){
        if (methods != null) {
            for (Method method : methods) {
                String name = getConstantPool().getUTF8String(method.getNameIndex());
                String desc = getConstantPool().getUTF8String(method.getDescriptorIndex());
                if(name.equals("main")&&desc.equals("([Ljava/lang/String;)V"))
                    return method;
            }
        }
        return null;
    }
}
