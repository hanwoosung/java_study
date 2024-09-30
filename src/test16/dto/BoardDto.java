package test16.dto;

import java.sql.Timestamp;
import java.util.ArrayList;

public class BoardDto {

    private long boardId;
    private String title;
    private String content;
    private String uId;
    private String noticeYn;
    private java.sql.Timestamp createdAt;
    private java.sql.Timestamp updatedAt;
    private ArrayList<CommentDto> commentList = new ArrayList<>();
    private int commentCount;

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public BoardDto() {}

    public BoardDto(long boardId, String title, String content, String uId, String noticeYn, Timestamp createdAt, Timestamp updatedAt) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.uId = uId;
        this.noticeYn = noticeYn;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public ArrayList<CommentDto> getCommentList() {
        return commentList;
    }

    public void addComment(CommentDto comment) {
        this.commentList.add(comment);
    }

    public BoardDto(String title, String content, String uId, String noticeYn, Timestamp createdAt) {
        this.title = title;
        this.content = content;
        this.uId = uId;
        this.noticeYn = noticeYn;
        this.createdAt = createdAt;
    }

    public BoardDto(int boardId, String title, String content, String uId, String noticYn, Timestamp createdAt) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.uId = uId;
        this.noticeYn = noticYn;
        this.createdAt = createdAt;
    }


    public long getBoardId() {
        return boardId;
    }

    public void setBoardId(long boardId) {
        this.boardId = boardId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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


    public String getNoticeYn() {
        return noticeYn;
    }

    public void setNoticeYn(String noticeYn) {
        this.noticeYn = noticeYn;
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
