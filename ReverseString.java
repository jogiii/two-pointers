public class ReverseString {



    /*
    
    
            Input: s = ["n","e","e","t"]

    Output: ["t","e","e","n"]
    
    */

    public void reverseString(char[] s){

        int i=0;
        int j= s.length-1;
        char temp;
        while(i<j){
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;

        }

    }

    public static void main (String[] args){
       
        ReverseString rs = new ReverseString();
        char[] s = {'n','e','e','t'};
        rs.reverseString(s);
        System.out.println("hello" + String.valueOf(s));
        for(char ss: s){
            
            System.out.println(ss);
        }
    }
    
}
