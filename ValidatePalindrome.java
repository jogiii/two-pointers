public class ValidatePalindrome {



    public boolean validatePalindrome(String s){

        int left =0;
        int right = s.length()-1;

        while(left<right){
            if(s.charAt(left) != s.charAt(right)){
                return isPalindrome(s,left+1,right) || isPalindrome(s,left,right-1);
            }
            left++;
            right--;
        }
        return true;

    }


    public boolean isPalindrome(String s, int left, int right){

        while(left<right && !Character.isLetterOrDigit(s.charAt(left))){
            left++;
        }
        while(left<right && !Character.isLetterOrDigit(s.charAt(right))){
            right--;
        }

        while(left<right){
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;

            left++;
            right--;
        }
        return true;
    }
    
}
