package kr.co.gyusta.module.domains.comment.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentDTO {
    private Integer id;
    private Integer post_id;
    private String username;
    private String content;

    @Builder
    public CommentDTO(Integer id, Integer post_id, String username, String content) {
        this.id = id;
        this.post_id = post_id;
        this.username = username;
        this.content = content;
    }
}
