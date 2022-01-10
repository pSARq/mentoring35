package co.com.sofka.mentoring35.models;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class RequestDTO {

    private String id;
    @NotBlank(message = "La lista no puede estar vacía")
    private String orginalList;

    public RequestDTO() {
    }

    public RequestDTO(String id, @NotBlank String orginalList) {
        this.id = id;
        this.orginalList = orginalList;
    }

    public RequestDTO(@NotBlank String orginalList) {
        this.orginalList = orginalList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrginalList() {
        return orginalList;
    }

    public void setOrginalList(String orginalList) {
        this.orginalList = orginalList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestDTO that = (RequestDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "RequestDTO{" +
                "orginalList='" + orginalList + '\'' +
                '}';
    }
}
