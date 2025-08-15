class Solution {
    public int minimumRecolors(String blocks, int k) {
       
        int wc = 0;

        
        for (int i = 0; i < k; i++)
        {
            if (blocks.charAt(i) == 'W')
            {
             wc++;
            }
        }

        int recolors = wc;


        for (int i = k; i < blocks.length(); i++)
        {
            if (blocks.charAt(i - k) == 'W') 
            {
                 wc--; 
            } 
            if (blocks.charAt(i) == 'W')
            {
                 wc++;  
            }    

            recolors = Math.min(recolors,wc);
        }

        return recolors;
    }
}
