package leetcode;

import java.util.*;

/**
 * Saliya Ekanayake on 11/9/17.
 * https://leetcode.com/problems/queue-reconstruction-by-height/description/
 *
 * Input:
 [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

 Output:
 [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class QueueReconstruct {
    /* Had the idea of insertion sort like thing
    but got lazy and looked up a tip from https://evelynn.gitbooks.io/google-interview/queue-reconstruction-by-height.html
     */
    public static void main(String[] args) {
        QueueReconstruct p = new QueueReconstruct();
        // Output:
        // [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
        /*int[][] people = new int[][]{
                new int[]{7,0},
                new int[]{4,4},
                new int[]{7,1},
                new int[]{5,0},
                new int[]{6,1},
                new int[]{5,2},
        };*/

        // Input:
        // [[2,3], [5,0], [2,7], [1,8], [1,10], [5,1], [3,0], [4,1], [3,3], [4,0], [2,6]]
        // Output:
        // [[3, 0] [4, 0] [4, 1] [2, 3] [3, 3] [5, 0] [2, 6] [2, 7] [1, 8] [5, 1] [1, 10]]
        int[][] people = new int[][]{
                new int[]{2,3},
                new int[]{5,0},
                new int[]{2,7},
                new int[]{1,8},
                new int[]{1,10},
                new int[]{5,1},
                new int[]{3,0},
                new int[]{4,1},
                new int[]{3,3},
                new int[]{4,0},
                new int[]{2,6},
        };

        int[][] ret = p.reconstructQueue(people);
        print(ret);
        ret = p.submission16ms(people);
        print(ret);
        ret = p.reconstructQueueFast(people);
        print(ret);
    }

    private static void print(int[][] ret) {
        for (int i = 0; i < ret.length; ++i){
            System.out.print(Arrays.toString(ret[i]) + " ");
        }
        System.out.println();
    }

    public int[][] reconstructQueueFast(int[][] people){
        // Things I didn't know
        // 1. Sorting on multiple conditions
        // 2. ArrayList.add(x,y) fails if x>0 when size==0, but works
        //    for x==0. Now, in this problem, once sorted, we always
        //    start with 0 and then continue to add to an index
        //    that'll always be present, so add (x,y) works
        Arrays.sort(people, (i,j)-> (i[0] != j[0] ? j[0]-i[0] : i[1]-j[1]));

        // The above sort will order people in descending heights then by ascending counts
        List<int[]> ret = new ArrayList<>();
        // Now, just add these poeple to the list in height order (descending)
        // at value position
        for (int[] person : people) {
            ret.add(person[1], person);
        }

        return ret.toArray(people);
    }


    public int[][] reconstructQueue(int[][] people) {
        SortedMap<Integer, List<Integer>> map  = new TreeMap<>((i,j) -> j-i);
        for (int[] person : people) {
            int h = person[0];
            map.putIfAbsent(h, new ArrayList<>());
            map.get(h).add(person[1]);
        }

        ArrayList<int[]> ret = new ArrayList<>(people.length);
        map.keySet().forEach(h ->{
            List<Integer> vs = map.get(h);
            Collections.sort(vs);
            vs.forEach(v->{
                if (ret.size() < v || ret.size() == 0){
                    ret.add(new int[]{h, v});
                } else {
                    ret.add(v, new int[]{h, v});
                }
            });

        });
        return ret.toArray(people);
    }



    /* Other people's submissions */
    public int[][] submission16ms(int[][]people){
        // Arrays.sort(people, (a,b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1];
            }
        });
        List<int[]> res = new LinkedList<>();
        for(int[] p : people) {
            res.add(p[1], p);
        }
        return res.toArray(new int[people.length][]);
    }

    public int[][] submission10ms(int[][] people) {
        int length = people.length;
        int[] nums = new int[length];
        for(int i = 0; i < length; i++) {
            nums[i] = people[i][1];
        }
        int[][] peopleCp = Arrays.copyOf(people, length);
        quickSort(peopleCp, 0, length);
        mergeSort(peopleCp, Arrays.copyOf(peopleCp, length), 0, length);
        for(int i = 0; i < length; i++) {
            people[i][1] = nums[i];
        }
        return peopleCp;
    }

    private void mergeSort(int[][] people, int[][] tmp, int start, int end) {
        if(start + 1 >= end) {
            return;
        }
        int mid = (start + end) >> 1;
        mergeSort(tmp, people, start, mid);
        mergeSort(tmp, people, mid, end);
        int i = start, j = mid, k = start, rightCnt = 0;
        int[] pi = tmp[i], pj = tmp[j];
        for(;;) {
            if(pi[1] - rightCnt <= pj[1]) {
                people[k++] = pi;
                pi[1] -= rightCnt;
                if(++i == mid) {
                    System.arraycopy(tmp, j, people, k, end - j);
                    break;
                }
                pi = tmp[i];
            } else {
                people[k++] = pj;
                rightCnt++;
                if(++j == end) {
                    System.arraycopy(tmp, i, people, k, mid - i);
                    for(; i < mid; i++) {
                        tmp[i][1] -= rightCnt;
                    }
                    break;
                }
                pj = tmp[j];
            }
        }
    }

    private static final int InsertitionSortThreshold = 7;

    private void quickSort(int[][] people, int start, int end) {
        if(end - start <= InsertitionSortThreshold) {
            for(int i = start + 1; i < end; i++) {
                int[] person = people[i];
                int j = i;
                for(; j > start && compare(person, people[j - 1]) < 0;) {
                    people[j] = people[--j];
                }
                people[j] = person;
            }
            return;
        }
        int i = random(start, end);
        int[] person = people[i];
        people[i] = people[start];
        int s = start, e = end;
        Loop:
        for(int[] ps, pe;;) {
            for(;;) {
                if(--e <= s) {
                    break Loop;
                }
                if(compare(pe = people[e], person) < 0) {
                    break;
                }
            }
            people[s] = pe;
            for(;;) {
                if(++s >= e) {
                    break Loop;
                }
                if(compare(ps = people[s], person) > 0) {
                    break;
                }
            }
            people[e] = ps;
        }
        people[s] = person;
        quickSort(people, start, s);
        quickSort(people, s + 1, end);
    }

    private int compare(int[] p1, int[] p2) {
        int h = p1[0] - p2[0];
        return h != 0 ? h : p2[1] - p1[1];
    }

    private int random(int start, int end) {
        return (int)(System.nanoTime() % (end - start) + start);
    }
}
