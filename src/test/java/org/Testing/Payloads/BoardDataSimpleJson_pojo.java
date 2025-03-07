package org.Testing.Payloads;

public class BoardDataSimpleJson_pojo {
    private String name;
    private String desc;
    BoardDataComplexJson_pojo prefs;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BoardDataComplexJson_pojo getPrefs() {
        return prefs;
    }

    public void setPrefs(BoardDataComplexJson_pojo prefs) {
        this.prefs = prefs;
    }

    public void defaultValues(){
        this.name="Bhuvaneshwari";
        this.desc="Private Board";
    }
}

