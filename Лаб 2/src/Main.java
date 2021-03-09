public class Main {
    public static void main(String[] args) {
        Fixed a = new Fixed("L");
        Fixed b = new Fixed("M");
        Hourly c = new Hourly("N");

        System.out.println(c.getId());
    }
}
