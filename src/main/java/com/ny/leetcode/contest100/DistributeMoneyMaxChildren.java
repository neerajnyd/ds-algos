package com.ny.leetcode.contest100;

public class DistributeMoneyMaxChildren {

    public static void main(String[] args) {
        DistributeMoneyMaxChildren c = new DistributeMoneyMaxChildren();

        System.out.println(c.distMoney(20, 3));
    }

    public int distMoney(int money, int children) {
        if (children > money) return -1;

        money -= children;
//        now how many get 7 without anyone getting 3
        if(money < 7) return 0;
        int childrenWithSeven = money / 7;
        int others = children - childrenWithSeven;
        boolean three = money % 7 == 3;
        if (three) {
            if(others == 1) {
                childrenWithSeven--;
            }
        }
        return childrenWithSeven;
    }

    public int distMoney2(int money, int children) {
        if (children > money) return -1;
        int eights = money / 8; //2 eights can be created
        int moneyLeft = money % 8; //4 money left after eights

        int childrenLeft = children - eights; //these many children need 1 dollar at least

        while (moneyLeft < childrenLeft) {
            moneyLeft += 8;
            eights--;
        }
        int nonEights = 0;
        while (childrenLeft > 1) {
            moneyLeft--;
            childrenLeft--;
            nonEights++;
        }

        if (moneyLeft == 4) {
            if (nonEights == 0) {
                eights--;
            }
        }

        return eights;


    }

}
