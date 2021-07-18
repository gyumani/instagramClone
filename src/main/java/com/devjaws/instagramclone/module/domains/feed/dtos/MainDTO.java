package kr.co.gyusta.module.domains.feed.dtos;

import kr.co.gyusta.module.domains.comment.dtos.entities.CommentEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MainDTO {
    @NotBlank
    private Integer id;
    @NotBlank
    private String postUsername;
    @NotBlank
    private String postPicture;
    @NotBlank
    private String profilePicture;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private String postContent;
    private List<CommentEntity> commentEntityList;

    @Builder
    public MainDTO(String postUsername, String postPicture, String profilePicture, String firstName, String lastName, String postContent, List<CommentEntity> commentEntityList) {
        this.postUsername = postUsername;
        this.postPicture = postPicture;
        this.profilePicture = profilePicture;
        this.firstName = firstName;
        this.lastName = lastName;
        this.postContent = postContent;
        this.commentEntityList=commentEntityList;
    }
}
