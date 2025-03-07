package org.Testing.Payloads;

public class BoardDataComplexJson_pojo {

    private String comments;
    private  String invitations;
    private String background;
    BoardDataJsonArray_pojo[] switcherViews;
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    public String getInvitations() {
        return invitations;
    }

    public void setInvitations(String invitations) {
        this.invitations = invitations;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public BoardDataJsonArray_pojo[] getSwitcherViews() {
        return switcherViews;
    }

    public void setSwitcherViews(BoardDataJsonArray_pojo[] switcherViews) {
        this.switcherViews = switcherViews;
    }





}
