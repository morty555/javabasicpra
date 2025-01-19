package dishp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DishApp {
    static List<Dish> dishList=new ArrayList<>();
    static List<Dish> personDish=new ArrayList<>();

    public static  void main(String[] args){

        initDish();
        // System.out.println(dishList);
        Scanner s =new Scanner(System.in);  //创建扫描器对象获取控制台内容
        while(true){
            showMenu();
            //System.out.println("请输入编号");
            //int num=s.nextInt();   //获取内容阻塞的效果
            //System.out.println("输入的值："+num);
            int num = s.nextInt();
            switch (num){
                case 1:

                    while (true){
                        showDishMenu();
                        int id=s.nextInt();
                        if(id==0){
                            break;
                        }
                        Dish dish = dishList.get(id - 1);
                        System.out.println("您点了"+dish.name);
                        personDish.add(dish);

                    }
                case 2:
                    showPersonDish();
                    break;
                case 3:
                    buy();
                    return;

            }
        }
    }

    private static void buy() {
        System.out.println("你需要付款");
        double sum=0f;
        for(Dish dish:personDish){
            sum=dish.price+sum;
        }
        System.out.println(sum);
    }

    private static void showPersonDish() {
        System.out.println("你已点的菜品");
       for(Dish dish:personDish){
           System.out.println(dish.id+"\t"+dish.name+"\t"+dish.price);
       }
        System.out.println("-----按0返回-----");
    }

    private static void showDishMenu() {
           System.out.println("请你点菜");
           for(int i=0;i<dishList.size();i++){
               Dish dish = dishList.get(i);
               System.out.println(dish.id+"\t"+dish.name+"\t"+dish.price);
           }
           System.out.println("-----输入序号点菜，按0返回-----");
    }

    public  static  void showMenu(){
        System.out.println("-------主菜单-------");
        System.out.println("菜单\t\t\t 1");
        System.out.println("已点菜品\t\t\t 2");
        System.out.println("买单\t\t\t 3");
        System.out.println("-------根据编码选择服务-------");
    }
    public static void initDish(){
        Dish dish1 = new Dish(1,"香辣肉丝",29.0);
        dishList.add(dish1);
        Dish dish2 = new Dish(2,"炖王八",59.0);
        dishList.add(dish2);
        dishList.add(new Dish(3,"家常凉菜",21.0));
        dishList.add(new Dish(4,"地三鲜",21.0));
        dishList.add(new Dish(5,"油焖大虾",21.0));
    }
}
