package com.aliyun.sls.rentalcar.utils;

import android.content.Intent;

import com.aliyun.sls.android.sdk.logutils.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by huangweishui on 2018/3/28.
 */

public class MuUtils {

    /**
     * 冒泡排序
     */
    public static void MPsort() {
        Random random = new Random();

        int[] ages = new int[5];
        HashSet<Integer> integers = new HashSet<>();
        for (int i = 0; i < ages.length; i++) {
            int number = random.nextInt(10 - 3) + 3;
            integers.add(number);

        }
        if (integers.size() < ages.length) {

        }
        Iterator<Integer> iterator = integers.iterator();


        for (int i = 0; i < ages.length; i++) {
            ages[i] = random.nextInt(10 - 3) + 3;
//            Logger.i("TTT","random"+ages[i]);
        }

        for (int i = 0; i < ages.length; i++) {
            for (int j = ages.length - 1; j > i; j--) {
                int tem = ages[j];
                if (ages[j] < ages[j - 1]) {
                    ages[j] = ages[j - 1];
                    ages[j - 1] = tem;
                }
            }
        }
        for (int i = 0; i < ages.length; i++) {
//            Logger.i("TTT","ages"+ages[i]);
        }

    }
    public static void setList(LinkedList<Integer> integers){

        if(integers==null){
            return;
        }
        List list=new ArrayList();
       boolean is= integers.add(1);


        Random random=new Random();
        for (int i = 0; i < 5; i++) {
            int count=random.nextInt(10);
            integers.add(count);
        }
//        Collections.sort(integers);
        for (int i = 0; i < integers.size(); i++) {
            Logger.i("TTT","list"+integers.get(i));
        }
    }

    public static void setLenth(int ninit, int max, TreeSet<Integer> hashSet, int[] ages) {
        if(hashSet==null||ages==null){
            return;
        }

        TreeMap treeMap=new TreeMap();
        Random random = new Random();
        int maxLenth=ages.length;
        for (int i = 0; i < maxLenth; i++) {
            int number = random.nextInt(max - ninit) + ninit;
            if(hashSet.size()<maxLenth){
                hashSet.add(number);
            }


        }
        if (hashSet.size() < maxLenth) {
            setLenth(ninit, max, hashSet, ages);
        } else {
            Iterator<Integer> iterator = hashSet.iterator();
            int count = 0;
            while (iterator.hasNext()) {
//                ages[count] = iterator.next();
                Logger.i("TTT", "TreeSet" + iterator.next());
//                Logger.i("TTT", "iterator" + ages[count]);
                count++;
            }

//            for (int i = 0; i < ages.length; i++) {
//                for (int j = ages.length - 1; j > i; j--) {
//                    int tem = ages[j];
//                    if (ages[j] < ages[j - 1]) {
//                        ages[j] = ages[j - 1];
//                        ages[j - 1] = tem;
//                    }
//                }
//            }
//            for (int i = 0; i < ages.length; i++) {
//            Logger.i("TTT","ages"+ages[i]);
//            }

        }
    }
    public static void setTreemapSort(){
        TreeMap<Integer,Integer> treeMap=new TreeMap<>();
        treeMap.put(5,5);
        treeMap.put(3,3);
        treeMap.put(6,6);
        treeMap.put(2,7);
        HashMap<String,String> hashMap=new HashMap<>();
        for (String key:hashMap.keySet()
             ) {

        }
        for (Integer map:treeMap.keySet()) {
            Logger.i("TTT","treeMap"+treeMap.get(map));
        }
//        for (int i = 0; i < treeMap.size(); i++) {
//            Logger.i("TTT","treeMap"+treeMap.get(i));
//        }

    }
    public static String getCurrentMethodName() {
        int level = 1;
        StackTraceElement[] stacks = new Throwable().getStackTrace();
        String methodName = stacks[level].getMethodName();
        return methodName;
    }
    public static String getCurrentClassName() {
        int level = 1;
        StackTraceElement[] stacks = new Throwable().getStackTrace();
        String className = stacks[level].getClassName();
        return className;
    }
    public static String getCurrentLine() {
        int level = 1;
        StackTraceElement[] stacks = new Throwable().getStackTrace();
        String lineName = stacks[level].getLineNumber()+"";
        return lineName;
    }
    public static String getCurrentClassNameMethodLine(){
        StringBuffer stringBuffer=new StringBuffer();
        String info="";
        int level = 1;
        StackTraceElement[] stacks = new Throwable().getStackTrace();
        String methodName = stacks[level].getMethodName();
        String className = stacks[level].getFileName();
        String lineName = stacks[level].getLineNumber()+"";
        stringBuffer.append(className).append(methodName).append(lineName);
        info=stringBuffer.toString();
        return info;
    }
    public static String getCurrentStacktraceInfo(){
        StringBuffer stringBuffer=new StringBuffer();
        String info="";
        int level = 1;
        StackTraceElement[] stacks = new Throwable().getStackTrace();
        if(stacks!=null&&stacks.length>1){
            String methodName = stacks[level].getMethodName();
        String className = stacks[level].getFileName();
        String lineName = stacks[level].getLineNumber()+"";
        stringBuffer.append("类名:"+className).append("方法:"+methodName).append("行数:"+lineName);
        info=stringBuffer.toString();

        }

        return info;
    }
    private static String generateTag(StackTraceElement stack){
        String tag = "%s.%s(L:%d)";
        if(stack!=null){
            String className = stack.getClassName();
            className = className.substring(className.lastIndexOf(".")+1);
            tag = String.format(tag, stack.getClassName(),className,stack.getLineNumber());
        }


        return tag;
    }

}
