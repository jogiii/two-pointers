import java.util.Arrays;

public class BoatsToRescue {

    /*
    
    If people[left] + people[right] <= limit → they share a boat, move both pointers inward
If they're too heavy together → the heaviest goes alone, move only right inward
Either way, one boat is used and the heaviest person is always handled
    
    
    */
    
    public int nuRescueBoats(int[] people, int limit){
        Arrays.sort(people);
        int left =0;
        int right=people.length-1;
        int boats =0;

        while(left <=right){

            if(people[left] +people[right] <= limit){
                left++; // lightest pairs with heaviest
            }
            right--; // heaviest always takes a boat
            boats++;


        }
        return boats;





    }
}
