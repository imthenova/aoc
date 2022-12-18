package bo;

import aoc2022.D11;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class MoneyBO {
    public int inspectTimes = 0;
    String operation;
    String operationTarget;
    int divisiblBy;
    int trueThrowTo;
    int falseThrowTo;
    public int getInspectTimes(){
        return inspectTimes;
    }
    public List<BigInteger> items = new ArrayList<>();

    public void test() {
        for (int i = 0; i < items.size(); i++) {
            inspectTimes++;
            BigInteger item = items.get(i);
            BigInteger opt = item;
            if (!operationTarget.equals("old")) {
                opt = BigInteger.valueOf(Long.parseLong(operationTarget) );
            }
            if (operation.equals("*")) {
                item = item.multiply(opt);
            } else {
                item = item.add(opt);
            }
//            item /= 3;
//            System.out.println(item);
            if (item.mod(BigInteger.valueOf((long)divisiblBy)) == BigInteger.ZERO) {
                D11.moneyBOS.get(trueThrowTo).items.add(item);
            }else{
                D11.moneyBOS.get(falseThrowTo).items.add(item);
            }
            //operate
            //divide 3
            //throw

        }
        items.clear();
    }

    public void throwTo() {

    }

    public MoneyBO(String content) {
        String[] rows = content.split("\n");
        String[] itemsStrs = rows[1].substring(18).split(",");
        for (int i = 0; i < itemsStrs.length; i++) {
            items.add(BigInteger.valueOf(Long.parseLong(itemsStrs[i].trim())));
        }
        String[] operationStr = rows[2].substring(13).split(" ");
        operation = operationStr[3];
        operationTarget = operationStr[4];

        divisiblBy = Integer.parseInt(rows[3].substring(21));
        trueThrowTo = Integer.parseInt(rows[4].substring(rows[4].length() - 1));
        falseThrowTo = Integer.parseInt(rows[5].substring(rows[5].length() - 1));
    }
    @Override
    public String toString(){
        String str = "";
        for (int i = 0; i < items.size(); i++) {
            str+=items.get(i)+", ";
        }
        return str;
    }
}
