package offer.jianzhi;

public class 表示数值的字符串 {

    public static void main(String [] args){
        System.out.println(isNumber(".1."));
    }

    public static boolean isNumber(String s) {
        if(s == null || "".equals(s.trim())){
            return false;
        }
        char [] cNum = s.trim().toCharArray();
        boolean res = false;
        //首字符是+ / - 或者数字
        if('+' == cNum[0] || '-' == cNum[0] || '.' == cNum[0]){
            if('.' == cNum[0] && cNum.length == 1){
                return false;
            }
            res = isCheckNum(cNum);
        }else if(isPurNum(cNum[0])){
            res = isCheckNum(cNum);
        }
        return res;
    }

    public  static boolean isPurNum(char num){
        if(num >= '0' && num <= '9' ){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isCheckNum(char [] cNum){
        int index = 1;
        if(index >= cNum.length){
            return true;
        }
        boolean isContainsPoint = false;
        boolean isContainsE = false;
        boolean res = false;
        while (index < cNum.length){
            if(isPurNum(cNum[index])){
                index++;
            }else{
                break;
            }
        }
        //如果全是数字
        if(index == cNum.length){
            res= true;
            return res;
        }else{
            //判断是.还是e 还是其他
            if(cNum[index] == '.' && isPurNum(cNum[index-1])){
                index+=1;
                //继续判断
                while (index < cNum.length){
                    if(isPurNum(cNum[index])){
                        index++;
                    }else{
                        break;
                    }
                }
                //判断是不是小数
                if(index == cNum.length){
                    res = true;
                    return res;
                }else{
                    //判断是否遇到了e
                    if(cNum[index] == 'e' && isPurNum(cNum[index-1])){
                        return isMiNum(cNum, index+1);
                    }else{
                        res = false;
                        return res;
                    }
                }

            }else if(cNum[index] == 'e' && isPurNum(cNum[index-1])){
                return isMiNum(cNum, index+1);
            }else{
                res = false;
                return false;
            }
        }
    }


    public static boolean isMiNum(char [] cNum , int index){
        boolean res = false;
        //判断是否越界
        int length = cNum.length;
        if(index < length){
            if(cNum[index] == '+'){
                return unsignMi(cNum, index+1);
            }else if(cNum[index] == '-'){
                return unsignMi(cNum, index+1);
            }else if(isPurNum(cNum[index])){
                return unsignMi(cNum, index+1);
            }else{
                return res;
            }
        }
        return res;
    }

    public static boolean unsignMi(char[] cNum, int index){
        boolean res = false;
        //判断是否越界
        int length = cNum.length;
        if(index < length){
            while(index < length){
                if(isPurNum(cNum[index])){
                    index+=1;
                }
            }
            //mi是不是纯数字
            if(index == cNum.length){
                return res;
            }else{
                //判断是.还是e 还是其他
                if(cNum[index] == '.'){
                    index+=1;
                    //继续判断
                    while (index < cNum.length){
                        if(isPurNum(cNum[index])){
                            index++;
                        }else{
                            break;
                        }
                    }
                    //判断是不是小数
                    if(index == cNum.length){
                        res = true;
                        return res;
                    }else{
                        return res;
                    }

                }else{
                    res = false;
                    return false;
                }
            }
        }else{
            res = true;
            return res;
        }
    }
}
