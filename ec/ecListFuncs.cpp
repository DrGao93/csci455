/*  Name: Jianan Gao
 *  USC NetID: 7450905127
 *  CS 455 Fall 2018
 *
 *  See ecListFuncs.h for specification of each function.
 *
 *  NOTE: remove the print statements below as you implement each function
 *  or you will receive no credit for that function.
 *
 */

#include <iostream>
#include <vector>
#include <stack>
#include "ecListFuncs.h"

using namespace std;


ListType vectorToList(const vector<int> & nums) {
    if (nums.size() == 0) {
        return NULL;
    }
    ListType list = new Node(nums[0]);
    Node* ptr = list;
    for (int i=1; i<nums.size(); i++) {
        Node* node = new Node(nums[i]);
        ptr->next = node;
        ptr = ptr->next;
    }
    return list;
}



int countRuns(ListType list) {
    int count = 0;
    Node* ptr = list;
    if (ptr == NULL) {
        return 0;
    }
    int target = ptr->data;
    ptr = ptr->next;
    bool hasCount = false;
    while (ptr != NULL) {
        if (ptr->data == target && hasCount == false) {
            count ++;
            hasCount = true;
        }else if(ptr-> data != target){
            target = ptr->data;
            hasCount = false;
        }
        ptr = ptr->next;
    }
    return count;

}



ListType reverse(ListType list) {
    if (list == NULL) {
        return NULL;
    }
    
    stack<Node*> s;
    while(list !=NULL){
        Node* newNode = new Node(list->data);
        s.push(newNode);
        list = list->next;
    }
    Node* poped = s.top();
    s.pop();
    ListType newList = new Node(poped->data);
    Node* ptr = newList;
    while(!s.empty()){
        ptr->next = s.top();
        s.pop();
        ptr = ptr->next;
    }
    return newList;

}



void removeMiddle(ListType &list) {
    Node* ptr = list;
    int len = 0;
    while (ptr != NULL) {
        len ++;
        ptr = ptr->next;
    }
    if (len == 0) {
        return;
    }
    if (len ==2||len ==1) {
        delete list;
        list = list->next;
        
    }else{
        int halfLen = len/2;
        if(len%2==1){
            halfLen ++;
        }
        
        Node* prev = list;
        Node* curr = list;
        for(int i=1;i<halfLen;i++){
            prev = curr;
            curr = curr->next;
        }
        
        
        prev->next = curr->next;
        delete curr;
    }
    
}



void split(ListType &list, int splitVal, ListType &a, ListType &b) {
    if (list == NULL) {
        a = NULL;
        b = NULL;
    }else if (list->data == splitVal) {
        a = NULL;
        b = list->next;
        delete list;
    }else{
        a = list;
        b = NULL;
        if(list !=NULL){
            Node* ptr = list;
            while (ptr->next!= NULL) {
                if (ptr->next->data == splitVal) {
                    Node* temp = ptr->next->next;
                    Node* cut = ptr;
                    delete cut->next;
                    cut->next = NULL;
                    ptr = temp;
                    if (ptr == NULL) {
                        break;
                    }
                }else{
                    ptr = ptr->next;
                }
            }
            b = ptr;
        }
    }
    list = NULL;
}
