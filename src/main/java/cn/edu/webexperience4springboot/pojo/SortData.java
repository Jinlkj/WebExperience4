package cn.edu.webexperience4springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SortData {
    Integer id;
    String ori_array;
    String sorted_array;
    LocalDate date;
    String method;
    String algorithm;
}
