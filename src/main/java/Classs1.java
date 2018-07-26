public class Classs1 {
    @Test (setPriority = 2)
    public static void word1() { System.out.println("test1 test1"); }

    @Test (setPriority = 1)
    public static void word2() {
        System.out.println("test2 test2");
    }

    @AfterSuite
    public static void word3() {
        System.out.println("test3 after ");
    }

    @AfterSuite
    public static void word33() {
        System.out.println("test33 after ");
    }

    @BeforeSuite
    public static void word4() {
        System.out.println("test4 before");
    }
}
