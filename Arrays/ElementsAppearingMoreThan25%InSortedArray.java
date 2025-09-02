class Solution {
    public int findSpecialInteger(int[] arr) {
        int l=arr.length;
        int count=1;
        for(int i=1;i<l;i++){
            if(arr[i]==arr[i-1]){
                count++;
                if(count>l/4){
                    return arr[i];
                }
            }
                else{
                    count=1;

                }
        
            }
        return arr[0];
        
    }
}