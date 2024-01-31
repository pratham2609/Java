package com.binarytree;
import java.util.*;
public class LeftView {
    static class node{
        int data;
        node left;
        node right;
        node(int data){
            this.data=data;
            this.left=this.right=null;
        }
    }

    public static node insert(node root, int data){
        if(root==null){
            root=new node(data);
            return root;
        }
        if(root.data>data){
            root.left=insert(root.left, data);
        }
        else if(root.data<data){
            root.right=insert(root.right, data);
        }
        return root;
    }

    public static void leftview(node root, ArrayList<node> list, int level){
        if(root==null){
            return;
        }
        if(level==list.size()){
            list.add(root);
        }
        leftview(root.left, list, level+1);
        leftview(root.right, list, level+1);
    }

    public static ArrayList<Integer> left(node root){
        ArrayList<node> list= new ArrayList<>();
        leftview(root,list,0);
        ArrayList<Integer> ans= new ArrayList<>();
        for(node cur:list){
            ans.add(cur.data);
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[]={4,7,6,3,1,2};
        node root=null;
        for(int i=0;i<arr.length;i++){
            root=insert(root, arr[i]);
        }
        System.out.print(left(root)+" ");
    }
}
