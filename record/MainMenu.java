import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainMenu {

     static List<Bills> billsList = new ArrayList<>();
     static {
         billsList.add(new Bills("吃饭支出",247,"交行","支出","2021-03-02","家庭聚餐"));
         billsList.add(new Bills("工资收入",247,"交行","收入","2022-03-02","工资"));
     }

   private static  void delBills(){
         Scanner inScanner = new Scanner(System.in);
         int id = inScanner.nextInt();
         billsList.remove(id-1);
         System.out.println("删除成功");
   }
     private static  void addBills(){
         Scanner scanner = new Scanner(System.in);
         Bills bills = new Bills();
         System.out.println("输入名字");
         bills.setName(scanner.next());
         System.out.println("输入账户");
         bills.setAccount(scanner.next());
         System.out.println("输入类型");
         bills.setTyoe(scanner.next());
         System.out.println("输入金额");
         bills.setTotal(scanner.nextDouble());
         System.out.println("输入时间");
         bills.setTime(scanner.next());
         System.out.println("输入备注");
         bills.setDesc(scanner.next());
         billsList.add(bills);
         System.out.println("添加成功");
         showMain();

     }
    public static void main(String[] args){
        run();
    }

    public static void showMain(){
        System.out.println("----随手记----");
        System.out.println("1.添加账务  2.删除账务  3.查询账务  4.退出系统");
        System.out.println("请输入功能序号【1-4】");
    }
    public static void run(){
        showMain();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
        int op=scanner.nextInt();
        switch (op){
            case 1:
               addBills();
                break;
            case 2:
                delBills();
                break;
            case 3:
                select();

                break;
            case 4:

                flag=false;
                break;
            default:
                System.out.println("请重新输入");
        }

    }
        System.out.println("退出系统，拜拜");
    }

    private static void select() {
         System.out.println("随手记》》账务查询");
         System.out.println("1.查询所有  2.按照时间区间查询  3.收入和支出类型查询");
         Scanner scanner = new Scanner(System.in);
         int op=scanner.nextInt();
         switch (op){
             case 1:
                 selectAll();
                 break;
             case 2:
                 selectByDate();
                 break;
             case 3:
                 selectByType();
                 break;
         }
         showMain();
    }

    private static void selectAll() {
         print(billsList);
    }

    private static void selectByDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("随手记》》账务查询》》按照时间区间来查询");
        System.out.println("请输入：开始时间");
        Scanner scanner = new Scanner(System.in);
        String start = scanner.next();
        String end = scanner.next();
        List<Bills> timeCollect = billsList.stream().filter(bills -> {
            String time = bills.getTime();
            try {
                Date startDate = format.parse(start);
                Date endDate = format.parse(end);
                Date timeDate = format.parse(time);
                if (timeDate.before(endDate) && timeDate.after(startDate)) {
                    return true;
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            return false;
        }).collect(Collectors.toList());
         print(timeCollect);
    }

    private static void selectByType() {
        System.out.println("随手记》》账务查询》》收入或支出的类型");
        System.out.println("请输入：收入或支出");
        Scanner scanner = new Scanner(System.in);
        String type=scanner.next();
        List<Bills> typecollect = billsList.stream().filter(bills -> {
            String type1 = bills.getTyoe();
            return type1.equals(type);
        }).collect(Collectors.toList());
        print(typecollect);
    }
    public static void print(List<Bills> list){
           System.out.println("ID\t\t类别\t\t账户\t\t类型\t\t金额\t\t时间\t\t\t\t备注\t\t");
        for (int i = 0; i < list.size(); i++) {
            Bills bills = billsList.get(i);
            System.out.println(i+1+"\t\t"+bills.getName()+"\t\t"+bills.getAccount()+"\t\t"+bills.getTyoe()+"\t\t"+bills.getTotal()+"\t\t"+bills.getTime()+"\t\t"+bills.getDesc());
        }
    }
}
