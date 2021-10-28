package codingtest.nadongbin.bdfs;

import java.util.Arrays;
import java.util.LinkedList;

import static java.lang.System.out;

public class Q01_프린터 {
    public static void main(String[] args) {

        Q01_프린터 q01_프린터 = new Q01_프린터();
        Solution sol = q01_프린터.new Solution();

        int[] priorities = {2, 1, 3, 2};
//        int[] priorities = {1, 1, 9, 1, 1, 1};

        int location = 2;
//        sol.solution(priorities, location);
        sol.solution2(priorities, location);
    }

    class Solution {
        public int solution2(int[] priorities, int location) {

            LinkedList<Work> q = createQueue(priorities, location);

            LinkedList<Work> results = new LinkedList<>();
            while (!q.isEmpty()) {
                Work first = q.poll();
                if (isPriorityHighst(q, first)) {
                    results.add(first);
                    continue;
                }
                q.offer(first);
            }

            for (int i = 0; i < results.size(); i++) {
                if (results.get(i).isMine) {
                    return i+1;
                }
            }
            return -1;
        }

        private boolean isPriorityHighst(LinkedList<Work> q, Work firstWork) {
            int first = firstWork.priority;
            for (int i = 0; i < q.size(); i++) {
                int next = (int) q.get(i).priority;
                if (first < next) {
                    return false;
                }
            }
            return true;
        }

        private LinkedList<Work> createQueue(int[] priorities, int location) {
            LinkedList<Work> q = new LinkedList<>();
            for (int i = 0; i < priorities.length; i++) {
                if (i == location) {
                    q.offer(new Work(priorities[i], true));
                    continue;
                }
                q.offer(new Work(priorities[i], false));
            }
            return q;
        }

        public int solution(int[] priorities, int location) {

            LinkedList<Request> queue = new LinkedList<>();

            for (int i = 0; i < priorities.length; i++) {
                int priority = priorities[i];
                if (i == location) {
                    queue.add(new Request(true, priority));
                    continue;
                }
                queue.add(new Request(false, priority));
            }


            for (int i = 0; i < queue.size(); i++) {
                Request first = queue.peek();

                for (int j = 1; j < queue.size(); j++) {
                    Request next = queue.get(j);

                    if (first.priority < next.priority) {
                        Request firstRemoved = queue.poll();
                        queue.add(firstRemoved);
                        break;
                    }
                }
            }

            int myPosition = -1;
            for (int i = 0; i < queue.size(); i++) {
                if (queue.get(i).isMine) {
                    myPosition = i + 1;
                    break;
                }
            }

            out.println("myPosition = " + myPosition);

            return myPosition;
        }
    }

    class Work {
        public int priority;
        public boolean isMine;

        public Work(int priority, boolean isMine) {
            this.priority = priority;
            this.isMine = isMine;
        }

        @Override
        public String toString() {
            return "Work{" +
                    "priority=" + priority +
                    ", isMine=" + isMine +
                    '}';
        }
    }

    class Request {
        boolean isMine;
        int priority;

        public Request(boolean isMine, int priority) {
            this.isMine = isMine;
            this.priority = priority;
        }
    }

}
