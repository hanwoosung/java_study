package test16.dto;

import java.sql.Timestamp;

public class CommentDto {

  private long commentId;
  private long boardId;
  private String content;
  private String uId;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp updatedAt;

  public CommentDto(long commentId, long boardId, String content, String uId, Timestamp createdAt, Timestamp updatedAt) {
    this.commentId = commentId;
    this.boardId=boardId;
    this.content = content;
    this.uId = uId;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }


  public long getCommentId() {
    return commentId;
  }

  public void setCommentId(long commentId) {
    this.commentId = commentId;
  }


  public long getBoardId() {
    return boardId;
  }

  public void setBoardId(long boardId) {
    this.boardId = boardId;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getUId() {
    return uId;
  }

  public void setUId(String uId) {
    this.uId = uId;
  }

  public CommentDto(String content, long boardId, String uId, Timestamp updatedAt) {
    this.content = content;
    this.boardId = boardId;
    this.uId = uId;
    this.updatedAt = updatedAt;
  }

  public CommentDto(long boardId, String content, String uId, Timestamp createdAt) {
    this.boardId = boardId;
    this.content = content;
    this.uId = uId;
    this.createdAt = createdAt;
  }

  @Override
  public String toString() {
    return "댓글 번호=" + commentId +
            ", 댓글 내용='" + content + '\'' +
            ", 댓글 작성자='" + uId + '\'' +
            ", 생성날짜=" + createdAt +
            ", 수정날짜=" + updatedAt +
            '}';
  }

  public java.sql.Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(java.sql.Timestamp createdAt) {
    this.createdAt = createdAt;
  }


  public java.sql.Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(java.sql.Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }

}
