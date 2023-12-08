// package Hashing;
import java.util.*;

class HashNode {
    int key;    //Unique identification for each data piece
    int value;

    public HashNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class HashMap {
    int capacity;    //Indices of the hashmap
    int size;
    HashNode[] arr;
    HashNode dummy;

    public HashMap() {
        this.capacity = 20;
        this.size = 0;
        this.arr = new HashNode[this.capacity];
        this.dummy = new HashNode(-1, -1);
    }

    //To obtain the index number of the data in the hash table
    public int hashCode(int key) {
        int code = key % this.capacity;
        return code;
    }

    public void insert(int key, int value) {
        HashNode temp = new HashNode(key, value);
        int hashIndex = hashCode(key);

        //Searching for free space
        //The conditions are:
        //1. The current hash index should not be null
        //2. The current hashIndex key should not be same as the key we wish to insert
        //3. Key of the data we wish to insert should not be -1
        while (this.arr[hashIndex] != null && this.arr[hashIndex].key != key && this.arr[hashIndex].key != -1) {
            hashIndex++;
            hashIndex = hashIndex % this.capacity;
        }


        //To insert
        //Conditions:
        //1. Either the current position in hash table is null
        //2. Or, the key of the current hashIndex is occupied by dummy data
        if (this.arr[hashIndex] == null || this.arr[hashIndex].key == -1) {
            this.size++;
        }

        this.arr[hashIndex] = temp;
    }


    public int deleteNode(int key) {
        int hashIndex = hashCode(key);

        while (this.arr[hashIndex] != null) {
            if (this.arr[hashIndex].key == key) {
                HashNode temp = this.arr[hashIndex];

                //Inserting dummy data
                this.arr[hashIndex] = this.dummy;
                this.size--;
                return temp.value;
            }

            hashIndex++;
            hashIndex = hashIndex % this.capacity;
        }

        return -1;
    }


    public int search(int key) {
        int hashIndex = hashCode(key);
        int counter = 0;

        while (this.arr[hashIndex] != null) {
            if (counter > this.capacity) {
                return -1;
            }

            if (this.arr[hashIndex].key == key) {
                return this.arr[hashIndex].value;
            }

            hashIndex++;
            hashIndex = hashIndex % this.capacity;
            counter++;
        }

        return 0;
    }

    public int sizeOfHash() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void display() {
        for (int i = 0; i < this.capacity; i++) {
            if (this.arr[i] != null && this.arr[i].key != -1) {
                System.out.println("Key: " + this.arr[i].key + " Value: " + this.arr[i].value);
            }
        }
    }
}

public class LinearProbing {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        HashMap h = new HashMap();
        h.insert(1, 1);
        h.insert(2, 2);
        h.display();

        input.close();
    }
}