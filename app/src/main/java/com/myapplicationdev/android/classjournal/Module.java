package com.myapplicationdev.android.classjournal;

public class Module {

    private String moduleCode;
    private String moduleTitle;


    public Module(String moduleCode, String moduleTitle) {
        this.moduleCode = moduleCode;
        this.moduleTitle = moduleTitle;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleTitle() {
        return moduleTitle;
    }

    public void setModuleTitle(String moduleTitle) {
        this.moduleTitle = moduleTitle;
    }
}
