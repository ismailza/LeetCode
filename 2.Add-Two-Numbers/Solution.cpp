/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
private:
    int offset = 0;
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int sum;
        if (l1 != nullptr && l2 != nullptr) {
            sum = l1->val + l2->val + offset;
            offset = sum / 10;
            return new ListNode(sum % 10, addTwoNumbers(l1->next, l2->next));
        }
        ListNode *ptr = l1 ? l1 : l2;
        ListNode result;
        ListNode *ptrCurr = &result;
        while (ptr) {
            sum = ptr->val + offset;
            offset = sum / 10;
            ptrCurr->next = new ListNode(sum % 10);
            ptrCurr = ptrCurr->next;
            ptr = ptr->next;
        }
        if (offset == 1)
            ptrCurr->next = new ListNode(offset);
        return result.next;        
    }
};