package model;

import java.util.Objects;

public class Subtask extends Task{
    private long epicid;

    public long getEpicid() {
        return epicid;
    }

    public void setEpicid(long epicid) {
        this.epicid = epicid;
    }

    public Subtask(String name, String description, TaskStatus taskStatus, long epicid) {
        super(name, description, taskStatus);
        this.epicid = epicid;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Subtask subtask = (Subtask) o;
        return epicid == subtask.epicid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), epicid);
    }
}
