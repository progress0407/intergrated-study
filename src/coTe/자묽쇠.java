/*
package coTe;

import static java.lang.System.out;

public class 자묽쇠 {
    public static void main(String[] args) {

        */
/*
        int[][] key = {
                {1,0},
                {1,0}
        };
        int[][] lock = {
                {1,0},
                {0,0}
        }; *//*


        int[][] key = {
                {0, 0, 0},
                {1, 0, 0},
                {0, 1, 1}
        };
        */
/*
        int[][] lock = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };*//*


        int[][] lock = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 0, 1, 1},
                {0, 1, 1, 1}
        };
        Solution_자물쇠 sol = new Solution_자물쇠();
        out.println("doo...");
        boolean b = sol.solution(key, lock);
        out.println("done: " + b);
    }
}

class Solution_자물쇠 {
    static int[][] pizzaDough;
    
    static int totOneCnt; // 총 돌기의 갯수
    static int N; // 피자 도우의 한 변의 크기

    int[][] lock;
    int[][] key;
    int[][] turned_key;
    int[][] horizontaled_key;

    public boolean solution(int[][] key_input, int[][] lock_input) {

        init_StaticLArr(key_input, lock_input);

        // 임시 int 공간이야
        makePizzaDough();

        int howMany_Turn = 0;
        int howMany_horizontal_Move = 0;
        int howMany_vertical_Move = 0;

        boolean isRight = true; // 0은 현재 오른쪽으로 가는중
        boolean isDown = true; // 0은 현재 아래로 가는중

        out.println("========= 처음이야 =========");
        print_arr("key", key);
        while(true) { // 턴하기
            while(true) { // 오른쪽 혹은 왼쪽으로
                while(true) { // 아래 혹은 위쪽으로
                    if(isMatch()) {
                        out.println("========================= The True =========================");
                        return true;
                    } else {
                    }
                    howMany_vertical_Move++;
                    if(howMany_vertical_Move == key.length || isAllZero()) { // 수직이동 끝나면
                        revert_horizontal_key();
                        out.println("== 수직 단방향 이동 끝 ==");
                        print_arr("key", key);
                        if(!isDown) { // 내려가고 올라가는 것도 다했다? 그럼 탈출
                            isDown = true;
                            howMany_vertical_Move=0;
                            break;
                        }
                        isDown = false;
                        howMany_vertical_Move=0;

                    }
                    else { // 아직 이동해야 한다면
                        if(isDown) {
                            move_Matrix(Direction.DOWN);
                            out.println("down");
                        }
                        else {
                            move_Matrix(Direction.UP);
                            out.println("up");
                        }
                        print_arr("key", key);
                    }
                } // vertical

                howMany_horizontal_Move++;
                if(howMany_horizontal_Move == key.length || isAllZero()) { // 수평이동 끝나면
                    revert_turned_key();
//                    out.println("==== 수평 단방향 이동 끝 ====");
                    print_arr("key", key);

                    if(!isRight) { // 왼쪽 이동이 끝나면
                        isRight = true;
                        howMany_horizontal_Move=0;
                        break;
                    }
                    isRight = false;
                    howMany_horizontal_Move = 0;
                }
                else {
                    if (isRight) {
                        move_Matrix(Direction.RIGHT);
                        out.println("right");
                    } else {
                        move_Matrix(Direction.LEFT);
                        out.println("left");
                    }
                    print_arr("key", key);
                }
            } // horizontal

            howMany_Turn++;
            if(howMany_Turn == 4) {
                break;
            } else {
                turn_Mattrix();
                print_arr("turn key", key);
            }
        } // turning
        return false;
    }

    // 앤 키만 바꿔 주는 애야 !!
    private void move_Matrix(Direction dir) {

        int N = key.length; // 여기선 키의 길이로. 지역변수야.
        int[][] tempMatrix = new int[N][N];

        switch (dir) {
            case LEFT:
                for(int i=0; i< N; i++)
                    for(int j=0; j< N; j++)
                        // 예외 경우를 먼저, 맨 마지막에 있는 원소라면?
                        if(j==N-1)
                            tempMatrix[i][j] = 0;
                        else
                            tempMatrix[i][j] = key[i][j+1];
                break;
            case UP:
                for(int i=0; i< N; i++)
                    for(int j=0; j< N; j++)
                        if(i==N-1)
                            tempMatrix[i][j] = 0;
                        else
                            tempMatrix[i][j] = key[i+1][j];
                break;
            case DOWN:
                for(int i=0; i< N; i++)
                    for(int j=0; j< N; j++)
                        if(i==0)
                            tempMatrix[i][j] = 0;
                        else
                            tempMatrix[i][j] = key[i-1][j];
                break;
            case RIGHT:
                for(int i=0; i< N; i++)
                    for(int j=0; j< N; j++)
                        if(j==0)
                            tempMatrix[i][j] = 0;
                        else
                            tempMatrix[i][j] = key[i][j-1];
                break;
        }
        if(dir == Direction.UP || dir == Direction.DOWN) {
//            out.println("일반키에 저장");
            key = deepCopyArr(tempMatrix);
        } else if(dir == Direction.LEFT || dir == Direction.RIGHT)  {
//            out.println("horizontal 키에 저장");
            horizontaled_key = deepCopyArr(tempMatrix);
            key = deepCopyArr(tempMatrix);
        } else {
            throw new IllegalStateException("이런 인자는 존재하지 않아");
        }
    }

    private void turn_Mattrix() {
        int N = turned_key.length;
        int[][] tempMatrix = new int[N][N];

        for(int i=0; i< N; i++) {
            for(int j= 0; j< N; j++) {
                tempMatrix[i][j] = turned_key[N-1 -j][i];
            }
        }
        turned_key = deepCopyArr(tempMatrix);
    }

    private void print_arr(String arrName, int[][] input_arr) {
        out.printf("=============== print : %s ============== \n", arrName);
        for(int i=0; i< input_arr.length; i++) {
            for(int j=0; j< input_arr[0].length; j++) {
                out.printf("%3d", input_arr[i][j]);
            }
            out.println();
        }
        out.println();
    }

    private void init_StaticLArr(int[][] key_input, int[][] lock_input) {
        // key, lock, 총 1의 갯수, 피자 도우 사이즈 초기화
        if(key_input.length < lock_input.length) {
            lock = deepCopyArr(lock_input);
            int N = lock.length;
            key = new int[N][N];
            for(int i=0; i< N; i++) {
                for(int j=0; j< N; j++) {
                    if(i< key_input.length && j < key_input[0].length) {
                        key[i][j] = key_input[i][j];
                    } else {
                        key[i][j] = 0;
                    }
                }
            }

        } else if (key_input.length > lock_input.length) {
            key = deepCopyArr(key_input);
            int N = key.length;
            lock = new int[N][N];
            for(int i=0; i< N; i++) {
                for (int j = 0; j < N; j++) {
                    if(i< lock_input.length && j < lock_input[0].length) {
                        lock[i][j] = lock_input[i][j];
                    } else {
                        lock[i][j] = 1;
                    }
                }
            }

        } else { // 같은 경우. 축복임
            key = deepCopyArr(key_input);
            lock = deepCopyArr(lock_input);
        }
        turned_key = deepCopyArr(key);
        horizontaled_key = deepCopyArr(key);
        pizzaDough = new int[lock.length][lock[0].length];
        N = pizzaDough.length; // 행열의 길이가 같아
        totOneCnt = lock.length * lock[0].length;
    }

    private void revert_turned_key() { // 턴 된 키로 리턴해
        key = deepCopyArr(turned_key);
        horizontaled_key = deepCopyArr(turned_key);
    }

    private void revert_horizontal_key() {
        key = deepCopyArr(horizontaled_key);
    }

    private boolean isAllZero() {
        int N = key.length;
        int zeroCnt = 0;
        for(int i=0; i< N; i++) {
            for(int j=0; j< N; j++) {
                if(key[i][j] == 0)
                    zeroCnt++;
            }
        }

        if(zeroCnt==N*N)
            return true;
        else
            return false;
    }

    private boolean isMatch() {
        for(int i=0; i<pizzaDough.length; i++) {
            for (int j = 0; j < pizzaDough[0].length; j++) {
                // 키의 돌기를 찾아
                if(key[i][j] == 1) {
                    // 근데 하필 그것이 피쨔또우의 돌기다? 그럼 그냥 여기하지마 return이야
                    if(pizzaDough[i][j] == 1) {
                        makePizzaDough();
                        return false;
                    }
                    else if(pizzaDough[i][j] == 0){
                        pizzaDough[i][j] = 1;
                    }
                }
            }
        }
        int howManyNum = 0;
        for(int i=0; i<pizzaDough.length; i++) {
            for (int j = 0; j < pizzaDough[0].length; j++) {
                if(pizzaDough[i][j] == 1) {
                    howManyNum++;
                }
            }
        }

        makePizzaDough(); // 피자도우는 사랑이야 다시 초기화 해줘야지

        // 만일 모든 돌기가 채워진게 아니면 열린게 아니야
        if(howManyNum == totOneCnt) {
            return true;
        } else {
            return false;
        }
    }

    private void makePizzaDough() {
        int N = lock.length;
        for(int i=0; i< N; i++) {
            for(int j=0; j< N ; j++) {
                pizzaDough[i][j] = lock[i][j];
            }
        }
    }

    private int[][] deepCopyArr(int[][] targetArr) {
        int N = targetArr.length;
        int[][] newArr = new int[N][N];
        for(int i=0; i< N; i++) {
            for(int j=0; j< N; j++) {
                newArr[i][j] = targetArr[i][j];
            }
        }
        return newArr;
    }
}

enum Direction {
    // vim key 순서인듯 ^-^
    LEFT, DOWN, UP, RIGHT;
}*/
