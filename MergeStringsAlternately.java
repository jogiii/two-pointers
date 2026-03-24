public class MergeStringsAlternately {


    public static void main(String args[]){
        MergeStringsAlternately msa = new MergeStringsAlternately();
        String result = msa.mergeAlternately("abc","xyz");

        System.out.println(result);
    }
    public String mergeAlternately(String word1, String word2) {

        StringBuilder merged = new StringBuilder();
        int i =0;

        while(i< word1.length() || i<word2.length()){
            if(i<word1.length()){
                merged.append(word1.charAt(i));
            }
            if(i<word2.length()){
                merged.append(word2.charAt(i));
            }
            i++;
        }

        return merged.toString();
        
    }
    
}
