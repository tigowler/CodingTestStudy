public class TestMain {
    public static void main(String[] args) {
        String title1 = "연습제목1234";
        String title2 = "숙피치 기말발표 연습";

        if (title1.contains("연습")){
            System.out.println("1. 연습 포함");
        }
        if (title2.contains("연습")){
            System.out.println("2. 연습 포함");
        }
        if (title1.contains("목1")){
            System.out.println("3. 목1 포함");
        }
        if (title2.contains("피치")){
            System.out.println("4. 피치 포함");
        }
        if (title1.contains("34")){
            System.out.println("5. 34 포함");
        }
        if (title2.contains("발표 연습")){
            System.out.println("6. 발표 연습 포함");
        }
    }
}
