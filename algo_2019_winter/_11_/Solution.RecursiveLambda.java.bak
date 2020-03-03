import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

class Solution {
  int n, t, m; List<LocalTime> timetable; LocalTime currentTime;

  public Function<String, Integer> toNum = (s) -> Integer.parseInt(s);

  Function<Integer, LocalTime> lambdaRecur = (num) -> {
    List<LocalTime> arrived_crew 
      = timetable.stream()
        .filter(x -> x.isBefore(currentTime) || x.equals(currentTime))
        .collect(Collectors.toList());
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

  String solution(int n, int t, int m, String[] timetable) {
    this.m = m;
    this.n = n;
    this.t = t;
    this.currentTime = LocalTime.parse("09:00", DateTimeFormatter.ofPattern("H:mm"));
    this.timetable = Arrays.asList(timetable)
      .stream()
      .map(x -> LocalTime.parse(x, DateTimeFormatter.ofPattern("H:mm")))
      .sorted(Comparator.reverseOrder())
      .collect(Collectors.toList());
    return lambdaRecur.apply(--this.n).toString();
  }
}
