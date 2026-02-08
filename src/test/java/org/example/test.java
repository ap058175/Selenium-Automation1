package org.example;

import com.google.common.collect.Streams;
import junit.framework.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test {
    //@Test
    public void regular(){
        ArrayList<String> a=new ArrayList<String>();
        a.add("Amit");
        a.add("Rahul");
        a.add("Amrit");
        a.add("Adam");
        a.add("John");
        int count=0;
        for(String name:a){
            if(name.startsWith("A")){
                count++;
            }
        }
        System.out.println(count);


    }
    //@Test
    public void streamfilter() {
        ArrayList<String> a = new ArrayList<String>();
        a.add("Amit");
        a.add("Rahul");
        a.add("Amrit");
        a.add("Adam");
        a.add("John");

       long c= a.stream().filter(s->s.startsWith("A")).count();
       System.out.println(c);
       long d=Stream.of("Amit","Rahul","Amrit","Adam","John").filter(s->{
           return s.startsWith("A");
       }).count();
       System.out.println(d);
       //print all the names of arraylist
        //a.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
        a.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
    }
//@Test
    public void streamMap(){
        //Names end with a and convert them to uppercase
        Stream.of("Amit","Amrita","Anita","Raja","Jonny").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
        //Names start with A and convert them to uppercase and sorted
         List<String> names1= Arrays.asList("Amit","Amrita","Adam","Raja","Jonny");
         List<String> names2=Arrays.asList("India","USA","UK","Germany","France");
         Stream<String> newStream=Streams.concat(names1.stream(),names2.stream());
         //newStream.sorted().forEach(s->System.out.println(s));
         boolean flag=newStream.anyMatch(s->s.equalsIgnoreCase("Amit"));
         System.out.println(flag);
         Assert.assertTrue(flag);

         //names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
    }
    @Test
    public void streamCollect(){
        List<String> newName=Stream.of("Amit","Kumar","Mahto").filter(s->s.startsWith("A")).map(s->s.toUpperCase()).collect(Collectors.toList());
        System.out.println(newName.get(0));
        List<Integer> values=Arrays.asList(3,4,5,6,7,8,7,6,5,4);
        values.stream().distinct().forEach(s->System.out.println(s));
        List<Integer> li=values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(li.get(0));
    }
}
