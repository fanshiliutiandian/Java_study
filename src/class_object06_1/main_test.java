package class_object06_1;

//main方法的使用说明
/*
1 main()作为程序的入口
2 main()也是普通的静态方法
3 main()可以作为和控制台交互的方式（之前用Scanner）//了解




 */

public class main_test {
    public static void main(String[] args) {
        Main.main(new String[100]);

    }
}

class Main{

    public static void main(String[] args) {
        for(int i=0;i< args.length;i++){
            args[i]="args_"+i;
            System.out.println(args[i]);
        }
    }
}
