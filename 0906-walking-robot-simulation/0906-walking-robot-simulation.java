class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Robot robot = new Robot();
        Set<Obstacle> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(new Obstacle(obstacle[0], obstacle[1]));
        }
        for (int command : commands) robot.handleCommand(command, obstacleSet);
        return robot.maxDistance;
    }
    private static class Robot {
        public int x = 0, y = 0, dir = 0, maxDistance = 0;
        public Set<Obstacle> obstacles;

        Robot() {}
        private void handleCommand(int command, Set<Obstacle> obstacles) {
            switch (command) {
                case -2:
                    dir = (dir + 3) % 4;
                    return;
                case -1:
                    dir = (dir + 1) % 4;
                    return;
                default: {
                    while (command-- > 0) {
                        int newX = x, newY = y;
                        switch (dir) {
                            case 0: ++newY; break;
                            case 1: ++newX; break;
                            case 2: --newY; break;
                            default: --newX;
                        }
                        if (!obstacles.contains(new Obstacle(newX, newY))) {
                            x = newX;
                            y = newY;
                        }
                    }
                    maxDistance = Math.max(x * x + y * y, maxDistance);
                }
            }
        }
    }
    private static class Obstacle {
        public int x, y;

        public Obstacle(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public boolean equals(Object other) {
            return x == ((Obstacle) other).x && y == ((Obstacle) other).y;
        }
        public int hashCode() {
            return x + y * 413;
        }
    }
}