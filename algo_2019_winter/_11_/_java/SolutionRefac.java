import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

class SolutionRefac {
  public Function<String, Integer> toNum = (s) -> Integer.parseInt(s);

  String solution(final int n, final int t, final int m, final String[] _timetable) {

    LocalTime currentTime = LocalTime.parse("09:00", DateTimeFormatter.ofPattern("H:mm"));
    List<LocalTime> timetable = Arrays.asList(_timetable)
      .stream()
      .map(x -> LocalTime.parse(x, DateTimeFormatter.ofPattern("H:mm")))
      .sorted(Comparator.reverseOrder())
      .collect(Collectors.toList());

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
      if (num > 0) {
        IntStream.range(0, Math.min(arrived_crew.size(), m))
          .forEach(x -> timetable.remove(timetable.size() - 1));
        currentTime = currentTime.plusMinutes(t);
        return lambdaRecur.apply(--num);
      }
      return lambdaRecur.apply(--num);
    };

    return lambdaRecur.apply(--n).toString();
  }
}
