package bo;

import java.util.ArrayList;
import java.util.List;

public class MoneyBO {
    int inspectTimes = 0;
    String operation;
    int divisiblBy;
    int trueThrowTo;
    int falseThrowTo;
    List<Integer> items = new ArrayList<>();

    public void test(){

    }

    public void throwTo(){

    }
    public MoneyBO(String content){
        String[] rows = content.split("\r\n");
        String[] itemsStrs = rows[1].substring(18).split(",");
        for (int i = 0; i < itemsStrs.length; i++) {
            items.add(Integer.parseInt(itemsStrs[i].trim()));
        }
        operation = rows[2].substring(13);
        divisiblBy = Integer.parseInt(rows[3].substring(21));
        trueThrowTo = Integer.parseInt(rows[4].substring(rows[4].length()-1));
        falseThrowTo = Integer.parseInt(rows[5].substring(rows[5].length()-1));
    }
}
