package test8;

public class ExceptionTest {
    public static void main(String[] args) {
//        int[] nums = {0, 1, 2};
//        int a;
//        int b = new Scanner(System.in).nextInt();
//        if (b > 0) a = 10 / b;
        String s = null;
        try {
            //System.out.println(nums[3]);
            //int a =   10 / 0;
            System.out.println(s.length());
        } catch (NullPointerException e) {
            System.out.println("hello");
            e.printStackTrace();
        }
    }
}
