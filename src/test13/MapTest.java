package test13;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);


        //자료 입력하기 put
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        System.out.println(map);
        System.out.println(map.containsKey(2));

        //자료 열기 : get
       /* System.out.println(map.get(3));

        int a = sc.nextInt();
        System.out.println(map.containsKey(a) == true ? map.get(a) : "존재하지 않는 키값");
        System.out.println(map.getOrDefault(a, "존재하지 않는 키값"));*/

        System.out.println("=================================================\n\n");

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("사과", 3);
        map2.put("귤", 2);
        map2.put("바나나", 4);
        System.out.println(map2);

        System.out.println("삭 제 전 : " + map2);
        map2.remove("귤");
        System.out.println("삭 제 후 : " + map2);

        int result = map2.replace("사과", 100);
        System.out.println("replace() 변경 값 : " + result);
        System.out.println(map2);

        System.out.println(map2.get("사과"));

        Set<String> keys = map2.keySet();
        System.out.println(keys);


        for (String key : keys) {
            System.out.println(key + " = {" + map2.get(key) + "}");
        }

        System.out.println("======================\n\n");

        Set<Map.Entry<String, Integer>> entrySet = map2.entrySet();
        System.out.println(entrySet);
        System.out.println("======================\n\n");

        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());

        }

        System.out.println("======================\n\n");
        Map<String, Integer> map3 = new HashMap<>();

        //학생 이름 과 성적을 입력받는다
        while (true) {
            System.out.println("학생 이름을 입력하세요");
            String name = sc.next();
            System.out.println("학생 성적을 입력하세요");
            int score = sc.nextInt();

            map3.put(name, score);

            System.out.println(name + " 의 성적은 " + map3.get(name) + " 입니다");

            System.out.println("수정할 성적을 입력하세요");
            int rpScore = sc.nextInt();

            System.out.println(name + " 성적을 기존 " + map3.replace(name, rpScore) + " 점 에서 -> " + rpScore + " 점으로 수정했습니다");

            System.out.println("전체 학생의 성적 출력");
            for (Map.Entry<String, Integer> entry : map3.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }

            System.out.println("전체 학생 성적 출력 방법2");
            for (String mapKey : map3.keySet()) {
                System.out.println(mapKey + " = " + map3.get(mapKey));
            }


            System.out.println("전체 학생 성적 출력 방법3 성적순");
            List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map3.entrySet());
            entryList.sort(Map.Entry.comparingByValue());

            for (Map.Entry<String, Integer> entry : entryList) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }

        }
    }
}

