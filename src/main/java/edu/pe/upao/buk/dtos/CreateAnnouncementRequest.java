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
}
