class Solution {
    public static int partition(int[] heights, String[] names, int low, int high) {
        int pivot = heights[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (heights[j] >= pivot) {
                i++;

                int temp = heights[i];
                heights[i] = heights[j];
                heights[j] = temp;

                String tempName = names[i];
                names[i] = names[j];
                names[j] = tempName;
            }
        }

        int temp = heights[i + 1];
        heights[i + 1] = heights[high];
        heights[high] = temp;

        String tempName = names[i + 1];
        names[i + 1] = names[high];
        names[high] = tempName;

        return i + 1;
    }

    public static void qSort(String[] names, int[] heights, int low, int high) {
        if (low < high) {
            int pi = partition(heights, names, low, high);

            qSort(names, heights, low, pi - 1);
            qSort(names, heights, pi + 1, high);
        }
    }

    public String[] sortPeople(String[] names, int[] heights) {
        qSort(names, heights, 0, heights.length - 1);
        return names;
    }
}