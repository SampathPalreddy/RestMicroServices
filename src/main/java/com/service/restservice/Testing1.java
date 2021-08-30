package com.biglots.tms.outbound.service;
import org.apache.commons.collections4.CollectionUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
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

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
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
                String description = (formatDescription(values[1]));
                String amount = formatMoney(values[2]);
                if(!response.contains(date+description)){
                   response.add(date+description);
                   Model model = new Model(date, description, amount);
                   models.add(model);
                }
        });
        return models.stream()
                .sorted(Comparator.comparing(Model::getDate).reversed()
                        .thenComparing(Model::getDescription))
                .map(Model::toString).collect(Collectors.toList());
    }

    public static String dateConverter(String date){
        ZoneId utc = ZoneId.of("UTC");
        ZoneId etZoneId = ZoneId.of("America/New_York");
        DateTimeFormatter etFormat = DateTimeFormatter.ofPattern("M/dd/yy h:mm a 'EDT'");

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
        NumberFormat myFormat = NumberFormat.getInstance();
        BigDecimal response = BigDecimal.valueOf(Double.valueOf(value))
                .setScale(2, RoundingMode.CEILING);
        String formatted = myFormat.format(response);
        return "$"+ formatted;
    }
}
