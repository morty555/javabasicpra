public class Bills {
    private String name;
    private String account;
    private String tyoe;
    private double total;
    private String time;

    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getTyoe() {
        return tyoe;
    }

    public void setTyoe(String tyoe) {
        this.tyoe = tyoe;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Bills(String name, double total, String tyoe, String account, String time, String desc) {
        this.name = name;
        this.account = account;
        this.tyoe = tyoe;
        this.total = total;
        this.time = time;
        this.desc = desc;
    }
    public Bills(){}
}
