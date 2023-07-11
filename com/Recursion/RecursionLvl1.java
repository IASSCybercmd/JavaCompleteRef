package com.Recursion;

/***
 * This java program covers several programs related to recursion video
 * ref: https://youtu.be/JxILxTwHukM
 * @author Priyanshu Raj
 * @category Core Java
 * @version V1.0(3July 2023)
 * 
 * Runner -> javac com/Recursion/RecursionLvl1.java && java com.Recursion.RecursionLvl1
 */

public class RecursionLvl1 {

    /*              >> Ques 1 <<                   */
    /**
     * This function prints the digits from n to 1 
     * 
     * @param num   Number from which you want to print in rev order.
     */
    public void printNT1(int num) {
        if(num<1){
            return;
        }
        System.out.println(num);
        printNT1(num-1);
        
    }


    /*              >> Ques 2 <<                   */
    /**
     * This function prints the digits from 1 to n .
     * 
     * @param n inputed number.
     */
    public void print1TN(int n) {
        if(n<1){
            return;
        }
        print1TN(n-1);
        System.out.println(n);
        
    }


    /*              >> Ques 3 <<                  */
    /**
     * This function prints the product of n to 1
     * @param n Input number.
     * @return  Returns the product of num to 1.
     */
    public int product(int n) {
        if(n == 1){
            return 1;
        }
        return n * product(n-1);
        
    }


    /*              >> Ques 4 <<              */
    /**
     * This function prints the sum of n to 1.
     * @param n    Inputted number.
     * @return     Returns the sum of number from n to 1.
     */
    public int sum(int n) {
        if(n == 1){
            return 1;
        }
        return n + sum(n-1);
        
    }

    /*              >> Ques 5 <<              */
    /**
     * This function prints the sum of digits.
     * @param num   Number whose digit sum you want to find.
     * @return  Sum of the digits.
     */
    public int digitSum(int num) { 
        if(num < 10){
            return num;
        }

        return (num%10) + digitSum(num/10);
    }


     /*              >> Ques 6 <<              */
     /**
     * This function prints the product of digits.
     * @param num   Number whose digit product you want to find.
     * @return  Product of the digits.
     */
      public int digitProduct(int num){
        if(num < 10){
            return num;
        }

        return (num%10) * digitProduct(num/10);
      }


    /*              >> Ques 7 <<              */
    /**
    * This function reverses the actual number.
    * @param num  Inputted number.
    * @return Reverse of the given number.
    */
     public int revNumber(int num){
        if (num < 10) {
            return num;
        }
    
        return (int) ((num % 10) * Math.pow(10, (int) (Math.log10(num)))) + revNumber(num / 10);
     }

     
    /*              >> Ques 8 <<              */
    /**
     * This method is used to find if a number is palindrome or not.
     * @param num
     * @return  Boolean result.
     */
    public boolean checkPalindrome1(int num){
        if(num == revNumber(num)){
            return true;
        }
        return false;
    }


    /*              >> Ques 9 <<              */
    /**
     * * This method is used to find if a number is palindrome or not.
     * 
     * @param num
     * @return  Boolean result.
     */
    public boolean checkPalindrome2(int num){
        if(num < 10){
            return true;
        }else if((num/(int)Math.pow(10,(int)(Math.log10(num)))) == (num%10)){
            int power = (int)(Math.pow(10, (int)Math.log10(num)));
            int nNum = (num%power)/10;
            return checkPalindrome2(nNum);     
        }else{
            return false;
        }
    }


    /*              >> Ques 9 <<              */
    /**
     * This method is used to calculate total number of zeroes in a nubmer.
     * @param num
     * @return  Total number of zeroes.
     */
    public int countZeros(int num){
        if(num < 10){
            if(num == 0)
                return 1;
            else
                return 0;
        }else if((num % 10) == 0){
            return (1+countZeros(num/10));
        }else{
            return countZeros(num/10);
        }
    }


    /*              >> Ques 9 <<              */
    /**
     * This method calculates the total nubmers of steps required to make a number zero.
     * @param num
     * @return  Total number of steps required.
     */
    public int numOfSteps(int num){
        if(num == 0){
            return 0;
        }
        
        //either use else if or use simple if else no problem in both(but else if looks cool and concise.)
        if(num%2 == 0){
            return (1+numOfSteps(num/2));
        }else{
            return (1+numOfSteps(num-1));
        }
    }

    public static void main(String[] args) {
        RecursionLvl1 obj = new RecursionLvl1();
        System.out.println("Ans 1");
        obj.printNT1(7);

        System.out.println("Ans 2");
        obj.print1TN(7);

        System.out.println("Ans 3");
        System.out.println(obj.product(5));

        System.out.println("Ans 4");
        System.out.println(obj.sum(9));

        System.out.println("Ans 5");
        System.out.println(obj.digitSum(12345));

        System.out.println("Ans 6");
        System.out.println(obj.digitProduct(2222222));

        System.out.println("Ans 7");
        System.out.println(obj.revNumber(1234));

        System.out.println("Ans 8 : Checking palindrome1...");
        if(obj.checkPalindrome1(7887)) System.out.println("It's palindrome");
        else System.out.println("Not a palindrome");

        System.out.println("Ans 9 : Checking palindrome2...");
        if(obj.checkPalindrome2(78987)) System.out.println("It's palindrome");
        else System.out.println("Not a palindrome");

        System.out.println("Ans 10 : Counting total zeros in a digit");
        System.out.println(obj.countZeros(80203032));

        System.out.println("Ans 11 : Calculate total number of steps req to make a number to zero.");
        System.out.println(obj.numOfSteps(8));
    }
}
