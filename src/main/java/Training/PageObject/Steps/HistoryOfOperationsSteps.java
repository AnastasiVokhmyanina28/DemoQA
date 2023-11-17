package Training.PageObject.Steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class HistoryOfOperationsSteps {
    private Integer day = 300;

    @Step("период в 4 дня от сегодняшнего дня")
    public SelenideElement proverim() {
        Calendar calendar = Calendar.getInstance();
        String currentDay = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
        Integer startDay = Integer.parseInt(currentDay) - day;
        return $x("//div[@class='datepicker datepicker-dropdown dropdown-menu'][contains(@style,'display: block;')]//tbody//td[contains(text(), " + startDay + ")]");
    }

    // функция вернет текущий месяц по индексу вычитаем 1 тк нумерация с 0
    public static String currentMonthThirdMethod() {
        String month = "";
        List<String> monthList = new ArrayList<>();
        monthList.add("Янв");
        monthList.add("Фев");
        monthList.add("Мар");
        monthList.add("Апр");
        monthList.add("Май");
        monthList.add("Июн");
        monthList.add("Июл");
        monthList.add("Авг");
        monthList.add("Сен");
        monthList.add("Окт");
        monthList.add("Ноя");
        monthList.add("Дек");

        String months = monthList.get(4);
        System.out.println(months);
        return months;

//        month = monthList.get(monthId - 1);
//        return month;
    }

    public static void currentMonthFourthMethod(int monthId) {

        HashMap<Integer, String> monthMap = new HashMap<>();
        monthMap.put(1, "Янв");
        monthMap.put(2, "Фев");
        monthMap.put(3, "Мар");
        monthMap.put(4, "Апр");
        monthMap.put(5, "Май");
        monthMap.put(6, "Июн");
        monthMap.put(7, "Июл");
        monthMap.put(8, "Авг");
        monthMap.put(9, "Сен");
        monthMap.put(10, "Окт");
        monthMap.put(11, "Ноя");
        monthMap.put(12, "Дек");

        String month = monthMap.get(monthId);
        System.out.println(month);
    }

    public static void currentMonthHashSet() {

        HashSet<String> month = new HashSet<>();
        month.add("Янв");
        month.add("Фев");
        month.add("Мар");
        month.add("Апр");
        month.add("Май");
        month.add("Июн");
        month.add("Июл");
        month.add("Авг");
        month.add("Сен");
        month.add("Окт");
        month.add("Ноя");
        month.add("Дек");
//        month.add("Дек");

        String a = month.stream().filter(x -> x.equals("Июн")).findFirst().get();

//        System.out.println(month);
        System.out.println(a);
    }




    //распарсили дату
    //todo оставим для сегодняшней даты (без дальнейшего использования)
    public String currentMonthSecondMethod() {
        Calendar calendar = Calendar.getInstance();
        String formattedDate = DateFormat.getDateInstance().format(calendar.getTime()); // дата на русском
        formattedDate.split(" ");
        return formattedDate.substring(3, 4).toUpperCase() + formattedDate.substring(4, 6);
    }


    public String currentMonthFirstMethod(int monthId) {
        String currentMonth = "";

        switch (monthId) {
            case 1:
                currentMonth = "Янв";
                break;
            case 2:
                currentMonth = "Фев";
                break;
            case 3:
                currentMonth = "Мар";
                break;
            case 4:
                currentMonth = "Апр";
                break;
            case 5:
                currentMonth = "Май";
                break;
            case 6:
                currentMonth = "Июн";
                break;
            case 7:
                currentMonth = "Июл";
                break;
            case 8:
                currentMonth = "Авг";
                break;
            case 9:
                currentMonth = "Сен";
                break;
            case 10:
                currentMonth = "Окт";
                break;
            case 11:
                currentMonth = "Ноя";
                break;
            case 12:
                currentMonth = "Дек";
                break;
        }
        return currentMonth;
    }


}
