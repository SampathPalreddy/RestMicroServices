
import org.apache.commons.collections4.CollectionUtils;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Testing1 {
    public static class Model{
        public String date;
        public String description;
        public String amount;

        public Model(String date, String description, String amount){
            this.date = date;
            this.description = description;
            this.amount = amount;
        }

        public String toString(){
            StringBuilder builder = new StringBuilder();
            builder.append(date);
            builder.append("|");
            builder.append(amount);
            builder.append("|");
            builder.append(description);
            return builder.toString();
        }

    }

    public static List<String> transform(List<String> input){
        if(CollectionUtils.isEmpty(input)){
            return null;
        }
        Set<String> response = new HashSet<>();
        List<Model> models = new ArrayList<>();
        input.stream().filter(it -> it.split(",").length == 3)
                .forEach(it -> {
            String[] values = it.split(",");
                String date = dateConverter(values[0]);
                String description = (formatDescription(values[2]));
                String amount = formatMoney(values[1]);
                if(!response.contains(date+description)){
                   response.add(date+description);
                   Model model = new Model(date, description, amount);
                   models.add(model);

                }
        });
        return models.stream().map(Model::toString).collect(Collectors.toList());
    }

    public static String dateConverter(String date){
        ZoneId utc = ZoneId.of("UTC");
        ZoneId etZoneId = ZoneId.of("America/New_York");
        DateTimeFormatter etFormat = DateTimeFormatter.ofPattern("MM/dd/yy hh:mm a 'EDT'");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy'T'HH:mm:ss'Z'");
        LocalDateTime currentDateTime = LocalDateTime.parse(date, formatter);

        ZonedDateTime currentISTime = currentDateTime.atZone(utc);
        ZonedDateTime currentETime = currentISTime.withZoneSameInstant(etZoneId);
        return etFormat.format(currentETime);
    }

    private static String formatDescription(String value) {
        return value;
    }

    public static String formatMoney(String value) {
        return "$"+String.format("%,d", Long.valueOf(value));
    }
}
