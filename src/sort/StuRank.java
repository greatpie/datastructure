package sort;

import org.omg.PortableInterceptor.SUCCESSFUL;

/**
 * Created by pie on 2016-5-23.
 */
public class StuRank {
    public static void quickSort(Student[] stuArr, int start, int end) {
        int i, j;
        i = start;
        j = end;
        if ((stuArr == null) || (stuArr.length == 0))
            return;
        while (i < j) {//查找基准点下标
            while (i < j && stuArr[i].grade <= stuArr[j].grade)
                // 以数组start下标的数据为key，右侧扫描
                j--;
            if (i < j) { // 右侧扫描，找出第一个比key小的，交换位置
                Student temp = stuArr[i];
                stuArr[i] = stuArr[j];
                stuArr[j] = temp;
            }
            while (i < j && stuArr[i].grade < stuArr[j].grade)
                // 左侧扫描（此时a[j]中存储着key值）
                i++;
            if (i < j) { // 找出第一个比key大的，交换位置
                Student temp = stuArr[i];
                stuArr[i] = stuArr[j];
                stuArr[j] = temp;
            }
        }
        if (i - start > 1) { // 递归调用，把key前面的完成排序
            quickSort(stuArr, 0, i - 1);
        }
        if (end - j > 1) {
            quickSort(stuArr, j + 1, end); // 递归调用，把key后面的完成排序
        }
    }

    public static void quickSort(Student[] stuArr) {
        int start = 0;
        int end = stuArr.length - 1;
        quickSort(stuArr, start, end);
    }

    public static void insertSort(Student[] stuArr) {
        for (int i = 1; i < stuArr.length; i++) {
            int currentValue = stuArr[i].grade;
            int position = i;
            for (int j = i - 1; j >= 0; j--) {
                if (stuArr[j].grade > currentValue) {
                    stuArr[j + 1] = stuArr[j];
                    position -= 1;
                } else {
                    break;
                }
            }
            stuArr[position].grade = currentValue;
        }
    }

    public static void setRankBySortRes(Student[] stuArr) {
//        int len = stuArr.length;
//        Student[] reverseArr = new Student[len];
//        stuArr[len-1].rank = 1;
//        for (int i=len-1;i>0;i--){
//            if(stuArr[i].grade == stuArr[i-1].grade){
//                stuArr[i-1].rank = stuArr[i].rank;
//            }else {
//                stuArr[i-1].rank = stuArr[i].rank + 1;
//            }
//            reverseArr[len-1-i] = stuArr[i];
//        }
//        reverseArr[len-1] = stuArr[0];
//        return reverseArr;
        reverse(stuArr);
        stuArr[0].rank = 1;
        for (int i = 0; i < stuArr.length-1; i++) {
            if (stuArr[i].grade == stuArr[i+1].grade) {
                stuArr[i+1].rank = stuArr[i].rank;
            } else {
                stuArr[i+ 1].rank = stuArr[i].rank + 1;
            }
        }
    }

    public static void reverse(Student[] stuArr) {
        int len = stuArr.length;
        for (int i = 0; i < len / 2; i++) {
            Student temp = stuArr[i];
            stuArr[i] = stuArr[len - 1 - i];
            stuArr[len - 1 - i] = temp;
        }
    }

    public static void printArr(double[] data) {
        String output = "array:";
        for (double each : data) {
            output += String.valueOf(each) + ',';
        }
        System.out.println(output);
    }


    public static void main(String args[]) {
        Student[] stuArr = new Student[4];
        stuArr[0] = new Student("刘佳派", 99);
        stuArr[1] = new Student("陈琛", 57);
        stuArr[2] = new Student("杜佳佳", 99);
        stuArr[3] = new Student("周杰伦", 100);
        quickSort(stuArr);
         setRankBySortRes(stuArr);
        for (Student stu : stuArr) {
            stu.printInfo();
        }
    }
}
