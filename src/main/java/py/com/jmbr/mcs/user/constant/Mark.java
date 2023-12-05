package py.com.jmbr.mcs.user.constant;

import javax.validation.constraints.NotNull;

public class Mark {
    @NotNull
    private String name;

    public Mark(@NotNull String name) {
        this.name = name;
    }

    public Mark() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
