package com.javaelementary;

public class MyBigInteger {
    private final int[] number;

    public MyBigInteger(int[] val) {
        this.number = val;
    }

    public MyBigInteger(String val) {
        char[] chars = val.toCharArray();
        int[] arr = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            arr[i] = Character.getNumericValue(chars[i]);
        }
        this.number = arr;
    }

    public MyBigInteger add(MyBigInteger val) {
        int length = Math.max(this.number.length, val.number.length);
        int[] number1 = new int[length + 1];
        int[] number2 = new int[length + 1];
        int[] result = new int[length + 1];
        System.arraycopy(this.number, 0, number1, number1.length - this.number.length, this.number.length);
        System.arraycopy(val.number, 0, number2, number2.length - val.number.length, val.number.length);
        int sum;
        int carry = 0;
        for (int i = result.length - 1; i >= 0; i--) {
            sum = number1[i] + number2[i] + carry;
            result[i] = sum % 10;
            carry = sum / 10;
        }
        StringBuilder stringBuilder = new StringBuilder(result.length);
        for (int i = 0; i < result.length; i++) {
            if (i == 0 && result[i] == 0) {
                continue;
            } else {
                stringBuilder.append(result[i]);
            }
        }
        return new MyBigInteger(stringBuilder.toString());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(this.number.length);
        for (int i : this.number) {
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }
}