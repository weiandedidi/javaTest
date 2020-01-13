import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qidi
 * @date 2020-01-09 16:54
 */
public class TestSwitch {


    public static void main(String[] args) {
        Aoo aoo = new Aoo(2, "ceshi");
        switch (aoo.getStatus()) {
            case Status.off.status:
                return;
        }
    }

    enum Status {
        on(1), off(2);
        public Integer status;

        Status(Integer status) {
            this.status = status;
        }

        public Integer getStatus() {
            return status;
        }
    }

    @Data
    @AllArgsConstructor
    static class Aoo {
        private int status;
        private String name;
    }
}
