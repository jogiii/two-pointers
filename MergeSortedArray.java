public class MergeSortedArray {


    /*
            // Brute Force
for (int i = 0; i < n; i++) {
    nums1[m + i] = nums2[i];   // fill the 0s with nums2 elements
}
Arrays.sort(nums1);            // sort the whole thing
```

✅ It works.
❌ But it's **O((m+n) log(m+n))** — we ignored the fact that both arrays are **already sorted!**

> 🧠 **Lesson:** When a problem says "sorted input", it's a **hint** — there's a smarter way.

---

## Step 3: Ask "Can We Do Better?"

Since both arrays are already sorted, we should be able to merge in **O(m+n)** time.

**Think about the classic merge step from Merge Sort:**
- Use two pointers, one for each array.
- Compare the current elements, pick the smaller one, move forward.

**But here's the catch — try it yourself mentally:**
```
nums1 = [1, 3, 5, 0, 0, 0]
nums2 = [2, 4, 6]
```

If we fill from the **front**, we'd overwrite valid elements in `nums1` before using them! 🚨

> 🧠 **Key Insight:** What if we fill from the **back** instead?

---

## Step 4: The "Fill From The Back" Insight

The zeros are at the **end** of `nums1`. The largest elements belong at the **end** of the merged result.

So instead of comparing smallest elements first, **compare the largest elements first** and place them at the back!

**Three pointers:**
```
p1 → last valid element of nums1  (index m-1)
p2 → last element of nums2        (index n-1)
p  → last position of nums1       (index m+n-1)
```
```
nums1 = [1, 3, 5, 0, 0, 0]
                        ↑ p (place here)
              ↑ p1
nums2 = [2, 4, 6]
                  ↑ p2
```

At each step: **pick the larger of `nums1[p1]` and `nums2[p2]`**, place it at `nums1[p]`, and move the corresponding pointer left.

---

## Step 5: Dry Run It — Never Skip This!
```
nums1 = [1, 3, 5, 0, 0, 0],  nums2 = [2, 4, 6]
p1 = 2, p2 = 2, p = 5
```

| Step | nums1[p1] | nums2[p2] | Winner | nums1 state            |
|------|-----------|-----------|--------|------------------------|
| 1    | 5         | 6         | 6      | [1, 3, 5, 0, 0, **6**] |
| 2    | 5         | 4         | 5      | [1, 3, 5, 0, **5**, 6] |
| 3    | 3         | 4         | 4      | [1, 3, 5, **4**, 5, 6] |
| 4    | 3         | 2         | 3      | [1, 3, **3**, 4, 5, 6] |
| 5    | 1         | 2         | 2      | [1, **2**, 3, 4, 5, 6] |
| 6    | 1         | —         | 1      | [**1**, 2, 3, 4, 5, 6] |

✅ Done!

---

## Step 6: Edge Cases — Always Think About These!

> 🧠 Edge cases are where most bugs hide.

**What if `nums2` is exhausted first?**
- Remaining elements in `nums1` are already in place. Nothing to do!

**What if `nums1`'s valid elements are exhausted first?**
- We still have leftover elements in `nums2` — copy them over.
```
nums1 = [4, 5, 6, 0, 0, 0],  nums2 = [1, 2, 3]

After p1 is exhausted, nums2 still has [1, 2, 3] → copy them in.
    
    
    */

    public void merge(int[] nums1, int m,int[] nums2, int n){

        int p1 = m-1;
        int p2 = n-1;
        int p = m+n-1;

        while(p1 >=0 && p2 >=0 ){
            if(nums1[p1] > nums2[p2]){
                nums1[p] = nums1[p1];
                p1--;
            }else{
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        //nums2 leftover if that is big

        while(p2 >=0){
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }

    }


    public static void main(String args[]){


        MergeSortedArray msa = new MergeSortedArray();
        int[] nums1 = {10,20,30,40,0,0};
        int m=4;
        int[] nums2 = {1,2};
        int n=2;

        msa.merge(nums1, m, nums2, n);

        for(int i : nums1){
            System.out.print(i+" ");
        }
    }
    
}
