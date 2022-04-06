public class break_continue123 {

    /*          使用范围                   作用
    break      switch-case和循环结构中    结束当前循环
    continue   仅循环结构中               结束当次循环
    默认只跳出一层循环（最内层）

    label: for(;;)
    {
        for(;;)
        {
        break（continue） label;
        }
    }
    结束指定标识的当前（当次）循环

     */
    public static void main(String args[]) {
        for (int i=1;i<=10;i++)
        {
            if(i%4==0)
            {
                break;
                //System.out.print("无法执行的语句！会报错！");
            }
            System.out.print(i);
        }
        System.out.println();
        for (int i=1;i<=10;i++)
        {
            if(i%4==0)
            {
                continue;
            }
            System.out.print(i);
        }
        System.out.println();
        //break与continue的不同

        for(int i=1;i<=4;i++)
        {
            for(int j=1;j<=10;j++)
            {
                if(j%4==0)
                {
                    break;
                }
                System.out.print(j);
            }
            System.out.println();
        }
        for(int i=1;i<=4;i++)
        {
            for(int j=1;j<=10;j++)
            {
                if(j%4==0)
                {
                    continue;
                }
                System.out.print(j);
            }
            System.out.println();
        }

        System.out.println("label（break）的使用");
        label: for(int i=1;i<=4;i++)
        {
            for(int j=1;j<=10;j++)
            {
                if(j%4==0)
                {
                    break label;
                }
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println("label（continue）的使用");
        label: for(int i=1;i<=4;i++)
        {
            for(int j=1;j<=10;j++)
            {
                if(j%4==0)
                {
                    continue label;
                }
                System.out.print(j);
            }
            System.out.println();
        }




    }
}