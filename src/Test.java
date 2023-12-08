import java.util.Scanner;
public class Test {
    public static void main(String[] args ){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();



        while(n>0){


            int rem = n%10;
            n = n/10;

            int rem1 = n%10;
            n = n/10;


            int sum1 =rem + rem1;

            System.out.println(sum1);

        }

    }

}