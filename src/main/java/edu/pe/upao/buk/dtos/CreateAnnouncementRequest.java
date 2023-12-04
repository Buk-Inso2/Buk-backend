package edu.pe.upao.buk.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAnnouncementRequest {
    private AnnouncementRequest announcementRequest;
    private JobRequest jobRequest;
    private FormRequest formRequest;
    private BaseRequest baseRequest;

    public AnnouncementRequest getAnnouncementRequest() {
        return announcementRequest;
    }

    public void setAnnouncementRequest(AnnouncementRequest announcementRequest) {
        this.announcementRequest = announcementRequest;
    }

    public JobRequest getJobRequest() {
        return jobRequest;
    }

    public void setJobRequest(JobRequest jobRequest) {
        this.jobRequest = jobRequest;
    }

    public FormRequest getFormRequest() {
        return formRequest;
    }

    public void setFormRequest(FormRequest formRequest) {
        this.formRequest = formRequest;
    }

    public BaseRequest getBaseRequest() {
        return baseRequest;
    }

    public void setBaseRequest(BaseRequest baseRequest) {
        this.baseRequest = baseRequest;
    }
}
