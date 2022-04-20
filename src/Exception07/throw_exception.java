package Exception07;

//手动抛出异常
/*
首先要生成异常类对象 然后通过 throw 语句实现抛出操作(提交给 Java 运行环境)

 */

public class throw_exception {
    public static void main(String[] args) {

        try {
            student s=new student();
            s.regist(-1000);
            System.out.println(s);
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}

class student{
    private int id;
    public void regist(int id)throws Exception{
        if(id>0){
            this.id=id;

        }
        else{
//            System.out.println("数据非法！");
            throw new RuntimeException("数据非法");
        }

    }
}

