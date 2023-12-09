class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] repeated = new boolean[128];

        int j = 0, max_size = 0, curr_size = 0;
        byte k;
        
        for (int i = 0; i < s.length(); i++)
        {
            k = (byte)s.charAt(i);
            if (repeated[k])
            {
                if (curr_size > max_size)
                    max_size = curr_size;
                i = j;
                j++;
                curr_size = 0;
                Arrays.fill(repeated, false);
            }
            else
            {
                repeated[k] = true;
                curr_size++;
            }
        }
        return max_size > curr_size ? max_size : curr_size;
    }
}