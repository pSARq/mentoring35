package co.com.sofka.mentoring35.models;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class RequestDTO {

    private String id;
    private String date;
    @NotBlank(message = "La lista no puede estar vacía")
    private String orginalList;
    private String randomList;

    public RequestDTO() {
    }

    public RequestDTO(@NotBlank String id, @NotBlank String date, @NotBlank String orginalList, @NotBlank String randomList) {
        this.id = id;
        this.date = date;
        this.orginalList = orginalList;
        this.randomList = randomList;
    }

    public RequestDTO(String id, @NotBlank String orginalList) {
        this.id = id;
        this.orginalList = orginalList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrginalList() {
        return orginalList;
    }

    public void setOrginalList(String orginalList) {
        this.orginalList = orginalList;
    }

    public String getRandomList() {
        return randomList;
    }

    public void setRandomList(String randomList) {
        this.randomList = randomList;
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
