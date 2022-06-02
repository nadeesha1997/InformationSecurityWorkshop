import java.math.BigInteger;
import java.util.Scanner;

public class Basics {
    public static void main(String[] args) {
//        System.out.println("Hello world");
//        System.out.print("Hello world");
//        System.out.print("Hello world");
//        System.out.print("Enter your name:");
//        Scanner input= new Scanner(System.in);
//        String in= input.nextLine();
////        System.out.println("Hello " + in);
//        Scanner input= new Scanner(System.in);
//        int val=input.nextInt();
//        isPrime(val);
//        isPrime(5);
//        isPrime(9);
//        isPrime(25);
//        isPrime(29);
//        BigInteger x=new BigInteger("23");
//        BigInteger y=new BigInteger("34");
////        boolean iscoprime=isCoPrime(x,y);
////        if (iscoprime)
////            System.out.println(x+ "and"+y+" are co-prime");
////        else
////            System.out.println(x+ " and "+y+" are not co-prime");
//        int tot=totion(x);
//        System.out.println("Totient value of "+x.intValue()+ " : "+tot);
//        BigInteger a,b;
//        System.out.print("Enter a:");
//        Scanner input=new Scanner(System.in);
//        String str_a=input.nextLine();
//        a=new BigInteger(str_a);
//        System.out.print("Enter b:");
//        String str_b=input.nextLine();
//        b=new BigInteger(str_b);
        euclidean();

    }
    static void isPrime(int x){
        boolean prime=true;
        int divisor=2;
        while (divisor<x){
            if (x%divisor==0){
                prime = false;
                break;
            }
            divisor++;
        }
        if(prime){
            System.out.println(x+" is a prime number");
        }
        else {
            System.out.println(x+" is not a prime number");
        }
    }
    static boolean isCoPrime(BigInteger x, BigInteger y){
        BigInteger z=x.gcd(y);
        return z.intValue()==1;
    }
    static int totion(BigInteger x){
        int count=0;
        for (int i=1;i<x.intValue();i++){
            if (isCoPrime(x,BigInteger.valueOf(i)))
                System.out.println(i);
                count++;
        }
        return count;
    }
    static void euclidean(){
        BigInteger a,b;
        System.out.print("Enter a:");
        Scanner input=new Scanner(System.in);
        String str_a=input.nextLine();
        a=new BigInteger(str_a);
        System.out.print("Enter b:");
        String str_b=input.nextLine();
        b=new BigInteger(str_b);
        BigInteger temp;
        while (a.compareTo(BigInteger.ZERO)!=0){
            temp=a;
            a=b;
            b=temp.mod(b);
        }
        System.out.println("ans="+a);
    }
}
