package cn.edu.webexperience4springboot.pojo;

import cn.edu.webexperience4springboot.mapper.DatabaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortArray {
    @Autowired
    DatabaseMapper databaseMapper;
    public String arrayToString(Integer[] array){
        if (array != null && array.length > 0) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < array.length; i++) {
                builder.append(array[i]);
                if (i < array.length - 1) {
                    builder.append(",");
                }
            }
            return builder.toString();
        }
        return ""; // 处理空数组的情况
    }
    public String bubbleSort(String partArray, String order) {
        String[] parts = partArray.split(","); // 使用逗号分隔字符串
        Integer[] array = new Integer[parts.length];

        for (int i = 0; i < parts.length; i++) {
            array[i] = Integer.parseInt(parts[i]    ); // 将每个分隔的字符串转换为整数
        }
        int n = array.length;
        boolean swapped;

        switch (order) {
            case "升序":
                do {
                    swapped = false;
                    for (int i = 1; i < n; i++) {
                        if (array[i - 1] > array[i]) {
                            // Swap the elements
                            int temp = array[i - 1];
                            array[i - 1] = array[i];
                            array[i] = temp;
                            swapped = true;
                        }
                    }
                } while (swapped);
                break;

            case "降序":
                do {
                    swapped = false;
                    for (int i = 1; i < n; i++) {
                        if (array[i - 1] < array[i]) { // Note: Changed '>' to '<' for descending order
                            // Swap the elements
                            int temp = array[i - 1];
                            array[i - 1] = array[i];
                            array[i] = temp;
                            swapped = true;
                        }
                    }
                } while (swapped);
                break;
        }

        return arrayToString(array);
    }
    public List<SortData> getInitPage(){
        return databaseMapper.getAll();
    }
    public void insertRecord(SortData sortData){
        databaseMapper.insert(sortData);
    }
}
