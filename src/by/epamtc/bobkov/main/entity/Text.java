package by.epamtc.bobkov.main.entity;

import java.io.Serializable;
import java.util.Objects;

public class Text implements Serializable {
    String allText;

    public Text() {
    }


    public Text(String text) {
        this.allText = text;
    }

    public String getAllText() {
        return allText;
    }

    public void setAllText(String allText) {
        this.allText = allText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text = (Text) o;
        return Objects.equals(getAllText(), text.getAllText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAllText());
    }
}
