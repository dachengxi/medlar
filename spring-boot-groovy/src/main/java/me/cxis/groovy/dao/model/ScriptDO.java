package me.cxis.groovy.dao.model;

import java.io.Serializable;

public class ScriptDO implements Serializable {

    private static final long serialVersionUID = 565087083803931753L;

    /**
     * 脚本名称
     */
    private String name;

    /**
     * 脚本执行模式：1-同步 2-异步
     */
    private int executeMode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExecuteMode() {
        return executeMode;
    }

    public void setExecuteMode(int executeMode) {
        this.executeMode = executeMode;
    }

    @Override
    public String toString() {
        return "ScriptDO{" +
                "name='" + name + '\'' +
                ", executeMode=" + executeMode +
                '}';
    }
}
