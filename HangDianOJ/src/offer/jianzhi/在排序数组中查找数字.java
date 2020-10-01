package offer.jianzhi;

//题目要求   数字在排序数组中出现的次数
//测试用例  1 2 3 3 3 3 4 5

//思路   分别找出数字的开始的下标  和    数字结束的下标。
//接着计算就可以了。

//在二分查找的时候，各种数组越界的异常！！！看怎么优化代码好一些
//多写一些递归的代码  好好的理解一下递归的代码
public class 在排序数组中查找数字 {

    public static int getNum(int [] arr,int num){
        if (arr.length<1){
            return 0;
        }
        int fistIndex = getFirstIndex(arr,0,arr.length-1,num);
        int lastIndex = getLastIndex(arr,0,arr.length-1,num);
        if (fistIndex==-1||lastIndex==-1){
            return 0;
        }else {
            return lastIndex - fistIndex+1;
        }
    }
    public static int  getFirstIndex(int [] arr,int beginIndex,int endIndex,int num){
        int mid ;
        if ((beginIndex+endIndex)%2==1){
            mid = ((beginIndex+endIndex+1)/2 + (beginIndex+endIndex-1)/2)/2;
        }else {
            mid = (beginIndex+endIndex)/2;
        }
        if (beginIndex==endIndex){
            if (arr[beginIndex]!=num){
                return -1;
            }else {
                return beginIndex;
            }
        }
        //如果相等
        if (arr[mid]==num){
            //判断mid是不是等于0
            if (mid!=0){
                if (arr[mid-1] != num){
                    return mid;
                }else {
                    mid = getFirstIndex(arr,beginIndex,mid-1,num);
                }
            }else {
                return mid;
            }
        }
        //不相等
        if (mid!=-1&&arr[mid]>num){
            //在左边查找
            if (mid!=0){
                mid = getFirstIndex(arr,beginIndex,mid-1,num);
            }else {
                mid=-1;
                return mid;
            }
        }
        if (mid!=-1&&arr[mid]<num){
            if (mid<arr.length-1){
                mid = getFirstIndex(arr,beginIndex+1,endIndex,num);
            }
            else {
                mid = -1;
                return mid;
            }
        }
        return mid;
    }
    public static int  getLastIndex(int [] arr,int beginIndex,int endIndex,int num){
        int mid ;
        if ((beginIndex+endIndex)%2==1){
            mid = ((beginIndex+endIndex+1)/2 + (beginIndex+endIndex-1)/2)/2;
        }else {
            mid = (beginIndex+endIndex)/2;
        }
        if (beginIndex==endIndex){
            if (arr[beginIndex]!=num){
                return -1;
            }else {
                return endIndex;
            }
        }
        //如果相等
        if (arr[mid]==num){
            if (mid< arr.length-1){
                if (arr[mid+1] != num){
                    return mid;
                }else {
                    mid = getLastIndex(arr,mid+1,endIndex,num);
                }
            }else {
                return mid;
            }
        }
        //不相等
        if (mid!=-1&&arr[mid]>num){
            //在左边查找
            if (mid!=0){
                mid = getLastIndex(arr,beginIndex,mid-1,num);
            }else {
                mid=-1;
                return mid;
            }
        }
        if (mid!=-1&&arr[mid]<num){
            if (mid<arr.length-1){
                mid = getLastIndex(arr,beginIndex+1,endIndex,num);
            }
            else {
                mid = -1;
                return mid;
            }
        }
        return mid;
    }
    public static void main(String [] agrs){
        int arr [] = {};
        int num = getNum(arr,2);
        System.out.println(num);
    }
}
