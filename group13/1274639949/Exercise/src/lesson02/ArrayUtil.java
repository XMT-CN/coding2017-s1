package lesson02;

import lesson01.ArrayList;
import lesson01.List;

public class ArrayUtil {
	
	/**
	 * 给定一个整形数组a , 对该数组的值进行置换
		例如： a = [7, 9 , 30, 3]  ,   置换后为 [3, 30, 9,7]
		如果     a = [7, 9, 30, 3, 4] , 置换后为 [4,3, 30 , 9,7]
	 * @param origin
	 * @return
	 */
	public void reverseArray(int[] origin){
		int len = origin.length;
		int temp = 0;
		for(int i = 0; i <= len >> 1; i++){
			temp = origin[i];
			origin[i] = origin[len - 1 - i];
			origin[len - 1 - i] = temp;
		}
	}
	
	/**
	 * 现在有如下的一个数组：   int oldArr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5}   
	 * 要求将以上数组中值为0的项去掉，将不为0的值存入一个新的数组，生成的新数组为：   
	 * {1,3,4,5,6,6,5,4,7,6,7,5}  
	 * @param oldArray
	 * @return
	 */
	public int[] removeZero(int[] oldArray){
		int count = 0;
		for(int i = 0; i < oldArray.length; i++){
			if(oldArray[i] != 0)
				count++;
		}
		
		int[] arr = new int[count];
		
		for(int i = oldArray.length - 1; i >= 0; i--){
			if(oldArray[i] != 0)
				arr[--count] = oldArray[i];
		}
		return arr;
	}
	
	/**
	 * 给定两个已经排序好的整形数组， a1和a2 ,  创建一个新的数组a3, 使得a3 包含a1和a2 的所有元素， 并且仍然是有序的
	 * 例如 a1 = [3, 5, 7,8]   a2 = [4, 5, 6,7]    则 a3 为[3,4,5,6,7,8]    , 注意： 已经消除了重复
	 * @param array1
	 * @param array2
	 * @return
	 */
	
	public int[] merge(int[] array1, int[] array2){
		int pos1 = 0;
		int pos2 = 0;
		ArrayList<Integer> al = new ArrayList<>();
		
		while(pos1 < array1.length && pos2 < array2.length){
			if(array1[pos1] > array2[pos2]){
				al.add(array1[pos1]);
				pos1++;
			}else if(array1[pos1] < array2[pos2]){
				al.add(array2[pos2]);
				pos2++;
			}else{
				al.add(array1[pos1]);
				pos1++;
				pos2++;
			}
		}
		
		while(pos1 < array1.length){
			al.add(array1[pos1++]);
		}
		
		while(pos2 < array2.length){
			al.add(array2[pos2++]);
		}
		
		int[] arr = W2P(al.toArray(new Integer[0]));
		
		return  arr;
	}
	
	private int[] W2P(Integer[] array) {
		int[] arr = new int[array.length];
		for(int i = 0; i < array.length; i++){
			arr[i] = array[i].intValue();
		}
		return arr;
	}

	/**
	 * 把一个已经存满数据的数组 oldArray的容量进行扩展， 扩展后的新数据大小为oldArray.length + size
	 * 注意，老数组的元素在新数组中需要保持
	 * 例如 oldArray = [2,3,6] , size = 3,则返回的新数组为
	 * [2,3,6,0,0,0]
	 * @param oldArray
	 * @param size
	 * @return
	 */
	public int[] grow(int [] oldArray,  int size){
		int len = oldArray.length;
		int[] newArr = new int[len + size];
//		for(int i = 0; i < len; i++){
//			newArr[i] = oldArray[i];
//		}
		System.arraycopy(oldArray, 0, newArr, 0, len);
		return newArr;
	}
	
	/**
	 * 斐波那契数列为：1，1，2，3，5，8，13，21......  ，给定一个最大值， 返回小于该值的数列
	 * 例如， max = 15 , 则返回的数组应该为 [1，1，2，3，5，8，13]
	 * max = 1, 则返回空数组 []
	 * @param max
	 * @return
	 */
	public int[] fibonacci(int max){
		if(max <= 0){
			throw new IllegalArgumentException("Error argument:" + max);
		}
		if(max == 1){
			return new int[0];
		}else{
			List<Integer> list = new ArrayList<>();
			list.add(1);
			list.add(1);
			int count  = 2;
			int sum = 0;
			
			while((sum = list.get(count - 1) + list.get(count - 2)) <= max){
				list.add(sum);
				count++;
			}
			return W2P((Integer[])list.toArray());
		}
	}
	
	/**
	 * 返回小于给定最大值max的所有素数数组
	 * 例如max = 23, 返回的数组为[2,3,5,7,11,13,17,19]
	 * @param max
	 * @return
	 */
	public int[] getPrimes(int max){
		if(max < 2){
			throw new IllegalArgumentException("Illegal argument:" + max);
		}
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 2; i <= max; i++){
			if(isPrimes(i))
				list.add(i);
		}
		
		return W2P((Integer[])list.toArray());
	}
	
	private boolean isPrimes(int num) {
		
		for(int i = 0; i <= Math.sqrt(num); i++){
			if(num % i == 0){
				return false;
			}
		}
		
		return true;
	}

	/**
	 * 所谓“完数”， 是指这个数恰好等于它的因子之和，例如6=1+2+3
	 * 给定一个最大值max， 返回一个数组， 数组中是小于max 的所有完数
	 * @param max
	 * @return
	 */
	public int[] getPerfectNumbers(int max){
		if(max < 0){
			throw new IllegalArgumentException();
		}else{
			List<Integer> list = new ArrayList<>();
			list.add(0);
			
			for(int i = 0; i < max; i++){
				if(isPerfectNumber(i)){
					list.add(i);
				}
			}
			
			return W2P((Integer[])list.toArray());
		}
	}
	
	private boolean isPerfectNumber(int num) {
		int sum = 0;
		
		for(int i = 1; i <= Math.sqrt(num); i++){
			 if(num % i == 0){
				 sum += i;
				 sum += num/i;
			 }
		}
		
		return sum == num;
	}

	/**
	 * 用seperator 把数组 array给连接起来
	 * 例如array= [3,8,9], seperator = "-"
	 * 则返回值为"3-8-9"
	 * @param array
	 * @param s
	 * @return
	 */
	public String join(int[] array, String seperator){
		int len = array.length;
		if(len == 0){
			return "";
		}else{
			StringBuilder sb = new StringBuilder();
			sb.append(array[0]);
			for(int i = 1; i < len; i++){
				sb.append(seperator);
				sb.append(array[i]);
			}
			return sb.toString();
		}
	}
	

}
