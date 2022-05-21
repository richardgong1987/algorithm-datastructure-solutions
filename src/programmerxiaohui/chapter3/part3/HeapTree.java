package programmerxiaohui.chapter3.part3;

import java.util.Arrays;

public class HeapTree {
    public static void main(String[] args) {
        HeapTree heapTree = new HeapTree();
        int[] array = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        heapTree.upAdjust(array);
        System.out.println(Arrays.toString(array));
    }

    void build(int[] array) {
        int len = array.length;
        for (int i = (len - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, len);
        }
    }
    void upAdjust(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;

        // temp保存插入的叶子节点值，用于最后的赋值
        int temp = array[childIndex];
        while (childIndex > 0 && temp < array[parentIndex]) {
            //无需真正交换，单向赋值即可
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }
    public void downAdjust(int[] array, int parentIndex, int length) {
        // temp保存父节点值，用于最后的赋值
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            // 如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            // 如果父节点小于任何一个孩子的值，直接跳出
            if (temp <= array[childIndex]) break;
            //无需真正交换，单向赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

}
