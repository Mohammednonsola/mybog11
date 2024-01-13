package com.blog;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SuplierInterface {
    public static void main(String[] args) {
//  List<Employees> employeesList=Arrays.asList(
//      new Employees("mohammed","palanpur",45),
//          new Employees("jawad","mumbai",24),
//          new Employees("mohammed","mumbai",35),
//          new Employees("mohammed","palanpur",45)
//
//  );

//        List<Employees> list = employeesList.stream().filter(i -> i.getCity().equals("mumbai")).collect(Collectors.toList());
//        for (Employees e:list) {
//            System.out.println(e.getName());
//        }
//  get name by age
//List<Employees> list=Arrays.asList(
//        new Employees("mohammed","mumbai",34),
//        new Employees("jabir","navi mumbai",24),
//        new Employees("Ahemad","palnpur",44),
//        new Employees("juned","dombivali",67)
//);
//        List<Employees> list1 = list.stream().filter(i -> i.getAge() > 40).collect(Collectors.toList());
//  for (Employees e:list1){
//      System.out.println(e.getName());
//  }
//        get by name startwith "m"
   List<Employees> list=Arrays.asList(
           new Employees("md","mumbai",45),
           new Employees("mohammed","bhopal",25),
           new Employees("jabir","mumbai",35),
           new Employees("shoaib","toranto",25)

  );
//        List<Employees> list1 = list.stream().filter(i -> i.getName().startsWith("m")).collect(Collectors.toList());
//      for (Employees e:list1){
//          System.out.println(e.getName());
//      }
        Map<String, List<Employees>> listMap = list.stream().collect(Collectors.groupingBy(i -> i.getCity()));
        for (Map.Entry<String,List<Employees>> key: listMap.entrySet()){
            String value = key.getKey();
            List<Employees> result = key.getValue();
            System.out.println(value);
            for (Employees e:result){
                System.out.println(e.getName());
            }

        }

    }
   }



