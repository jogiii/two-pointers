public class Palindrome {

    // Input: s = "????Was it a car or a cat I saw?**"



    public boolean isPalindrome(String s)|{
       int left =0;
       int right = s.length()-1;

       while(left < right){
        while(left<right && !Character.isLetterOrDigit(s.charAt(left))){
            left++;
        }
        while(left<right && !Character.isLetterOrDigit(s.charAt(right))){
            right--;
        }




        if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
            return false;
        }
        left++;
        right--;




       }
       return true;
        
        
    }
    
}
