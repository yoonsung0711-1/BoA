import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

class ShuttleBusTailRecursion {
  int n, t, m; List<LocalTime> timetable; LocalTime currentTime;
  public static void main(String[] args) {
    ShuttleBusTailRecursion bus = new ShuttleBusTailRecursion();
    bus.init(new String[] {
          // "1|1|5/08:00|08:01|08:02|08:03|08:04", 
          "1|1|5/08:00|08:01|08:02|08:03", 
          "2|10|2/09:10|09:09|08:00",
          "2|1|2/09:00|09:00|09:00|09:00",
          "1|1|5/00:01|00:01|00:01|00:01|00:01",
          "1|1|1/23:59",
          "10|60|45/23:59|23:59|23:59|23:59|23:59|23:59|23:59|23:59|23:59|23:59|23:59|23:59|23:59|23:59|23:59|23:59"
    }, 3);
    System.out.println(bus.solve());

    // System.out.println(bus.solution(1, 1, 5, new String[]{
    //   "08:00", "08:01",
    //   "08:02", "08:03",
    //   "08:04" 
    // }));
  }
  // case2: ArrayList<ArrayList<String>>
  // System.out.println(
  // (ArrayList<ArrayList<String>>) arr.stream()
  // .map(x -> new ArrayList<String>(Arrays.asList(x.split("\\|"))))
  // .collect(Collectors.toCollection(ArrayList<ArrayList<String>>::new))
  // );


  public Function<String, Integer> toNum = (s) -> Integer.parseInt(s);

  public void init(String[] __timetable, int i) {
    List<String> arr =  Arrays.asList(__timetable[i].split("/"));
    String[] nmt = arr.get(0).split("\\|");
    String[] _timetable = arr.get(1).split("\\|");
    this.currentTime = LocalTime.parse("09:00", DateTimeFormatter.ofPattern("H:mm"));
    this.n = toNum.apply(nmt[0]);
    this.t = toNum.apply(nmt[1]);
    this.m = toNum.apply(nmt[2]);
    this.timetable = Arrays.asList(_timetable)
      .stream()
      .map(x -> LocalTime.parse(x, DateTimeFormatter.ofPattern("H:mm")))
      .sorted(Comparator.reverseOrder())
      .collect(Collectors.toList());
  }

  Function<Integer, LocalTime> lambdaRecur = (num) -> {
    System.out.println(String.format("# n: %d, current_time: %s\n", n, currentTime));
    List<LocalTime> arrived_crew 
      = timetable.stream()
        .filter(x -> x.isBefore(currentTime) || x.equals(currentTime))
        .collect(Collectors.toList());
    System.out.println(String.format("  crew %s arrived", arrived_crew.size()));
    System.out.println(String.format("\t[ %s ]", 
      arrived_crew.stream()
        .map(x -> x.toString())
        .collect(Collectors.joining(","))
    ));
    if (num == 0) {
        if (arrived_crew.size() <= m - 1) {
            return currentTime;
        } else {
          return arrived_crew.get(arrived_crew.size() - 1 - (m - 1)).minusMinutes(1);
        }
    }
    if (n > 0) {
      IntStream.range(0, Math.min(arrived_crew.size(), m))
        .forEach(x -> timetable.remove(timetable.size() - 1));
      currentTime = currentTime.plusMinutes(t);
      return this.lambdaRecur.apply(--num);
    }
    return this.lambdaRecur.apply(--num);
  };

  @Override
  public String toString() {
    return String.format("n = %d, t = %d, m = %d\ntimetable: \n\t%s", n, t, m, timetable);
  }

  private LocalTime solve() {
    System.out.println("---------------------");
    System.out.println(this.toString());
    System.out.println("---------------------\n");
    return lambdaRecur.apply(--n);
  }

  private LocalTime solution(int n, int t, int m, String[] timetable) {
    this.m = m;
    this.n = n;
    this.t = t;
    this.currentTime = LocalTime.parse("09:00", DateTimeFormatter.ofPattern("H:mm"));
    this.timetable = Arrays.asList(timetable)
      .stream()
      .map(x -> LocalTime.parse(x, DateTimeFormatter.ofPattern("H:mm")))
      .sorted(Comparator.reverseOrder())
      .collect(Collectors.toList());
    System.out.println("---------------------");
    System.out.println(this.toString());
    System.out.println("---------------------\n");
    return lambdaRecur.apply(--this.n);
  }
}
