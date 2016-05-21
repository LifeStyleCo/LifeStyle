package lifestyle_alfresco.lifestyle_alfresco.dto;

import java.util.Date;

public class PostDTO {

    private long id;
    private String title;
    private Date remindDate;

    public PostDTO(String title) {
        this.title = title;
    }

    public PostDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getRemindDate() {
        return remindDate;
    }

    public void setRemindDate(Date remindDate) {
        this.remindDate = remindDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
