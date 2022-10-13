//package ss1;
//
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.PriorityQueue;
//
//public class Main {
//    public static void main(String[] args) {
//        HashSet<String> hs = new HashSet<>();
//        hs.add("Hello");
//        hs.add("World");
//        hs.add("Hello");
//        for(String s: hs){
//            System.out.println(s);
//        }
//        PriorityQueue<Integer> numbers = new PriorityQueue<>();
//        numbers.add(4);
//        numbers.add(2);
//        numbers.add(1);
//        System.out.println(numbers.peek());
//
//        PriorityQueue<Student> st = new PriorityQueue<>(new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o2.getMark() - o1.getMark();
//            }
//        });
//        st.add(new Student("AAA", 2));
//        st.add(new Student("BBB", 3));
//        Student s;
//        while ((s = st.poll()) != null){
//            System.out.println("SV: "+s.getName()+" Mark: "+s.getMark());
//        }
//        HashMap<String, Integer> hm = new HashMap<>();
//        hm.put("Good_Student", 10);
//    }
//}
