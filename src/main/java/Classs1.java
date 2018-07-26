public class Classs1 {
    @Test
    public static void word1() {

        System.out.println("test1 test");
    }
    @Test
    public static void word2() {
        System.out.println("test2 test");
    }
    @AfterSuite
    public static void word3() {
        System.out.println("test3 after ");
    }
    @BeforeSuite
    public static void word4() {
        System.out.println("test4 before");
    }
}
