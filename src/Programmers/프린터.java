package Programmers;

import java.util.*;

public class 프린터 {
    public static void main(String[] args) throws Exception {
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

    //[2, 1, 3, 2]
    public static int solution(int[] priorities, int location) throws Exception {
        //ArrayList로 변환
        List<Integer> list = new ArrayList<>();
        for (int priority : priorities) {
            list.add(priority);
        }

        int turn = 1;   //몇번째 카운트
        while(!list.isEmpty()) {
            final int j = list.get(0);  //첫번째 수를 가져온다.

            if(list.stream().anyMatch(v -> v > j)) {    //만약 첫번째 수보다 더 큰것이 있다면
                list.add(list.remove(0));   //리스트 제일 뒤로 옮긴다.
            } else {    //첫번째 수보다 더 큰 수가 없다면
                if(location == 0) { //내 숫자의 위치가 0번째라면
                    return turn;    //리턴
                } else {    //내 숫자의 위치가 0번째가 아니라면
                    list.remove(0); //첫번째수를 지우고
                    turn++; //수를 카운트한다.
                }
            }

            if(location == 0) { //내가 원하는 수가 0번째라면
                location = list.size() - 1; //리스트 제일 뒤로 옮김
            } else {    //0번째가 아니라면
                location--; //하나 줄임
            }
        }
        throw new Exception();
    }

}



