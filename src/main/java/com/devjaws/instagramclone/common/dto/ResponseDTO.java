package com.devjaws.instagramclone.common.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDTO<T> {
    int status;
    T data;
}
