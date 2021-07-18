package kr.co.gyusta.module.domains.comment.dtos.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CommentEntity {
    private Integer id;
    private Integer post_id;
    private String username;
    private String content;
    private LocalDate createDate;

    @Builder
    public CommentEntity(Integer post_id, String username, String content, LocalDate createDate) {
        this.post_id = post_id;
        this.username = username;
        this.content = content;
        this.createDate = createDate;
    }
}
