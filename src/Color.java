import java.util.Objects;

public class Color {
    char name;

    public Color(char name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Color color = (Color) o;
        return name == color.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
