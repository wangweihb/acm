package javaTest;

public class 继承构造方法测试
{
    private String baseName = "base";
    public 继承构造方法测试()
    {
        callName();
    }

    public void callName()
    {
        System. out. println(baseName);
    }

    static class Sub extends 继承构造方法测试
    {
        private String baseName = "sub";
        public void callName()
        {
            System. out. println (baseName) ;
        }
    }
    public static void main(String[] args)
    {
        继承构造方法测试 b = new Sub();
    }
}
