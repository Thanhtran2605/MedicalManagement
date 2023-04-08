package model;

import java.util.Objects;

public class PatientStatEntry {
    int month;
    int count;

    public PatientStatEntry() {
    }

    public PatientStatEntry(int month, int count) {
        this.month = month;
        this.count = count;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PatientStatEntry)) return false;
        PatientStatEntry that = (PatientStatEntry) o;
        return month == that.month && count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, count);
    }

    @Override
    public String toString() {
        return "PatientStatEntry{" +
                "month=" + month +
                ", count=" + count +
                '}';
    }
}
