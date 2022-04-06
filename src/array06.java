import java.util.Scanner;

public class array06 {
/*数组为引用数据类型，引用的元素可以是基本或引用数据类型
  数组名引用的是连续空间的首地址
*/
    public static void main(String args[]) {
    int[] ids;//声明
    //或 int ids[];   声明时不能指定其长度

    //静态初始化(初始化和元素赋值同时进行)
    ids=new int[]{1001,1002,1003,1004};
    //动态初始化（分开进行）
    String[] names=new String[5];
    //不要动静结合
    //int []id=new int[3]{1,2,3}

    //索引从0开始，到length-1
    names[0]="张三";
    names[1]="李四";
    names[2]="王二";
    names[3]="麻子";
    names[4]="赵五";

    System.out.println(names.length);

    //遍历数组元素
    for(int i=0;i< names.length;i++)
    {
        System.out.println(names[i]);
    }

    //数组元素默认初始化值
    //0，false，null


        int[] arr = new int[]{8,2,1,0,3};
        int[] index = new int[]{2,0,3,2,4,0,1,3,2,3,3};
        String tel = "";
        for(int i = 0;i < index.length;i++) {
            tel += arr[index[i]];
        }
        System.out.println("联系方式:"+tel);

        Scanner scanner =new Scanner(System.in);
        System.out.println("学生人数：");
        int num= scanner.nextInt();
        int []scores=new int[num];
        System.out.println("学生成绩：");
        for(int i=0;i< scores.length;i++)
        {
            scores[i]= scanner.nextInt();
        }//录入成绩
        int maxscore=0;
        for(int i=0;i< scores.length;i++)
        {
            if(maxscore<scores[i])
            {
                maxscore=scores[i];
            }
        }//比较出最高分
        char level;
        for(int i=0;i< scores.length;i++)
        {
            if(maxscore-scores[i]<=10)
            {
                level='A';
            }
            else if(maxscore-scores[i]<=20)
            {
                level='B';
            }
            else if(maxscore-scores[i]<=30)
            {
                level='C';
            }
            else
            {
                level='D';
            }
            System.out.println("student"+i+" score is "+scores[i]+",level is "+level);
        }//等级和输出


//二维数组
        //静态初始化
        int[][]arr1=new int[][]{{1,2,3},{4,5},{6,7,8}};
        //动态初始化
        int[][]arr2=new int[3][];//行数必须有，列不必

        //数组长度
        System.out.println(arr1.length);//行（元素为一维数组的一维数组）
        System.out.println(arr1[0].length);//列
        System.out.println(arr1[1].length);//当行的元素个数


        System.out.println(arr1[1]);//地址值
        System.out.println(arr1[1][1]);//值 5
        System.out.println(arr2[1]);//null 不是地址
//        System.out.println(arr2[1][1]);//空指针异常







    }


}
