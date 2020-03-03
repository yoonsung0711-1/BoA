package _ref;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

class StreamTest {
  public static void main(String[] args) {
    String[] sample = {
      "1|1|5/08:00|08:01|08:02|08:03",
      "1|1|5/08:00|08:01|08:02|08:03",
      "2|10|2/09:10|09:09|08:00",
      "2|1|2/09:00|09:00|09:00|09:00",
      "1|1|5/00:01|00:01|00:01|00:01|00:01",
      "1|1|1/23:59",
      "10|60|45/23:59|23:59|23:59|23:59|23:59|23:59|23:59|23:59|23:59|23:59|23:59|23:59|23:59|23:59|23:59|23:59"
    };
    ArrayList<String> arr = new ArrayList<String>(Arrays.asList(sample[0].split("/")));
    System.out.println(
      arr.stream()
        .map(x -> 
          //System.out.println(
          Arrays.asList(x.split("\\|"))
          //)
        ).collect(Collectors.toList())
    );
      List arr2 = arr.stream()
        .map(x -> 
          //System.out.println(
          Arrays.asList(x.split("\\|"))
          //)
        ).collect(Collectors.toList());
      System.out.println(arr2);

      ArrayList<ArrayList<String>> arr3 = arr.stream()
        .map(x -> 
          //System.out.println(
          //Arrays.asList(x.split("\\|"))
          new ArrayList<String>(Arrays.asList(x.split("\\|")))
          //)
        //).collect(Collectors.toList());
        ).collect(Collectors.toCollection(ArrayList<ArrayList<String>>::new));
      System.out.println(arr3.get(0).getClass());
      //.forEach(System.out::println);
  }
}
