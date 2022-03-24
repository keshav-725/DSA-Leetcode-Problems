class Solution {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        int boats = 0;
        while (i < j) {
            if (people[i] + people[j] <= limit) {
                boats++;
                i++;
                j--;
            } else if (people[i] + people[j] > limit) {
                boats++;
                j--;
            }
        }

        if (i == j) {
            return boats + 1;
        }

        return boats;
    }
}