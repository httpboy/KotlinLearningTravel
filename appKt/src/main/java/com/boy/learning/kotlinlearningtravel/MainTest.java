package com.boy.learning.kotlinlearningtravel;

import com.boy.learning.kotlinlearningtravel.extensions.utils.StringUtils;
import com.boy.learning.kotlinlearningtravel.extensions.utils.StringUtilsKt;

public class MainTest {
    public static void main(String[] args) {
        int lenth = StringUtilsKt.CustomGetLenth(new StringUtils());
        System.out.println(lenth);//11
    }
}