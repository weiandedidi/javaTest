package lombok;

/**
 * @author qidi
 * @date 2019-08-22 14:23
 */
public class builder {


    @Data
    @Builder
    static class Aoo {
        @Builder.Default
        private String name = "李磊";
        private Integer age;
    }

    @Data
    static class Boo {
        private String name = "李磊";
        private Integer age;
    }


    public static void main(String[] args) {
        Aoo aoo = Aoo.builder().age(2).build();
        System.out.println(aoo.getName());

        Boo boo = new Boo();
        System.out.println(boo.getName());

    }

}
