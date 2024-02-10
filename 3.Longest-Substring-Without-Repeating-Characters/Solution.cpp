class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        vector<bool> repeated(128, false);
        int j = 0, max_size = 0, curr_size = 0, size = s.length();
        unsigned char k;
        for (int i = 0; i < size; i++) {
            k = s[i];
            if (repeated[k]) {
                if (curr_size > max_size)
                    max_size = curr_size;
                i = j++;
                curr_size = 0;
                fill(repeated.begin(), repeated.end(), false);
            }
            else {
                repeated[k] = true;
                curr_size++;
            }
        }
        return max(max_size, curr_size);
    }
};