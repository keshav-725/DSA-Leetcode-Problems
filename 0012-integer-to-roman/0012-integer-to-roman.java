class Solution {
    public String intToRoman(int num) {
        TreeMap<Integer, String> map = new TreeMap<>(){{
            put(1, "I");
            put(5, "V");
            put(4, "IV");
            put(9, "IX");
            put(10, "X");
            put(40, "XL");
            put(50, "L");
            put(90, "XC");
            put(100, "C");
            put(400, "CD");
            put(500, "D");
            put(900, "CM");
            put(1000, "M");
        }};

        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            int closest = map.floorKey(num);
            sb.append(map.get(closest));
            num -= closest;
        }

        return sb.toString();
    }
}