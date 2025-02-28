package org.Testing.Payloads;

public class BoardData {
    private String name;
    private String prefsBackground;
    private String prefsInvitations;

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getPrefsBackground() {
        return prefsBackground;
    }

    public void setPrefsBackground(String prefsBackground) {
        this.prefsBackground = prefsBackground;
    }

    public String getPrefsInvitations() {
        return prefsInvitations;
    }

    public void setPrefsInvitations(String prefsInvitations) {
        this.prefsInvitations = prefsInvitations;
    }

    public void defaultValues(){
        this.name="Bhuvaneshwari";
        this.prefsBackground="pink";
        this.prefsInvitations="admins";
    }
}
