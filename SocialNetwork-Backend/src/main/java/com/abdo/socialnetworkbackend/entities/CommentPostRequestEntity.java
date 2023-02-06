package com.abdo.socialnetworkbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentPostRequestEntity {
    private Comment commentEntity;
    private IdObjectEntity postId;
}
