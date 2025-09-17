class FoodRatings {

    static class Food {
        String name;
        String cuisine;
        int rating;

        Food(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }

    private Map<String, Food> foodMap;

    private Map<String, PriorityQueue<Food>> cuisineToMaxHeap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodMap = new HashMap<>();
        cuisineToMaxHeap = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            Food food = new Food(foods[i], cuisines[i], ratings[i]);
            foodMap.put(foods[i], food);

            cuisineToMaxHeap
                .computeIfAbsent(cuisines[i], k -> new PriorityQueue<>(
                    (a, b) -> {
                        if (b.rating != a.rating) {
                            return b.rating - a.rating;
                        }
                        return a.name.compareTo(b.name);
                    }
                ))
                .add(food);
        }
    }

    public void changeRating(String foodName, int newRating) {
        Food oldFood = foodMap.get(foodName);
        Food updatedFood = new Food(foodName, oldFood.cuisine, newRating);
        
        foodMap.put(foodName, updatedFood);
        
        cuisineToMaxHeap.get(oldFood.cuisine).add(updatedFood);
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Food> pq = cuisineToMaxHeap.get(cuisine);

        while (!pq.isEmpty()) {
            Food top = pq.peek();
            Food latest = foodMap.get(top.name);
            if (top.rating == latest.rating) {
                return top.name;
            } else {
                pq.poll();
            }
        }
        return "";
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */