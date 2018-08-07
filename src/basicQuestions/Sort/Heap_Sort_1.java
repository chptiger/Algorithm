package sort;
//http://blog.csdn.net/u012483425/article/details/50353830
public class Heap_Sort_1 {

    /**
     * 建立大根堆
     * 
     * @param datas
     *            待排数组
     * @param s
     *            父节点
     * @param length
     *            无序项的个数
     */
    private void creatHeap(int[] datas, int s, int length) {
        int temp = datas[s];
        for (int j = 2 * s; j <= length; j *= 2) {
            if (j < length && datas[j] < datas[j + 1])
                ++j;// j是关键字中较大的记录的下标
            if (temp >= datas[j])
                break;
            datas[s] = datas[j];// 将最大值赋予父节点
            s = j;
        }
        datas[s] = temp;// 将原父节点的值赋予拥有最大值的子节点，完成最终的交换
    }

    /**
     * 堆排序
     * 
     * @param datas
     *            待排序的数组
     * @param index
     *            待排序数组中待排项的个数
     */
    private void heapSort(int[] datas, int index) {
        if (datas == null || index < 2)
            return;
        for (int i = index / 2; i > 0; i--) {
            creatHeap(datas, i, index);
        }
        for (int i = index; i > 1; i--) {
            int temp = datas[i];
            datas[i] = datas[1];
            datas[1] = temp;
            // 对其余数值进行重建堆操作
            creatHeap(datas, 1, i - 1);
        }
    }

    public static void main(String[] args) {
        int[] datas = new int[10];
        datas[1] = 4;
        datas[2] = 5;
        datas[3] = 7;
        datas[4] = 8;
        datas[5] = 1;
        datas[6] = 0;
        datas[7] = 2;
        datas[8] = 9;
        datas[9] = 10;
        int index = 9;
        System.out.println("********排序前********");
        for (int i = 1; i < index + 1; i++) {
            System.out.print(datas[i] + ",");
        }

        Heap_Sort_1 heapSort = new Heap_Sort_1();
        heapSort.heapSort(datas, index);

        System.out.println("\n********排序后********");
        for (int i = 1; i < index + 1; i++) {
            System.out.print(datas[i] + ",");
        }
    }

}
