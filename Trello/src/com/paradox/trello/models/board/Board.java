package com.paradox.trello.models.board;

import com.paradox.trello.models.BoardList;
import com.paradox.trello.models.User;
import com.paradox.trello.models.enums.BoardPrivacy;

import java.util.*;

public class Board {
    private String id;
    private String name;
    private BoardPrivacy privacy;
    private String url;
    private Map<String, User> members;
    private Map<String, BoardList> boardListMap;

    public Board(String id,String name, BoardPrivacy privacy, String url) {
        this.id = id;
//        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.privacy = privacy;
        this.url = url;
        this.members = new HashMap<>();
        this.boardListMap = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BoardPrivacy getPrivacy() {
        return privacy;
    }

    public void setPrivacy(BoardPrivacy privacy) {
        this.privacy = privacy;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, User> getMembers() {
        return members;
    }

    public void setMembers(Map<String, User> members) {
        this.members = members;
    }

    public void addMember(User member) {
        this.members.put(member.getId(), member);
    }

    public void removeMember(User member) {
        this.members.remove(member.getId());
    }

    public Map<String, BoardList> getLists() {
        return boardListMap;
    }

    public void setLists(Map<String, BoardList> boardListMap) {
        this.boardListMap = boardListMap;
    }

    public void addBoardList(BoardList list) {
        this.boardListMap.put(list.getId(), list);
    }

    public void deleteBoardList(BoardList list) {
        this.boardListMap.remove(list.getId());
    }

    @Override
    public String toString() {
        return "Board{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", privacy=" + privacy +
                ", url='" + url + '\'' +
                ", members=" + members +
                ", lists=" + boardListMap +
                '}';
    }
}
