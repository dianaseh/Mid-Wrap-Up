import java.util.Random;

public class Lecture5Exercises {

    /*
     *   implement a function to create a random password with
     *   given length using lower case letters
     *   lecture 5 page 14
     */
    public String weakPassword(int length) {
        String password ="";
        for(int i=0 ; i<length ; i++){
            Random rnd = new Random();
            char c = (char) ('a' + rnd.nextInt(26));
            password += String.valueOf(c);
        }
        return password;
    }

    /*
     *   implement a function to create a random password with
     *   given length and at least 1 digit and 1 special character
     *   lecture 5 page 14
     */
    public String strongPassword(int length) throws Exception {
        Random rand = new Random();
        String nums = "0123456789";
        String spchars = "!#$%&'()*+,-./:;<=>?@[]^_`{|}~";
        String res = "";
        res += String.valueOf(nums.charAt(rand.nextInt(nums.length())));
        res += String.valueOf(spchars.charAt(rand.nextInt(spchars.length())));
        res += weakPassword(length-2);
        return res;
    }

    /*
     *   implement a function that checks if a integer is a fibobin number
     *   integer n is fibobin is there exist an i where:
     *       n = fib(i) + bin(fib(i))
     *   where fib(i) is the ith fibonacci number and bin(i) is the number
     *   of ones in binary format
     *   lecture 5 page 17
     */
    public boolean isFiboBin(int n) {
        boolean flag = false ;
        for(int i=0 ; i<n ; i++){
            if(fib(i)+bin(fib(i)) == n )
                flag = true ;
        }
        return flag;
    }
    public int fib(int n) {
        if(n<=1)
            return n;
        else {
            return fib(n-1)+fib(n-2);
        }
    }
    public int bin(int i ){
        String bin = Integer.toBinaryString(i);
        int res=0;
        for(int j=0 ; j<bin.length() ; j++){
            if(bin.charAt(j) == '1')
                res++;

        }
        return res ;
    }
}
