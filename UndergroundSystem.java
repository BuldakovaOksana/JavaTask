
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UndergroundSystem {

    Map<Integer, Pair<String, Integer>> map = new HashMap<>();

    Map<String, Pair<Integer, Integer>> durationMap = new HashMap<>();

    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        map.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkin = map.remove(id);

        String key = checkin.p1 + "_" + stationName;
        Pair<Integer, Integer> time = durationMap.getOrDefault(key, new Pair<>(0, 0));
        time.p1 = time.p1 + (t - checkin.p2);
        time.p2 += 1;
        durationMap.put(key, time);
    }

    public double getAverageTime(String startStation, String endStation) {
        Pair<Integer, Integer> pair = durationMap.get(startStation + "_" + endStation);
        if (pair != null) {
            return (double) pair.p1 / pair.p2;
        }
        return -1.0;
    }

    static class Pair<K, V> {
        K p1;
        V p2;

        public Pair(K p1, V p2) {
            this.p1 = p1;
            this.p2 = p2;
        }

        @Override
        public String toString() {
            return "StationTime{" +
                    "stationName='" + p1 + '\'' +
                    ", time=" + p2 +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Pair that = (Pair) o;
            return p2 == that.p2 && Objects.equals(p1, that.p1);
        }

        @Override
        public int hashCode() {
            return Objects.hash(p1, p2);
        }
    }

    public static void main(String[] args) {

        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15); 
        undergroundSystem.checkOut(27, "Waterloo", 20); 
        undergroundSystem.checkOut(32, "Cambridge", 22); 
        System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge")); 
                                                                                      
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo")); 
        undergroundSystem.checkIn(10, "Leyton", 24);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo")); 
        undergroundSystem.checkOut(10, "Waterloo", 38); 
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo")); 
    }
}